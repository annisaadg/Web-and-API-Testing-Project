Feature: GET

  @get-positive
  Scenario: Test to get existing user data with valid app-id in header
    Given I set up the URL for "get user by id"
    And I prepare the app-id "662ca6cad9ec7557d41a378a"
    When I send a GET request with the user id "60d0fe4f5311236168a109fa"
    Then The API response status code should be 200
    And The response body should show the full data of the user

  @get-negative
  Scenario: Test to get existing user data without app-id in header
    Given I set up the URL for "get user by id"
    And I prepare the app-id ""
    When I send a GET request with the user id "60d0fe4f5311236168a109fa"
    Then The API response status code should be 403
    And The response body should contain error "APP_ID_MISSING"

  @get-negative
  Scenario: Test to get existing user data with invalid app-id in header
    Given I set up the URL for "get user by id"
    And I prepare the app-id "662ca6cad9ec7557d41a378"
    When I send a GET request with the user id "60d0fe4f5311236168a109fa"
    Then The API response status code should be 403
    And The response body should contain error "APP_ID_NOT_EXIST"

  @get-negative
  Scenario: Test to get non-existing user data with valid app-id in header
    Given I set up the URL for "get user by id"
    And I prepare the app-id "662ca6cad9ec7557d41a378a"
    When I send a GET request with the user id "60d0fe4f5311236168a109c1"
    Then The API response status code should be 404
    And The response body should contain error "RESOURCE_NOT_FOUND"
  
  @get-negative
  Scenario: Test to get data by passing invalid user id format as parameter with valid app-id in header
    Given I set up the URL for "get user by id"
    And I prepare the app-id "662ca6cad9ec7557d41a378a"
    When I send a GET request with the user id "60d0fe4f5311236168a109c"
    Then The API response status code should be 400
    And The response body should contain error "PARAMS_NOT_VALID"