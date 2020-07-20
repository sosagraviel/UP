package stepsDefinitions;

import POM.POMCajaApertura;
import POM.POMaddCustomer;
import POM.POMloginPage;
import POM.POMsearchCustomer;
import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.WebDriver;

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
