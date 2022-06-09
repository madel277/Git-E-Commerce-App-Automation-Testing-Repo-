package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class createOrderPage {
    WebDriver driver;

    public createOrderPage(WebDriver driver)
    {
        this.driver = driver;
    }
    public void shoppingCartElementPOM()
    {
        driver.findElement(By.xpath("//a[@href='/cart']")).click();

    }
    public void TermsOfServiceElementPOM()
    {
        driver.findElement(By.id("termsofservice")).click();
    }
    public void checkoutElementPOM()
    {
        driver.findElement(By.id("checkout")).click();
    }
    public void checkoutAsGuestElementPOM()
    {
        driver.findElement(By.className("checkout-as-guest-button")).click();
    }
    public void firstNameElementPOM(String firstname)
    {
        driver.findElement(By.id("BillingNewAddress_FirstName")).sendKeys(firstname);
    }
    public void lastNameElementPOM(String lastname)
    {
        driver.findElement(By.id("BillingNewAddress_LastName")).sendKeys(lastname);
    }
    public void emailElementPOM(String email)
    {
        driver.findElement(By.id("BillingNewAddress_Email")).sendKeys(email);
    }
    public void countryElementPOM(String country)
    {
        new Select(driver.findElement(By.id("BillingNewAddress_CountryId"))).selectByVisibleText(country);
    }
    public void cityElementPOM(String city)
    {
        driver.findElement(By.id("BillingNewAddress_City")).sendKeys(city);
    }
    public void addressElementPOM(String address)
    {
        driver.findElement(By.id("BillingNewAddress_Address1")).sendKeys(address);
    }
    public void postalCodeElementPOM(String postalCode)
    {
        driver.findElement(By.id("BillingNewAddress_ZipPostalCode")).sendKeys(postalCode);
    }
    public void numberElementPOM(String number)
    {
        driver.findElement(By.id("BillingNewAddress_PhoneNumber")).sendKeys(number);
    }
    public void continueElementPOM()
    {
        driver.findElement(By.name("save")).click();
    }
    public void shippingElementPOM()
    {
        new WebDriverWait(driver, Duration.ofMillis(2000)).until(ExpectedConditions.elementToBeClickable(By.id("shippingoption_1"))).click();

    }
    public void continueShippingElementPOM()
    {
        driver.findElement(By.className("shipping-method-next-step-button")).click();
    }
    public void continuePaymentElementPOM()
    {
        driver.findElement(By.className("payment-method-next-step-button")).click();
    }
    public void paymentElementPOM()
    {
        new WebDriverWait(driver, Duration.ofMillis(2000)).until(ExpectedConditions.elementToBeClickable(By.id("paymentmethod_1"))).click();

    }
    public void cardholderElementPOM(String name)
    {
        driver.findElement(By.id("CardholderName")).sendKeys(name);
    }
    public void cardNumberElementPOM(String number)
    {
        driver.findElement(By.id("CardNumber")).sendKeys(number);
    }
    public void expiryDateElementPOM(String month, String year)
    {
        new Select(driver.findElement(By.id("ExpireMonth"))).selectByVisibleText(month);
        new Select(driver.findElement(By.id("ExpireYear"))).selectByVisibleText(year);

    }
    public void codeElementPOM(String code)
    {
        driver.findElement(By.id("CardCode")).sendKeys(code);
    }
    public void continuePaymentInfoElementPOM()
    {
        driver.findElement(By.className("payment-info-next-step-button")).click();
    }
    public void confirmElementPOM()
    {
        driver.findElement(By.className("confirm-order-next-step-button")).click();

    }



}
