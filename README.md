# test-framework

## Run Tests

### IntelliJ

* Navigate to `/src/test/java/*`
* Select the test you want to run either in the project window OR test class
    * Right click and select
        * `Run'test_name'` OR
        * `Debug'test_name'`
    * Use the keyboard shortcut
        * `^+Shift+R` to run
        * `^+Shift+D` to debug

### Command Line

In terminal, navigate to project root and type

**note this will run all Test functions with the `@Test` tag**

To run tests
 ```
 ./gradlew clean test 
```

## View Test Output

* Open browser
* Select Open File
* Open file `ptsd/build/reports/tests/test/index.html`
* Review Test Summary

## Improvements

* DriverFactory to allow browser instanciate abstraction
* SeleniumGrid integration to allow tests to run in parallel
* Test annotation grouping to run tests in command line as a group
* Integrate Gherkin/Cucumber framework in `/main` to allow test writting in given/when/then constructs
* Move Elements & Utilities `src/test/java/*` into `/src/main` to integrate with Gherkin/Cucmber
* Add log4j to address logging capabilities
* Replace Junit 4 with compatible unit test runner with paralle test running capabilities