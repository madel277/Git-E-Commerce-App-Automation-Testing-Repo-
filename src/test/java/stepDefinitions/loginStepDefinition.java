package stepDefinitions;

import Pages.loginPage;
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

public class loginStepDefinition {
    WebDriver driver = null;
    loginPage login;
    @Before("@login")
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
        login = new loginPage(driver);
    }

    @And("user navigates to login page")
    public void user_navigates()
    {
        driver.navigate().to("https://demo.nopcommerce.com/login?returnUrl=%2F");

    }

    @When("^user fills in email with \"(.*)\" and password with \"(.*)\"$")
    public void data(String email, String password)
    {
        login.loginSteps(email, password);

    }
    @And("user chooses remember me")
    public void rememberMe_checkbox() {
        login.rememberMeElementPOM();

    }

    @And("user clicks on login button")
    public void login_button() throws InterruptedException {
        Thread.sleep(3000);
        login.loginElementPOM();

    }

    @Then("user could login successfully and goes to the home page")
    public void success_login_home_page()
    {
        Assert.assertEquals("https://demo.nopcommerce.com/", driver.getCurrentUrl());
    }

    @After("@login")
    public void close_browser()
    {
        driver.quit();
    }
}
