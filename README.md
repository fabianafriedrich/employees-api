_**DEMO:**_<br/>
The full project demo deployed on Heroku can be found at: https://employee-ui.heroku.com

**_Cloning Projects:_**<br/>
Employees-ui: https://github.com/fabianafriedrich/angular-employees-ui.git

Employees-api: https://github.com/fabianafriedrich/employees-api.git

_**Employees API Documentation:**_<br/>
GET: /employee<br/>
● Returns a list of employees<br/>
GET: /employee/:code<br/>
● Returns a single employee by code<br/>
POST: /employee/signup<br/>
● Create new employee<br/>
PUT: /employee/update<br/>
● Update employee data<br/>
DELETE: /employee/:code<br/>
● Delete employee

**_Starting Back-end (development)_**<br/>
Install maven (https://maven.apache.org/install.html)<br/>
Install MySQL DB (https://dev.mysql.com/doc/mysql-installation-excerpt/5.7/en/)<br/>

Create in your local MYSQL the database name: **hitech_health_db**<br/>
update the property _spring.datasource.password=_ in application.properties file with your local MYSQL password.<br/>

_**Start Back-end**_<br/>
cd employees-api<br/>
mvn clean install<br/>
java -jar target/*.jar<br/>

_**Run unit tests Back-end (development)**_<br/>
mvn test
