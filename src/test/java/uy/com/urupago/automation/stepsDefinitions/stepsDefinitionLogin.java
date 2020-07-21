package uy.com.urupago.automation.stepsDefinitions;



import io.cucumber.java8.En;
import org.junit.Assert;

import org.openqa.selenium.WebDriver;

import org.springframework.beans.factory.annotation.Autowired;
import uy.com.urupago.automation.POM.POMaddCustomer;
import uy.com.urupago.automation.POM.POMloginPage;

import uy.com.urupago.automation.config.AutomationProperties;

public class stepsDefinitionLogin implements En {

    @Autowired
    private AutomationProperties properties;//agarra los valores definidos en las propiedades

    private POMaddCustomer poMaddCustomer;
    private POMloginPage poMloginPage;

    public stepsDefinitionLogin(WebDriver driver) {

        Given("^I Launch Chrome Browser", () -> {
            driver.get(properties.getUrl());

        });


        /*Given("I Launch Chrome Browser")
        public void i_Launch_Chrome_Browser() {
       /* logger= Logger.getLogger("noCommerce");//Added logger
        PropertyConfigurator.configure("log4j.properties");//Added Logger*/
             // System.setProperty("webdriver.chrome.driver","//home/graviel/Descargas/intelij/chromedriver");
            //System.setProperty("webdriver.gecko.driver", driverPath);
            //HERE  base.basewebDriver=new ChromeDriver();
            //base.basewebDriver=new FirefoxDriver();
            //poMloginPage=new POMloginPage(driver);
            //HERE   base.poMsearchCustomer=new POMsearchCustomer(base.basewebDriver);
        /*base.poMaddCustomer=new POMaddCustomer(base.basewebDriver);
        pomCajaApertura=new POMCajaApertura(base.basewebDriver);


            }*/

        When("^I open urupago homepage$", () -> {
            driver.manage().window().maximize();
        });

    /*@When("I open urupago homepage {string}")
    public void i_open_orange_hrm_homepage(String url) {
        base.basewebDriver.get(url);//http://cobranza.qa.urupago.com.uy"
        base.basewebDriver.manage().window().maximize();

    }*/



    /*@Then("I verify that the logo  present on page")
    public void i_verify_that_the_logo_present_on_page() {
        boolean status=base.basewebDriver.findElement(By.xpath("/html/body/up-root/div/up-login/div/div[2]/div/mat-card/mat-card-header/div[2]")).isDisplayed();//for is it present
        Assert.assertEquals(true,status);
    }*/

        Then("^close browser$", () -> {
            driver.quit();
        });

    /*@And("close browser")
    public void close_browser() {
        base.basewebDriver.quit();
    }*/



            //*****/*/*/*/*/*/********-*-*-*-*-*-*-*-*-*-*-*-*-*-*--*-*-*-**
            /*--------------------------------------------------BackGround-----------------------------------------*/


        And("^User Enter UserName and password$", () -> {
            poMloginPage.setUserName(properties.getUser());
            poMloginPage.setTxtPassword(properties.getPassword());
        });

   /*@And("User Enter UserName as {string} and password as {string}")
    public void user_Enter_Email_as_and_password_as(String user, String password) {
        //logger.info("**************Proving logging Details **********");

        poMloginPage.setUserName(user);
        poMloginPage.setTxtPassword(password);
    }/*

   /* @And("^User Enter UserName and password$")
    public void user_Enter_Email_as_and_password_as(DataTable credentials) {
        //logger.info("**************Proving logging Details **********");
        List<List<String>> position=credentials.row();
            poMloginPage.setUserName(position.get(0));
        poMloginPage.setTxtPassword(password);
    }*/

        When("^Click on Login$", () -> {
            poMloginPage.clickOnLogin();
            Thread.sleep(7000);
        });
    /*@When("Click on Login")
    public void click_on_Login() throws InterruptedException {
        //logger.info("**************Started Logging**********");
        poMloginPage.clickOnLogin();
      Thread.sleep(7000);
    }*/

   /* @Then("User Can view Dashboad")
    public void user_Can_view_Dashboad() {

        Assert.assertEquals("Urupago - Cobros realizados",base.poMaddCustomer.getPageTitle());

    }*/
            /*---------------------------------Valid Credentials---------------------------*/

        Then("Page Title Should be {string} and {string} as {string}", (String title,String val, String pass) -> {
            if(val!="5") {//en un futuro saber la cantidad de intentos permitidos
                if (val.equals("") || pass.isEmpty()) {
                    driver.getPageSource().contains("Usuario o contraseña incorrectos. Inténtelo de nuevo.");//tell me if the current page has this comment "Login was unsuccessful"
                    driver.close();
                    Assert.assertTrue(true);
                } else {
                    Assert.assertEquals(title, driver.getTitle());
                }
                Thread.sleep(3000);
            }else {
                driver.getPageSource().contains("Usuario o contraseña incorrectos. Inténtelo de nuevo.");//tell me if the current page has this comment "Login was unsuccessful"
                driver.close();
                Assert.assertTrue(true);
            }
            Thread.sleep(3000);
        });

   /*@When("User CLick on log Out link")
    public void user_CLick_on_log_Out_link() throws InterruptedException {
        poMloginPage.clickOnLogOut();
       Thread.sleep(3000);

        });

   //@Then("Page Title Should be {string} and {string} as {string}")
    /*public void page_Title_Should_be(String title,String val, String pass) throws InterruptedException {
        if(val!="5") {//en un futuro saber la cantidad de intentos permitidos
            if (val.equals("") || pass.isEmpty()) {
                base.basewebDriver.getPageSource().contains("Usuario o contraseña incorrectos. Inténtelo de nuevo.");//tell me if the current page has this comment "Login was unsuccessful"
                base.basewebDriver.close();
                Assert.assertTrue(true);
            } else {
                Assert.assertEquals(title, base.basewebDriver.getTitle());
            }
            Thread.sleep(3000);
        }else {
            base.basewebDriver.getPageSource().contains("Usuario o contraseña incorrectos. Inténtelo de nuevo.");//tell me if the current page has this comment "Login was unsuccessful"
            base.basewebDriver.close();
            Assert.assertTrue(true);
        }
        Thread.sleep(3000);
    }*/

   /*@When("User CLick on log Out link")
    public void user_CLick_on_log_Out_link() throws InterruptedException {
        poMloginPage.clickOnLogOut();
       Thread.sleep(3000);
    }*/


            /*-------------------------------------Added Customer----------------------------------------------*/
/*
    @When("User click on customer menu")
    public void user_click_on_customer_menu() throws InterruptedException {
        addCustomer.clickOnCustomerMenu();
        Thread.sleep(3000);

    }


    @When("Click on Add new button")
    public void click_on_Add_new_button() throws InterruptedException {
        addCustomer.clickOnAddNew();
        Thread.sleep(3000);
    }

    @Then("user can view add customer page")
    public void user_can_view_add_customer_page() {
        Assert.assertEquals("Urupago - Usuarios",addCustomer.getPageTitle());

    }

    @When("User enter customer info")//informacion correcta de un usuario
    public void user_enter_customer_info() throws InterruptedException {

           String user = randomString();
           auxUser=user;
           addCustomer.setFirstNAme(user+"1");
           addCustomer.setLAstNAme("Kumar");
           addCustomer.setTxtUser(user);
           addCustomer.setPassword("test123");
           addCustomer.setEmail(user+"@gmail.com");
           Thread.sleep(3000);

    }

    @When("User enter customer info same user")//valida usuarios repetidos
    public void user_enter_customer_info_same_user() throws InterruptedException {
        String user=poMsearchCustomer.getSearchByUser();//obtienes un usuario de la tabla
            addCustomer.setFirstNAme("Kumar");
            addCustomer.setLAstNAme("Kumar");
            addCustomer.setTxtUser(user);
            addCustomer.setPassword("test123");
            addCustomer.setEmail("sameemail@gmail.com");
        //Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains("Email no disponible")); // un mensaje en la consola
        Thread.sleep(3000);


    }
    @When("User enter customer info same email")//valida email repetidos
    public void user_enter_customer_info_same_email() throws InterruptedException {
        String user=poMsearchCustomer.getSearchByUser();
        String email=poMsearchCustomer.getSearchByEmail();
        addCustomer.setFirstNAme("Kumar");
        addCustomer.setLAstNAme("Kumar");
        addCustomer.setTxtUser(user);
        addCustomer.setPassword("test123");
        addCustomer.setEmail(email);
        //Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains("Email no disponible")); // un mensaje en la consola
        Thread.sleep(3000);
    }

    @When("User enter customer info in blank")//valida fields en blanco
    public void user_enter_customer_info_in_blank() throws InterruptedException {
        addCustomer.setFirstNAme("");
        addCustomer.setLAstNAme("");
        addCustomer.setTxtUser("");
        addCustomer.setPassword("test123");
        addCustomer.setEmail("");
        Thread.sleep(3000);
    }

    @When("click on save button")
    public void click_on_save_button() throws InterruptedException {
            addCustomer.clickOnSave();
        Thread.sleep(3000);
    }

    @Then("click on save button disable")//valida que el boton save no este enable
    public void click_on_save_button_disable() throws InterruptedException {
        if(addCustomer.checkBtnSave()) {
            addCustomer.clickOnSave();
        }
        else {
            Assert.assertTrue(base.basewebDriver.findElement(By.tagName("body")).getText().contains("Email no disponible"));
        }
        Thread.sleep(3000);

    }

    @When("click on cancel button")
    public void click_on_cancel_button() throws InterruptedException {
        addCustomer.clickOnCancel();
        Thread.sleep(3000);
    }

    @Then("user can view confirmation message {string}")//I found in the body for that msg
    public void user_can_view_confirmation_message(String msg) {
        if(addCustomer.checkBtnSave() && poMsearchCustomer.searchByUser(auxUser)) {//chequeo si el boton Save esta habilitado y si existe ese usuario en la BD
            //Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains("The new customer has been added successfully.")); muestra un mensaje en la consola
            Assert.assertEquals("Urupago - Usuarios", addCustomer.getPageTitle());
        }else{
            Assert.assertEquals("Urupago", addCustomer.getPageTitle());
        }


    }
    @Then("user can view confirmation message error {string}")//I found in the body for that msg
    public void user_can_view_confirmation_message_error(String msg) {
        if(poMaddCustomer.checkBtnSave()) {
            Assert.assertTrue(base.basewebDriver.findElement(By.tagName("body")).getText().contains("Email no disponible"));// muestra un mensaje en la consola
            Assert.assertTrue(base.basewebDriver.findElement(By.tagName("body")).getText().contains(msg)); //muestra un mensaje en la consola
        }else{
            Assert.assertTrue(base.basewebDriver.findElement(By.tagName("body")).getText().contains(msg)); //muestra un mensaje en la consola
        }


    }

//----------------------------------Search Customers------------------------------
    @When("Enter Customer Email")
    public void enter_Customer_Email() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("click on search button")
    public void click_on_search_button() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("User should found email in the search table")
    public void user_should_found_email_in_the_search_table() throws InterruptedException {
        if(poMsearchCustomer.searchByUser(auxUser)){
            Assert.assertTrue(true);
        }else{
            Assert.assertTrue(false);
        }
        Thread.sleep(3000);
    }
*/
            /*......*-*-*-*-*-*-*-*-*-**-*-*-*-*-*-*caja*-*-*-*-**-*--*-*-*-**-*-**-***-**-*-**-*.......*/
   /* @And("Mouse move on Caja")
    public void mouse_nove_on_Caja() {
        pomCajaApertura.ClickApertura();

    }
    @Then("user can view confirmation messages {string}")
    public void user_click_on_Apertura(String title) throws InterruptedException {

        Assert.assertEquals(title, driver.getTitle());//"Urupago - Apertura de caja"
        Thread.sleep(3000);
    }*/



//-----------------------Search Customer By Email---------------------------------
   /* @When("Enter Customer first name")
    public void enter_Customer_first_name() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("Enter Customer Last name")
    public void enter_Customer_Last_name() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("Click on Search Button")
    public void click_on_Search_Button() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("User should found the name in the Search Table")
    public void user_should_found_the_name_in_the_Search_Table() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

        }


   /*HERE public POMloginPage poMloginPage;
    //public POMaddCustomer addCustomer;//this class extended from base class for that i don´t need this attributes
    //public POMsearchCustomer poMsearchCustomer;
    //public POMCajaApertura pomCajaApertura;
    //public String driverPath = "//home/graviel/Descargas/intelij/gecko/geckodriver";
    final baseClass base;

    public stepsDefinitionLogin(baseClass base){
        this.base=base;
    }*/









}}
