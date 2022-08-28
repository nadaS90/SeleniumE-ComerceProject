package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;


public class HomePage extends PageBase
{


    public HomePage(WebDriver driver)
    {
        super(driver);
        // put it with the constracur to intialize it
        jse = (JavascriptExecutor) driver;
        action = new Actions(driver);
    }

    @FindBy(linkText = "Register")
        WebElement rgstrLink ;

        @FindBy(linkText="Log in")
        WebElement loginLink;

        @FindBy (linkText = "Contact us")
        WebElement contactUsLink;

        @FindBy(id = "customerCurrency")
        public WebElement changeCurncy;

        @FindBy(css = "ul[class=\"top-menu notmobile\"] [href=\"/electronics\"]")
        public WebElement hovermenu;

        @FindBy(css = "body > div.master-wrapper-page > div.header-menu > ul.top-menu.notmobile > li:nth-child(2) > ul > li:nth-child(2) > a")
        public WebElement hoverDropDown;




        public void openRegistrationPage()
        {
            clickBtn(rgstrLink);
        }

        public void openLoginPage()
        {
            clickBtn(loginLink);
        }

        public void openContactUsPage()
        {
            scrollPageToBottom();
            clickBtn(contactUsLink);
        }

    public void changeCrncy()
    {
        select = new Select(changeCurncy);
        select.selectByVisibleText("Euro");
    }

    public void hoverMenu()
    {
        action.moveToElement(hovermenu)
                .moveToElement(hoverDropDown).
                click().build().perform();
    }


}
