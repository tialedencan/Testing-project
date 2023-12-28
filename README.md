# $${\color[RGB]{128, 0, 128} Testing\space project \space -\space MTTPP }$$
### $${\color[RGB]{128, 0, 128} Automated \space Testing \space of \space Acta \space Croatica }$$

### Used Maven dependencies:
- selenium-java
- testng
- maven-surefire-report-plugin
- maven-compiler-plugin
  
To search for newer versions of dependencies see [MVN Repository](https://mvnrepository.com/ ).

The project uses Page Object Models and implicit waits.

## Running tests
To run the tests from the command line there is a testng.xml file and the following command:
```
mvn test (Ctrl + Enter)
```
NOTE: Execute the command inside the project folder.

<ins>To change the browser</ins> in which the tests will be executed, there is an *Option* class with a static attribute named *browser*.
It can be passed a value of *Chrome* or *Firefox*.
