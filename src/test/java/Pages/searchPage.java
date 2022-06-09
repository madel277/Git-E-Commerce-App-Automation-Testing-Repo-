package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class searchPage {
    WebDriver driver;

    public searchPage(WebDriver driver)
    {
        this.driver = driver;
    }

    public void searchElementPOM(String product)
    {
        driver.findElement(By.id("small-searchterms")).sendKeys(product);
    }
    public void searchButtonElementPOM()
    {
        driver.findElement(By.className("search-box-button")).click();
    }
    public void advancedSearchCheckBoxElementPOM()
    {
        driver.findElement(By.id("advs")).click();
    }
    public void categoryElementPOM(String category)
    {
        new Select(driver.findElement(By.name("cid"))).selectByVisibleText(category);
    }
    public void subCategoriesElementPOM()
    {
        driver.findElement(By.id("isc")).click();
    }
    public void manufacturerElementPOM(String manufacturer)
    {
        new Select(driver.findElement(By.name("mid"))).selectByVisibleText(manufacturer);
    }
    public void productDescriptionElementPOM()
    {
        driver.findElement(By.id("sid")).click();

    }
    public void advancedSearchButtonElementPOM()
    {
        driver.findElement(By.className("search-button")).click();
    }


}
