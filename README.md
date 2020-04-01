# Spring Boot Application Cafeto/Code Chanllenge project


## Built With

* 	[Maven](https://maven.apache.org/) - Dependency Management
* 	[JDK](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) - Java™ Platform, Standard Edition Development Kit 
* 	[Spring Boot](https://spring.io/projects/spring-boot) - Framework to ease the bootstrapping and development of new Spring Applications


## External Tools Used

* [Postman](https://www.getpostman.com/) - API Development Environment (Testing Docmentation)

## To-Do

- [ ] Logger (Console, File, Mail)
- [x] RESTful Web Service (CRUD)
- [ ] Bootstrap - CSS
- [ ] Web - HTML, JavaScript (jQuery)
- [ ] Swagger


## Running the application locally

There are several ways to run a Spring Boot application on your local machine. One way is to execute the `main` method in the `com.cafeto.codechallenge.CodeChallengeApplication` class from your IDE.

- Download the zip or clone the Git repository.
- Unzip the zip file (if you downloaded one)
- Open Command Prompt and Change directory (cd) to folder containing pom.xml
- Open IntelliJ Idea 
   - File -> Import -> Existing Maven Project -> Navigate to the folder where you unzipped the zip
   - Select the project
- Choose the Spring Boot Application file (search for @SpringBootApplication)
- Right Click on the file and Run as Java Application

Alternatively you can use the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) like so:

```shell
mvn spring-boot:run
```

### Security

```
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-security</artifactId>
</dependency>
```

Spring Boot Starter Security default username is `user` and a generated security password is printed in the console like `Using generated security password: 0423bec1-6759-4ed2-8e3e-e8196effadf9`



## Documentation

* [Postman Collection](https://documenter.getpostman.com/view/2449187/RWTiwzb2) - online, with code auto-generated snippets in cURL, jQuery, Ruby,Python Requests, Node, PHP and Go programming languages


## Files and Directories

The project (a.k.a. project directory) has a particular directory structure. A representative project is shown below:

```
.
├── Spring Elements
├── src
│   └── main
│       └── java
│           ├── com.cafeto.codechallenge
│           ├── com.cafeto.codechallenge.config
│           ├── com.cafeto.codechallenge.controller
│           ├── com.cafeto.codechallenge.exception
│           ├── com.cafeto.codechallenge.model
│           └── com.cafeto.codechallenge.repository
├── src
│   └── main
│       └── resources
│           └── static
│           └── templates
│           └─── application.properties
├── src
│   └── test
│       └── java
├── JRE System Library
├── Maven Dependencies
├── pom.xml
└── README.md
```

## packages

- `model` — to hold our entities;
- `repository` — to communicate with the database;
- `config` — to hold our business logic;
- `security` — security configuration;
- `controller` — to listen to the client;
- `resources/application.properties` - It contains application-wide properties. Spring reads the properties defined in this file to configure your application. You can define server’s default port, server’s context path, database URLs etc, in this file.

- `test/` - contains unit and integration tests

- `pom.xml` - contains all the project dependencies
 
  
## Resources

* [My API Lifecycle Checklist and Scorecard](https://dzone.com/articles/my-api-lifecycle-checklist-and-scorecard)
* [HTTP Status Codes](https://www.restapitutorial.com/httpstatuscodes.html)
* [Bootstrap w3schools](https://www.w3schools.com/bootstrap/)
* [Common application properties](https://docs.spring.io/spring-boot/docs/current/reference/html/common-application-properties.html)


