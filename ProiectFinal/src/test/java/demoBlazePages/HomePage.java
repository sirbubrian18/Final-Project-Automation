package demoBlazePages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
    @FindBy (xpath = "//a[@class=\"navbar-brand\"]")
    private WebElement homePageButton;

    @FindBy (id = "signin2")
    private WebElement signInButton;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void returnToHomePage(){
        elementsHelper.clickElement(homePageButton);
    }

    public void clickOnSignInButton(){
        elementsHelper.clickElement(signInButton);
    }

    @Override
    public void isPageLoaded() {

    }
}
