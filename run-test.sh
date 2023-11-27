git pull https://github.com/vadymmerezhko/SeleniumAWS.git
cd SeleniumAWS
mvn test "-DtestSuite=./src/test/resources/org.example.Selenium1Test.signUp1.xml" "-DthreadCount=1" "-Dlambda=no"
