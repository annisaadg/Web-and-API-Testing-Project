@endtoend
Feature: End to End

  @endtoend-positive
  Scenario: Melakukan proses pemesanan mulai dari login sampai checkout berhasil
    Given I am on the login page
    When I fill in the username "standard_user"
    And I fill in the password "secret_sauce"
    And I click the login button
    And I am on the dashboard page
    And I add an item to the cart
    And I click the cart icon
    And I am on the cart page
    And I click checkout
    And I fill the First Name with "Lebron"
    And I fill the Last Name with "James"
    And I fill the Postal Code with "40121"
    And I click the continue button
    And I click the finish button
    Then The checkout process is complete, showing Page Title "Checkout: Complete!", Remark "Thank you for your order!", Description "Your order has been dispatched, and will arrive just as fast as the pony can get there!", and a "Back Home" button