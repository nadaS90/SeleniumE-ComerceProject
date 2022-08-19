package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchItmPage extends PageBase{

    public SearchItmPage(WebDriver driver)
    {
        super(driver);
    }


    @FindBy (id = "small-searchterms")
    WebElement searchBox;

    @FindBy(css = "button.button-1.search-box-button")
    WebElement seachBtn;

    //-----> this is wrong becouse it returns with dropDown list so we search for a list not one item
   @FindBy(id = "ui-id-1")
   List<WebElement> searcDropDownResult;

    @FindBy(linkText = "Apple MacBook Pro 13-inch")
    WebElement searchResult;

    public void productSearch ( String productName)
    {
        sendText(searchBox, productName);
        clickBtn(seachBtn);
    }

    public void openitemDetails()
    {
        clickBtn(searchResult);
    }

    public void productSearchWithAutoComplete(String searchAutoComplte)
    {
        sendText(searchBox, searchAutoComplte);
        try {
            Thread.sleep(1000);
        }
        catch (InterruptedException e)
        {
            throw new RuntimeException(e);
        }
        searcDropDownResult.get(0).click();
    }




}
