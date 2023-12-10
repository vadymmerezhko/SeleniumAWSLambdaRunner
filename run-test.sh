cd git/SeleniumAWS

sudo yum install unzip -y

wget 	https://edgedl.me.gvt1.com/edgedl/chrome/chrome-for-testing/120.0.6099.71/linux64/chrome-linux64.zip
unzip chrome-linux64

wget https://edgedl.me.gvt1.com/edgedl/chrome/chrome-for-testing/120.0.6099.71/linux64/chromedriver-linux64.zip
unzip chromedriver-linux64

git clone https://github.com/vadymmerezhko/SeleniumAWS.git
mvn test "-DtestSuite=src/test/resources/$1" "-DthreadCount=1" "-Dlambda=no"
