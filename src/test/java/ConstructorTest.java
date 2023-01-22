import jdk.jfr.Description;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(JUnitParamsRunner.class)
public class ConstructorTest extends BaseTest {

    private final Object[] getTestData() {
        return new Object[]{
                new Object[]{"Булки"},
                new Object[]{"Соусы"},
                new Object[]{"Начинки"}
        };
    }

    @Test
    @Parameters(method = "getTestData")
    @Description("Проверяем, что по клику на вкладку {0} происходит переход к вкладке {0}")
    public void checkActiveTab(String tab) {
        if (!driver.findElement(objConstructorPage.getTabElement(tab)).getAttribute("class").contains("current")) {
            driver.findElement(objConstructorPage.getTabElement(tab)).click();
        }
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(objConstructorPage.getTabElement(tab))));
        assertTrue("Переход к владке " + tab + " не произошел",
                driver.findElement(objConstructorPage.getTabElement(tab)).getAttribute("class").contains("current"));
    }
}