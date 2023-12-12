cd /tmp/SeleniumAWS || exit
mvn test "-DtestSuite=/tmp/SeleniumAWS/src/test/resources/$1" "-DthreadCount=1" "-Dlambda=no"
