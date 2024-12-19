package pageObjects.utils;

import apis.Validate;
import com.shaft.driver.SHAFT;
import org.openqa.selenium.Cookie;

public class Utils {
    private Utils() {

    }

    public static void navigate(SHAFT.GUI.WebDriver driver, String url) {
        driver.browser().navigateToURL(url);
        driver.browser().deleteAllCookies();
        Cookie cookie = new Cookie.Builder("orangehrm", Validate.validateCookie.replace("orangehrm=",""))
                .domain("opensource-demo.orangehrmlive.com")
                .path("/")
                .isHttpOnly(true)
                .isSecure(true)
                .build();
        driver.getDriver().manage().addCookie(cookie);
        driver.browser().navigateToURL(url);
    }
}
