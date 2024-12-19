package apis;

import com.shaft.driver.SHAFT;
import io.restassured.response.Response;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Login {

    private SHAFT.API api;
    public static String loginCookie;
    public static String token;

    public Login(SHAFT.API api) {
        this.api = api;
    }
    public Login() {

    }

    public Login login() {
        Response response = api.get("web/index.php/auth/login")
                .addHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.7")
                .addHeader("Accept-Language", "en-US,en;q=0.9")
                .addHeader("Connection", "keep-alive")
                .addHeader("Referer", "https://www.google.com/")
                .addHeader("Sec-Fetch-Dest", "document")
                .addHeader("Sec-Fetch-Mode", "navigate")
                .addHeader("Sec-Fetch-Site", "cross-site")
                .addHeader("Sec-Fetch-User", "?1")
                .addHeader("Upgrade-Insecure-Requests", "1")
                .addHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/131.0.0.0 Safari/537.36")
                .addHeader("sec-ch-ua", "\"Google Chrome\";v=\"131\", \"Chromium\";v=\"131\", \"Not_A Brand\";v=\"24\"")
                .addHeader("sec-ch-ua-mobile", "?0")
                .addHeader("sec-ch-ua-platform", "\"Windows\"")
                .perform();

        String setCookie = response.getHeader("set-cookie");
        String responseBody = response.getBody().asPrettyString();

        loginCookie = extractCookie(setCookie)[0];
        token = extractToken(responseBody);

        return this;
    }

    private String[] extractCookie(String setCookie) {
        return setCookie.trim().split(";");
    }

    private String extractToken(String responseBody) {
        Pattern pattern = Pattern.compile("token=\\\"&quot;(.*?)&quot;\\\"");
        String localToken = "";
        Matcher matcher = pattern.matcher(responseBody);

        if (matcher.find()) {
            localToken = matcher.group(1);
        }
        return localToken;
    }

}
