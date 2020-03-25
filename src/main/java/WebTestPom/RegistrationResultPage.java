package WebTestPom;

import org.openqa.selenium.By;

public class RegistrationResultPage extends Utils
{
    private By _registerSuccessMessage = By.cssSelector("div.result");
    private By _continue = By.name("register-continue");
    private String expected = "Your registration completedABCD";

    public void verifyUserSeeRegistrationSuccessMessage()
    {
        assertURL("registerresult");
        assertTextMessage(expected,_registerSuccessMessage);
    }

    public void clickOnContinueRegistrationResultPage()
    {
        clickOnElement(_continue);
        timeDelay(2);
    }
}
