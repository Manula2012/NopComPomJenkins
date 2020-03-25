package WebTestPom;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.text.SimpleDateFormat;
import java.util.Date;

public class BaseTest extends Utils
{
    BrowserSelector browserSelector = new BrowserSelector();
    private String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());

    @BeforeTest
     public void openBrowser()
    {
      browserSelector.setupBrowser();
    }

    @AfterTest

    public void closeBrowser()
    {
        driver.quit();
    }
//    @AfterTest
//    public void closeBrowser(ITestResult result) {
//        if (!result.isSuccess()) {
//            takesScreenShot(result.getName() + createTimeStamp());}
//        driver.quit();
//
//    }
}
