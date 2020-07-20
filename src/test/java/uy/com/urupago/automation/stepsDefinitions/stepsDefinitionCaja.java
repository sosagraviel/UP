package uy.com.urupago.automation.stepsDefinitions;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import uy.com.urupago.automation.POM.POMCajaApertura;

public class stepsDefinitionCaja extends baseClass{
    public POMCajaApertura pomCajaApertura;

    private baseClass base;

    public stepsDefinitionCaja(baseClass base){
        this.base=base;

    }


    @And("Mouse move on Caja")
    public void mouse_nove_on_Caja() {
        pomCajaApertura=new POMCajaApertura(base.basewebDriver);
        pomCajaApertura.ClickApertura();

    }
    @Then("user can view confirmation messages {string}")
    public void user_click_on_Apertura(String title) throws InterruptedException {

        Assert.assertEquals(title, base.basewebDriver.getTitle());//"Urupago - Apertura de caja"
        Thread.sleep(3000);
    }

}
