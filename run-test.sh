cd /tmp/SeleniumAWS
mvn test "-DtestSuite=/tmp/SeleniumAWS/src/test/resources/$1" "-DthreadCount=1" "-Dlambda=no"
