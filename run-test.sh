mkdir test
cd test
git clone https://github.com/vadymmerezhko/SeleniumAWS.git; echo "SeleniumAWS is cloned. "
cd SeleniumAWS
mvn test "-DtestSuite=./src/test/resources/org.example.Selenium1Test.signUp1.xml" "-DthreadCount=1" "-Dlambda=no"
