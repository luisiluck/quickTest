package quickTest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

public class SearchResultsPage extends BasePage {
    
    // Web Elements
    private String locatorItemResult = ".search-result:nth-child(%d) a";

    public SearchResultsPage(WebDriver driver, String searchText) {
        super(driver);
        url += searchText;
    }
    
    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected String setUrl() {
        return "search/node/";
    }
    
    /**
     * 
     * @param i index of item
     * @return item link
     */
    public WebElement getItemResult(int i) {
        String locator = String.format(locatorItemResult, i);
        return getElementBy( By.cssSelector(locator) );
    }
    
    /**
     * click item result
     * @param i index of item result
     */
    public void clickItemResult(int i) {
        getItemResult(i).click();
        Reporter.log( "Clicked on result #" + i, true );
    }

}
