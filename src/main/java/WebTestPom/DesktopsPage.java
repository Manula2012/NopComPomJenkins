package WebTestPom;

import org.openqa.selenium.By;

public class DesktopsPage extends Utils
{
    private By _sortBy = By.id("products-orderby");
    private  By _addToCartDigitalStorm = By.xpath("//div[@data-productid='2']/div[2]/div[3]/div[2]/input[1]");
    private By _shoppingCartButton = By.linkText("shopping cart");

    public void clickOnSortBy() {
        clickOnElement(_sortBy);
    }

    public void selectHighToLowPrice()
    {
        selectElementByIndex(_sortBy,4);
    }

    public void scrollAndClickAddToCartDigitalStorm()
    {
        scrollAndClick(_addToCartDigitalStorm);
    }
    public void clickOnShoppingCart()
    {
        clickOnElement(_shoppingCartButton);
    }

}
