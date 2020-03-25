package WebTestPom;

import org.openqa.selenium.By;

import static WebTestPom.Utils.*;

public class ComputerPage
{
    private By _desktops = By.xpath("//img[@alt='Picture for category Desktops']");


    public void verifyUserIsOnComputerPage() {
        assertURL("computers");
    }

    public void clickOnDesktops() {
        clickOnElement(_desktops);
    }

    public void waitForDesktops() {
        waitForVisible(_desktops, 30);
    }
    public void scrollAndClickOnDesktop()
    {
        scrollAndClick(_desktops);
    }
}
