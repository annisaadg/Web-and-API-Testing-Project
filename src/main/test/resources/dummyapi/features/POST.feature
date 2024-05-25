@api
Feature: POST

  @post-negative
  Scenario: Test success create new user with incomplete data
    Given prepare url for "create new user"
    When i prepare for app-id "662e68fabb70a7086a25966e"
    When enter request data with firstname "John", lastname "Doe", and email "jnisss1@example.com"
    When i send the POST request with valid user data input
    Then validation status code api user is equals 200
    Then validation response body post create new user