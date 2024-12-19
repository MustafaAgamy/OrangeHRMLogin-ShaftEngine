import apis.Login;
import apis.Validate;
import com.shaft.driver.SHAFT;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.DashboardPage;

public class DashboardTest {
    private SHAFT.GUI.WebDriver driver;
    private SHAFT.API api;

    @Test
    public void testDashboard() {
        new DashboardPage(driver)
                .navigate()
                .assertNavigationIsSuccessful("System Users");
    }

    @BeforeMethod
    public void setUp() {
        api = new SHAFT.API(System.getProperty("baseUrl"));

        new Login(api)
                .login();
        new Validate(api)
                .validate();

        driver = new SHAFT.GUI.WebDriver();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
