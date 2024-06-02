@delete
Feature: DELETE

  @delete-positive
  Scenario: Test to delete existing user data with correct app-id in header
    Given I set up the URL for "delete user"
    And I prepare the app-id "662ca6cad9ec7557d41a378a"
    When I send a DELETE request with the user id "665c09604fd179981f762ef3"
    Then The API response status code should be 200
    And The response body should show the id of the deleted user

  @delete-negative
  Scenario: Test to delete existing user data without app-id in header
    Given I set up the URL for "delete user"
    And I prepare the app-id ""
    When I send a DELETE request with the user id ""
    Then The API response status code should be 403
    And The response body should contain error "APP_ID_MISSING"

  @delete-negative
  Scenario: Test to delete existing user data with incorrect app-id in header
    Given I set up the URL for "delete user"
    And I prepare the app-id "662ca6cad9ec7557d41a378"
    When I send a DELETE request with the user id ""
    Then The API response status code should be 403
    And The response body should contain error "APP_ID_NOT_EXIST"

  @delete-negative
  Scenario: Test to delete non-existing user data with correct app-id in header
    Given I set up the URL for "delete user"
    And I prepare the app-id "662ca6cad9ec7557d41a378a"
    When I send a DELETE request with the user id "60d0fe4f5311236168a109c1"
    Then The API response status code should be 404
    And The response body should contain error "RESOURCE_NOT_FOUND"
  
  @delete-negative
  Scenario: Test to delete data by passing invalid user id format as parameter with correct app-id in header
    Given I set up the URL for "delete user"
    And I prepare the app-id "662ca6cad9ec7557d41a378a"
    When I send a DELETE request with the user id "60d0fe4f5311236168a109c"
    Then The API response status code should be 400
    And The response body should contain error "PARAMS_NOT_VALID"