package uy.com.urupago.automation.stepsDefinitions;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java8.En;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import uy.com.urupago.automation.POM.POMCajaApertura;
import uy.com.urupago.automation.config.AutomationProperties;

public class stepsDefinitionCaja implements En {


    @Autowired
    private AutomationProperties properties;//agarra los valores definidos en las propiedades

    public POMCajaApertura pomCajaApertura;



    public stepsDefinitionCaja(WebDriver driver){

        When("Mouse move on Caja", () -> {
            pomCajaApertura=new POMCajaApertura(driver);
            pomCajaApertura.ClickApertura();
        });

        Then("user can view confirmation messages {string}", (String title) -> {
            Assert.assertEquals(title, driver.getTitle());//"Urupago - Apertura de caja"
            Thread.sleep(3000);
        });



    }


   /* @And("Mouse move on Caja")
    public void mouse_nove_on_Caja() {
        pomCajaApertura=new POMCajaApertura(base.basewebDriver);
        pomCajaApertura.ClickApertura();

    }
    @Then("user can view confirmation messages {string}")
    public void user_click_on_Apertura(String title) throws InterruptedException {

        Assert.assertEquals(title, base.basewebDriver.getTitle());//"Urupago - Apertura de caja"
        Thread.sleep(3000);
    }*/

}
