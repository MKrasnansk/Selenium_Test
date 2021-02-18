package tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class zjavTest extends MainTest {

    @Before
    public void openBaseUrl() {
        driver.get(getBASE_URL() + "/zjavenie.php");
    }


    @Test
    public void zjavTest() throws InterruptedException {
        String expectedClass = "active";
        driver.findElement(By.id("showHim")).click();
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions
//                        .visibilityOfElementLocated(By.xpath("//img[@class='brano']"))); //je zobrazeny
                        .presenceOfElementLocated(By.xpath("//img[@class='brano']"))); //je v DOM
        Assert.assertTrue(driver.findElement(By.xpath("//img[@class='brano']")).isDisplayed());

        List<String> pages = new ArrayList<>();
        pages.add("zjavenie.php");
        pages.add("vybersi.php");
        pages.add("tabulka.php");
        for (String page : pages) {
            driver.get(getBASE_URL() + "/" + page);
            Assert.assertTrue(driver.findElement(By.xpath("//li[a/@href='" + page + "']")).getAttribute("class").contains(expectedClass));

        }
    }
}
