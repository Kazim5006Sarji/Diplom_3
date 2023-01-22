import jdk.jfr.Description;
import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.junit.Assert.assertEquals;

public class EnterTest extends BaseTest {

    @Test
    @Description("Вход через кнопку «Личный кабинет»")
    public void enterButtonOnMainPage() {
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(objConstructorPage.personalAreaButton)));
        objConstructorPage.clickPersonalAreaButton();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(objEnterPage.registrationLink)));
        objEnterPage.clickRegistrationButton();
        registration();
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(objEnterPage.enterButton)));
        auth();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(objConstructorPage.makeOrder)));
        assertEquals("Оформить заказ", driver.findElement(objConstructorPage.makeOrder).getText());
        objConstructorPage.clickPersonalAreaButton();
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(objPersonalAreaPage.quitButton)));
        objPersonalAreaPage.clickQuitButton();
    }

    @Test
    @Description("Вход по кнопке «Войти в аккаунт» на главной")
    public void enterButtonPersonalArea() {
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(objConstructorPage.personalAreaButton)));
        objConstructorPage.clickPersonalAreaButton();
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(objEnterPage.registrationLink)));
        objEnterPage.clickRegistrationButton();
        registration();
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(objEnterPage.enterButton)));
        auth();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(objConstructorPage.makeOrder)));
        assertEquals("Оформить заказ", driver.findElement(objConstructorPage.makeOrder).getText());
        objConstructorPage.clickPersonalAreaButton();
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(objPersonalAreaPage.quitButton)));
        objPersonalAreaPage.clickQuitButton();
    }

    @Test
    @Description("Вход через кнопку в форме регистрации")
    public void enterButtonOnRegistrationPage() {
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(objConstructorPage.personalAreaButton)));
        objConstructorPage.clickPersonalAreaButton();
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(objEnterPage.registrationLink)));
        objEnterPage.clickRegistrationButton();
        registration();
        wait.until(ExpectedConditions.elementToBeClickable((driver.findElement(objEnterPage.enterButton))));
        auth();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(objConstructorPage.makeOrder)));
        assertEquals("Оформить заказ", driver.findElement(objConstructorPage.makeOrder).getText());
        objConstructorPage.clickPersonalAreaButton();
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(objPersonalAreaPage.quitButton)));
        objPersonalAreaPage.clickQuitButton();
    }

    @Test
    @Description("Вход через кнопку в форме восстановления пароля")
    public void enterButtonOnRecoveryPage() {
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(objConstructorPage.personalAreaButton)));
        objConstructorPage.clickPersonalAreaButton();
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(objEnterPage.registrationLink)));
        objEnterPage.clickRegistrationButton();
        registration();
        wait.until(ExpectedConditions.elementToBeClickable((driver.findElement(objEnterPage.enterButton))));
        objEnterPage.clickRecoveryPasswordButton();
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(objRecoveryPage.recoveryButton)));
        objRecoveryPage.clickEnterButtonOnRecoveryPage();
        wait.until(ExpectedConditions.elementToBeClickable((driver.findElement(objEnterPage.enterButton))));
        auth();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(objConstructorPage.makeOrder)));
        assertEquals("Оформить заказ", driver.findElement(objConstructorPage.makeOrder).getText());
        objConstructorPage.clickPersonalAreaButton();
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(objPersonalAreaPage.quitButton)));
        objPersonalAreaPage.clickQuitButton();
    }
}