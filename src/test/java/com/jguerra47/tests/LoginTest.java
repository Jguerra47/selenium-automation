package com.jguerra47.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.jguerra47.pages.ProductsPage;
import com.jguerra47.pages.LoginPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LoginTest extends BaseTest {
    LoginPage loginPage;
    ProductsPage productsPage;

    @BeforeEach
    public void initializePages() {
        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
    }

    @Test
    public void loginTest() {
        // Arrange
        String expectedPageTitle = "Products";

        // Act
        loginPage.open("https://www.saucedemo.com/");
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.login();

        String actualPageTitle = productsPage.getPageTitle();

        // Assert
        assertEquals(expectedPageTitle, actualPageTitle, "The page title after login should be 'Products'.");
    }
}
