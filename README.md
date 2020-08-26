##DEMO
The full project demo deployed on Heroku can be found at: https://hitech-health-employees-ui.herokuapp.com

##Cloning Projects
Employees-ui: https://github.com/fabianafriedrich/angular-employees-ui.git

Employees-api: https://github.com/fabianafriedrich/employees-api.git

##Employees API Documentation:
GET: /employee

    ● Returns a list of employees
    
GET: /employee/:code

    ● Returns a single employee by code
    
POST: /employee/signup

    ● Create new employee

PUT: /employee/update

    ● Update employee data
    
DELETE: /employee/:code

    ● Delete employee

##Starting Back-end (development)
Install maven (https://maven.apache.org/install.html)

Install MySQL DB (https://dev.mysql.com/doc/mysql-installation-excerpt/5.7/en/)

Create in your local MYSQL the database name: **hitech_health_db**

update the property _spring.datasource.password=_ in application.properties file with your local MYSQL password.

##start API locally
cd employees-api

mvn clean install

java -jar target/*.jar

##Run unit tests Back-end (development)
mvn test
