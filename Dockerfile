# ------------------------------------
# STAGE 1 : Build (Construction)
# ------------------------------------
FROM maven:3.9.11-openjdk-21 AS build
LABEL maintainer="zaidriahi.14@gmail.com"

# Définir le répertoire de travail dans le conteneur
WORKDIR /app

# Copier les fichiers de construction (pom.xml) pour permettre à Docker d'utiliser le cache
COPY pom.xml .

# Télécharger les dépendances pour utiliser le cache Docker si seulement le code change
RUN mvn dependency:go-offline

# Copier tout le code source
COPY src ./src

# Construire l'application Spring Boot
# Le -DskipTests est recommandé en Docker pour un build rapide
RUN mvn package -DskipTests

# ------------------------------------
# STAGE 2 : Final (Image Légère pour l'exécution)
# ------------------------------------
# Utiliser une image OpenJDK légère et sécurisée (Alpine est petite)
FROM openjdk:21-jre-slim

# Définir les variables d'environnement
ENV SPRING_PROFILES_ACTIVE=prod
ENV SERVER_PORT=8081

# Définir le port que l'application utilise
EXPOSE 8081

# Copier le JAR exécutable du stage de build vers l'image finale
# Le nom du JAR doit correspondre au nom généré par votre pom.xml
ARG JAR_FILE=target/Book-Library-Management-*.jar
COPY --from=build ${JAR_FILE} app.jar

# Commande pour démarrer l'application Spring Boot
ENTRYPOINT ["java", "-jar", "/app.jar"]