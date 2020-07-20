package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import utilities.WaitHelper;

public class POMloginPage {

    public WebDriver driver;
    WaitHelper waitHelper;

    public POMloginPage(WebDriver rdriver){
        driver=rdriver;
        PageFactory.initElements(rdriver,this);
        //waitHelper=new WaitHelper(driver);
    }



    @FindBy(id = "username")
    @CacheLookup
    WebElement txtEmail;


    @FindBy(xpath = "//*[@id=\"mat-input-1\"]")
    @CacheLookup
    WebElement txtPassWord;


    @FindBy(id = "Password")
    @CacheLookup
    WebElement txtPassWords;

    @FindBy(xpath = "/html/body/up-root/div/up-login/div/div[2]/div/mat-card/mat-card-actions/button")
    @CacheLookup
    WebElement btnLogIn;

    @FindBy(linkText = "Logout")
    @CacheLookup
    WebElement lnkLogout;

    @FindBy(how = How.XPATH,using = "//*[@id=\"Password\"]")
    @CacheLookup
    WebElement password;


    public void setUserName(String username){
        txtEmail.clear();
        txtEmail.sendKeys(username);
    }
    public void setTxtPassword(String passWord){
        txtPassWord.clear();
        txtPassWord.sendKeys(passWord);
    }
    public void clickOnLogin(){
        btnLogIn.click();
    }
    public void clickOnLogOut(){

        lnkLogout.click();
    }
    public String Length()
    {
       return driver.findElement((By) txtEmail).getText();
    }

   /* By txtEmail=By.xpath("/html/body/div[6]/div/div/div/div/div[2]/div[1]/div/form/div[2]/div[1]/label");
    By txtPassWord=By.xpath("//*[@id=\"Password\"]");
    By buttonLogIn = By.xpath("/html/body/div[6]/div/div/div/div/div[2]/div[1]/div/form/div[3]/input");


    public void setTxtEmail(String email){
        driver.findElement(txtEmail).sendKeys(email);
    }
    public void setTxtPassWord(String passWord){
        driver.findElement(txtPassWord).sendKeys(passWord);
    }
    public void clickOnButtonLogin(){
        driver.findElement(buttonLogIn).click();
    }

    public void LoginAll(String email, String password){
        setTxtEmail(email);
        setTxtPassWord(password);
        clickOnButtonLogin();
    }
    public void clickLogOut(){
        clickOnButtonLogin();
    }
    public String getPageTitle(){
        return driver.getTitle();
    }*/
/*test about Junit*/
    public int resul (int uno, int dos){
        return uno*dos;
    }

    public boolean isNull(int valor){
        boolean result=true;
        if(valor!=0){
            result=false;
        }
        return result;
    }



}
