package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class categoriesPage {
    WebDriver driver;

    Actions actions;

    public categoriesPage(WebDriver driver)
    {
        this.driver = driver;
        actions = new Actions(driver);
    }

    public void computerCategoryElementPOM(){
        driver.findElement(By.xpath("//a[@href='/computers']")).click();

    }
    public void compactTagElementPOM(){
        driver.findElement(By.xpath("//a[@href='/compact']")).click();

    }
    public void cameraTagElementPOM(){
        driver.findElement(By.xpath("//a[@href='/camera']")).click();

    }
    public void categoryElementPOM() throws InterruptedException {
        WebElement mainCategory = driver.findElement(By.xpath("//a[@href='/electronics']"));
        actions.moveToElement(mainCategory);
        Thread.sleep(3000);

    }
    public void subCategoryElementPOM()
    {
        WebElement subMenu = driver.findElement(By.xpath("//a[@href='/cell-phones']"));
        actions.moveToElement(subMenu);
        actions.click().build().perform();
    }
    public void apparelCategoryElementPOM() throws InterruptedException {
        WebElement mainCategory = driver.findElement(By.xpath("//a[@href='/apparel']"));
        actions.moveToElement(mainCategory);
        Thread.sleep(3000);

    }
    public void shoesSubCategoryElementPOM()
    {
        WebElement subMenu = driver.findElement(By.xpath("//a[@href='/shoes']"));
        actions.moveToElement(subMenu);
        actions.click().build().perform();
    }
    public void redElementPOM()
    {
        driver.findElement(By.id("attribute-option-15")).click();
    }
    public void greyElementPOM()
    {
        driver.findElement(By.id("attribute-option-14")).click();
    }



}
