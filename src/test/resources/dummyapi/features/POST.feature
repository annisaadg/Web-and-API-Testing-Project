@api
Feature: POST

  # Background:
  #   Given all request header is properly setup

  @post-negative
  Scenario: Test create new user normal
    Given prepare url for "CREATE_NEW_USER"
    When hit api post create new user with app-id "662e68fabb70a7086a25966e"
    Then validation status code api user is equals 200
    Then validation response body post create new user
    Then validation response json with JSONSchema "post_half_user.json"