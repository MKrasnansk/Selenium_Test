package tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class registraciaTest extends MainTest {

    @Before
    public void openBaseUrl() {
        driver.get(getBASE_URL() + "/registracia.php");
    }

    @Test
    public void test() {
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        List<WebElement> formDivs = driver.findElements(By.xpath("//div[input]"));
        for (WebElement formDiv : formDivs) {
            System.out.println(formDiv.getAttribute("class"));
        }

        String email = "mkr@mksd.sk";
        String name = "Michal";
        String surname = "Krasnansky";
        driver.findElement(By.name("email")).clear();
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("name")).clear();
        driver.findElement(By.name("name")).sendKeys(name);
        driver.findElement(By.name("surname")).clear();
        driver.findElement(By.name("surname")).sendKeys(surname);
        driver.findElement(By.xpath("//a[@href='zenaalebomuz.php']")).click();

        driver.navigate().back();

        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By.name("email")));
        Assert.assertEquals(email, driver.findElement(By.name("email")).getAttribute("value"));
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By.name("name")));
        Assert.assertEquals(name, driver.findElement(By.name("name")).getAttribute("value"));
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By.name("surname")));
        Assert.assertEquals(surname, driver.findElement(By.name("surname")).getAttribute("value"));

        driver.navigate().forward();

        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//img[@src='img/conchita.jpg']")));
        Assert.assertTrue(driver.findElement(By.xpath("//img[@src='img/conchita.jpg']")).isDisplayed());

    }
}
