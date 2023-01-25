package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ConstructorPage {
    public WebDriver driver;
    public WebDriverWait wait;
    public By enterAccountButton;
    public By personalAreaButton;
    public By mainButton;
    public By makeOrder;
    public By nonSelectBuns;
    public By selectBuns;
    public By nonSelectSauces;
    public By selectSauces;
    public By nonSelectFilling;
    public By selectFilling;

    public ConstructorPage(WebDriver driver) {
        this.driver = driver;
        this.enterAccountButton = By.xpath(".//button[contains(text(), \"Войти в аккаунт\")]");
        this.personalAreaButton = By.xpath(".//p[contains(text(), \"Личный Кабинет\")]");
        this.mainButton = By.xpath("//*[@id=\"root\"]/div/header/nav/div/a");
        this.makeOrder = By.xpath(".//button[text()='Оформить заказ']");
        this.nonSelectBuns = By.xpath("//div[contains(@class, 'noselect')]/span[text()='Булки']");
        this.selectBuns = By.xpath("//div[contains(@class, 'current')]/span[text()='Булки']");
        this.nonSelectSauces = By.xpath("//span[@class='text text_type_main-default'][text()='Соусы']");
        this.selectSauces = By.xpath("//div[contains(@class, 'current')]/span[text()='Соусы']");
        this.nonSelectFilling = By.xpath("//div[contains(@class, 'noselect')]/span[text()='Начинки']");
        this.selectFilling = By.xpath("//div[contains(@class, 'current')]/span[text()='Начинки']");
    }

    public void clickPersonalAreaButton() {
        driver.findElement(personalAreaButton).click();
    }

    public void clickMainButton() {
        driver.findElement(mainButton).click();
    }

    public By getTabElement(String tabName) {
        return By.xpath("//div[./span[text()='" + tabName + "']]");
    }

}