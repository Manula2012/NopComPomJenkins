package WebTestPom;

import org.openqa.selenium.By;

public class CompareProductsPage extends Utils
{
    private By _compareProductsMessage = By.xpath("//div[@class='page-title']/h1");
    String expected = "Compare products";

    public void varifyUserSeeCompareProductsMessage()
    { assertURL("compareproducts");
        assertTextMessage(expected,_compareProductsMessage);

    }

}
