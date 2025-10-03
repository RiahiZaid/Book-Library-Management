Architecture et Exécution Locale (Docker Compose)
L'application est conteneurisée à l'aide de Docker Compose pour faciliter l'environnement de développement local.

Prérequis
Docker Desktop (ou Docker Engine)

Java 21 JDK (pour le développement local)

Démarrage Rapide
Cloner le dépôt :

git clone [VOTRE_URL_REPO]
cd book-library-management

Lancer l'application et la base de données :
La commande suivante construit l'image de l'API et lance le conteneur ainsi que la base de données PostgreSQL (tel que défini dans docker-compose.yml).

docker compose up --build -d

Accès :
L'API est maintenant disponible sur http://localhost:8081.

⚙️ Pipeline d'Intégration Continue (Jenkins)
Le projet utilise Jenkins pour automatiser le cycle de vie de l'application, garantissant que chaque modification est testée et prête à être déployée rapidement.

Vue des Étapes du Pipeline
Le pipeline Jenkins est un processus déclaratif qui orchestre le build, les tests et le déploiement de l'application.

Comme illustré dans le tableau de la Stage View, chaque étape est chronométrée pour assurer l'efficacité :

Checkout SCM : Récupération du code source depuis Git.

Tool Install : Configuration de l'environnement (Maven, JDK).

Build : Exécution du mvn package pour créer le JAR.

Test : Exécution des tests unitaires et d'intégration.

Deploy : Packaging Docker (build de l'image) et poussée vers un registre.
<img width="938" height="432" alt="1" src="https://github.com/user-attachments/assets/5739e5b9-8041-497a-a189-9fa34b7d1bc0" />


🧪 Documentation de l'API (Endpoints)
L'API de la bibliothèque fournit les fonctionnalités CRUD de base pour la gestion des livres. Les exemples ci-dessous montrent les requêtes effectuées via Postman.

1. GET : Récupérer tous les livres
Requête : GET http://localhost:8081/api/books/getBooks

2. PUT : Modifier un livre existant
Requête : PUT http://localhost:8081/api/books/book/1

3. DELETE : Supprimer un livre
Requête : DELETE http://localhost:8081/api/books/delete/1

