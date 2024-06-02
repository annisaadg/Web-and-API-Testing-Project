@detail
Feature: Product Detail

  @detail-positive
  Scenario: Verifikasi Halaman Detail Produk ketika Gambar Produk ditekan
    Given I have successfully logged in
    When I am on the dashboard page
    And I click the product image
    Then I have to move to the product details page which displays product data