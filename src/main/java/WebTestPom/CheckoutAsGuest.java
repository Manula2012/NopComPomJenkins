package WebTestPom;

import org.openqa.selenium.By;

import static WebTestPom.Utils.clickOnElement;

public class CheckoutAsGuest
{
    private By _checkoutAsGuest = By.xpath("//input[@value='Checkout as Guest']");

    public void clickOnCheckoutAsGuest()
    {
        clickOnElement(_checkoutAsGuest);
    }
}
