package uy.com.urupago.automation.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = {/*".//Feature/Caja.feature",*/".//Feature/Login.feature"/*,".//Feature/Customer.feature""src/test/resources/Features"*/},
        glue = "uy.com.urupago.automation",
        dryRun = false,
        monochrome = true,
        plugin = {
                "html:reports/default-report", "pretty"
        }
        //strict = true,
        //tags = {"@SmokeTest","@RegressionTest"}
)
public class CucumberRunner {
}
