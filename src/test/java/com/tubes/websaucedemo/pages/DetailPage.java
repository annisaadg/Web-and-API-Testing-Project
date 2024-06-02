package com.tubes.websaucedemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DetailPage {

    public DetailPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@id='item_4_img_link']")
    private WebElement gambarProduk;

    @FindBy(css = "button[data-test='add-to-cart']")
    private WebElement buttonAdd;

    @FindBy(css = "button[data-test='remove']")
    private WebElement buttonRemove;

    @FindBy(className = "shopping_cart_badge")
    private WebElement shoppingCartBadge;

    @FindBy(id = "back-to-products")
    private WebElement buttonBack;

    // Elemen untuk halaman detail produk menggunakan atribut class dan data-test
    @FindBy(className = "inventory_details_img")
    private WebElement detailGambarProduk;

    @FindBy(css = "div[data-test='inventory-item-name']")
    private WebElement detailNamaProduk;

    @FindBy(css = "div[data-test='inventory-item-desc']")
    private WebElement detailDeskripsiProduk;

    @FindBy(css = "div[data-test='inventory-item-price']")
    private WebElement detailHargaProduk;

    public void clickGambar() {
        gambarProduk.click();
    }

    public void clickAddToCart() {
        buttonAdd.click();
    }

    public void clickRemove() {
        buttonRemove.click();
    }

    public void clickBackToProduk() {
        buttonBack.click();
    }

    // Metode untuk mendapatkan detail halaman produk
    public boolean isDetailPageDisplayed() {
        return detailGambarProduk.isDisplayed() && detailNamaProduk.isDisplayed()
                && detailDeskripsiProduk.isDisplayed() && detailHargaProduk.isDisplayed()
                && buttonAdd.isDisplayed();
    }

    public boolean isDetailPageDisplayed2() {
        return buttonRemove.isDisplayed() && shoppingCartBadge.isDisplayed();
    }

    // Metode untuk mendapatkan informasi produk
    public String getNamaProduk() {
        return detailNamaProduk.getText();
    }

    public String getDeskripsiProduk() {
        return detailDeskripsiProduk.getText();
    }

    public String getHargaProduk() {
        return detailHargaProduk.getText();
    }

    public String getGambarProdukSrc() {
        return detailGambarProduk.getAttribute("src");
    }

    public String getGambarProdukAlt() {
        return detailGambarProduk.getAttribute("alt");
    }

    public String getGambarProdukDataTest() {
        return detailGambarProduk.getAttribute("data-test");
    }

    // Metode untuk mendapatkan jumlah item di keranjang belanja
    public String getShoppingCartBadge() {
        return shoppingCartBadge.getText();
    }

    // Metode untuk memeriksa apakah tombol "Remove" ditampilkan
    public boolean isRemoveButtonDisplayed() {
        return buttonRemove.isDisplayed();
    }
}
