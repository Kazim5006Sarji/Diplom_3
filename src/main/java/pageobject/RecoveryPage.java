package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RecoveryPage {
    public WebDriver driver;

    public By recoveryButton;
    public By enterButtonOnRecovery;


    public RecoveryPage(WebDriver driver) {
        this.driver = driver;
        this.recoveryButton = By.xpath(".//button[text()='Восстановить']");
        this.enterButtonOnRecovery = By.xpath(".//a[text()='Войти']");
    }

    public void clickEnterButtonOnRecoveryPage() {
        driver.findElement(enterButtonOnRecovery).click();
    }
}
