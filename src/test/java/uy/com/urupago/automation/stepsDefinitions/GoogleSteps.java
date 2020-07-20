package uy.com.urupago.automation.stepsDefinitions;

import io.cucumber.java8.En;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GoogleSteps implements En {

    public GoogleSteps(WebDriver driver) {

        Given("^Open the browser$", () -> {
            driver.get("https://google.com");
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
