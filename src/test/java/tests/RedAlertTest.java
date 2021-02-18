package tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

public class RedAlertTest extends MainTest {

    @Before
    public void openBaseUrl() {
        driver.get(getBASE_URL() + "/redalert.php");
    }


    @Test
    public void test() {
        driver.findElement(By.id("alert1")).click();
        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.accept();
        System.out.println(driver.findElement(By.xpath("//div[@class='result']/h1")).getText());

        driver.findElement(By.id("alert2")).click();
        Alert alert2 = driver.switchTo().alert();
        System.out.println(alert2.getText());
        Assert.assertEquals("Second alert!", alert.getText());
        alert2.dismiss();
        System.out.println(driver.findElement(By.xpath("//div[@class='result']/h1")).getText());
        Assert.assertEquals("Negative", driver.findElement(By.xpath("//div[@class='result']/h1")).getText());

        driver.findElement(By.id("alert3")).click();
        Alert alert3 = driver.switchTo().alert();
        System.out.println(alert3.getText());
        alert3.sendKeys("Michal");
        Assert.assertEquals("Enter your name comrade", alert.getText());
        alert3.accept();
        System.out.println(driver.findElement(By.xpath("//div[@class='result']/h1")).getText());
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='result']/h1")).getText().contains("Michal"));

    }
}
