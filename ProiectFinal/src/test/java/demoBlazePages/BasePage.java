package demoBlazePages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import webHelper.AlertHelpers;
import webHelper.ElementsHelper;

import java.util.HashMap;
import java.util.Map;

public abstract class BasePage {

    //Vom folosi aceasta variabila in toate paginile care o sa mostenita Base Page;
    public WebDriver driver;
    public ElementsHelper elementsHelper;
    public AlertHelpers alertHelpers;

    //Facem un constructor care sa initializeze driver-ul;
    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.elementsHelper = new ElementsHelper(driver);
        this.alertHelpers =new AlertHelpers(driver);
        PageFactory.initElements(driver, this);
    }

    public void chromeConfig() {
        System.setProperty("webdriver.chrome.driver", "C:\\Tools\\chromedriver\\");

        ChromeOptions options = new ChromeOptions();

        options.addArguments("--incognito");

        Map<String, Object> prefs = new HashMap<>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);

        options.setExperimentalOption("prefs", prefs);

        WebDriver driver = new ChromeDriver(options);

        // Navighează pe site
        driver.get("https://www.demoblaze.com/");

        // Execută JavaScript pentru a dezactiva managerul de parole
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(
                "Object.defineProperty(navigator, 'credentials', { value: { preventSilentAccess: () => {}, store: () => {}, get: () => {} } });"
        );

        // Continuă cu pașii de automatizare...
    }

    //Facem o metoda abstracta pe care fiecare pagina trebuie sa o implementeze pt a verifica daca pagina este incarcata corect;
    public abstract void isPageLoaded();
}
