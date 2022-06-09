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

public class categoriesStepDefinition {
    WebDriver driver = null;
    loginPage login;
    categoriesPage categories;
    @Before("@category")
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
    @And("user moves to login page")
    public void login_page()
    {
        driver.navigate().to("https://demo.nopcommerce.com/login?returnUrl=%2F");
    }
    @And("^user enters \"(.*)\" and \"(.*)\"$")
    public void data(String email, String password)
    {
        login.loginSteps(email, password);

    }
    @And("user clicks on button to login")
    public void login()
    {
        login.loginElementPOM();
    }

    @When("user selects category Electronics")
    public void select_category() throws InterruptedException {
        categories.categoryElementPOM();
    }
    @And("user selects subcategory Cell phones")
    public void select_subcategory()
    {
        categories.subCategoryElementPOM();
    }
    @Then("user gets all cellphones shown")
    public void get_products()
    {
        Assert.assertEquals("https://demo.nopcommerce.com/cell-phones", driver.getCurrentUrl());
    }
    @After("@category")
    public void close_browser()
    {
        driver.quit();
    }



}
