# Usando a imagem base do OpenJDK 11
FROM openjdk:11-jre-slim

# Definindo o diretório de trabalho dentro do container
#WORKDIR /app

# Copiando o JAR do serviço para o diretório de trabalho
COPY target/Order-Service-0.0.1-SNAPSHOT.jar order-service.jar

# Expondo a porta em que a aplicação será executada
#EXPOSE 8081

# Comando de inicialização da aplicação
ENTRYPOINT [ "java", "-jar", "order-service.jar" ]