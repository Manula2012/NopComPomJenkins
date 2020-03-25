package WebTestPom;

import org.openqa.selenium.By;

public class OnePageCheckout extends Utils

{   LoadProp loadProp = new LoadProp();
    private By _firstName = By.name("BillingNewAddress.FirstName");
    private By _lastName = By.name("BillingNewAddress.LastName");
    private By _email = By.name("BillingNewAddress.Email");
    private By __country = By.name("BillingNewAddress.CountryId");
    private By _city = By.id("BillingNewAddress_City");
    private By _address1 = By.xpath("//input[contains(@id,'_Address1')]");
    private By _postCode = By.xpath("//input[contains(@name,'.ZipPostalCode')]");
    private By _phoneNumber = By.xpath("//input[contains(@id,'_PhoneNumber')]");
    private By _continueButton = By.xpath("//input[@onclick='Billing.save()']");
    private By _continueShippingMethod = By.xpath("//input[@onclick='ShippingMethod.save()']");
    private By _creditCardPaymentOption = By.cssSelector("#paymentmethod_1");
    private By _continuePaymentMethod = By.xpath("//input[@onclick='PaymentMethod.save()']");
    private By _creditCardType = By.cssSelector("#CreditCardType");
    private By _cardHolderName = By.cssSelector("#CardholderName");
    private By _cardNumber = By.cssSelector("#CardNumber");
    private By _expireMonth = By.cssSelector("#ExpireMonth");
    private By _expireYear = By.cssSelector("#ExpireYear");
    private By _cardCode = By.cssSelector("#CardCode");
    private By _continueCardDetails = By.xpath("//input[@onclick='PaymentInfo.save()']");
    private By _confirmOrder = By.xpath("//input[@value='Confirm']");
    private By _orderNumber = By.linkText("Order number: 2602");







    String firstName = loadProp.getProperty("firstName");
    String lastName = loadProp.getProperty("lastName");
    String email = loadProp.getProperty("email");
    String city = loadProp.getProperty("city");
    String address1 = loadProp.getProperty("address1");
    String postCode = loadProp.getProperty("postCode");
    String phoneNumber = loadProp.getProperty("phoneNumber");
    String cardHolderName = loadProp.getProperty("cardHolderName");
    String cardNumber = loadProp.getProperty("cardNumber");
    String cardCode = loadProp.getProperty("cardCode");




    public void guestEnterDetails()
    { sendText(_firstName,firstName);
        sendText(_lastName,lastName);
        sendText(_email,email);
        selectElementByIndex(__country,3);
        sendText(_city,city);
        sendText(_address1,address1);
        sendText(_postCode,postCode);
        sendText(_phoneNumber,phoneNumber);
        clickOnElement(_continueButton);

    }

    public void clickOnContinueShippingMethod()
    {
        clickOnElement(_continueShippingMethod);
    }

    public void clickOnCreditCardPaymentOption()
    {
        clickOnElement(_creditCardPaymentOption);
    }

    public void clickOnContinuePaymentOption()
    {
        clickOnElement(_continuePaymentMethod);
    }



    public void enterCardDetails()
    { selectElementByIndex(_creditCardType,1);
        sendText(_cardHolderName,cardHolderName);
        sendText(_cardNumber,cardNumber);
        selectElementByIndex(_expireMonth,2);
        selectElementByIndex(_expireYear,2);
        sendText(_cardCode,cardCode);
    }

    public void clickOnContinueCardDetails()
    {
        clickOnElement(_continueCardDetails);
    }
    public void clickOnConfirm()
    {
        clickOnElement(_confirmOrder);
    }




}
