# Prices service

This is a little project that consult a database to get the price of a specific product on a determinate day and hour.
It's implemented on a H2 database that works on memory, follows ApiFirst requirements and have swagger-ui documentation and is tested with JUnit and Mockito for unitary tests, and you can use a postman collection for e2e tests.

## Run application

The project use maven and java 17, so the first thing you must do is be sure that your `%JAVA_HOME%` is a java 17 version or your that your maven used java is that version. Then you have run the command `mvn clean install` or `mvn clean install -DskipTests` if you want skip the tests. You can use the IDE usages of the similar configuration.

The project is using ApiFirst requirements, so it are using the file [price-api.yml](src%2Fmain%2Fresources%2Fprice-api.yml) as specification of the API and is using codegen plugin for create an API controller interface that are declarated on the file specification as well the request and responses DTOs, so don't scare if you see errors before run maven installation.

And for last step, you can run the application, there are so many ways to do it, but principally you have to run [PriceTestApplication](src%2Fmain%2Fjava%2Fcom%2Fgft%2Fpricetest%2FPriceTestApplication) file with java or execute the command `java -jar pricetest-0.0.1-SNAPSHOT.jar` that you can find here [pricetest-0.0.1-SNAPSHOT.jar](target%2Fpricetest-0.0.1-SNAPSHOT.jar).
Other common way to run the application is using the command `mvn spring-boot:run` or your IDE usages for springboot.

## Testing

### Unitary tests
The project have unitary tests, so you can run the test that you can find under [test](src%2Ftest) folder, or running the before commented command `mvn clean install` and it runs tests automatically.

### E2e tests

For e2e testing, you can use the postman collection json file that you can find here [Prices.postman_collection.json](..%2FDOCS%2Fimg%2FPrices.postman_collection.json) you have to import it and use the running tests you can fine under the folder `Tests` and run them on the `run` bottom that you can find on the right top corner and click on the `Run Prices` bottom of the next window

![Postman_tests.png](..%2FDOCS%2Fimg%2FPostman_tests.png)

![Postman_runTests.png](..%2FDOCS%2Fimg%2FPostman_runTests.png)

And you should have a result like this

![Postman_testsResults.png](..%2FDOCS%2Fimg%2FPostman_testsResults.png)

I have created more tests for error control that check 3 cases, a missing parameter, bad parameter type and a bad date format

## Postman

One way to try the Api, you can import the [Prices.postman_collection.json](..%2FDOCS%2FPrices.postman_collection.json) file. You will find 2 folder and 1 get request. `Error control` folder have a prepared request for check controlled errors. `Tests` folder is for e2e testing. And `Get basic traffic price` is the basic request for try the API.


## Error control

For the error control, the project have the class [MainExceptionHandler](src%2Fmain%2Fjava%2Fcom%2Fgft%2Fpricetest%2Fexceptions%2Fhandler%2FMainExceptionHandler) that is a ControllerAdvice to handle the exceptions to generate the responses for specific exception.

On the other hand, we have an example of custom exception class [NotFoundTariffPriceException](src%2Fmain%2Fjava%2Fcom%2Fgft%2Fpricetest%2Fexceptions%2Fexception%2FNotFoundTariffPriceException) that is created for throws an error when the query returns a empty *List* of *Prices* and is handled by [MainExceptionHandler](src%2Fmain%2Fjava%2Fcom%2Fgft%2Fpricetest%2Fexceptions%2Fhandler%2FMainExceptionHandler)

## Swagger

The project have a swagger-ui and you can use it as documentation or to try the API.

Once you have the service started, you can access to swagger by [Swagger](http://localhost:9000/swagger-ui/index.html) and you have access to the [API doc](http://localhost:9000/v3/api-docs).

## H2 database

The project run automatically the database, if you want to access, you must enter the link [H2 database link](http://localhost:9000/h2-console) and have the JDBC URL as `jdbc:h2:mem:E_COMMERCE`. The credentials to login are `User name: admin` `Password: admin`.

![h2_login.png](..%2FDOCS%2Fimg%2Fh2_login.png)

Obviously, admin-admin as user and password is only for the test and furthermore, I like to configure it as Enviroment variables calling them on [application.yml](src%2Fmain%2Fresources%2Fapplication.yml) as `${H2_USER}` and `${H2_PASS}` but this complicate the project for try it.
Once inside you can use the console to execute queries, but when you stop the project you will lose all changes.

