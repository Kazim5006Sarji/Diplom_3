import api.model.ResponseWithToken;
import api.model.User;
import configuration.TestProperties;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import net.datafaker.Faker;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.html5.WebStorage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobject.*;

import java.util.Collections;
import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.given;

public class BaseTest {
    protected static WebDriver driver;
    protected static WebDriverWait wait;
    protected static ConstructorPage objConstructorPage;
    protected static EnterPage objEnterPage;
    protected static PersonalAreaPage objPersonalAreaPage;
    protected static RegistrationPage objRegistrationPage;
    protected static RecoveryPage objRecoveryPage;
    static Faker faker;
    static String name;
    static String email;
    static String password;
    static User user;

    protected static TestProperties properties = TestProperties.getInstance();
    protected final String URL = "https://stellarburgers.nomoreparties.site/";

    public WebDriver initDriver() {
        if (properties.getProperties("browser").equals("yandex")) {
            System.setProperty("webdriver.chrome.driver", "src/drv/chromedriver.exe");
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.setBinary("C:\\Users\\kazim\\AppData\\Local\\Yandex\\YandexBrowser\\Application\\browser.exe");
            driver = new ChromeDriver(chromeOptions);
        } else {
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.setExperimentalOption("useAutomationExtension", false);
            chromeOptions.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(chromeOptions);
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        objConstructorPage = new ConstructorPage(driver);
        objEnterPage = new EnterPage(driver);
        objPersonalAreaPage = new PersonalAreaPage(driver);
        objRegistrationPage = new RegistrationPage(driver);
        objRecoveryPage = new RecoveryPage(driver);
        wait = new WebDriverWait(driver, 60L);
        faker = new Faker();
        name = faker.name().firstName();
        email = faker.internet().emailAddress();
        password = String.valueOf(faker.number().numberBetween(1000000, 99999999));
        user = new User(email, password);
        RestAssured.baseURI = "https://stellarburgers.nomoreparties.site";
        return driver;
    }

    @Before
    public void setUp() {
        initDriver().get(URL);
    }

    public void clearData() {
        Response response = given()
                .header("Content-type", "application/json")
                .body(user)
                .when()
                .post("/api/auth/login");
        if (response.statusCode() == 200) {
            ResponseWithToken token = response.body().as(ResponseWithToken.class);

            if (token != null) {
                Response deleteUser = given().header("Authorization", token.getAccessToken())
                        .delete("/api/auth/user");
                deleteUser.then().assertThat().statusCode(202);
            }
        }
        driver.manage().deleteAllCookies();
        ((WebStorage) driver).getLocalStorage().clear();
        ((WebStorage) driver).getSessionStorage().clear();

    }

    @After
    public void tearDown() {
        clearData();
        driver.quit();
    }

    public void registration() {
        objRegistrationPage.enterName(name);
        objRegistrationPage.enterEmail(email);
        objRegistrationPage.enterPassword(password);
        objRegistrationPage.clickRegistrationButton();
    }

    public void auth() {
        objEnterPage.enterEmail(email);
        objEnterPage.enterPassword(password);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(objEnterPage.enterButton)));
        objEnterPage.clickEnterButton();
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(objEnterPage.enterButton)));
    }

}