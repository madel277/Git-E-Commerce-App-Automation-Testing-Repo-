package stepDefinitions;

import Pages.categoriesPage;
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

public class filterColorStepDefinition {
    WebDriver driver = null;
    loginPage login;
    categoriesPage categories;
    @Before("@color")
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
        categories = new categoriesPage(driver);
    }
    @And("user moves to page to login")
    public void login_page()
    {
        driver.navigate().to("https://demo.nopcommerce.com/login?returnUrl=%2F");
    }
    @And("^enters \"(.*)\" and \"(.*)\"$")
    public void data(String email, String password)
    {
        login.loginSteps(email, password);

    }
    @And("clicks on button to login")
    public void login()
    {
        login.loginElementPOM();
    }

    @When("user selects category Apparel")
    public void select_apparel() throws InterruptedException {
        categories.apparelCategoryElementPOM();
    }
    @And("user selects subcategory Shoes")
    public void select_shoes()
    {
        categories.shoesSubCategoryElementPOM();
    }
    @And("user selects color red")
    public void select_red()
    {
        categories.redElementPOM();
    }
    @Then("user gets all offered red shoes")
    public void get_red_shoes()
    {
        Assert.assertEquals("https://demo.nopcommerce.com/shoes?viewmode=grid&orderby=0&pagesize=6&specs=15", driver.getCurrentUrl());
    }
    @And("user selects color grey")
    public void select_grey()
    {
        categories.greyElementPOM();
    }
    @And("user gets all offered red and grey shoes")
    public void get_red_and_grey_shoes()
    {
        Assert.assertEquals("https://demo.nopcommerce.com/shoes?viewmode=grid&orderby=0&pagesize=6&specs=14%2C15", driver.getCurrentUrl());
    }

    @After("@color")
    public void close_browser()
    {
        driver.quit();
    }



}
