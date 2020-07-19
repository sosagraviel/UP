package uy.com.urupago.automation.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("firefox")
public class FirefoxWebDriver implements MyWebDriver {
    @Override
    public WebDriver webDriver() {
        return new FirefoxDriver();
    }
}
