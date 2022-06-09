package stepDefinitions;

import Pages.currenciesPage;
import Pages.loginPage;
import Pages.searchPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class currenciesStepDefinition {
    WebDriver driver = null;
    loginPage login;
    searchPage search;
    currenciesPage currencies;
    @Before("@currency")
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
        currencies = new currenciesPage(driver);
    }
    @And("user types login page")
    public void login_page()
    {
        driver.navigate().to("https://demo.nopcommerce.com/login?returnUrl=%2F");
    }
    @And("^user logs in with \"(.*)\" and \"(.*)\"$")
    public void data(String email, String password)
    {
        login.loginSteps(email, password);

    }
    @And("user clicks login button")
    public void login()
    {
        login.loginElementPOM();
    }

    @And("^user searches for \"(.*)\"$")
    public void search_product(String product) {
        search.searchElementPOM(product);
    }

    @And("user clicks search")
    public void search_button() throws InterruptedException {
        search.searchButtonElementPOM();
        Thread.sleep(2000);


    }
    @And("^user chooses currency \"(.*)\" from currency dropbox")
    public void select_currency(String currency)
    {
        currencies.currencyElementPOM(currency);
    }

    @Then("user get price in Euro")
    public void price_in_euro()
    {
        Assert.assertEquals("€1548.00", driver.findElement(By.className("actual-price")).getText());
    }
   @And("user get price in US Dollar")
   public void price_in_us_dollar()
   {
       Assert.assertEquals("$1,800.00", driver.findElement(By.className("actual-price")).getText());
   }
    @After("@currency")
    public void close_browser()
    {
        driver.quit();
    }

}
