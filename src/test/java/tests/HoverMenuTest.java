package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;

public class HoverMenuTest extends TestBase
{
    HomePage homeObject;


    @Test
    public  void userHoverAndSelect()
    {
        homeObject = new HomePage(driver);
        homeObject.hoverMenu();
       Assert.assertTrue(driver.getCurrentUrl().toLowerCase().contains("phones"));
    }
}
