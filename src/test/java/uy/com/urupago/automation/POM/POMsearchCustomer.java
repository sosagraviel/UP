package uy.com.urupago.automation.POM;

import io.cucumber.java8.En;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import uy.com.urupago.automation.utilities.WaitHelper;

import java.util.List;

public class POMsearchCustomer implements En {
    public WebDriver webDrivers;
    public WaitHelper waitHelper;

    public POMsearchCustomer(WebDriver driver){
        webDrivers=driver;
        waitHelper=new WaitHelper(webDrivers);
    }

    @FindBy(how = How.XPATH, using = "SearchEmail")
    @CacheLookup
    WebElement txtEmail;

    @FindBy(how = How.XPATH, using = "SearchFirstName")
    @CacheLookup
    WebElement txtFirstName;

    @FindBy(how = How.XPATH, using = "SearchLastName")
    @CacheLookup
    WebElement txtLastName;

    @FindBy(how = How.XPATH, using = "SearchMonthOfBirth")
    @CacheLookup
    WebElement drpdobMonth;

    @FindBy(how = How.XPATH, using = "SearchDayOfBirth")
    @CacheLookup
    WebElement drpdobDay;

    @FindBy(how = How.XPATH, using = "SearchCompany")
    @CacheLookup
    WebElement txtCompany;

    @FindBy(how = How.XPATH, using = "//div[@class='k-multiselect-wrap k-floatwrap']")
    @CacheLookup
    WebElement txtCustomerRoles;

    @FindBy(how = How.XPATH, using = "//li[contains(text(),'Administrators')]")
    @CacheLookup
    WebElement lstitemAdministrators;

    @FindBy(how = How.XPATH, using = "//li[contains(text(),'Registered')]")
    @CacheLookup
    WebElement lstitemRegistered;

    @FindBy(how = How.XPATH, using = "//li[contains(text(),'Guests')]")
    @CacheLookup
    WebElement lstitemGuests;

    @FindBy(how = How.XPATH, using = "//li[contains(text(),'Vendors')]")
    @CacheLookup
    WebElement lstitemVendors;

    @FindBy(how = How.XPATH, using = "search-customers")
    @CacheLookup
    WebElement btnSearch;

    @FindBy(how = How.XPATH, using = "//table[@role='grid']")
    @CacheLookup
    WebElement tblSearchResult;


    @FindBy(how = How.XPATH, using  = "//table[@class='td-data-table mat-selectable']")
    @CacheLookup
    WebElement table;


    public void setEmail(String email){
        waitHelper.WaitForElement(txtEmail,30);
        txtEmail.clear();
        txtEmail.sendKeys(email);
    }
    public void setFirstName(String fname){
        waitHelper.WaitForElement(txtFirstName,30);
        txtFirstName.clear();
        txtFirstName.sendKeys(fname);
    }
    public void setLastName(String lname){
        waitHelper.WaitForElement(txtLastName,30);
        txtLastName.clear();
        txtLastName.sendKeys(lname);
    }
    public void clickSearch(){
        btnSearch.click();
        waitHelper.WaitForElement(btnSearch,30);
    }
    public int getNoOfRows(){
        List <WebElement> tableRows=webDrivers.findElements(By.xpath("//div/table/tbody/tr"));
        return(tableRows.size());
    }
    public int getNoOfColumns(){
        List <WebElement> tableColumns=webDrivers.findElements(By.xpath("html/body/up-root/div/up-dashboard/mat-drawer-container/mat-drawer-content/div/up-users-list/up-data-table/up-panel/mat-card/mat-card-content/perfect-scrollbar/div/div[1]/div/td-data-table/div/table/tbody/tr/td"));
        return (tableColumns.size());
    }

    /*search the email in the table*/
    public boolean searchByEmail(String email){
        boolean flag=false;
        for (int i=1; i<getNoOfRows(); i++){
            String emailid=table.findElement(By.xpath("//table/tbody/tr["+i+"]/td[7]")).getText();
            System.out.println(emailid);
            if (emailid.equals(email)){
                flag=true;
            }
        }
        return flag;

    }
    //search if the user exists in the table
    public boolean searchByUser(String user){
        boolean flag=false;
        for (int i=1; i<getNoOfRows(); i++){
            String userId=webDrivers.findElement(By.xpath("//table/tbody/tr["+i+"]/td[4]")).getText();
            System.out.println(userId);
            if (userId.equals(user)){
                flag=true;
            }
        }
        return flag;

    }

    /*return the first user in the table*/
    public String getSearchByUser(){
           String userId=webDrivers.findElement(By.xpath("//table/tbody/tr[1]/td[4]")).getText();
            System.out.println(userId);
        return userId;
    }

    //return the first email in the table
    public String getSearchByEmail(){

        String userId=webDrivers.findElement(By.xpath("//table/tbody/tr[1]/td[7]")).getText();
        System.out.println(userId);

        return userId;
    }


}
