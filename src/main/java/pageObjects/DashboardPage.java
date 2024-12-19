package pageObjects;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;import pageObjects.utils.Utils;

public class DashboardPage {
    private SHAFT.GUI.WebDriver driver;

    private final By dashboardPageTitle = By.tagName("h5");

    public DashboardPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }
    public DashboardPage() {

    }

    public DashboardPage navigate() {
        Utils.navigate(driver, "https://opensource-demo.orangehrmlive.com/web/index.php/admin/viewSystemUsers");
        return this;
    }

    public DashboardPage assertNavigationIsSuccessful(String dashboardTitle) {
        driver.assertThat().element(dashboardPageTitle).text().isEqualTo(dashboardTitle);
        return this;
    }
}
