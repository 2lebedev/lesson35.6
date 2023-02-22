import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public class SiteTest {
    private WebDriver driver;

    @BeforeAll
    static void installDriver() {

        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void beforeTest() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void siteTest() {
        SiteRegPage siteRegPage = new SiteRegPage(driver);
        siteRegPage.openPage();
        SiteProfilePage siteProfilePage = siteRegPage.enterRegData("Артемий", "Синицын", "temasinitsyn", "sinitsyn_cucumber@gmail.su", "tema123456");

        System.out.println(siteProfilePage.getName());
    }

    @AfterEach
    public void closeBrowser() {
        driver.close();
    }
}
