# Usando a imagem base do OpenJDK 11
FROM openjdk:11-jre-slim

# Definindo o diretório de trabalho dentro do container
WORKDIR /app

# Copiando o JAR do serviço para o diretório de trabalho
COPY target/API-0.0.1-SNAPSHOT.jar eureka-server.jar

# Expondo a porta em que a aplicação será executada
EXPOSE 8761

# Comando de inicialização da aplicação
ENTRYPOINT ["java", "-jar", "eureka-server.jar"]
