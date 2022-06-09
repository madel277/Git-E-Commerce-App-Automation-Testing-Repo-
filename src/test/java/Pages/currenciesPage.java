package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class currenciesPage {
    WebDriver driver;

    public currenciesPage(WebDriver driver)
    {
        this.driver = driver;
    }

    public void currencyElementPOM(String currency)
    {
        new Select(driver.findElement(By.name("customerCurrency"))).selectByVisibleText(currency);
    }




}
