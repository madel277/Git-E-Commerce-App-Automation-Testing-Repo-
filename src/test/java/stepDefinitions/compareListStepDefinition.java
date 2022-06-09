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

public class compareListStepDefinition {
    WebDriver driver = null;
    loginPage login;
    categoriesPage categories;
    addProductsPage addProducts;
    @Before("@compareList")
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
    @And("user enters the login page")
    public void login_page()
    {
        driver.navigate().to("https://demo.nopcommerce.com/login?returnUrl=%2F");
    }
    @And("^user keys in \"(.*)\", \"(.*)\"$")
    public void data(String email, String password)
    {
        login.loginSteps(email, password);

    }
    @And("user click login button")
    public void login()
    {
        login.loginElementPOM();
    }

    @When("user chooses Category Electronics")
    public void select_Electronics() throws InterruptedException {
        addProducts.electronicsCategoryElementPOM();
    }
    @And("user chooses subCategory Cellphones")
    public void select_Cellphones() {
        addProducts.cellphonesSubcategoryElementPOM();
    }

    @And("user adds a HTC One to the compareList")
    public void add_HTCCellphone() throws InterruptedException {
        addProducts.addHTCCellphoneElementPOM();
        Thread.sleep(3000);

    }
    @Then("user adds product successfully to compareList")
    public void product_added_successfully_to_compareList() {
        String actualResult = driver.findElement(By.xpath("//div[@id='bar-notification']//div[@class='bar-notification success']")).getText();
        Assert.assertEquals("The product has been added to your product comparison", actualResult);
    }
    @And("user adds Nokia Lumia to compareList")
    public void add_NokiaCellphone() throws InterruptedException {
        addProducts.addNokiaCellphoneElementPOM();
        Thread.sleep(3000);

    }
    @And("user adds second product successfully to compareList")
    public void second_product_added_successfully_to_compareList() {
        String actualResult = driver.findElement(By.xpath("//div[@id='bar-notification']//div[@class='bar-notification success']")).getText();
        Assert.assertEquals("The product has been added to your product comparison", actualResult);
    }

    @After("@compareList")
    public void close_browser()
    {
        driver.quit();
    }
}
