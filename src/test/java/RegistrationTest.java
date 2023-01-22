import jdk.jfr.Description;
import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.junit.Assert.assertEquals;

public class RegistrationTest extends BaseTest {

    @Test
    @Description("Проверка успешной регистрации")
    public void successRegistration() {
        objConstructorPage.clickPersonalAreaButton();
        objEnterPage.clickRegistrationButton();
        registration();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(objEnterPage.enterButton)));
        assertEquals("Войти", driver.findElement(objEnterPage.enterButton).getText());
    }

    @Test
    @Description("Проверка ошибку для некорректного пароля. Минимальный пароль — шесть символов.")
    public void failedRegistration() {
        objConstructorPage.clickPersonalAreaButton();
        objEnterPage.clickRegistrationButton();
        objRegistrationPage.enterName(faker.name().firstName());
        objRegistrationPage.enterEmail(faker.internet().emailAddress());
        objRegistrationPage.enterPassword("1");
        objRegistrationPage.clickRegistrationButton();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(objRegistrationPage.errorText)));
        assertEquals("Некорректный пароль", driver.findElement(objRegistrationPage.errorText).getText());
    }
}