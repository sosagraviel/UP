package uy.com.urupago.automation.utilities;

import io.cucumber.java8.En;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitHelper implements En {
    public WebDriver webDriver;
            public WaitHelper(WebDriver driver){
        webDriver=driver; }

    public void WaitForElement(WebElement element,long timeOutInSeconds) {
        WebDriverWait wait=new WebDriverWait(webDriver,timeOutInSeconds);
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}
