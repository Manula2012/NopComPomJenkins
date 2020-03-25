package WebTestPom;

import org.openqa.selenium.By;

public class ShoppingCartPage extends Utils
{
    private By _termsOfServiceBox = By.xpath("//input[@id='termsofservice']");
    private By _checkOut = By.xpath("//button[@id='checkout']");


    public void scrollAndClickTermsOfService()
    {
        scrollAndClick(_termsOfServiceBox);
    }

    public void clickOnCheckOut()
    {
        clickOnElement(_checkOut);
    }
}
