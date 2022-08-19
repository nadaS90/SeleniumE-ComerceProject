package tests;


import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utilities.Helper;


public class TestBase
{

    // First page to be created in test used to open and close browser
    public static WebDriver driver ;

    @BeforeSuite
    @Parameters({"browser"})
    //if we have multiple browsers check name in testng file then select from list
    //need variable to start driver
    //@optional if we don't get parameter from testng file we use this value
    public void startDriver(@Optional("chrome") String browserName)
    {

        if (browserName.equalsIgnoreCase("chrome"))
        {
            System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "/drivers/chromedriver.exe");
            driver = new ChromeDriver();
        } else if(browserName.equalsIgnoreCase("firefox"))
        {
           System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/drivers/geckodriver.exe");
            driver = new FirefoxDriver();

//            String fireFoxPath = System.getProperty("user.dir") + "\\drivers\\geckodriver.exe";
//            System.out.println(fireFoxPath);
//            System.setProperty("webdriver.gecko.driver",fireFoxPath);
//            driver = new FirefoxDriver();

        } else
            if (browserName.equalsIgnoreCase("edge"))
            {
                System.setProperty("webdriver.edge.driver",System.getProperty("user.dir") + "/drivers/msedgedriver.exe");
                driver = new EdgeDriver();
            }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
        driver.navigate().to("http://demo.nopcommerce.com/");
    }

    @AfterSuite
    public void stopDriver()
    {
        driver.quit();
    }
    // return with Tc status pass or fail
    @AfterMethod
    public void takeScreenshotOnFailure(ITestResult result)
    {
        if(result.getStatus() == ITestResult.FAILURE)
        {
            System.out.println("We have Failed TC");
            System.out.println("We Took screenshot");
            Helper.failureScreenSoot(driver,result.getName());
        }
    }


}
