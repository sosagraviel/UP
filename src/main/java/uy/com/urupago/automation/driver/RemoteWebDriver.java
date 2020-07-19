package uy.com.urupago.automation.driver;

import lombok.RequiredArgsConstructor;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import uy.com.urupago.automation.config.AutomationProperties;

import java.net.URI;

@RequiredArgsConstructor
@Configuration
@Profile("remote")
public class RemoteWebDriver implements MyWebDriver {

    private final AutomationProperties properties;

    @Override
    public WebDriver webDriver() throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setPlatform(Platform.LINUX);
        capabilities.setBrowserName("chrome");
        capabilities.setJavascriptEnabled(true);

        return new org.openqa.selenium.remote.RemoteWebDriver(
                URI.create(properties.getDrivers().getRemote().getDriverPath()).toURL(),
                capabilities
        );
    }
}
