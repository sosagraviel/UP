package uy.com.urupago.automation.driver;

import lombok.RequiredArgsConstructor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import uy.com.urupago.automation.config.AutomationProperties;


@RequiredArgsConstructor
@Configuration
@Profile("chrome")
public class ChromeWebDriver {

    private final AutomationProperties properties;



    @Bean
    public WebDriver webDriver() {
        System.setProperty("webdriver.chrome.driver", properties.getDrivers().getChrome().getDriverPath());
        System.setProperty("webdriver.chrome.logfile", "chromedriver.log");
        System.setProperty("webdriver.chrome.verboseLogging", "true");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--allow-insecure-localhost", "--dns-prefetch-disable", "--verbose", "--whitelisted-ips=''");
        return new ChromeDriver(options);
    }
}
