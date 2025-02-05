package demoBlazePages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage{
    @FindBy (id = "cartur")
    private WebElement cartButton;

    @FindBy (xpath = "//*[@id=\"tbodyid\"]/tr[1]/td[4]/a")
    private WebElement deleteItem;

    @FindBy (xpath = "//button[@data-target=\"#orderModal\"]")
    private WebElement placeOrder;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void finishTheOrder(){
        elementsHelper.clickElement(cartButton);
    }

    @Override
    public void isPageLoaded() {
    }
}
