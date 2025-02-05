package demoBlazePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ShoppingPage extends BasePage {
    @FindBy (xpath = "//a[@onclick=\"byCat('monitor')\"]")
    private WebElement category;

    @FindBy (xpath = "//*[@id=\"tbodyid\"]/div[2]/div/div/h4/a")
    private WebElement firstItem;

    @FindBy (xpath = "//*[@id=\"tbodyid\"]/div[2]/div/a")
    private WebElement addCart;

    @FindBy (xpath = "//a[@class=\"hrefch\" and text()='ASUS Full HD']")
    private WebElement secondItem;

    public ShoppingPage(WebDriver driver) {
        super(driver);
    }

    public void selectFirstItem(){
        elementsHelper.clickElement(firstItem);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement modal = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"tbodyid\"]/div[2]/div/a")));
        elementsHelper.clickElement(addCart);
        alertHelpers.waitForAlert();
        alertHelpers.acceptAlert();
    }

    public void selectSecondItem(){
        elementsHelper.clickElement(category);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement product = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"tbodyid\"]/div[2]/div/a")));
        elementsHelper.clickElement(secondItem);
        WebElement button = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"tbodyid\"]/div[2]/div/a")));
        elementsHelper.clickElement(addCart);
        alertHelpers.waitForAlert();
        alertHelpers.acceptAlert();
    }

    @Override
    public void isPageLoaded() {
    }
}
