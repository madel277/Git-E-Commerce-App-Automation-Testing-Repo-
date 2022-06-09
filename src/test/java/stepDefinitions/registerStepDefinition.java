package stepDefinitions;

import Pages.registerPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class registerStepDefinition {
    WebDriver driver = null;
    registerPage register;
    @Before("@register")
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
        register = new registerPage(driver);
    }

    @And("user navigates to register page")
    public void user_navigates()
    {
        driver.navigate().to("https://demo.nopcommerce.com/register?returnUrl=%2F");

    }
    @When("user chooses Female as Gender")
    public void gender_checkbox()
    {
        register.genderElementPOM();
    }
    @And("^user fills in first name with \"(.*)\"$")
    public void first_name(String firstname)
    {
        register.firstnameElementPOM(firstname);
    }
    @And("^user fills in last name with \"(.*)\"$")
    public void last_name(String lastname)
    {
        register.lastnameElementPOM(lastname);
    }
    @And("^user chooses as birthdate \"(.*)\" as day and \"(.*)\" as month and \"(.*)\" as year")
    public void date_of_birth(String day, String month, String year)
    {
        register.dateOfBirthElementPOM(day, month, year);
    }
    @And("^user enters email \"(.*)\"$")
    public void email(String email)
    {
        register.emailElementPOM(email);
    }
    @And("^user fills in company name with \"(.*)\"$")
    public void company_name(String company)
    {
        register.companyElementPOM(company);
    }

    @And("user chooses Newsletter")
    public void newsletter_checkbox()
    {
        register.newsletterElementPOM();
    }
    @And("^user fills in password with \"(.*)\"$")
    public void password(String password)
    {
        register.passwordElementPOM(password);
    }
    @And("^user fills in password confirmation with \"(.*)\"$")
    public void confirm_password(String confpassword)
    {
        register.confirmPasswordElementPOM(confpassword);
    }
    @And("user clicks on register button")
    public void register_button() throws InterruptedException {
        Thread.sleep(3000);
        register.registerElementPOM();
    }
    @Then("user could register successfully")
    public void success_register()
    {
        String expectedResult ="Your registration completed";
        String actualResult = driver.findElement(By.className("result")).getText();
        Assert.assertTrue(actualResult.contains(expectedResult));
    }
    @And("user clicks on continue button")
    public void continue_button() throws InterruptedException {
        register.continueElementPOM();

    }
    @And("user goes to the home page")
    public void home_page()
    {
        Assert.assertEquals("https://demo.nopcommerce.com/", driver.getCurrentUrl());
    }

    @After("@register")
    public void close_browser()
    {
        driver.quit();
    }
}
