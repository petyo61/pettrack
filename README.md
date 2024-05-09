### pettrack
Pet tracking application demo
### warning 
This is a demo application and should not be used in production.
There is no security implemented in this application.

### build and run
* To build the application, you can use the following command:
```mvn clean install```
* To run the application, you can use the following command:
```java -jar target/pet-tracker-demo.jar```

### access
* To access the application, you can use the following URL:
```http://localhost:8080```
* To access H2 console, you can use the following URL:
```http://localhost:8080/h2-console``` the JDBC URL is ```jdbc:h2:mem:petdb```
* 
### notes
* The application uses an in-memory H2 database. It can be easily replaced with a different database by changing the configuration in the application.properties file. And changing the maven dependencies in the pom.xml file.