// Jenkinsfile
pipeline {
    // Exécuter le pipeline sur n'importe quel agent (serveur Jenkins)
    agent any

    // Définir les outils Maven et JDK avec les NOMS EXACTS configurés dans Jenkins
    tools {
        maven 'M3_HOME'
        jdk 'JDK-21'
    }

    stages {

        // 1. Étape de Construction (Compilation et Packaging)
        stage('Build') {
            steps {
                echo '▶️ Démarrage de la construction de l\'application Spring Boot avec Maven...'
                // Clean : Supprime les artefacts précédents
                // Install : Compile, exécute le package et met l'artefact dans le dépôt local de Maven
                sh 'mvn clean install -DskipTests'
            }
        }

        // 2. Étape de Test
        stage('Test') {
            steps {
                echo '🧪 Exécution des tests unitaires et d\'intégration...'
                // Exécute la phase 'test' de Maven (nécessite que le Build ait réussi)
                sh 'mvn test'
                // Optionnel : Archiver les rapports de tests pour Jenkins (JUnit format)
                // junit '**/target/surefire-reports/TEST-*.xml'
            }
        }

        // 3. Étape de Déploiement
        stage('Deploy') {
            steps {
                echo '🚀 Déploiement de l\'application sur le serveur...'

                // 🛑 Étape 3a: Arrêter l'ancienne instance
                // pkill -f : recherche et tue le processus qui contient le nom de l'application JAR.
                // || true : permet à la commande de ne pas faire échouer le pipeline si l'application n'est pas encore démarrée.
                sh 'pkill -f "Book-Library-Management" || true'

                // 🛑 Étape 3b: Démarrer la nouvelle instance
                // nohup : permet à l'application de continuer à rouler après que la session SSH de Jenkins se ferme.
                // & : lance le processus en arrière-plan.
                // target/*.jar : trouve le fichier JAR généré (ex: Book-Library-Management-0.0.1-SNAPSHOT.jar)
                sh 'nohup java -jar target/*.jar > app.log 2>&1 &'

                echo '✅ Application Book-Library-Management lancée en arrière-plan.'

                // Optionnel : Attendre quelques secondes pour s'assurer que l'application démarre
                // sh 'sleep 10'
            }
        }
    }
}