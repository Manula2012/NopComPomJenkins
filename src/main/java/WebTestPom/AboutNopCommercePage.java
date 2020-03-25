package WebTestPom;

import org.openqa.selenium.By;

import static WebTestPom.Utils.*;

public class AboutNopCommercePage
{
    LoadProp loadProp = new LoadProp();

    private By _commentTitle = By.className("enter-comment-title");
    private By _comment =By.tagName("textarea");
    private By _newComment = By.name("add-comment");
    private By _commentAddedMessage = By.xpath("//div[@class='result']");



    String commentTitle = loadProp.getProperty("commentTitle");
    String comment = loadProp.getProperty("comment");
    String expected = "Your Comment has been added";




    public void enterCommentTitle()
    {
        sendText(_commentTitle,commentTitle);
    }

    public void enterComment()
    {
        sendText(_comment,comment);
    }

    public void clickOnNewComment()
    {
        clickOnElement(_newComment);
    }

    public void verifyUserAbleToSeeCommentAddedMessage()
    {
        assertTextMessage(expected,_commentAddedMessage);
    }

}


