package pageobject;

import net.datafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage {
    public WebDriver driver;
    Faker faker = new Faker();
    String name = faker.name().firstName();
    String email = faker.internet().emailAddress();
    String password = String.valueOf(faker.number().numberBetween(1000000, 99999999));

    public By nameArea;
    public By emailArea;
    public By passwordArea;
    public By registrationButton;
    public By enterButtonLink;
    public By errorText;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
        this.nameArea = By.xpath("//label[text()='Имя']/following::input[1]");
        this.emailArea = By.xpath("//label[text()='Имя']/following::input[2]");
        this.passwordArea = By.xpath("//label[text()='Имя']/following::input[3]");
        this.registrationButton = By.xpath(".//button[contains(text(),'Зарегистрироваться')]");
        this.enterButtonLink = By.xpath(".//a[contains(text(),'Войти')]");
        this.errorText = By.xpath("//p[text()='Некорректный пароль']");
    }

    public void enterName(String name) {
        driver.findElement(nameArea).sendKeys(name);
    }

    public void enterEmail(String email) {
        driver.findElement(emailArea).sendKeys(email);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordArea).sendKeys(password);
    }

    public void clickRegistrationButton() {
        driver.findElement(registrationButton).click();
    }
}