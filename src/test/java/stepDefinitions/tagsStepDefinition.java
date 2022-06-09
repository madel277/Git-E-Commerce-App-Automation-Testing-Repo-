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

public class tagsStepDefinition {
    WebDriver driver = null;
    loginPage login;
    categoriesPage categories;
    @Before("@tag")
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
    @And("moves to login page")
    public void login_page()
    {
        driver.navigate().to("https://demo.nopcommerce.com/login?returnUrl=%2F");
    }
    @And("^enters \"(.*)\" \"(.*)\"$")
    public void data(String email, String password)
    {
        login.loginSteps(email, password);

    }
    @And("clicks on login")
    public void login()
    {
        login.loginElementPOM();
    }

    @When("user selects category Computers")
    public void select_computers() {
        categories.computerCategoryElementPOM();
    }
    @And("user selects tag compact")
    public void select_compactTag()
    {
        categories.compactTagElementPOM();
    }
    @Then("user gets all products tagged with compact")
    public void get_compact_products()
    {
        Assert.assertEquals("https://demo.nopcommerce.com/compact", driver.getCurrentUrl());
    }
    @And("user selects tag camera")
    public void select_cameraTag()
    {
        categories.cameraTagElementPOM();
    }
    @And("user gets all products tagged with camera")
    public void get_camera_products()
    {
        Assert.assertEquals("https://demo.nopcommerce.com/camera", driver.getCurrentUrl());

    }

    @After("@tag")
    public void close_browser()
    {
        driver.quit();
    }



}
