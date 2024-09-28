package com.jguerra47.pages;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CheckoutPage extends BasePage {
    @FindBy(xpath = "//div[@class=\"checkout_info\"]/div[@class=\"form_group\"]/input[@data-test=\"firstName\"]")
    WebElement firstNameInput;
    @FindBy(xpath = "//div[@class=\"checkout_info\"]/div[@class=\"form_group\"]/input[@data-test=\"lastName\"]")
    WebElement lastNameInput;
    @FindBy(xpath = "//div[@class=\"checkout_info\"]/div[@class=\"form_group\"]/input[@data-test=\"postalCode\"]")
    WebElement postalCodeInput;
    @FindBy(xpath = "//div[@class='checkout_buttons']/input")
    WebElement continueButton;
    @FindBy(xpath = "//div[@class=\"summary_info\"]/div[@class=\"cart_footer\"]/button[@data-test='finish']")
    WebElement finishButton;
    @FindBy(xpath = "//div[@class=\"summary_info\"]/div[@data-test=\"subtotal-label\"]")
    WebElement subtotalLabel;
    @FindBy(xpath = "//div[@data-test]/div[@data-test=\"inventory-item\"]/div/div[@class=\"item_pricebar\"]/div")
    List<WebElement> checkoutPrices;

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public void enterCheckoutInformation(String firstName, String lastName, String postalCode) {
        firstNameInput.sendKeys(firstName);
        lastNameInput.sendKeys(lastName);
        postalCodeInput.sendKeys(postalCode);
        continueButton.click();
    }

    public void finishPurchase() {
        wait.until(ExpectedConditions.elementToBeClickable(finishButton)).click();
    }

    public double getSubtotal() {
        String subtotalText = subtotalLabel.getText().split("\\$")[1];
        return Double.parseDouble(subtotalText);
    }

    public List<String> getCheckoutPrices(int quantity) {
        return checkoutPrices.stream()
                .limit(quantity)
                .map(WebElement::getText)
                .toList();
    }
}

