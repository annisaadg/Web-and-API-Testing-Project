@checkout
Feature: Checkout

  @checkout-positive
  Scenario: Melanjutkan proses checkout dengan Field First Name, Last Name dan Zip/Postal Code sudah terisi
    Given I have successfully logged in
    And I am on the dashboard page
    And I have added an item to the cart
    And I have opened the cart page and clicked checkout
    When I fill the First Name with "Lebron"
    And I fill the Last Name with "James"
    And I fill the Postal Code with "40121"
    And I click the continue button
    Then I should see the page title "Checkout: Overview"
    And I should see list of items bought including the name, description, and price of the item
    And I should see the payment information as "SauceCard #31337", shipping information as "Free Pony Express Delivery!", and Total Price information
    And I should see Cancel Button and Continue Button

  @checkout-positive1
  Scenario: Menyelesaikan proses checkout pada halaman checkout overview 
    Given I have successfully logged in
    And I am on the dashboard page
    And I have added an item to the cart
    And I have processed the checkout by filling the data with First Name "Lebron", Last Name "James", and Postal Code "40121"
    When I click the finish button
    Then The checkout process is complete, showing Page Title "Checkout: Complete!", Remark "Thank you for your order!", and a "Back Home" button

  @checkout-positive1
  Scenario: Melanjutkan belanja pada halaman checkout complete 
    Given I have successfully logged in
    And I am on the dashboard page
    And I have added an item to the cart
    And I have processed the checkout by filling the data with First Name "Lebron", Last Name "James", and Postal Code "40121"
    And I click the finish button
    When I click the Back Home button
    Then I am on the dashboard page
    And I should see the dashboard page title "Products"
    And I should see a list of items with name, description, image, price, and an "Add to cart" button
