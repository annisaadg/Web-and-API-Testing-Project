@api
Feature: POST

  @post-negative
  Scenario: Test creating a new user with full fields
    Given I set up the URL for "create new user"
    And I prepare the app-id "662e68fabb70a7086a25966e"
    And I load user profile data from JSON file "src/test/resources/dummyapi/data/user_profile.json"
    When I send a POST request with the user data
    Then The API response status code should be 200
    And The response body should match the expected user creation schema with "full" field data

  @post-negative
  Scenario: Test creating a new user with only required fields
    Given I set up the URL for "create new user"
    And I prepare the app-id "662e68fabb70a7086a25966e"
    And I load user profile data from JSON file "src/test/resources/dummyapi/data/user_profile_required.json"
    When I send a POST request with the user data
    Then The API response status code should be 200
    And The response body should match the expected user creation schema with "required" field data
