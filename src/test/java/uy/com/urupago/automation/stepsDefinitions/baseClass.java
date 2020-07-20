package uy.com.urupago.automation.stepsDefinitions;


import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import uy.com.urupago.automation.POM.POMCajaApertura;
import uy.com.urupago.automation.POM.POMaddCustomer;
import uy.com.urupago.automation.POM.POMloginPage;
import uy.com.urupago.automation.POM.POMsearchCustomer;

public class baseClass {
    public WebDriver basewebDriver;
    public POMloginPage poMloginPage;
    public POMaddCustomer poMaddCustomer;
    public POMsearchCustomer poMsearchCustomer;
    public POMCajaApertura pomCajaApertura;



    //Created for generating random string for unique email
    public static String randomString(){
        String generateString= RandomStringUtils.randomAlphabetic(5);
        return (generateString);
    }
}
