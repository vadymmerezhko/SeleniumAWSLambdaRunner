cd test/SeleniumAWS
mvn test "-DtestSuite=src/test/resources/$1.$2" "-DthreadCount=1" "-Dlambda=no"
