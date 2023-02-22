import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SiteProfilePage {
    private final WebDriver driver;

    private final By profileLocator = By.xpath("/html/body/div[5]/div/div/div/div[2]/div[2]/span[1]");

    public SiteProfilePage(WebDriver driver) {
        this.driver = driver;
    }

    public String getName() {
        return driver.findElement(profileLocator).getText();
    }
}
