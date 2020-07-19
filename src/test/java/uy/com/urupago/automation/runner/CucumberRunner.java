package uy.com.urupago.automation.runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/Features",
        glue = "uy.com.urupago.automation",
        plugin = {
                "html:reports/default-report", "pretty"
        }
        //tags = {"@Acceptance"}
)
public class CucumberRunner {
}
