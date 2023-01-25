package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EnterPage {
    public WebDriver driver;

    public WebDriverWait wait;
    public By emailArea;
    public By passwordArea;
    public By registrationLink;
    public By enterButton;
    public By recoveryPasswordLink;

    public EnterPage(WebDriver driver) {
        this.driver = driver;
        this.emailArea = By.xpath("//label[text()='Email']/following::input[1]");
        this.passwordArea = By.xpath("//label[text()='Пароль']/following::input[1]");
        this.registrationLink = By.xpath("//*[@id=\"root\"]/div/main/div/div/p[1]/a");
        this.enterButton = By.xpath(".//button[contains(text(), \"Войти\")]");
        this.recoveryPasswordLink = By.xpath(".//a[contains(text(),'Восстановить пароль')]");
    }

    public void enterEmail(String email) {
        driver.findElement(emailArea).sendKeys(email);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordArea).sendKeys(password);
    }

    public void clickEnterButton() {
        driver.findElement(enterButton).click();
    }

    public void clickRegistrationButton() {
        driver.findElement(registrationLink).click();
    }

    public void clickRecoveryPasswordButton() {
        driver.findElement(recoveryPasswordLink).click();
    }
}