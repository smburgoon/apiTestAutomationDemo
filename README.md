# API Test Automation Demonstration

Uses RESTAssured to run a suite of simple API tests against a given endpoint. 

Intended to build upon this to add models for various API endpoints.

Currently invokes from the IDE; 

## RequestForm API


NOTE: I did not implement a cucumber / BDD layer here for time's sake I simply am documenting the test cases and demonstrating code structure

tests against the given API https://github.com/samuel-chabot/simple-form-app/tree/main/src/be/SimpleFormApp

validate http://localhost:4200/api/RequestForm

1. POST to create a new ticket
   2. should respond with 201
      3. this is actually in error, it responds with 200
   3. validate request headers (ex. content-type)
   4. should contain the "id" of the newly created ticket in the response body
2. GET an existing ticket, validate fields are as expected
   3. should respond with 200
   4. should respond with body containing ticket data matching expected known values for existing ticket
   3. this provides insight into whether there have been breaking database contract changes
4. GET an unknown ticket
   5. should respond with 404
4. PUT to update an existing ticket happy path
   5. should respond with 200 OK
5. PUT to update an existing ticket unhappy (check validation errors)
   6. should respond with 400 or 422
5. DELETE the previously created ticket (not the well known one)
   6. should respond with 201 empty body 

# TODO

1. Will need to learn how to invoke this and collect results from command Line such that these tests can be run as part of a pipeline