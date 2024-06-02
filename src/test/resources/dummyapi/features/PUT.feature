@put
Feature: PUT

  @post-positive
  Scenario: Melakukan request update user ketika tidak ada app-id pada header
    Given I set up the URL for "update user"
    And I prepare the app-id ""
    And I load user profile data from JSON file "src/test/resources/dummyapi/data/user_profile_update.json"
    When I send a PUT request with the user id "663068bc22f582dd9b5e428c"
    Then The API response status code should be 403


  @post-positive
  Scenario: Melakukan request update user ketika app-id pada header ada namun nilainya salah
    Given I set up the URL for "update user"
    And I prepare the app-id "662e60f6bb70a70a3a2595f1"
    And I load user profile data from JSON file "src/test/resources/dummyapi/data/user_profile_update.json"
    When I send a PUT request with the user id "663068bc22f582dd9b5e428c"
    Then The API response status code should be 403

  @post-positive
  Scenario: Melakukan update user dengan parameter id tidak sesuai
    Given I set up the URL for "update user"
    And I prepare the app-id "662e60f6bb70a70a3a2595fd"
    And I load user profile data from JSON file "src/test/resources/dummyapi/data/user_profile_update.json"
    When I send a PUT request with the user id "663068bc22f582dd9b5e428c1"
    Then The API response status code should be 400

  @post-positive
  Scenario: Melakukan update user dengan parameter id tidak diisi
    Given I set up the URL for "update user"
    And I prepare the app-id "662e60f6bb70a70a3a2595fd"
    And I load user profile data from JSON file "src/test/resources/dummyapi/data/user_profile_update.json"
    When I send a PUT request with the user id ""
    Then The API response status code should be 404

@post-positive
  Scenario: Melakukan update user dengan parameter id tidak diisi
    Given I set up the URL for "update user"
    And I prepare the app-id "662e60f6bb70a70a3a2595fd"
    And I load user profile data from JSON file "src/test/resources/dummyapi/data/user_profile_update.json"
    When I send a PUT request with the user id "663068bc22f582dd9b5e428c"
    Then The API response status code should be 200