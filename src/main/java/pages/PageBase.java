package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PageBase
{

    // first page to be created in java main contain driver webElm / constructor / shortcut for any action related to this package " page "

    protected WebDriver drvier ;
    public JavascriptExecutor jse;
    public Select select;
    //Create constructor
    // initialize the instance and set default values
    public PageBase(WebDriver driver)
    {
        // when we have a cals with the main property and we need the property of that class to be called in this clas
        // we send this proparty as constractor here
        // and in the class that have the propert we initialize it there

        PageFactory.initElements(driver, this);
    }

    //Method to click all btns we have this will affect only paged in java main
    protected static void clickBtn(WebElement button)
    {
        button.click();
    }

    protected static void sendText(WebElement textElm, String value)
    {
        textElm.sendKeys(value);
    }

    public void scrollPageToBottom()
    {
        // this code will let us scroll to the buttom of the page
        jse.executeScript("scrollBy(0,2500)");
    }


}
