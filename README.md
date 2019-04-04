# netguru-tests
To run this tests you will need java environment and chromedriver.
I have provided one in resources, but it works for macos chrome version 73.
If you need to run on different chrome version, please download proper chromedriver from:
http://chromedriver.chromium.org/downloads
and put it in test resources folder (src/test/resources).
After that if path/name of file or extension changed, please update also in Hooks.java file
()netguruTests/src/test/java/steps/Hooks.java)

To run tests:
./gradlew cucumber


After finished test run, nicer report can be found at:
netguruTests/target/cucumber-reports/index.html