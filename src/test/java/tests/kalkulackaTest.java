package tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class kalkulackaTest extends MainTest {

    @Before
    public void openBaseUrl() {
        driver.get(getBASE_URL() + "/kalkulacka.php");
    }

    @Test
    public void testSum() {
        checkSum("1", "2", "count", "3");
        checkSum("3", "4", "count", "7");
        checkSum("8", "8", "count", "16");
        checkSum("33", "55", "count", "88");
    }

    @Test
    public void testDeduct() {
        check("10", "4", "deduct", "6");
        check("133", "33", "deduct", "100");
        check("100", "4", "deduct", "96");
    }

    @Test
    public void testReset() {
        enterInputs("5", "4");
        driver.findElement(By.id("count")).click();
        driver.findElement(By.id("reset")).click();

        Assert.assertTrue(driver.findElement(By.id("firstInput")).getAttribute("value").isEmpty());
        Assert.assertTrue(driver.findElement(By.id("secondInput")).getAttribute("value").isEmpty());
        Assert.assertTrue(driver.findElement(By.id("result")).getText().isEmpty());

    }

    @Test
    public void testInvalid() {
        enterInputs("nic", "nieea");
        driver.findElement(By.id("count")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//div[input[@id='firstInput']]")).getAttribute("class").contains("has-error"));
        Assert.assertTrue(driver.findElement(By.xpath("//div[input[@id='secondInput']]")).getAttribute("class").contains("has-error"));
    }

    private void checkSum(String s, String s2, String count, String s3) {
        driver.findElement(By.id("firstInput")).clear();
        driver.findElement(By.id("firstInput")).sendKeys(s);
        driver.findElement(By.id("secondInput")).clear();
        driver.findElement(By.id("secondInput")).sendKeys(s2);
        driver.findElement(By.id(count)).click();
        Assert.assertEquals(s3, driver.findElement(By.id("result")).getText());
    }

    private void check(String s, String s2, String deduct, String s3) {
        driver.findElement(By.id("firstInput")).clear();
        driver.findElement(By.id("firstInput")).sendKeys(s);
        driver.findElement(By.id("secondInput")).clear();
        driver.findElement(By.id("secondInput")).sendKeys(s2);
        driver.findElement(By.id(deduct)).click();
        Assert.assertEquals(s3, driver.findElement(By.id("result")).getText());
    }

    private void enterInputs(String first, String second) {
        driver.findElement(By.id("firstInput")).clear();
        driver.findElement(By.id("firstInput")).sendKeys(first);
        driver.findElement(By.id("secondInput")).clear();
        driver.findElement(By.id("secondInput")).sendKeys(second);
    }

    @Test
    public void baseKalkulacka() {
        driver.findElement(By.id("firstInput")).click();
        driver.findElement(By.id("firstInput")).sendKeys("3");
        driver.findElement(By.id("secondInput")).click();
        driver.findElement(By.id("secondInput")).sendKeys("4");
        driver.findElement(By.id("count")).click();
        driver.findElement(By.id("reset")).click();
        driver.findElement(By.id("firstInput")).click();
        driver.findElement(By.id("firstInput")).sendKeys("4");
        driver.findElement(By.id("secondInput")).click();
        driver.findElement(By.id("secondInput")).sendKeys("6");
        driver.findElement(By.id("deduct")).click();
        driver.findElement(By.id("reset")).click();
        driver.findElement(By.id("firstInput")).click();
        driver.findElement(By.id("firstInput")).sendKeys("0");
        driver.findElement(By.id("secondInput")).click();
        driver.findElement(By.id("secondInput")).sendKeys("0");
        driver.findElement(By.id("count")).click();
    }

}
