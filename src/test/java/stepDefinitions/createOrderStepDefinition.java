package stepDefinitions;

import Pages.addProductsPage;
import Pages.categoriesPage;
import Pages.createOrderPage;
import Pages.loginPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class createOrderStepDefinition {
    WebDriver driver = null;
    addProductsPage addProducts;
    createOrderPage createOrder;
    @Before("@createOrder")
    public void OpenBrowser() throws InterruptedException {
        //first step-Bridge between test scripts and browser
        String chromePath = System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe";
        System.out.println(chromePath);
        System.setProperty("webdriver.chrome.driver", chromePath);

        //second Step-New Object
        driver = new ChromeDriver();

        //third Step-Navigate to Google website and maximize screen and sleep 3 seconds
        driver.manage().window().maximize();
        Thread.sleep(3000);

        //forth Step-Create new Object
        addProducts = new addProductsPage(driver);
        createOrder = new createOrderPage(driver);
    }
    @And("user navigates to homepage")
    public void user_navigates()
    {
        driver.navigate().to("https://demo.nopcommerce.com/");

    }
    @When("user selects Category Jewelry")
    public void select_Jewelery()
    {
        addProducts.jewelryCategoryElementPOM();
    }
    @And("user adds Flower Girl Bracelet to the Shopping cart")
    public void add_bracelet(){
        addProducts.addBraceletElementPOM();
    }
    @And("user goes to the Shopping cart")
    public void shopping_cart(){
        createOrder.shoppingCartElementPOM();
    }
    @And("user agrees with terms of service")
    public void terms_of_service() throws InterruptedException {
        Thread.sleep(3000);

        createOrder.TermsOfServiceElementPOM();
    }
    @And("user clicks on checkout button")
    public void checkout_button(){
        createOrder.checkoutElementPOM();
    }

    @And("user chooses Checkout as a Guest")
    public void checkout_as_guest(){
        createOrder.checkoutAsGuestElementPOM();
    }
    @And("^user enters first name \"(.*)\"$")
    public void firstname(String firstname){
        createOrder.firstNameElementPOM(firstname);
    }
    @And("^user enters last name \"(.*)\"$")
    public void lastname(String lastname){
        createOrder.lastNameElementPOM(lastname);
    }
    @And("^user fills in email \"(.*)\"$")
    public void email(String email){
        createOrder.emailElementPOM(email);
    }
    @And("^user selects Country \"(.*)\"$")
    public void country(String country){
        createOrder.countryElementPOM(country);
    }
    @And("^user enters City \"(.*)\"$")
    public void city(String city){
        createOrder.cityElementPOM(city);
    }
    @And("^user enters Address 1 \"(.*)\"$")
    public void address(String address){
        createOrder.addressElementPOM(address);
    }
    @And("^user enters postal code \"(.*)\"$")
    public void postalCode(String postalCode){
        createOrder.postalCodeElementPOM(postalCode);
    }
    @And("^user enters Phone number \"(.*)\"$")
    public void phonenumber(String number){
        createOrder.numberElementPOM(number);
    }
    @And("user clicks Continue")
    public void continue_button(){
        createOrder.continueElementPOM();
    }
    @And("user chooses Shipping method Next Day Air")
    public void shipping_method(){
        createOrder.shippingElementPOM();
    }
    @And("user chooses Continue button")
    public void continue_button_shipping(){
        createOrder.continueShippingElementPOM();
    }
    @And("user chooses Payment method Credit Card")
    public void payment_method(){
        createOrder.paymentElementPOM();
    }
    @And("user continues")
    public void continue_button_payment(){
        createOrder.continuePaymentElementPOM();
    }
    @And("^user enters Cardholder name \"(.*)\"$")
    public void cardholder(String name) throws InterruptedException {
        Thread.sleep(3000);

        createOrder.cardholderElementPOM(name);
    }
    @And("^user enters Card number \"(.*)\"$")
    public void cardNumber(String number)
    {
        createOrder.cardNumberElementPOM(number);
    }
    @And("^user enters Expiration date \"(.*)\"/\"(.*)\"$")
    public void expiryDate(String month, String year)
    {
        createOrder.expiryDateElementPOM(month, year);
    }
    @And("^user enters Card code \"(.*)\"$")
    public void cardCode(String code)
    {
        createOrder.codeElementPOM(code);
    }
    @And("users clicks again on Continue button")
    public void continue_button_payment_info() {
        createOrder.continuePaymentInfoElementPOM();
    }
    @And("user clicks on Confirm button")
    public void confirm_button() throws InterruptedException {
        Thread.sleep(3000);
        createOrder.confirmElementPOM();

    }
    @Then("user created order successfully")
    public void create_order_successfully() throws InterruptedException {
        Thread.sleep(3000);
        Assert.assertEquals("https://demo.nopcommerce.com/checkout/completed", driver.getCurrentUrl());
    }
    @After("@createOrder")
    public void close_browser()
    {
        driver.quit();
    }







}
