package WebTestPom;

import org.openqa.selenium.By;

public class RegistrationPage extends Utils
{
    private By _firstName = By.name("FirstName");
    private By _lastName = By.name("LastName");
    private By _email = By.id("Email");
    private By _password = By.id("Password");
    private By _confirmPassword = By.id("ConfirmPassword");
    private By _registerButton = By.id("register-button");
    private String firstName = "Mala";
    private String lastName ="Wij";
    private String email = "manulasn2012+"+createTimeStamp()+"@gmail.com";
    private String password = "masw12";
    private String confirmPassword = "masw12";
    private static String timestamp = createTimeStamp();




    public void verifyUserIsOnRegisterPage() {
        assertURL("register");
        timeDelay(2);
    }

    public void userEntersRegistrationDetails() {
        sendText(_firstName,firstName);
        sendText(_lastName, lastName);
        sendText(_email,email);
        sendText(_password,password);
        sendText(_confirmPassword, confirmPassword);


    }

    public void clickOnRegisterButton()
    {
        clickOnElement(_registerButton);

    }

}
