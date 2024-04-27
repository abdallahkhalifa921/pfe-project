# Utiliser l'image Java 17
FROM openjdk:17-alpine

# Définir le répertoire de travail
WORKDIR /app

# Copier le build jar dans le conteneur
COPY target/*.jar app.jar

# Exposer le port sur lequel l'application va écouter
EXPOSE 8080

# Commande pour exécuter l'application
ENTRYPOINT ["java", "-jar", "app.jar"]

