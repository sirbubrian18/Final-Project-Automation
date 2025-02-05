package demoBlazePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegisterPage extends BasePage{
    @FindBy (id = "sign-username")
    private WebElement newUserName;

    @FindBy (id = "sign-password")
    private WebElement password;

    @FindBy (xpath = "//*[@id=\"signInModal\"]/div/div/div[3]/button[1]")
    private WebElement closeModal;

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    public void registerForm(){
        fillNewUserNameInput();
        fillPasswordInput();
        clickOnClose();
    }

    public void fillNewUserNameInput(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement modal = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("sign-username")));
        elementsHelper.fillElement(newUserName, "username1");
    }

    public void fillPasswordInput(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement modal = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("sign-password")));
        elementsHelper.fillElement(password, "parola1");
    }

    public void clickOnClose(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement modal = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"signInModal\"]/div/div/div[3]/button[1]")));
        elementsHelper.clickElement(closeModal);
    }

    @Override
    public void isPageLoaded() {
    }
}
