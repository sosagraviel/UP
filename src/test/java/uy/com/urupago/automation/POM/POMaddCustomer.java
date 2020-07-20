package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class POMaddCustomer {
    public WebDriver webDriver;

    public POMaddCustomer(WebDriver rdriver){
        webDriver=rdriver;
        PageFactory.initElements(webDriver,this);
    }
    By lnkCustomers_menu =By.xpath("//a[@href='#']//span[contains(text(),'Customers')]");
    By lnkCustomers_menuitem =By.xpath("/html/body/div[3]/div[2]/div/ul/li[4]/ul/li[1]/a/span");
    By btnAddnew =By.xpath("//a[@class='btn bg-blue']");
    //By txtEmail= By.xpath("//input[@id='Email']");
   // By txtPassword=By.xpath("//input[@id='Password']");
    By txtCustomerRoles=By.xpath("//div[@class='k-multiselect-wrap k-floatwrap']");
    By lstItemsAdministrator=By.xpath("//*[@id=\"SelectedCustomerRoleIds_listbox\"]/li[1]");
    By lstItemsForumModerators=By.xpath("//*[@id=\"SelectedCustomerRoleIds_listbox\"]/li[2]");
    By lstItemsGuests=By.xpath("//*[@id=\"SelectedCustomerRoleIds_listbox\"]/li[3]");
    By lstItemsRegistered=By.xpath("//li[contain(text(),'Registered')]");
    By lstItemsVendors=By.xpath("//li[contain(text(),'Vendors')]");
    By eliminate=By.xpath("//*[@id=\"SelectedCustomerRoleIds_taglist\"]/li/span[2]");

    By drpmgrOfVendor=By.xpath("//*[@id='VendorId']");
    By rdMaleGender=By.id("Gender_Male");
    By rdFeMaleGender=By.id("Gender_Female");

    //By txtFirstName=By.xpath("//input[@id='FirstName']");
    //By  txtFirstName=By.xpath("//*[@id=\"mat-input-6\"]");
    //By txtLastName=By.xpath("//input[@id='LastName']");
    //By txtLastName=By.xpath("//*[@id=\"mat-input-7\"]");
   // By txtUser=By.xpath("//*[@id=\"cdk-overlay-1\"]/mat-dialog-container/up-user/div[1]/form/div[1]/mat-form-field");
    //By txtPassword=By.xpath("//*[@id=\"mat-input-8\"]");
    //By txtEmail=By.xpath("//*[@id=\"mat-input-5\"]");



    By txtDob=By.xpath("//input[@id='DateOfBirth']");
    By txtCompanyName=By.xpath("//input[@id='Company']");
    By txtAdminContent=By.xpath("//textarea[@id='AdminComment']");
    //By btnSave=By.xpath("/html/body/div[3]/div[3]/div/form/div[1]/div/button[1]");
/*-----------------------------------------------------------------------*/
    By lnkbtnUser=By.xpath("/html/body/up-root/div/up-dashboard/mat-drawer-container/mat-drawer/up-menu/div/mat-nav-list/mat-list-item[1]/div/div[3]");
    By btnAddNewUser=By.xpath("/html/body/up-root/div/up-dashboard/mat-drawer-container/mat-drawer-content/div/up-users-list/up-data-table/up-panel/mat-card/mat-card-content/perfect-scrollbar/div/div[1]/div/div/button/span");
    By txtFirstName=By.xpath("//*[@id=\"mat-input-6\"]");
    By txtLastName=By.xpath("//*[@id=\"mat-input-7\"]");
    By txtUser=By.xpath("//*[@id=\"mat-input-4\"]");
    By txtPassword=By.xpath("//*[@id=\"mat-input-8\"]");
    By txtEmail=By.xpath("//*[@id=\"mat-input-5\"]");
    By btnSave=By.xpath("//span[contains(text(),'Guardar')]");
    By btnCancel=By.xpath("//span[contains(text(),'Cancelar')]");
 /*----------------------------------------------------------------------*/
    //Action Methods
    public void clickOnCustomerMenu(){
        webDriver.findElement(lnkbtnUser).click();
    }
    public void clickOnCustomerMenuItem(){
        webDriver.findElement(lnkCustomers_menuitem).click();
    }
    public void clickOnAddNew(){
        webDriver.findElement(btnAddNewUser).click();
    }
    public void setEmail(String email){
        webDriver.findElement(txtEmail).clear();
        webDriver.findElement(txtEmail).sendKeys(email);
    }
    public void setPassword(String password){
        webDriver.findElement(txtPassword).clear();
        webDriver.findElement(txtPassword).sendKeys(password);
    }

    public void setCustomerRoles(String roles) throws InterruptedException{
        if (!roles.equals("Vendors"))//if role is not vendor should not deleted Register as
        {
            webDriver.findElement(By.xpath("//*[@id=\"SelectedCustomerRoleIds_taglist\"]/li/span[1]")).click();
        }
        webDriver.findElement(txtCustomerRoles).click();
        WebElement listitem;
        Thread.sleep(3000);
        if (roles.equals("Administrators")){//if role is not vendor should not deleted Register as
            webDriver.findElement(By.xpath("//*[@id=\"SelectedCustomerRoleIds\"]/option[1]"));
            listitem=webDriver.findElement(lstItemsAdministrator);
            listitem.click();
            Thread.sleep(3000);

            JavascriptExecutor js =(JavascriptExecutor) webDriver;
            js.executeScript("arguments[0].click",listitem);
        }else if (roles.equals("Guests")){
            listitem=webDriver.findElement(lstItemsGuests);
            listitem.click();
            webDriver.findElement(eliminate).click();
            Thread.sleep(3000);

            JavascriptExecutor js =(JavascriptExecutor) webDriver;
            js.executeScript("arguments[0].click",listitem);


        }else if (roles.equals("Registered")){
            listitem=webDriver.findElement(lstItemsRegistered);
            listitem.click();
            Thread.sleep(3000);

            JavascriptExecutor js =(JavascriptExecutor) webDriver;
            js.executeScript("arguments[0].click",listitem);
        }else if (roles.equals("Vendors")){
            webDriver.findElement(By.xpath("//*[@id=\"SelectedCustomerRoleIds_taglist\"]/li/span[1]")).click();
            listitem=webDriver.findElement(lstItemsVendors);

            listitem.click();
            Thread.sleep(3000);

            JavascriptExecutor js =(JavascriptExecutor) webDriver;
            js.executeScript("arguments[0].click",listitem);

        }else {
            listitem=webDriver.findElement(lstItemsForumModerators);
            listitem.click();
            Thread.sleep(3000);

            JavascriptExecutor js =(JavascriptExecutor) webDriver;
            js.executeScript("arguments[0].click",listitem);
        }

    }
    public void setManagementOfVendors(String value){
        Select drp=new Select(webDriver.findElement(drpmgrOfVendor));
        drp.selectByVisibleText(value);
    }
    public void setGender(String gender){
        if (gender.equals("Male")){
            webDriver.findElement(rdMaleGender).click();
        }else if (gender.equals("Female")){
            webDriver.findElement(rdFeMaleGender).click();
        }else {
            webDriver.findElement(rdMaleGender).click();//default
        }
    }
    public void setFirstNAme(String fname){
        webDriver.findElement(txtFirstName).sendKeys(fname);
    }
    public void setTxtUser(String user){
        webDriver.findElement(txtUser).sendKeys(user);
    }
    public void setLAstNAme(String lname){
        webDriver.findElement(txtLastName).sendKeys(lname);
    }
    public void setDob(String dob){
        webDriver.findElement(txtDob).sendKeys(dob);
    }
    public void setCompanyName(String comname){
        webDriver.findElement(txtCompanyName).sendKeys(comname);
    }
    public void setAdminContent(String content){
        webDriver.findElement(txtAdminContent).sendKeys(content);
    }
    public void clickOnSave(){
        webDriver.findElement(btnSave).click();
    }

    public boolean checkBtnSave(){
        webDriver.findElement(btnAddNewUser).isEnabled();
       return true;
    }
    public void clickOnCancel(){
        webDriver.findElement(btnCancel).click();
    }


    public String getPageTitle(){
       return webDriver.getTitle();
    }

}
