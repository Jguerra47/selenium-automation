package com.jguerra47.tests;

import com.jguerra47.pages.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CheckoutTest extends BaseTest {
    LoginPage loginPage;
    ProductsPage productsPage;
    CartPage cartPage;
    CheckoutPage checkoutPage;
    SuccessPage successPage;

    @BeforeEach
    public void initializePages() {
        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
        cartPage = new CartPage(driver);
        checkoutPage = new CheckoutPage(driver);
        successPage = new SuccessPage(driver);
    }


    @Test
    public void checkoutPricesMatchTest() {
        // Arrange
        int numberOfItems = 3;
        loginPage.open("https://www.saucedemo.com/");

        // Act
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.login();

        List<String> shopPricesText = productsPage.getPrices(numberOfItems);
        productsPage.addProductsToCart(numberOfItems);
        productsPage.goToCart();

        cartPage.goToCheckout();

        checkoutPage.enterCheckoutInformation("John", "Doe", "12345");

        List<String> checkoutPricesText = checkoutPage.getCheckoutPrices(numberOfItems);
        double itemTotalPrice = checkoutPage.getSubtotal();
        checkoutPage.finishPurchase();

        String successMessage = successPage.getTitle();

        double sumOfShopPrices = shopPricesText.stream()
                .mapToDouble(price -> Double.parseDouble(price.replace("$", "")))
                .sum();

        // Assert
        assertEquals(shopPricesText, checkoutPricesText, "Prices on the checkout do not match the shop prices.");
        assertEquals("Checkout: Complete!", successMessage, "The success message is not as expected.");
        assertEquals(sumOfShopPrices, itemTotalPrice, "The subtotal does not match the sum of the product prices.");
    }
}
