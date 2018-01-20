# Routee Java SDK       

[![Codacy Badge](https://api.codacy.com/project/badge/Grade/c6241f5aec5940a895a2d4ca6df79b52)](https://www.codacy.com/app/randinterval/Routee-Java-SDK?utm_source=github.com&utm_medium=referral&utm_content=randinterval/Routee-Java-SDK&utm_campaign=badger)

Routee JAVA SDK provides the necessary classes to communicate with Routee Services. It currently supports all of the services offered by the Routee:

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

To use the jar, simply include the jar file into your project, and add it to your build path. Than simply export the classes that you want to use.

To Build from Source:

We use Maven build system, you can generate jar by using the following commands:

Simply go into SDK Directory (RouteeJavaSDK), and run the following commands

```sh
$ mvn dependency:resolve
$ mvn -Dmaven.test.skip=true install
```
First command is used to get all the dependencies for the project (OKHttp,JSON,JUnit). Second command will build the jar file from source code (The jar file will be located in target folder).

### Testing

The sdk has been thoroughly tested. To run the tests, simply type
```sh
$ mvn tests
```
Please note that, you need to setup test environment prior to running the tests - You can do so my modifying the src/test/java/net/routee/TestConfiguraiton.Java File.


