import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public class SiteRegistrationTest {
    private WebDriver driver;
    @Given("browser is open")
    public void browserIsOpen() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @And("user is on a website registration page")
    public void userIsOnWebsitePage() {
        SiteRegPage siteRegPage = new SiteRegPage(driver);
        driver.get("https://knigavuhe.org/register/");
        siteRegPage.openPage();
    }
    
    @When("user enters correct registration data in form")
    public void userEntersRegDataInForm () {
        SiteRegPage siteRegPage = new SiteRegPage(driver);
        SiteProfilePage siteProfilePage = siteRegPage.enterRegData("Артемий", "Синицын", "artemiysinitsyn11", "sinitsyn_cucumber@gmail.su", "tema123456");

        System.out.println(siteProfilePage.getName());
    }

    @When("user enters incorrect registration data in form")
    public void userEntersBadRegDataInForm () {
        SiteRegPage siteRegPage = new SiteRegPage(driver);
        SiteProfilePage siteProfilePage = siteRegPage.enterRegData("Артемий", "Синицын", "artemiysinitsyn11", "sinitsyn_cucumbergmail.su", "1");

        System.out.println(siteProfilePage.getName());
    }

    @And("click on 'Зарегистрироваться' button")
    public void clickOnRegButton() {
        SiteRegPage siteRegPage = new SiteRegPage(driver);
        siteRegPage.clickRegButton();
    }

    @Then("user is navigated to 'Profile' page on a website")
    public void userIsNavigatedToProfilePage() {
        SiteProfilePage siteProfilePage = new SiteProfilePage(driver);
        System.out.println(siteProfilePage.getName());
        driver.close();
    }
}
