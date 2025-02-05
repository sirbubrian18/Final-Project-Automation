package demoBlazeTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;



public class TestPage {

    public WebDriver driver;
    public String testName;

    @BeforeMethod
    public void openBrowser() {
        driver = new ChromeDriver();

        driver.get("https://www.demoblaze.com/");
        //Facem fereastra la dimensiunea maxima:
        driver.manage().window().maximize();

        //Facem fereastra la dimensiunea dorita: 1980 cu 1080
        // driver.manage().window().setSize(new Dimension(1980, 1080));

    }

    @AfterMethod
    public void quitBrowser(ITestResult result) {
//        if (driver != null) {
//            driver.quit();
//        }
    }
}
