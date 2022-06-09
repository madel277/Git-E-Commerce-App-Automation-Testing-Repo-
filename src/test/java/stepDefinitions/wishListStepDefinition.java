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

public class wishListStepDefinition {
    WebDriver driver = null;
    loginPage login;
    categoriesPage categories;
    addProductsPage addProducts;
    @Before("@wishList")
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
    @And("enters the login page")
    public void login_page()
    {
        driver.navigate().to("https://demo.nopcommerce.com/login?returnUrl=%2F");
    }
    @And("^keys in \"(.*)\", \"(.*)\"$")
    public void data(String email, String password)
    {
        login.loginSteps(email, password);

    }
    @And("user click the login button")
    public void login()
    {
        login.loginElementPOM();
    }

    @When("user selects Category Electronics")
    public void select_Electronics() throws InterruptedException {
        addProducts.electronicsCategoryElementPOM();
    }
    @And("user selects subCategory Cellphones")
    public void select_Cellphones() {
        addProducts.cellphonesSubcategoryElementPOM();
    }
    @And("user adds a Nokia Lumia to the WishList")
    public void add_cellphone() throws InterruptedException {
        addProducts.addCellphoneElementPOM();
        Thread.sleep(3000);
    }
    @Then("user adds product successfully to WishList")
    public void product_added_successfully_to_WishList() {
        String actualResult = driver.findElement(By.xpath("//div[@id='bar-notification']//div[@class='bar-notification success']")).getText();
        Assert.assertEquals("The product has been added to your wishlist", actualResult);
    }
    @Then("user chooses Category Computers")
    public void select_Computers() throws InterruptedException {
        Thread.sleep(3000);
        addProducts.computersCategoryElementPOM();
    }
    @And("user chooses subCategory Notebooks")
    public void select_NoteBooks() {
        addProducts.notebooksSubCategoryElementPOM();
    }
    @And("user adds HP Notebook to WishList")
    public void add_notebook() throws InterruptedException {
        addProducts.addNotebookElementPOM();
        Thread.sleep(3000);

    }
    @And("user adds second product successfully to WishList")
    public void second_product_added_successfully_to_WishList() {
        String actualResult = driver.findElement(By.xpath("//div[@id='bar-notification']//div[@class='bar-notification success']")).getText();
        Assert.assertEquals("The product has been added to your wishlist", actualResult);
    }
    @After("@wishList")
    public void close_browser()
    {
        driver.quit();
    }
}
