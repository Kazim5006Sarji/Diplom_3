import jdk.jfr.Description;
import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.junit.Assert.assertEquals;

public class PersonalAreaTest extends BaseTest {

    @Test
    @Description("Переход в личный кабинет")
    public void checkEnterPersonalArea() {
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(objConstructorPage.personalAreaButton)));
        objConstructorPage.clickPersonalAreaButton();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(objEnterPage.registrationLink)));
        objEnterPage.clickRegistrationButton();
        registration();
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(objEnterPage.enterButton)));
        auth();
        objConstructorPage.clickPersonalAreaButton();
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(objPersonalAreaPage.quitButton)));
        assertEquals("Выход", driver.findElement(objPersonalAreaPage.quitButton).getText());
        objPersonalAreaPage.clickQuitButton();
    }

    @Test
    @Description("Переход из личного кабинета в конструктор по кнопке конструктор")
    public void checkGoToConstructorFromPersonalArea() {
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(objConstructorPage.personalAreaButton)));
        objConstructorPage.clickPersonalAreaButton();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(objEnterPage.registrationLink)));
        objEnterPage.clickRegistrationButton();
        registration();
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(objEnterPage.enterButton)));
        auth();
        objConstructorPage.clickPersonalAreaButton();
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(objPersonalAreaPage.quitButton)));
        objPersonalAreaPage.clickConstructorButton();
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(objConstructorPage.makeOrder)));
        assertEquals("Оформить заказ", driver.findElement(objConstructorPage.makeOrder).getText());
        objConstructorPage.clickPersonalAreaButton();
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(objPersonalAreaPage.quitButton)));
        objPersonalAreaPage.clickQuitButton();
    }

    @Test
    @Description("Переход из личного кабинета в конструктор по кнопке Stellar Burgers")
    public void checkGoToStellarBurgersFromPersonalArea() {
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(objConstructorPage.personalAreaButton)));
        objConstructorPage.clickPersonalAreaButton();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(objEnterPage.registrationLink)));
        objEnterPage.clickRegistrationButton();
        registration();
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(objEnterPage.enterButton)));
        auth();
        objConstructorPage.clickPersonalAreaButton();
        objConstructorPage.clickMainButton();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(objConstructorPage.makeOrder)));
        assertEquals("Оформить заказ", driver.findElement(objConstructorPage.makeOrder).getText());
        objConstructorPage.clickPersonalAreaButton();
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(objPersonalAreaPage.quitButton)));
        objPersonalAreaPage.clickQuitButton();
    }

    @Test
    @Description("Проверь выход по кнопке «Выйти» в личном кабинете")
    public void exitFromPersonalArea() {
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(objConstructorPage.personalAreaButton)));
        objConstructorPage.clickPersonalAreaButton();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(objEnterPage.registrationLink)));
        objEnterPage.clickRegistrationButton();
        registration();
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(objEnterPage.enterButton)));
        auth();
        objConstructorPage.clickPersonalAreaButton();
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(objPersonalAreaPage.quitButton)));
        objPersonalAreaPage.clickQuitButton();
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(objEnterPage.enterButton)));
        assertEquals("Войти", driver.findElement(objEnterPage.enterButton).getText());
    }
}