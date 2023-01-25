package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PersonalAreaPage {
    public WebDriver driver;
    public By quitButton;
    public By constructorButton;

    public PersonalAreaPage(WebDriver driver) {
        this.driver = driver;
        this.quitButton = By.xpath(".//button[contains(text(),\"Выход\")]");
        this.constructorButton = By.xpath(".//p[contains(text(),\"Конструктор\")]");
    }

    public void clickQuitButton() {
        driver.findElement(quitButton).click();
    }

    public void clickConstructorButton() {
        driver.findElement(constructorButton).click();
    }
}