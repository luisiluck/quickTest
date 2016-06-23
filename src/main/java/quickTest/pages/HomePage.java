package quickTest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Reporter;

public class HomePage extends BasePage {
    
    //Web Elements
    private By fieldSearch = By.id("edit-search-block-form--2");
    private By buttonSearch = By.name("submit");
    private By buttonClosePopUp = By.id("popup-message-close");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected String setUrl() {
        return "/";
    }
    
    /**
     * 
     * @return Search field
     */
    public WebElement fieldSearch() {
        return getElementBy(fieldSearch);
    }
    
    /**
     * 
     * @param search text
     * @return HomePage
     */
    public HomePage setFieldSearch(String text) {
        fieldSearch().sendKeys(text);
        Reporter.log( "Fill Search field with " + text, true );
        return this;
    }
    
    /**
     * 
     * @return Search Button
     */
    public WebElement buttonSearch() {
        return getElementBy(buttonSearch);
    }
    
    /**
     * click search button
     * @return SearchResultsPage
     */
    public SearchResultsPage clickButtonSearch() {
        buttonSearch().click();
        Reporter.log( "Search performed", true );
        return new SearchResultsPage( getDriver() );
    }
    
    /**
     * 
     * @param search text
     * @return SearchResultsPage
     */
    public SearchResultsPage performSearch(String text) {
        setFieldSearch(text);
        return clickButtonSearch();
    }
    
    /**
     * 
     * @return Close PopUp button
     */
    public WebElement buttonClosePopUp() {
        return getElementBy(buttonClosePopUp);
    }
    
    /**
     * close Home Page pop up 
     * @return HomePage
     */
    public HomePage closePopUp() {
        buttonClosePopUp().click();
        explicitWait().until(ExpectedConditions.invisibilityOfElementLocated(buttonClosePopUp) );
        Reporter.log( "Home Page pop up closed", true );
        return this;
    }

}
