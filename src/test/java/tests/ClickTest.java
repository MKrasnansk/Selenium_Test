package tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ClickTest extends MainTest {

    @Before
    public void openBaseUrl() {
        driver.get(getBASE_URL() + "/clickmebaby.php");
    }


    @Test
    public void click() {
        System.out.println(driver.findElement(By.id("clicks")).getText());
        Assert.assertEquals("inicialny pocet klikov", "0", driver.findElement(By.id("clicks")).getText());
        Assert.assertEquals("klikov", driver.findElement(By.className("description")).getText());
        for (int i = 1; i < 11; i++) {
            driver.findElement(By.id("clickMe")).click();
            Assert.assertEquals(String.valueOf(i), driver.findElement(By.id("clicks")).getText());
            driver.findElement(By.className("description")).getText();
            if (i == 1) {
                Assert.assertEquals("klik", driver.findElement(By.className("description")).getText());
            }
            if (i >= 2 && i <= 4) {
                Assert.assertEquals("kliky", driver.findElement(By.className("description")).getText());
            }
            if (i >= 5) {
                Assert.assertEquals("klikov", driver.findElement(By.className("description")).getText());
            }
        }

    }

    @Test
    public void secondTest() {
        driver.findElement(By.id("clickMe")).click();
        driver.get(getBASE_URL() + "/registracia.php");
        driver.findElement(By.name("email")).clear();
        driver.findElement(By.name("email")).sendKeys("miso.krasnansky@gmail.com");
        driver.findElement(By.name("name")).clear();
        driver.findElement(By.name("name")).sendKeys("Miso");
        driver.get(getBASE_URL() + "/kalkulacka.php");
        driver.findElement(By.cssSelector("#count")).click();
        driver.findElement(By.id("firstInput")).sendKeys("4");
        driver.findElement(By.id("secondInput")).sendKeys("6");
        driver.findElement(By.cssSelector("#count")).click();
        driver.get(getBASE_URL() + "/registracia.php");
        driver.findElement(By.name("email")).clear();
        driver.findElement(By.name("email")).sendKeys("mkr@mks.sk");
        driver.findElement(By.name("name")).clear();
        driver.findElement(By.name("name")).sendKeys("Michal");
        driver.findElement(By.name("surname")).clear();
        driver.findElement(By.name("surname")).sendKeys("Krasnansky");
        driver.findElement(By.name("password")).sendKeys("0000");
        driver.findElement(By.name("password")).sendKeys("0000");


    }

    @Test
    public void refreshTest() throws InterruptedException {
        for (int i = 1; i < 11; i++) {
            driver.findElement(By.id("clickMe")).click();
            Assert.assertEquals(String.valueOf(i), driver.findElement(By.id("clicks")).getText());
        }
        driver.navigate().refresh();
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By.id("clicks")));
        Assert.assertEquals("0", driver.findElement(By.id("clicks")).getText());

    }

    @Test
    public void sizeTest() {
        driver.manage().window().setSize(new Dimension(300, 2500));
        driver.findElement(By.id("clickMe")).click();
        Assert.assertEquals("1", driver.findElement(By.id("clicks")).getText());
        Assert.assertEquals("klik", driver.findElement(By.className("description")).getText());

    }

    @Test
    public void test2() {
        driver.get(getBASE_URL() + "/moveme.php");
        Assert.assertTrue(driver.findElement(By.xpath("//img[@id='donald']")).isDisplayed());
    }

}