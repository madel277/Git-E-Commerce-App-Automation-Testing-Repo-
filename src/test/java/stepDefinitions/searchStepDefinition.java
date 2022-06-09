package stepDefinitions;

import Pages.loginPage;
import Pages.searchPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class searchStepDefinition {
    WebDriver driver = null;
    loginPage login;
    searchPage search;
    @Before("@search")
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
        search = new searchPage(driver);
    }
    @And("user goes to login page")
    public void login_page()
    {
        driver.navigate().to("https://demo.nopcommerce.com/login?returnUrl=%2F");
    }
    @And("^user logs in with email \"(.*)\" and password \"(.*)\"$")
    public void data(String email, String password)
    {
        login.loginSteps(email, password);

    }
    @And("user logs in by clicking login button")
    public void login()
    {
        login.loginElementPOM();
    }

    @And("^user types \"(.*)\" in search box")
    public void search_product(String product) {
        search.searchElementPOM(product);
    }

    @And("user clicks on search button")
    public void search_button() throws InterruptedException {
        Thread.sleep(3000);
        search.searchButtonElementPOM();
        Thread.sleep(2000);


    }

    @Then("user goes to search page")
    public void success_search_page()
    {
        Assert.assertEquals("https://demo.nopcommerce.com/search?q=laptop", driver.getCurrentUrl());
    }

    @When("^user fills in \"(.*)\" in search box")
    public void advanced_search_textbox(String product)
    {
        search.searchElementPOM(product);;
    }
    @And("user clicks search button")
    public void search()
    {
        search.searchButtonElementPOM();
    }
    @And("user clicks on advanced search")
    public void advanced_search_checkbox()
    {
        search.advancedSearchCheckBoxElementPOM();
    }
    @And("^user chooses \"(.*)\" as Category")
    public void category(String category)
    {
        search.categoryElementPOM(category);
    }
    @And("user clicks on Automatically search sub categories")
    public void subcategories()
    {
        search.subCategoriesElementPOM();
    }
    @And("^user chooses \"(.*)\" as Manufacturer")
    public void manufacturer(String manufacturer)
    {
        search.manufacturerElementPOM(manufacturer);
    }
    @And("user chooses Search In product description")
    public void product_description()
    {
        search.productDescriptionElementPOM();
    }
    @And("user clicks on advanced search button")
    public void advanced_search_button() throws InterruptedException {
        Thread.sleep(3000);
        search.advancedSearchButtonElementPOM();
        Thread.sleep(3000);

    }

    @Then("search result will be shown to user")
    public void success_advanced_search()
    {
        Assert.assertEquals("https://demo.nopcommerce.com/search?q=laptop&advs=true&cid=1&isc=true&mid=2&sid=true&advs=false&isc=false&sid=false", driver.getCurrentUrl());

    }
    @After("@search")
    public void close_browser()
    {
        driver.quit();
    }
}

