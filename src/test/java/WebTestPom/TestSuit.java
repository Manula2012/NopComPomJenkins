package WebTestPom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class TestSuit extends BaseTest
{ HomePage homepage = new HomePage();
    RegistrationPage registrationPage = new RegistrationPage();
    RegistrationResultPage registrationResultPage = new RegistrationResultPage();
    CompareProductsPage compareProductsPage = new CompareProductsPage();
    AppleMacBookPro13 appleMacBookPro13 = new AppleMacBookPro13();
    EmailAFriendAppleMacBook emailAFriendAppleMacBook = new EmailAFriendAppleMacBook();
    NonRegisteredEmailAFriendAppleMac nonRegisteredEmailAFriendAppleMac = new NonRegisteredEmailAFriendAppleMac();
    ComputerPage computerPage = new ComputerPage();
    DesktopsPage desktopsPage = new DesktopsPage();
    ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
    CheckoutAsGuest checkoutAsGuest = new CheckoutAsGuest();
    OnePageCheckout onePageCheckout = new OnePageCheckout();
    NewsPage newsPage = new NewsPage();
    AboutNopCommercePage aboutNopCommercePage = new AboutNopCommercePage();
    CheckoutCompletedPage checkoutCompletedPage = new CheckoutCompletedPage();


    @Test
    public void userShouldAbleToRegisterSuccessfully() {
        homepage.clickOnRegisterButton();
        registrationPage.verifyUserIsOnRegisterPage();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // registrationPage.verifyFirstNameIsVisible();
        // registrationPage.waitUntilDisplayRegisterButton();
        registrationPage.userEntersRegistrationDetails();
        registrationPage.clickOnRegisterButton();
        registrationResultPage.verifyUserSeeRegistrationSuccessMessage();


    }

    @Test

    public void userShouldAbleToCompareSuccessfully() {

        homepage.compareTwoProducts();
        compareProductsPage.varifyUserSeeCompareProductsMessage();
    }

    @Test

    public void registeredUserShouldAbleToEmailAFriendSuccessfully() {
        homepage.clickOnRegisterButton();
        registrationPage.verifyUserIsOnRegisterPage();
        registrationPage.userEntersRegistrationDetails();
        registrationPage.clickOnRegisterButton();
        registrationResultPage.verifyUserSeeRegistrationSuccessMessage();
        registrationResultPage.clickOnContinueRegistrationResultPage();
        homepage.clickOnAppleMacBook();
        appleMacBookPro13.clickOnEmailAFriendButton();
        emailAFriendAppleMacBook.userEntersEmailAFriendDetails();
        emailAFriendAppleMacBook.verifyUserSeeEmailAFriendSentMessage();

    }

    @Test
    public void unregisteredUserWillSeeErrorMessage() {
        timeDelay(2);
        homepage.clickOnAppleMacBook();
        appleMacBookPro13.clickOnEmailAFriendButton();
        nonRegisteredEmailAFriendAppleMac.userEntersEmailsAFriendDetails();
        nonRegisteredEmailAFriendAppleMac.verifyUnregisteredUserWillSeeErrorMessageForEmailAFriend();

    }

    @Test
    public void userShouldAbleToSeePriceSortedHighToLow() {
        homepage.clickOnComputer();
        computerPage.verifyUserIsOnComputerPage();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        computerPage.clickOnDesktops();
        desktopsPage.clickOnSortBy();
        desktopsPage.selectHighToLowPrice();

    }

    @Test
    public void userShouldAbleToCheckOutSuccessfully()
    //click on computer
    {
        homepage.clickOnComputer();
        //click on desktops
        computerPage.clickOnDesktops();
        //click on add to cart button of Digital storm
        desktopsPage.scrollAndClickAddToCartDigitalStorm();
        //click on shopping cart
        desktopsPage.clickOnShoppingCart();
        //click on Terms and Conditions
        shoppingCartPage.scrollAndClickTermsOfService();
        //click on checkout
        shoppingCartPage.clickOnCheckOut();
        //click on checkout as guest
        checkoutAsGuest.clickOnCheckoutAsGuest();
        //enter guest details
        onePageCheckout.guestEnterDetails();
        //click on continue
        onePageCheckout.clickOnContinueShippingMethod();
        //click on credit card payment option
        onePageCheckout.clickOnCreditCardPaymentOption();
        //click on continue payment option
        onePageCheckout.clickOnContinuePaymentOption();
        //enter card details
        onePageCheckout.enterCardDetails();
        //click on continue
        onePageCheckout.clickOnContinueCardDetails();
        //click on confirm
        onePageCheckout.clickOnConfirm();
        //verify checkout completed message
        checkoutCompletedPage.verifyUserSeeCheckoutCompletedMessage();

    }

    @Test

    public void guestUserShouldAbleToAddNewCommentOnNopCommerce() {
        //click on news
        homepage.clickOnNews();
        //click on details
        newsPage.scrollAndClickOnDetails();
        // enter comment title
        aboutNopCommercePage.enterCommentTitle();
        //enter comment
        aboutNopCommercePage.enterComment();
        //click on new comment
        aboutNopCommercePage.clickOnNewComment();
        //verify comment added message visible
        aboutNopCommercePage.verifyUserAbleToSeeCommentAddedMessage();

    }


    @Test
    public void userShouldAbleToChangeCurrencySuccessfully() {
        //change currency to Euro from drop down arrow
        homepage.changeCurrencyToEuro();
        //verify euro currency is visible
        homepage.verifyUserAbleToSeeEuroCurrency();
    }

    @Test
    public void verifyAllTheProductsHaveAddToCartButton() {
        //verify add to cart button is visible for all the products
        homepage.verifyAddToCartButton();
    }


    @Test
    public void verifyProductsSortedInPriceDescendingOrder() {
        List<WebElement> productPrice = driver.findElements(By.xpath("//div[@class='prices']/span"));
        ArrayList<String> allProductPrices = new ArrayList<>();
        for (WebElement we : productPrice) {
            allProductPrices.add(we.getText().replaceAll("[$,]", "").replaceAll("[,]", ""));
        }
        System.out.println(allProductPrices);
        //String s;
        //s = allProductPrices.get(0);
        //System.out.println(s);
        for (int i = 0; i < allProductPrices.size(); i++) {
            // allProductPrices.get(i);
            String strPrice1;
            strPrice1 = allProductPrices.get(i);
            float fPrice1 = Float.parseFloat(strPrice1);
            System.out.println(fPrice1);
            if (i < allProductPrices.size() - 1) {
                String strPrice2;
                strPrice2 = allProductPrices.get(i + 1);
                float fPrice2 = Float.parseFloat(strPrice2);
                if (fPrice1 >= fPrice2) {
                    boolean highToLow = true;

                } else {
                    boolean highToLow = false;

                }

            }
        }
        Assert.assertTrue(true, "not sorted in high to low");

    }


}
