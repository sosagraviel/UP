package uy.com.urupago.automation.stepsDefinitions;


import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import uy.com.urupago.automation.POM.POMaddCustomer;

public class stepsAddCustomer extends baseClass{
    public String auxUser="";
    public POMaddCustomer poMaddCustomer;
    private baseClass base;
    public stepsDefinitionCaja d;



    public stepsAddCustomer(baseClass base){
    this.base=base;
}

    @Then("User Can view Dashboad")
    public void user_Can_view_Dashboad() {
        poMaddCustomer=new POMaddCustomer(base.basewebDriver);
        Assert.assertEquals("Urupago - Cobros realizados",poMaddCustomer.getPageTitle());

    }


    @When("User click on customer menu")
    public void user_click_on_customer_menu() throws InterruptedException {

        poMaddCustomer.clickOnCustomerMenu();
        Thread.sleep(3000);

    }


    @When("Click on Add new button")
    public void click_on_Add_new_button() throws InterruptedException {
        poMaddCustomer.clickOnAddNew();
        Thread.sleep(3000);
    }

    @Then("user can view add customer page")
    public void user_can_view_add_customer_page() {
        Assert.assertEquals("Urupago - Usuarios",poMaddCustomer.getPageTitle());

    }

    @When("User enter customer info")//informacion correcta de un usuario
    public void user_enter_customer_info() throws InterruptedException {

        String user = randomString();
        auxUser=user;
        poMaddCustomer.setFirstNAme(user+"1");
        poMaddCustomer.setLAstNAme("Kumar");
        poMaddCustomer.setTxtUser(user);
        poMaddCustomer.setPassword("test123");
        poMaddCustomer.setEmail(user+"@gmail.com");
        Thread.sleep(3000);

    }

    @When("User enter customer info same user")//valida usuarios repetidos
    public void user_enter_customer_info_same_user() throws InterruptedException {
        String user=base.poMsearchCustomer.getSearchByUser();//obtienes un usuario de la tabla
        poMaddCustomer.setFirstNAme("Kumar");
        poMaddCustomer.setLAstNAme("Kumar");
        poMaddCustomer.setTxtUser(user);
        poMaddCustomer.setPassword("test123");
        poMaddCustomer.setEmail("sameemail@gmail.com");
        //Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains("Email no disponible")); // un mensaje en la consola
        Thread.sleep(3000);


    }
    @When("User enter customer info same email")//valida email repetidos
    public void user_enter_customer_info_same_email() throws InterruptedException {
        String user=base.poMsearchCustomer.getSearchByUser();
        String email=base.poMsearchCustomer.getSearchByEmail();
        poMaddCustomer.setFirstNAme("Kumar");
        poMaddCustomer.setLAstNAme("Kumar");
        poMaddCustomer.setTxtUser(user);
        poMaddCustomer.setPassword("test123");
        poMaddCustomer.setEmail(email);
        //Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains("Email no disponible")); // un mensaje en la consola
        Thread.sleep(3000);
    }

    @When("User enter customer info in blank")//valida fields en blanco
    public void user_enter_customer_info_in_blank() throws InterruptedException {
        poMaddCustomer.setFirstNAme("");
        poMaddCustomer.setLAstNAme("");
        poMaddCustomer.setTxtUser("");
        poMaddCustomer.setPassword("test123");
        poMaddCustomer.setEmail("");
        Thread.sleep(3000);
    }

    @When("click on save button")
    public void click_on_save_button() throws InterruptedException {
        poMaddCustomer.clickOnSave();
        Thread.sleep(3000);
    }

    @Then("click on save button disable")//valida que el boton save no este enable
    public void click_on_save_button_disable() throws InterruptedException {
        if(poMaddCustomer.checkBtnSave()) {
            poMaddCustomer.clickOnSave();
        }
        else {
            Assert.assertTrue(base.basewebDriver.findElement(By.tagName("body")).getText().contains("Email no disponible"));
        }
        Thread.sleep(3000);

    }

    @When("click on cancel button")
    public void click_on_cancel_button() throws InterruptedException {
        poMaddCustomer.clickOnCancel();
        Thread.sleep(3000);
    }

    @Then("user can view confirmation message {string}")//I found in the body for that msg
    public void user_can_view_confirmation_message(String msg) {
        if(!poMaddCustomer.checkBtnSave() /*&& base.poMsearchCustomer.searchByUser(auxUser)*/) {//chequeo si el boton Save esta habilitado y si existe ese usuario en la BD
            //Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains("The new customer has been added successfully.")); muestra un mensaje en la consola
            Assert.assertEquals("Urupago - Usuarios", poMaddCustomer.getPageTitle());
        }else{
            Assert.assertEquals("Urupago - Usuarios", poMaddCustomer.getPageTitle());
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
        if(base.poMsearchCustomer.searchByUser(auxUser)){
            Assert.assertTrue(true);
        }else{
            Assert.assertTrue(false);
        }
        Thread.sleep(3000);
    }
}
