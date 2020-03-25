package WebTestPom;

import org.openqa.selenium.By;

import static WebTestPom.Utils.assertTextMessage;

public class CheckoutCompletedPage
{
    private By _checkoutCompletedMessage = By.xpath("//div[@class='section order-completed']/div/strong");

    String expected = "Your order has been completed";

    public void verifyUserSeeCheckoutCompletedMessage()
    {
        assertTextMessage(expected,_checkoutCompletedMessage);
    }

}
