package demoBlazePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PlaceOrderForm extends BasePage {
    @FindBy(xpath = "//button[@data-target=\"#orderModal\"]")
    private WebElement placeOrder;

    @FindBy (xpath = "//input[@class=\"form-control\" and @id=\"name\"]")
    private WebElement nameInput;

    @FindBy (xpath = "//input[@class=\"form-control\" and @id=\"country\"]")
    private WebElement countryInput;

    @FindBy (id = "city")
    private WebElement cityInput;

    @FindBy (id = "card")
    private WebElement creditCard;

    @FindBy (id = "month")
    private WebElement monthInput;

    @FindBy (id = "year")
    private WebElement yearInput;

    @FindBy (xpath = "//button[@onclick=\"purchaseOrder()\"]")
    private WebElement purchaseButton;

    @FindBy (xpath = "//button[@class=\"confirm btn btn-lg btn-primary\"]")
    private WebElement confirmButton;

    @FindBy (xpath = "//*[@id=\"orderModal\"]/div/div/div[3]/button[1]")
    private WebElement closeModal;

    public PlaceOrderForm(WebDriver driver) {
        super(driver);
    }

    public void fillOrderForm(){
    openModalRegister();
    fillNameInput();
    fillCountryInput();
    fillCityInput();
    fillCreditCardInput();
    fillMonthInput();
    fillYearInput();
    clickOnPurchaseButton();
    elementsHelper.clickElement(confirmButton);
    elementsHelper.clickElement(closeModal);
    }

    public void openModalRegister(){
        elementsHelper.threadSleep(700);
        elementsHelper.clickElement(placeOrder);
    }

    public void fillNameInput(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement name = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class=\"form-control\" and @id=\"name\"]")));
        elementsHelper.fillElement(nameInput, "name1");
    }

    public void fillCountryInput(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement country = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class=\"form-control\" and @id=\"country\"]")));
        elementsHelper.fillElement(countryInput, "Romania");
    }

    public void fillCityInput(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement city = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("city")));
        elementsHelper.fillElement(city, "Timisoara");
    }

    public void fillCreditCardInput(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement creditCard = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("card")));
        elementsHelper.fillElement(creditCard, "1111111111111111");
    }

    public void fillMonthInput(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement month = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("month")));
        elementsHelper.fillElement(month, "08");
    }

    public void fillYearInput(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement year = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("year")));
        elementsHelper.fillElement(year, "2022");
    }

    public void clickOnPurchaseButton(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement purchase = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@onclick=\"purchaseOrder()\"]")));
        elementsHelper.clickElement(purchase);
    }



    @Override
    public void isPageLoaded() {

    }
}
