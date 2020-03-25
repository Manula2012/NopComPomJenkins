package WebTestPom;

import org.openqa.selenium.By;

public class EmailAFriendAppleMacBook extends Utils
{
    private By _continue = By.name("register-continue");
    private By _friendEmail = By.className("friend-email");
    private By _yourEmail = By.cssSelector("input.your-email");
    private By _personalMessage = By.tagName("textarea");
    private By _sendEmail = By.name("send-email");
    private By _emailSendMessage = By.xpath("//div[@class='result']");
    private String expected = "Your message has been sent";
    private String friendEmail = "naa12@gmail.com";
    private String yourEmail = "gkl123@gmail.com";
    private String personalMessage = "It's an excellent product";


    public void clickOnContinue()
    {
        clickOnElement(_continue);
    }


    public void waitForFriendEmailIsvisible()
    {
        waitForVisible(_friendEmail,90);
    }

    public void waitUntilSendEmailClickable()
    {
        waitForClickable(_sendEmail,50);
    }

    public void verifyUserIsOnEmailAFriendPage()
    {
        assertURL("productemailafriend/4");
    }
    public void userEntersEmailAFriendDetails() {
        sendText(_friendEmail, friendEmail);
        sendText(_personalMessage,personalMessage);
        clickOnElement(_sendEmail);
    }

    public void verifyUserSeeEmailAFriendSentMessage()
    {
        assertTextMessage(expected,_emailSendMessage);
    }


}
