Feature: Menu

    Scenario: Verifikasi halaman Menu
        Given I have successfully logged in
        When I click the menu button
        Then I should see all menu items

    Scenario: Verifikasi menu "Logout"
        Given I have successfully logged in
        And I have clicked the menu button
        When I click the "Logout" button
        Then I have logged out successfully
    
    Scenario: Verifikasi menu "About"
        Given I have successfully logged in
        And I have clicked the menu button
        When I click the "About" button
        Then I should be redirected to the Swag Labs website
        