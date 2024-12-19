package apis;

import com.shaft.driver.SHAFT;
import io.restassured.response.Response;

public class Validate {

    private SHAFT.API api;
    public static String validateCookie;

    public Validate(SHAFT.API api) {
        this.api = api;
    }
    public Validate() {

    }

    public Validate validate() {
        Response response = api.post("web/index.php/auth/validate")
                .addHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.7")
                .addHeader("accept-encoding", "gzip, deflate, br, zstd")
                .addHeader("Accept-Language", "en-US,en;q=0.9")
                .addHeader("Cache-Control", "max-age=0")
                .addHeader("Connection", "keep-alive")
                .addHeader("Content-Type", "application/x-www-form-urlencoded")
                .addHeader("Cookie",Login.loginCookie)
                .addHeader("host", "opensource-demo.orangehrmlive.com")
                .addHeader("Origin", "https://opensource-demo.orangehrmlive.com")
                .addHeader("Referer", "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login")
                .addHeader("sec-ch-ua", "\"Google Chrome\";v=\"131\", \"Chromium\";v=\"131\", \"Not_A Brand\";v=\"24\"")
                .addHeader("sec-ch-ua-mobile", "?0")
                .addHeader("sec-ch-ua-platform", "\"Windows\"")
                .addHeader("Sec-Fetch-Dest", "document")
                .addHeader("Sec-Fetch-Mode", "navigate")
                .addHeader("Sec-Fetch-Site", "same-origin")
                .addHeader("Sec-Fetch-User", "?1")
                .addHeader("Upgrade-Insecure-Requests", "1")
                .addHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/131.0.0.0 Safari/537.36")
                .setRequestBody("_token=" + Login.token + "&username=Admin&password=admin123")
                .perform();

        String setCookie = response.getHeader("set-cookie");
        validateCookie = extractCookie(setCookie)[0];

        return this;
    }

    private String[] extractCookie(String setCookie) {
        return setCookie.trim().split(";");
    }
}
