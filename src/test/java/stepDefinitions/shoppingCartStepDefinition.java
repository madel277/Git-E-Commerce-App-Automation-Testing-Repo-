package stepDefinitions;

import Pages.addProductsPage;
import Pages.categoriesPage;
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

public class shoppingCartStepDefinition {
    WebDriver driver = null;
    loginPage login;
    categoriesPage categories;
    addProductsPage addProducts;
    @Before("@shoppingCart")
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
        addProducts = new addProductsPage(driver);
    }
    @And("enters login page")
    public void login_page()
    {
        driver.navigate().to("https://demo.nopcommerce.com/login?returnUrl=%2F");
    }
    @And("^keys in \"(.*)\" and \"(.*)\"$")
    public void data(String email, String password)
    {
        login.loginSteps(email, password);

    }
    @And("user could click the button to login")
    public void login()
    {
        login.loginElementPOM();
    }
    @When("user clicks on Category Jewelry")
    public void select_Jewelery()
    {
        addProducts.jewelryCategoryElementPOM();
    }
    @And("user adds Bracelet to the Shopping cart")
    public void add_bracelet() throws InterruptedException {
        addProducts.addBraceletElementPOM();
        Thread.sleep(3000);

    }
    @Then("user adds product successfully")
    public void product_added_successfully() {
        String actualResult = driver.findElement(By.xpath("//div[@id='bar-notification']//div[@class='bar-notification success']")).getText();
        Assert.assertEquals("The product has been added to your shopping cart", actualResult);
    }
    @Then("user clicks on Category Books")
    public void select_Books() throws InterruptedException {
        Thread.sleep(3000);
        addProducts.bookCategoryElementPOM();
    }
    @And("user adds Pride and Prejudice to the Shopping cart")
    public void add_book() throws InterruptedException {
        addProducts.addBookElementPOM();
        Thread.sleep(3000);

    }
    @And("user adds second product successfully to Shopping cart")
    public void second_product_added_successfully()
    {
        String actualResult = driver.findElement(By.xpath("//div[@id='bar-notification']//div[@class='bar-notification success']")).getText();
        Assert.assertEquals("The product has been added to your shopping cart", actualResult);
    }

    @After("@shoppingCart")
    public void close_browser()
    {
        driver.quit();
    }
}
