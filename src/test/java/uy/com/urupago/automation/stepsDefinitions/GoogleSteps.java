package uy.com.urupago.automation.stepsDefinitions;

import io.cucumber.java8.En;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import uy.com.urupago.automation.POM.POMaddCustomer;
import uy.com.urupago.automation.config.AutomationProperties;

public class GoogleSteps implements En {

    @Autowired
    private AutomationProperties properties;

    private POMaddCustomer poMaddCustomer;

    public GoogleSteps(WebDriver driver) {
        Given("^Open the browser$", () -> {
            driver.get(properties.getUrl());
        });

        When("^search Cuba$", () -> {
            WebElement element = driver.findElement(By.name("q"));
            element.sendKeys("Cuba!\n"); // send also a "\n"
            element.submit();
        });

        Then("^results are shown$", () -> {
        });
    }
}
