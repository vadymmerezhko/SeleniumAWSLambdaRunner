cd test/SeleniumAWS
mvn test "-DtestSuite=src/test/resources/$1" "-DthreadCount=1" "-Dlambda=no"
