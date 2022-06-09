package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class registerPage {
    WebDriver driver;

    public registerPage(WebDriver driver)
    {
        this.driver = driver;
    }

    public void genderElementPOM()
    {
        driver.findElement(By.id("gender-female")).click();
    }

    public void firstnameElementPOM(String firstname)
    {
        driver.findElement(By.id("FirstName")).sendKeys(firstname);
    }

    public void lastnameElementPOM(String lastname)
    {
        driver.findElement(By.id("LastName")).sendKeys(lastname);
    }
    public void dateOfBirthElementPOM(String day, String month, String year)
    {
        new Select(driver.findElement(By.name("DateOfBirthDay"))).selectByValue(day);
        new Select(driver.findElement(By.name("DateOfBirthMonth"))).selectByValue(month);
        new Select(driver.findElement(By.name("DateOfBirthYear"))).selectByValue(year);
    }
    public void emailElementPOM(String email)
    {
        driver.findElement(By.id("Email")).sendKeys(email);
    }

    public void companyElementPOM(String company)
    {
        driver.findElement(By.id("Company")).sendKeys(company);
    }
    public void newsletterElementPOM()
    {
        boolean selected  = driver.findElement(By.id("Newsletter")).isSelected();
        if(selected == false)
        {
            driver.findElement(By.id("Newsletter")).click();
        }
    }
    public void passwordElementPOM(String password)
    {

        driver.findElement(By.id("Password")).sendKeys(password);
    }
    public void confirmPasswordElementPOM(String confirmPassword)
    {
        driver.findElement(By.id("ConfirmPassword")).sendKeys(confirmPassword);
    }
    public void registerElementPOM()
    {
        driver.findElement(By.id("register-button")).click();
    }
    public void continueElementPOM()
    {
        driver.findElement(By.className("register-continue-button")).click();
    }
}
