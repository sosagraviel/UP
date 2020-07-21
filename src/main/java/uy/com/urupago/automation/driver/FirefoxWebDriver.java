package uy.com.urupago.automation.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("firefox")
public class FirefoxWebDriver {


    @Bean
    public WebDriver webDriver() {
        //System.setProperty("webdriver.gecko.driver", properties.getDrivers().getFirefox().getDriverPath());
        System.setProperty("webdriver.firefox.logfile", "firefoxdriver.log");
        System.setProperty("webdriver.firefox.verboseLogging", "true");
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--allow-insecure-localhost", "--dns-prefetch-disable", "--verbose", "--whitelisted-ips=''");
        return new FirefoxDriver(options);
    }
}
