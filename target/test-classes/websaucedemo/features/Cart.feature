@cart
Feature: Cart

  @cart-positive
  Scenario: Verifikasi halaman keranjang kosong
    Given I have successfully logged in
    When I am on the dashboard page
    And I click the cart icon
    Then I see an empty cart page that contains Title page, Continue Shopping button, Checkout button
    
  @cart-positive
  Scenario: Verifikasi halaman keranjang berisi barang
    Given I have successfully logged in
    When I am on the dashboard page
    And I click the add to cart in product Sauce Labs Backpack button
    And I click the cart icon
    Then I see a cart page with items that contain Title page, List of items containing item name, item description, and price, Continue Shopping button, Checkout button

  @cart-positive
  Scenario: Verifikasi operasi tekan tombol "Continue Shopping" pada halaman keranjang
    Given I have successfully logged in
    When I am on the dashboard page
    And I click the cart icon
    And I click the Continue Shopping button
    Then I am on the dashboard page