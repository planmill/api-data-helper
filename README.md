# Tool to test api and insert new data for testing

Tests have methods that could get or modify data through 1.5 API. 

## Basic setup

1. setup env (see below)
1. checkout and compile project
1. create new apiuser through web interface
1. login with that user and create new token (https://online.planmill.com/instance/api/registrations.jsp)
1. copy application.yml.template -> application.yml, and change corresponding settings
1. run ConnectionTest.testConnection() test
1. you should see id of your api user (or error if auth/connection/etc failed)


More info here:
https://github.com/planmill/api/wiki/Security


## Environment setup (for convenience)

1. install java8, git, ide (e.g. eclipse/idea/etc)
1. enable annotation processing in IDE
1. add lombok to IDE

