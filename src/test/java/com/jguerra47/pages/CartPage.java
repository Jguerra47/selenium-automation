package com.jguerra47.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CartPage extends BasePage {
    @FindBy(xpath = "//div[@class='cart_footer']/button[@data-test='checkout']")
    WebElement checkoutButton;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void goToCheckout() {
        wait.until(ExpectedConditions.elementToBeClickable(checkoutButton)).click();
    }
}
