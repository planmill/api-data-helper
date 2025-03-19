# Tool to test api and insert new data for testing

Tests have methods that could get or modify data through 1.5 API. 

## Basic setup

1. Install java8, git, ide (e.g. eclipse/idea/etc).
1. Enable annotation processing in IDE.
1. Add lombok plugin to IDE.
1. Checkout locally the project from git.
1. In IDE import as gradle project and compile.
1. Login to your Planmill instance and create new user for API.
1. Login with that user and register the new token (https://github.com/planmill/api/wiki/Security#registration).
1. In your local project, navigate to \src\main\resources\. Copy application.yml.template, create a new named application.yml file in the same directory & update it with the appropriate settings:
    * baseUrl,
    * tokenUrl,
    * clientId,
    * clientSecret.
1. Run ConnectionTest.testConnection() test. In the log you should see id of your api user (or error if auth/connection/etc failed).


More info here:
https://github.com/planmill/api/wiki/Security



