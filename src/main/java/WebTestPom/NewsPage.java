package WebTestPom;

import org.openqa.selenium.By;

public class NewsPage extends Utils
{
    private By _details = By.xpath("//a[@href='/about-nopcommerce' and @class='read-more']");



    public void scrollAndClickOnDetails()
    {
        scrollAndClick(_details);
    }


}
