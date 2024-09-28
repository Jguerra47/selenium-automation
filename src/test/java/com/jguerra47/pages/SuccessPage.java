package com.jguerra47.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SuccessPage extends BasePage {
    @FindBy(xpath = "//div[@data-test=\"header-container\"]/div[@data-test=\"secondary-header\"]/span[@data-test=\"title\"]")
    WebElement successTitle;

    public SuccessPage(WebDriver driver) {
        super(driver);
    }

    public String getTitle() {
        return successTitle.getText();
    }
}
