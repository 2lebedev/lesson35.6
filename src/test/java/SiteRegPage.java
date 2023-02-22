import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SiteRegPage {
    private final WebDriver driver;
    private final By nameLocator = By.name("name");
    private final By surnameLocator = By.name("surname");
    private final By usernameLocator = By.name("username");
    private final By emailLocator = By.xpath("//*[@id=\"reg_form\"]/form/div[3]/input");
    private final By passwordLocator = By.xpath("//*[@id=\"reg_form\"]/form/div[4]/input");
    private final By regButtonLocator = By.xpath("//*[@id=\"reg_form\"]/form/div[5]/button");

    public SiteRegPage(WebDriver driver) {

        this.driver = driver;
    }

    public void  openPage() {

        driver.get("https://knigavuhe.org/register/");
    }

    public void sendKeysNameField(String name) {

        driver.findElement(nameLocator).sendKeys(name);
    }

    public void sendKeysSurnameField(String surname) {

        driver.findElement(surnameLocator).sendKeys(surname);
    }

    public void sendKeysUsernameField(String username) {

        driver.findElement(usernameLocator).sendKeys(username);
    }

    public void sendKeysEmailField(String email) {

        driver.findElement(emailLocator).sendKeys(email);
    }

    public void sendKeysPasswordField(String password) {

        driver.findElement(passwordLocator).sendKeys(password);
    }

    public SiteProfilePage clickRegButton() {
        driver.findElement(regButtonLocator).click();
        return new SiteProfilePage(driver);
    }

    public SiteProfilePage enterRegData (String name, String surname, String username, String email, String password) {
        sendKeysNameField(name);
        sendKeysSurnameField(surname);
        sendKeysUsernameField(username);
        sendKeysEmailField(email);
        sendKeysPasswordField(password);
        return clickRegButton();
    }
}
