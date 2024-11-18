Feature: API Testing with RestAssured

   @API_Test
   Scenario: Test GET endpoint
      Given the API base URI is "https://api.example.com"
      When I send a GET request to "/endpoint"
      Then the response status code should be 200
      And the response body should contain "key" with value "value"

   @API_Test_2
   Scenario: Test POST endpoint
      Given the API base URI is "https://api.example.com"
      When I send a POST request to "/endpoint" with body:
      """
      { "name": "example" }
      """
      Then the response status code should be 201
      And the response body should contain "id"