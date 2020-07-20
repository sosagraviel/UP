package uy.com.urupago.automation.POM;

import io.cucumber.java8.En;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import uy.com.urupago.automation.utilities.WaitHelper;

public class POMCajaApertura implements En {
    public WebDriver webDriver;
    public WaitHelper waitHelper;
    public Actions actions;

    public POMCajaApertura(WebDriver driver) {
        webDriver = driver;
        waitHelper = new WaitHelper(webDriver);
        actions = new Actions(webDriver);
        PageFactory.initElements(webDriver, this);

    }


    By linkAperturaCaja = By.xpath("//span[contains(text(),'Apertura')]");

    public void ClickApertura() {
        WebElement linkCaja = webDriver.findElement(By.xpath("//i[@class='fa fa-archive']"));
        actions.moveToElement(linkCaja).build().perform();
        webDriver.findElement(linkAperturaCaja).click();
    }
}
