package uy.com.urupago.automation.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {/*".//Feature/Caja.feature","src/test/resources/Features/Login.feature",".//Feature/Customer.feature"*/"src/test/resources/Features/google.feature"},
        glue = "uy.com.urupago.automation",
        dryRun = false,
        //monochrome = true,
        plugin = {
                "html:reports/default-report", "pretty",
                "junit:junit_xml_output/cucumber.xml",
                "rerun:target/rerun.txt"
        }
        //tags = {"@SmokeTest","@RegressionTest"}
)
public class CucumberRunner {
}
