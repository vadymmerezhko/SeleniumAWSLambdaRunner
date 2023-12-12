cd /tmp/SeleniumAWS
mvn test "-DtestSuite=/tmp/SeleniumAWS/src/test/resources/org.example.Selenium1Test.signUp1.xml" "-DthreadCount=1" "-Dlambda=no"
