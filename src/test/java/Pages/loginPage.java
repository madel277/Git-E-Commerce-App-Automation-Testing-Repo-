package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class loginPage {
    WebDriver driver;

    public loginPage(WebDriver driver)
    {
        this.driver = driver;
    }

    public void loginSteps(String email, String password)
    {

        emailElementPOM().sendKeys(email);
        passwordElementPOM().sendKeys(password);
    }

    public WebElement emailElementPOM()
    {
        return driver.findElement(By.id("Email"));
    }
    public void emailElementPOM(String email)
    {
        driver.findElement(By.id("Email")).sendKeys(email);
    }

    public WebElement passwordElementPOM()
    {

        return driver.findElement(By.id("Password"));
    }
    public void rememberMeElementPOM()
    {
        driver.findElement(By.id("RememberMe")).click();
    }
    public void loginElementPOM()
    {
        driver.findElement(By.className("login-button")).click();
    }
    public void forgetPasswordElementPOM()
    {
        driver.findElement(By.xpath("//a[@href='/passwordrecovery']")).click();
    }
    public void recoverElementPOM()
    {
        driver.findElement(By.className("password-recovery-button")).click();
    }


}
