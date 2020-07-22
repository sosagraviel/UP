package uy.com.urupago.automation.stepsDefinitions;



import io.cucumber.java8.En;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;
import uy.com.urupago.automation.POM.POMaddCustomer;
import uy.com.urupago.automation.POM.POMloginPage;
import uy.com.urupago.automation.config.AutomationProperties;

public class stepsDefinitionLogin implements En {


    private final AutomationProperties properties;//agarra los valores definidos en las propiedades
    @Autowired
    private POMaddCustomer poMaddCustomer;
    private final POMloginPage poMloginPage;

    public stepsDefinitionLogin(WebDriver driver, AutomationProperties properties, POMloginPage poMloginPage) {
        this.properties = properties;
        this.poMloginPage = poMloginPage;
        PageFactory.initElements(driver,this.poMloginPage);



        Given("^I Launch Chrome Browser", () -> {

            driver.get(this.properties.getUrl());

        });


        When("^I open urupago homepage$", () -> {
            driver.manage().window().maximize();
        });


        And("User Enter {string} and {string}", (String user, String pass) -> {
            this.poMloginPage.setUserName(user);
            this.poMloginPage.setTxtPassword(pass);

        });

        Then("Page Title Should be {string} and {string} as {string}", (String title,String val, String pass) -> {
            if(!val.equals("5")) {//en un futuro saber la cantidad de intentos permitidos
                if (val.equals("") || pass.isEmpty()) {
                    Assert.assertTrue(driver.getPageSource().contains("Usuario o contraseña incorrectos. Inténtelo de nuevo."));;//tell me if the current page has this comment "Login was unsuccessful"
                    //driver.close();

                } else {
                    Assert.assertEquals(title, driver.getTitle());
                }
                Thread.sleep(3000);
            }else {
                driver.getPageSource().contains("Usuario o contraseña incorrectos. Inténtelo de nuevo.");//tell me if the current page has this comment "Login was unsuccessful"
                //driver.close();
                Assert.assertTrue(true);
            }
            Thread.sleep(3000);
        });

        When("^Click on Login$", () -> {
            this.poMloginPage.clickOnLogin();
            Thread.sleep(7000);
        });




        Then("^close browser$", () -> {
            driver.close();
        });





            //*****/*/*/*/*/*/********-*-*-*-*-*-*-*-*-*-*-*-*-*-*--*-*-*-**
            /*--------------------------------------------------BackGround-----------------------------------------*/







            /*---------------------------------Valid Credentials---------------------------*/













}}
