# Prices service

This is a small project designed to query a database for the price of a specific product at a particular date and time. The service is implemented using an in-memory H2 database, adheres to ApiFirst requirements, and includes Swagger-UI documentation. It is also thoroughly tested using JUnit and Mockito for unit tests. Additionally, an accompanying Postman collection is provided for end-to-end testing.

## Run application

To run the application, ensure that your system is equipped with Java 17. Confirm that your `%JAVA_HOME%` is set to Java 17 or that your Maven installation is configured to use this version. Then, execute the command `mvn clean install` or `mvn clean install -DskipTests` if you wish to skip tests. Alternatively, you can utilize your IDE's configurations for a similar setup.

This project follows ApiFirst requirements, using the [price-api.yml](src%2Fmain%2Fresources%2Fprice-api.yml) file as the API specification. It leverages a code generation plugin to create an API controller interface, along with the request and response DTOs, which are declared in the specification file. Don't be alarmed if you encounter errors before running the Maven installation; this is part of the process.

Finally, you can start the application in various ways. Principally, run the [PriceTestApplication](src%2Fmain%2Fjava%2Fcom%2Fgft%2Fpricetest%2FPriceTestApplication) file using Java or execute the command `java -jar pricetest-0.0.1-SNAPSHOT.jar` which can be found here: [pricetest-0.0.1-SNAPSHOT.jar](target%2Fpricetest-0.0.1-SNAPSHOT.jar). Another common method is to use the command mvn spring-boot:run or your IDE's spring boot support.

## Testing

### Unitary tests

This project includes a suite of unit tests. You can run these tests by executing the command `mvn clean install` or by running the tests individually, which are located in the [test](src%2Ftest) folder.

### E2e tests

For end-to-end testing, you can employ the Postman collection provided in the  [Prices.postman_collection.json](..%2FDOCS%2Fimg%2FPrices.postman_collection.json) file. Import this collection into Postman, where you'll find prepared tests in the "Tests" folder. Execute these tests by clicking the "Run Prices" button in the top right corner.

![Postman_tests.png](DOCS%2Fimg%2FPostman_tests.png)

![Postman_runTests.png](DOCS%2Fimg%2FPostman_runTests.png)

You should receive results like this:

![Postman_testsResults.png](DOCS%2Fimg%2FPostman_testsResults.png)

Additional tests have been created to handle error scenarios, covering cases such as missing parameters, invalid parameter types, and improper date formats.

### Integration testing

Finally, the projects have integration testing that you can find on [IntegrationTest.java](src%2Ftest%2Fjava%2Fcom%2Fgft%2Fpricetest%2Finfrastructure%2Fcontroller%2FIntegrationTest.java) file. These tests check the same casuistry as the e2e tests.

## Postman

To explore the API, import the [Prices.postman_collection.json](..%2FDOCS%2FPrices.postman_collection.json) file. Within this collection, you'll find two folders: "Error Control" contains requests designed to test controlled errors, while "Tests" is for end-to-end testing. The "Get basic traffic price" request is your entry point for trying out the API.

## Error Handling

For error handling, the project includes the class [MainExceptionHandler](src%2Fmain%2Fjava%2Fcom%2Fgft%2Fpricetest%2Fexceptions%2Fhandler%2FMainExceptionHandler), which acts as a ControllerAdvice to manage exceptions and generate appropriate responses.

Additionally, there's an example of a custom exception class, [NotFoundTariffPriceException](src%2Fmain%2Fjava%2Fcom%2Fgft%2Fpricetest%2Fexceptions%2Fexception%2FNotFoundTariffPriceException), which includes access to the [MainExceptionHandler](src%2Fmain%2Fjava%2Fcom%2Fgft%2Fpricetest%2Fexceptions%2Fhandler%2FMainExceptionHandler)

## Swagger Documentation

The project provides Swagger-UI for documentation and API testing. Once the service is up and running, you can access the Swagger documentation at [Swagger](http://localhost:9000/swagger-ui/index.html) and you have access to the [API doc](http://localhost:9000/v3/api-docs).

## H2 database

The project automatically runs an H2 database. To access it, use the link [H2 database link](http://localhost:9000/h2-console) and set the JDBC URL to `jdbc:h2:mem:E_COMMERCE`. The login credentials are as follows: `User name: admin` and `Password: admin`.
![h2_login.png](DOCS%2Fimg%2Fh2_login.png)

Please note that using "admin" as both the username and password is for testing purposes. Ideally, you should configure these credentials as environment variables and reference them in [application.yml](src%2Fmain%2Fresources%2Fapplication.yml). However, this complexity is unnecessary for trying out the project, as it's configured to work out of the box. Keep in mind that any changes you make within the H2 database will be lost when the project is stopped.

## Docker

I integrate this service with docker too, if you want to deploy it, you can follow this steps
1. Run `mvn clean install` to generate the .jar file [pricetest-0.0.1-SNAPSHOT.jar](target%2Fpricetest-0.0.1-SNAPSHOT.jar)
2. Open your terminal on root project where is the [Dockerfile](Dockerfile).
3. Run `docker build -t "priceEntities-docker" .`.
4. Finally run `docker run --name priceEntities-service -p 9000:9000 priceEntities-docker:latest`

Now your service is running on localhost:9000. If you want to change expose docker port, you must change the value of **EXPOSE** in [Dockerfile](Dockerfile) and refactor de last command with `docker run --name priceEntities-service -p {newExposePort}:9000 priceEntities-docker:latest`.
You can change internal port too if you want, you have to change property `server.port` in [application.yml](src%2Fmain%2Fresources%2Fapplication.yml) and change last command with `docker run --name priceEntities-service -p 9000:{newInternalPort} priceEntities-docker:latest`

