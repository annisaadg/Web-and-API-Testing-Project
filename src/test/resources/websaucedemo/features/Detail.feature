@detail
Feature: Product Detail

  @detail-positive
  Scenario: Verifikasi Halaman Detail Produk ketika Gambar Produk ditekan
    Given I have successfully logged in
    When I am on the dashboard page
    And I click the product image
    Then I have to move to the product details page which displays product data 
    
  @detail-positive
  Scenario: Menambahkan Produk ke Cart
    Given I have successfully logged in
    When I am on the dashboard page
    And I click the product image
    And I am on the detail page
    And I click the add to cart button
    Then I saw the Add to Cart button changed to the Remove button and the notification of the number of items on the cart icon changed where the number of items increased

  @detail-positive
  Scenario: Verifikasi Halaman Dashboard ketika "Back to Product" ditekan
    Given I have successfully logged in
    When I am on the dashboard page
    And I click the product image
    And I am on the detail page
    And I click the Back to Product button
    Then I am on the dashboard page