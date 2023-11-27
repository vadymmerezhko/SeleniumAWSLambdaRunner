cd test/SeleniumAWS
mvn test "-DtestSuite=src/test/resources/org.example.Selenium1Test.signUp1.xml" "-DthreadCount=1" "-Dlambda=no"
