package uy.com.urupago.automation;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import uy.com.urupago.automation.driver.ChromeWebDriver;
import uy.com.urupago.automation.driver.MyWebDriver;

import java.util.List;


@SpringBootTest
class AutomationApplicationTests {

    @Autowired
    private MyWebDriver driver;


    @Test
    void contextLoads() {
      System.out.println(driver.webDriver());
    }

}
