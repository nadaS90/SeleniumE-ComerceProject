package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CompareProductPage extends PageBase
{
    public CompareProductPage(WebDriver driver)
    {
        super(driver);
    }

    @FindBy(css = "a.clear-list")
    WebElement clearListBtn;

    @FindBy(css = "div.no-data")
    WebElement noDataToCompare;
    //You have no items to compare.

    //Find all table elements
    @FindBy(css = "table.compare-products-table")
    List<WebElement> compareTable;

    @FindBy(tagName = "tr")
    List<WebElement> allRows;

    @FindBy(tagName = "td")
    List<WebElement> allcoloms;

    @FindBy (linkText = "HTC One Mini Blue")
    public WebElement firstProductName;

    @FindBy(linkText = "HTC One M8 Android L 5.0 Lollipop")
    public  WebElement secondProductName;






    public void ClearCompaeList()
    {
        clickBtn(clearListBtn);
    }

    public void compareProducts()
    {
        // Get all Rows
        System.out.println(allRows.size());
        System.out.println(allcoloms.size());

        // Get data from each Row
        for(WebElement row : allRows)
        {
            System.out.println(row.getText() + "\t");
            for(WebElement colms : allcoloms)
            {
                System.out.println(colms.getText()+"\t");
            }
        }
    }


}
