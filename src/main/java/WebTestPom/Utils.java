package WebTestPom;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils extends BasePage
{
    public static void clickOnElement(By by)
    {
        driver.findElement(by).click();
    }

    public static String getTextFromElement(By by)
    {
        return driver.findElement(by).getText();
    }

    public static String createTimeStamp()
    {
        DateFormat dateFormat = new SimpleDateFormat("ddMMHHmmss");
        Date date = new Date();
        return (dateFormat.format(date));
    }

    public static void waitForVisible(By by, int time)
    {
        WebDriverWait wait = new WebDriverWait(driver, time);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }


    public static void assertURL(String text)
    {
        Assert.assertTrue(driver.getCurrentUrl().contains(text));
    }


    public static void sendText(By by,String text)
    {
        driver.findElement(by).sendKeys(text);
        waitForClickable(by, 20);

    }

    public static void assertTextMessage(String expected,By by)
    {
        String actual = getTextFromElement(by);
        Assert.assertEquals(actual,expected);
    }
    public static void waitForClickable(By by, int time)
    {
        WebDriverWait wait = new WebDriverWait(driver, time);
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }
    public static void selectElementByIndex(By by,int index)
    {
        Select select = new Select(driver.findElement(by));
        select.selectByIndex(index);
    }
    public static void selectElementByVisibleText(By by,String text)
    {
        Select select = new Select(driver.findElement(by));
        select.selectByVisibleText(text);
    }

    public static void scrollAndClick(By by)
    {
        WebElement element = driver.findElement(by);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",element);
        element.click();

    }

    //Time delay for sleep
    public static void timeDelay(int time){
        try {
            Thread.sleep(time *1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

  public static void takesScreenShot(String fileName)
  {
      try{
          File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
          FileUtils.copyFile(scrFile, new File("src\\test\\resources\\Screenshots\\" + fileName + ".jpg"));

      }catch (IOException e) {
          e.printStackTrace();
      }

      }


}
