package uy.com.urupago.automation.runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = {/*"/"src/test/resources/Features/Caja.feature",*/"src/test/resources/Features/Login.feature"/*,".//Feature/Customer.feature""src/test/resources/Features/google.feature"*/},
        tags = "@SmokeTest and @RegressionTest",
        glue = "uy.com.urupago.automation",
        dryRun = false,
        monochrome = true,
        plugin = {
                "html:reports/default-report", "pretty",
                "junit:junit_xml_output/cucumber.xml",
                "rerun:target/rerun.txt"
        },
        strict = true


)
public class CucumberRunner {
}
