import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class InitialTest {

    public WebDriver driver;

    @BeforeTest
    public void setupWebDriver() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.navigate().to("http://automationpractice.com/");
        Thread.sleep(5000);
    }

    @AfterTest
    public void cleanupWebDriver() throws InterruptedException {
        System.out.println();
        driver.manage().deleteAllCookies();
        Thread.sleep(5000);
        driver.close();
    }

}
