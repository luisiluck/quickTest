package quickTest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public abstract class BasePage {
    
    /**
     * Explicit Wait timeout
     */
    private long timeout = 5;

    /**
     * base URL 
     */
    protected String url = "http://www.sirsidynix.com";
    
    private WebDriver driver;

    private WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        url+=setUrl();
        wait = new WebDriverWait(driver, timeout);
        
        // call own URL if web driver has about:blank
        if ( "about:blank".equals( driver.getCurrentUrl() ) ) {
            driver.get( getUrl() );
            Reporter.log( "Navigating to " + getUrl(), true );
        }
    }
    
    /**
     * URL page implementation required
     */
    protected abstract String setUrl();
    
    public String getUrl() {
        return url;
    }
    
    public WebDriverWait explicitWait() {
        return wait;
    }
    
    /**
     * 
     * @return WebDriver
     */
    public WebDriver getDriver() {
        return driver;
    }
    
    protected WebElement getElementBy(By locator) {
        return explicitWait().until( ExpectedConditions.elementToBeClickable(locator) );
    }

}
