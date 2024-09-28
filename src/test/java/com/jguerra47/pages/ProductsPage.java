package com.jguerra47.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;
import org.openqa.selenium.support.FindBy;

public class ProductsPage extends BasePage {
    @FindBy(xpath = "(//div[@data-test=\"inventory-item-description\"])/div[@class=\"pricebar\"]/button")
    List<WebElement> addButtons;
    @FindBy(xpath = "(//div[@data-test=\"inventory-item-description\"])/div[@class=\"pricebar\"]/div[@data-test=\"inventory-item-price\"]")
    List<WebElement> prices;
    @FindBy(xpath = "//div[@data-test=\"primary-header\"]/div[@class=\"shopping_cart_container\"]/a")
    WebElement cartButton;
    @FindBy(xpath = "//span[@data-test='title']")
    WebElement pageTitle;

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public List<String> getPrices(int quantity) {
        return prices.stream().limit(quantity).map(WebElement::getText).toList();
    }

    public void addProductsToCart(int quantity) {
        addButtons.stream().limit(quantity).forEach(WebElement::click);
    }

    public void goToCart() {
        cartButton.click();
    }

    public String getPageTitle() {
        return pageTitle.getText();
    }
}
