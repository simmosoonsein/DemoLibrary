# Demo Library tests

This demo project will run tests on Web:
=======
This demo project will run tests on Chrome browser for:
* https://raamatukogu.herokuapp.com


### Setup
Prerequisites for running tests:
* Install IntelliJ IDEA (or any other IDE)
* Install gradle https://gradle.org/install/
* Install Java JDK 1.8
* Gradle https://gradle.org/install/


### Tests description

There are 2 tests in total.
1. Creates new books based ont defined test data with TestNG dataprovider
2. Checks if new books are visible in "All books" list

Test page URL is defined in 'testrun.properties' file.
New books are added (and later searched) based on the data described in dataprovider. Meaning: tests will be executed as many times as there is data in dataprovider. At the moment tests will be executed 2 times with following data:
* "Book1", "Lewis", "Summary1", "215788", "Fiction"
* "Book2", "Kenobi", "Summary2", "215789", "Non-fiction"

### Tests execution
There is possibility to run tests 2 different ways:
* TestNG: Open *Tests class, right mouse click on desired test and press "Run.."
* Terminal: For Mac type: './gradlew test' this will run all test cases under 'tests' folder

### Test sample video
You can check how samle set of tests run here: https://youtu.be/9yuMseqR-UE
