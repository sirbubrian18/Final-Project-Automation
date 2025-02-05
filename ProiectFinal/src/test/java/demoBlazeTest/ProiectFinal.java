package demoBlazeTest;

import demoBlazePages.*;
import org.testng.annotations.Test;

public class ProiectFinal extends TestPage{

    @Test
    public void demoBlazeRun() {
        HomePage homePage = new HomePage(driver);
        homePage.isPageLoaded();
        homePage.clickOnSignInButton();
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.isPageLoaded();
        registerPage.registerForm();
        ShoppingPage shoppingPage = new ShoppingPage(driver);
        shoppingPage.isPageLoaded();
        shoppingPage.selectFirstItem();
        homePage.returnToHomePage();
        shoppingPage.selectSecondItem();
        homePage.returnToHomePage();
        CartPage cartPage = new CartPage(driver);
        cartPage.isPageLoaded();
        cartPage.finishTheOrder();
        PlaceOrderForm placeOrderForm = new PlaceOrderForm(driver);
        placeOrderForm.fillOrderForm();
        homePage.returnToHomePage();
    }
}
