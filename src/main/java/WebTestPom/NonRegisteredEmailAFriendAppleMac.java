package WebTestPom;

import org.openqa.selenium.By;

public class NonRegisteredEmailAFriendAppleMac extends Utils
{
    private By _continue = By.name("register-continue");
    private By _friendEmail = By.className("friend-email");
    private By _yourEmail = By.cssSelector("input.your-email");
    private By _personalMessage = By.tagName("textarea");
    private By _sendEmail = By.name("send-email");
    private By _errorMessageEmailFriend = By.xpath("//form[@method='post']/div/ul/li");
    private String expected = "Your email is invalid";
    private String friendEmail = "naa12@gmail.com";
    private String yourEmail = "gkl123@gmail.com";
    private String personalMessage = "It's an excellent product";



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
    public void userEntersEmailsAFriendDetails()
    {
        sendText(_friendEmail,friendEmail);
        sendText(_yourEmail,yourEmail);
        sendText(_personalMessage,personalMessage);
        clickOnElement(_sendEmail);
        timeDelay(2);
    }

    public void verifyUnregisteredUserWillSeeErrorMessageForEmailAFriend()
    {
        assertTextMessage(expected,_errorMessageEmailFriend);
    }

}
