# Routee Java SDK      

[![Join the chat at https://gitter.im/randinterval/Routee-Java-SDK](https://badges.gitter.im/randinterval/Routee-Java-SDK.svg)](https://gitter.im/randinterval/Routee-Java-SDK?utm_source=badge&utm_medium=badge&utm_campaign=pr-badge&utm_content=badge)[![Codacy Badge](https://api.codacy.com/project/badge/Grade/f722206bcb70415198f40964277a0184)](https://www.codacy.com/app/randinterval/Routee-Java-SDK?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=randinterval/Routee-Java-SDK&amp;utm_campaign=Badge_Grade) [![Coverage Status](https://coveralls.io/repos/github/randinterval/Routee-Java-SDK/badge.svg?branch=master)](https://coveralls.io/github/randinterval/Routee-Java-SDK?branch=master)

Routee JAVA SDK provides the necessary classes to communicate with Routee Services in Java. It currently supports all of the services offered by the Routee:

  - Messaging
  - Accounts
  - Authentication
  - Reports
  - Two Step Verification

### Dependencies

Routee Java SDK uses a number of open source projects to work properly:

* [OKHttp] - An HTTP & HTTP/2 client for Java Applications - We use it to communicate with Routee REST API.
* [JSON] - JSON Parser to convert responses from Routee API to JAVA Objects and vice versa
* [Maven] - We use maven build system 
* [JUnit] - We use JUnit for unit testing the code - Tests have been written for the entire SDK.

### Installation

You can either build the jar from source or use the existing jar included in the repository  (RouteeJavaSDK.jar). 

To use the jar, simply include the jar file into your project, and add it to your build path. You'd then need to export the classes that you want to use.

### To Build from Source:

We use Maven build system, you can generate jar by using the following commands:

Simply go into SDK Directory (RouteeJavaSDK), and run the following commands

```sh
$ mvn dependency:resolve
$ mvn -Dmaven.test.skip=true install
```
First command is used to get all the dependencies for the project (OKHttp,JSON,JUnit). Second command will build the jar file from source code (The jar file will be located in target folder).

### Testing

Unit Tests have been written in JUnit for the SDK. To run the tests, simply type
```sh
$ mvn tests
```

You'll need to setup the test environment variables to run the test suite. You can do so by modifying src/test/java/net/routee/TestConfiguraiton.Java file.


### Contributing

I would love to have your helping hand on Routee Java SDK! I have followed [Google Java Style Guide](https://google.github.io/styleguide/javaguide.html), so please follow the Style Guide if you're interested in contributing to the project :)

### Documentation

Documentation for the SDK is available at [Routee Java SDK Documentation Repo](https://github.com/randinterval/Routee-Java-SDK-Docs)
