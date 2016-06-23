package quickTest.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import quickTest.pages.HomePage;

public class QuickTest {
    
    private WebDriver driver;
    
    @BeforeTest
    public void beforeTest() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
    }

    /**
     * test id: Demo 1
     * @author luis.portillo
     * @date 06/22/16
     * @ver 1.0
     */
    @Test
    public void quickTest() {
        
        // 1st step: Open http://www.sirsidynix.com/
        new HomePage(driver)
        
        // Closing pop up
        .closePopUp()
        
        // 2nd step: Type "cosugi 2016" (without the quotation marks) into the search box in the top right
        .setFieldSearch("cosugi 2016")
        
        // 3rd step: Click the search button
        .clickButtonSearch()
        
        // 4th step: Click on the link for the second result
        .clickItemResult(2);
        
        // 5th step: Validate/assert that the current URL is http://www.sirsidynix.com/blog/2016/05/09/your-cosugi-compendium-everything-you-need-to-know-about
        Assert.assertEquals(driver.getCurrentUrl(),
                "http://www.sirsidynix.com/blog/2016/05/09/your-cosugi-compendium-everything-you-need-to-know-about");
        Reporter.log( "Current URL is:\n" + driver.getCurrentUrl(), true );
    }
    
    @AfterTest
    public void afterTest() {
        driver.close();
    }
}
