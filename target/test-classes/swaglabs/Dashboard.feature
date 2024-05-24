Feature: Dashboard

  Scenario: Verifikasi Tampilan Daftar Barang
    Given I have successfully logged in
    And I am on the dashboard page
    Then I should see a list of items with name, description, image, price, and an "Add to cart" button

  @focus
  Scenario: Verifikasi Tampilan Menuju Halaman Cart
    Given I have successfully logged in
    And I am on the dashboard page
    Then I should see the cart icon displayed

  Scenario: Validasi Button "Add to Cart" Berubah menjadi "Remove"
    Given I have successfully logged in
    And I am on the dashboard page
    And I have added an item to the cart
    Then the button should change to "Remove"
