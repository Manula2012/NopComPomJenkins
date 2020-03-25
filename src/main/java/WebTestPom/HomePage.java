package WebTestPom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertTrue;

public class HomePage extends Utils
{private By _registerLink = By.xpath("//a[@class='ico-register']");
    private By _compareAppleMacBook = By.xpath("//div[@class='product-grid home-page-product-grid']/div[2]/div[2]/div/div[2]/div[3]/div[2]/input[2]");
    private By _compareHtcOneM8 = By.xpath("//div[@class='product-grid home-page-product-grid']/div[2]/div[3]/div/div[2]/div[3]/div[2]/input[2]");
    private By _productComparison = By.linkText("product comparison");
    private By _compareProducts = By.xpath("//h1[text()='Compare products']");
    private By _appleMacBookPro13 = By.xpath("//div[@class='product-grid home-page-product-grid']/div[2]/div[2]/div/div/a/img");
    private By _computer = By.linkText("Computers");
    private By _news = By.linkText("News");
    private By _currency = By.id("customerCurrency");
    private By _priceAppleMacBook = By.xpath("//div[@class='page-body']/div[4]/div[2]/div[2]/div/div[2]/div[3]/div/span");
    private By _homePageMessage = By.xpath("//div[@class='topic-block-title']/h2");
    private String expected = "Welcome to our store";
    // private static WebElement computer = driver.findElement( By.linkText("Computers"));


    public void verifyUserIsInHomePage() {
        assertTextMessage(expected, _homePageMessage);
    }

    public void clickOnRegisterButton() {
        clickOnElement(_registerLink);
    }


    public void compareTwoProducts() {
        clickOnElement(_compareAppleMacBook);
        timeDelay(2);
        clickOnElement(_compareHtcOneM8);
        timeDelay(2);
        clickOnElement(_productComparison);

    }

    public void clickOnAppleMacBook() {
        clickOnElement(_appleMacBookPro13);
    }

    public void clickOnComputer() {
        clickOnElement(_computer);
        timeDelay(2);
    }

    public void clickOnNews() {
        clickOnElement(_news);
        timeDelay(2);
    }

    public void changeCurrencyToEuro() {


        selectElementByVisibleText(_currency, "Euro");
    }

    //  try {
    //   Thread.sleep(3000);
    //} catch (InterruptedException e) {
    //  e.printStackTrace();
    //}
    public void verifyUserAbleToSeeEuroCurrency() {
        List<WebElement> productPrice = driver.findElements(By.xpath("//div[@class='prices']/span"));
        for (WebElement we : productPrice) {
            assertTrue(we.getText().contains("Ђ"), "Price not Contains" + "$" + "sign");

        }
    }

    public void verifyAddToCartButton() {
        List<WebElement> listOfItems = driver.findElements(By.xpath("//div[@class='product-item']"));
        SoftAssert softAssert = new SoftAssert();

        for (WebElement item : listOfItems) {
            softAssert.assertTrue(item.getAttribute("innerHTML").contains("Add to cart"), "This item doesn't have Add to cart Button " + item.getText());
        }
        softAssert.assertAll();
    }


}
