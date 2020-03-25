package WebTestPom;

import org.openqa.selenium.By;

public class AppleMacBookPro13 extends Utils
{
    private By _emailAFriend = By.xpath("//div[@class='email-a-friend']");

    public void verifyUserIsOnAppleMacBookPage()
    {
        assertURL("apple-macbook-pro-13-inch");
    }

    public void clickOnEmailAFriendButton()
    {
        clickOnElement(_emailAFriend);
        timeDelay(2);
    }


}
