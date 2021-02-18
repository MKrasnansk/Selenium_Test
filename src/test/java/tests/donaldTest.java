package tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.io.IOException;

public class donaldTest extends MainTest {

    @Before
    public void openBaseUrl() {
        driver.get(getBASE_URL() + "/moveme.php");
    }


    @Test
    public void test() throws InterruptedException, IOException {
        WebElement donald = driver.findElement(By.id("donald"));
        WebElement strom = driver.findElement(By.id("tree"));

        Actions actions = new Actions(driver);
        actions.dragAndDrop(donald, strom).build().perform();
        WebElement expectTitle = driver.findElement(By.xpath("//div[contains(@class,'success')]/h2"));

        Assert.assertTrue(expectTitle.isDisplayed());
        Assert.assertEquals("HOOO HOOOOO !!!!", expectTitle.getText());
//        actions.clickAndHold(donald).moveByOffset(3000, 0).release().build().perform();
    }
}
