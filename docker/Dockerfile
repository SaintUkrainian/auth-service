FROM maven:openjdk

WORKDIR /auth-service

COPY . .

EXPOSE 8081

CMD ["mvn", "spring-boot:run", "-Dspring-boot.run.profiles=prod"]