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

public class resetStepDefinition {
    WebDriver driver = null;
    loginPage login;
    @Before("@reset")
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

    @And("user enters login page")
    public void user_navigates()
    {
        driver.navigate().to("https://demo.nopcommerce.com/login?returnUrl=%2F");

    }
    @When("user clicks on Forget Password?")
    public void forget_Password()
    {
        login.forgetPasswordElementPOM();
    }
    @And("^user types email \"(.*)\"$")
    public void enter_Email(String email)
    {
        login.emailElementPOM(email);

    }
    @And("user clicks on recover button")
    public void recover_button() throws InterruptedException {
        Thread.sleep(3000);
        login.recoverElementPOM();
    }
    @Then("user resets password successfully")
    public void success_password_reset()
    {
        String expectedResult ="Email with instructions has been sent to you.";
        String actualResult = driver.findElement(By.className("content")).getText();
        Assert.assertTrue(actualResult.contains(expectedResult));
    }

    @After("@reset")
    public void close_browser()
    {
        driver.quit();
    }
}
