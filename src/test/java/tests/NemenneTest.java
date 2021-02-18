package tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class NemenneTest extends MainTest {

    @Before
    public void openBaseUrl() {
        driver.get(getBASE_URL() + "/nemenne.php");
    }

    @Test
    public void test() {
        Assert.assertFalse(driver.findElement(By.xpath("//input[@type='email']")).isEnabled());
        Assert.assertFalse(driver.findElement(By.id("sel1")).isEnabled());
        Assert.assertTrue(driver.findElement(By.id("sel2")).isEnabled());

        Assert.assertFalse(driver.findElement(By.id("sel2")).findElement(By.xpath("./option[1]")).isEnabled());
        Assert.assertFalse(driver.findElement(By.id("sel2")).findElement(By.xpath("./option[2]")).isEnabled());
        Assert.assertTrue(driver.findElement(By.id("sel2")).findElement(By.xpath("./option[3]")).isEnabled());
        //
        System.out.println(driver.findElement(By.id("sel2")).findElement(By.xpath("./option[1]")).isEnabled());
        System.out.println(driver.findElement(By.id("sel2")).findElement(By.xpath("./option[2]")).isEnabled());
        System.out.println(driver.findElement(By.id("sel2")).findElement(By.xpath("./option[3]")).isEnabled());

        Assert.assertFalse(driver.findElement(By.xpath("//button[1]")).isEnabled());
        Assert.assertTrue(driver.findElement(By.xpath("//button[2]")).isEnabled());
        //
        System.out.println(driver.findElement(By.xpath("//button[1]")).isEnabled());
        System.out.println(driver.findElement(By.xpath("//button[2]")).isEnabled());


    }
}
