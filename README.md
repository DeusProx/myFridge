# myJerseyRest

This project contains a small Java Rest Backend written with the Jersey Framework, Swagger and is buildet by gradle.
## Contents
* [Run it in Linux](#11-run-it-in-linux)
* [Run it in Windows](#12-run-it-in-windows)
* [Use it](#13-use-it)
* [Start developing (Linux)](#14-start-developing-linux)
* [Code Structure] (#code-structure)
* [Committers] (#committers)

## 1. Getting started
### 1.1 Run it in Linux
* You need to have a valid JDK installed. See [1.4](#14-start-developing-linux) for how to install Java from Oracle.
* Download & extract the project
```
wget https://github.com/DeusProx/myJerseyRest/archive/master.zip
unzip master.zip
cd myJersey-Rest
```
* Run the gradle wrapper
```
./gradlew clean build appRun
```

### 1.2 Run it in Windows
* You need to have a valid JDK installation: http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html
* Download the project from https://github.com/DeusProx/myJerseyRest/archive/master.zip
* Extract it with some windows tool and rename the directory containing the project to "myJerseyRest". Otherwise all following URLs will change according to the name you set.
* Run the gradle wrapper inside the project
```
gradlew.bat clean build appRun
```

### 1.3 Use it
Now you can reach our Swagger application by opening [http://localhost:8080/myJerseyRest](http://localhost:8080/myJerseyRest) in your favorit browser. Swagger lists every resource of your API and provides an easy way to test your implemented functions.
![alt text](https://github.com/DeusProx/myJerseyRest/blob/master/docu/jersey.swagger.example.png "Logo Title Text 1")
The real API is reachable via the url [http://localhost:8080/myJerseyRest/api](http://localhost:8080/myJerseyRest/api) and the api-docs created by swagger are reachable under [http://localhost:8080/myJerseyRest/api/api-docs](http://localhost:8080/myJerseyRest/api/api-docs).
### 1.4 Start developing (Linux)
* install java & git & gradle
```
sudo add-apt-repository ppa:webupd8team/java
sudo add-apt-repository ppa:cwchien/gradle
sudo apt-get update
sudo apt-get install oracle-java8-installer git gradle
```
* clone the repository
```
mkdir ~/git
git clone https://github.com/DeusProx/myJerseyRest
cd myJerseyRest
```
* change some code
* run it with gradle
```
gradle clean build appRun
```

### Code structure
```
src/
    main/
        java/.../myJerseyRest
            resources/                  <-- The directory where we place our REST Resources for our API
                Example.java            <-- An Example Resource
            SwaggerJaxrsListener.java   <-- Creates the api-docs
            WebApplication.java         <-- Bootstraps our REST resources
        webapp/*                        <-- Place where our Swagger-UI Webapp is
build.gradle    <-- gradle build management file
gradlew         <-- gradle wrapper for linux; run this if you are on linux and don't have gradle installed
gradlew.bat     <-- gradle wrapper for windows; run this if you are on windows and don't have gradle installed
gretty.plugin   <-- plugin which runs an embedded webserver (jetty)
```
## Committers
```
Developed by
    Gordon Lawrenz <lawrenz@dbis.rwth-aachen.de>
```
