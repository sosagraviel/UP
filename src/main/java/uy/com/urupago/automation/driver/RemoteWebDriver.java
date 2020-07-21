package uy.com.urupago.automation.driver;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import uy.com.urupago.automation.config.AutomationProperties;

import java.net.URI;


@Configuration
@Profile("remote")
public class RemoteWebDriver{

    private final AutomationProperties properties= new AutomationProperties();

    @Bean
    public WebDriver webDriver() throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setPlatform(Platform.LINUX);
        capabilities.setBrowserName("remote");
        capabilities.setJavascriptEnabled(true);

        return new org.openqa.selenium.remote.RemoteWebDriver(
                URI.create(properties.getDrivers().getRemote().getDriverPath()).toURL(),

                capabilities
        );
    }
}
