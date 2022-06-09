package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class addProductsPage {
    WebDriver driver;

    Actions actions;

    public addProductsPage(WebDriver driver)
    {
        this.driver = driver;
        actions = new Actions(driver);
    }
    public void jewelryCategoryElementPOM(){
        driver.findElement(By.xpath("//a[@href='/jewelry']")).click();

    }
    public void electronicsCategoryElementPOM() throws InterruptedException {
        WebElement mainCategory = driver.findElement(By.xpath("//a[@href='/electronics']"));
        actions.moveToElement(mainCategory);
        Thread.sleep(3000);

    }
    public void cellphonesSubcategoryElementPOM()
    {
        WebElement subMenu = driver.findElement(By.xpath("//a[@href='/cell-phones']"));
        actions.moveToElement(subMenu);
        actions.click().build().perform();
    }
    public void addBraceletElementPOM(){
        driver.findElement(By.xpath("//button[@onclick='return AjaxCart.addproducttocart_catalog(\"/addproducttocart/catalog/41/1/1\"),!1']")).click();
    }
    public void addCellphoneElementPOM(){
        driver.findElement(By.xpath("//button[@onclick='return AjaxCart.addproducttocart_catalog(\"/addproducttocart/catalog/20/2/1\"),!1']")).click();
    }
    public void bookCategoryElementPOM(){
        driver.findElement(By.xpath("//a[@href='/books']")).click();

    }
    public void computersCategoryElementPOM() throws InterruptedException {
        WebElement mainCategory = driver.findElement(By.xpath("//a[@href='/computers']"));
        actions.moveToElement(mainCategory);
        Thread.sleep(3000);
    }
    public void notebooksSubCategoryElementPOM(){
        WebElement subMenu = driver.findElement(By.xpath("//a[@href='/notebooks']"));
        actions.moveToElement(subMenu);
        actions.click().build().perform();
    }
    public void addBookElementPOM(){
        driver.findElement(By.xpath("//button[@onclick='return AjaxCart.addproducttocart_catalog(\"/addproducttocart/catalog/39/1/1\"),!1']")).click();
    }
    public void addNotebookElementPOM(){
        driver.findElement(By.xpath("//button[@onclick='return AjaxCart.addproducttocart_catalog(\"/addproducttocart/catalog/8/2/1\"),!1']")).click();
    }
    public void addHTCCellphoneElementPOM(){
        driver.findElement(By.xpath("//button[@onclick='return AjaxCart.addproducttocomparelist(\"/compareproducts/add/18\"),!1']")).click();
    }
    public void addNokiaCellphoneElementPOM(){
        driver.findElement(By.xpath("//button[@onclick='return AjaxCart.addproducttocomparelist(\"/compareproducts/add/20\"),!1']")).click();
    }
}
