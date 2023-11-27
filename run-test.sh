cd test/SeleniumAWS
mvn test "-DtestSuite=src/test/resources/$1.$2.xml" "-DthreadCount=1" "-Dlambda=no"
