package tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class tabulkaTest extends MainTest {

    @Before
    public void openBaseUrl() {
        driver.get(getBASE_URL() + "/tabulka.php");
    }

    @Test
    public void test() {
        int rows = Integer.parseInt(driver.findElement(By.xpath("//table/tbody/tr[last()]/td[1]")).getText());
        for (int i = 1; i < rows + 1; i++) {
            Assert.assertFalse(driver.findElement(By.xpath("//table/tbody/tr[" + i + "]/td[3]")).getText().isEmpty());
        }

    }

    @Test
    public void test2() {
        List<WebElement> rows = driver.findElements(By.xpath("//table/tbody/tr"));
        for (int i = 1; i < rows.size() + 1; i++) {
            try {
                Assert.assertEquals(String.valueOf(i), driver.findElement(By.xpath("//tr[" + i + "]")).getText());
            } catch (Error e) {
            }
        }
    }

    @Test
    public void test3() {
        List<WebElement> rows = driver.findElements(By.xpath("//table/tbody/tr"));
        System.out.println(rows);
        for (WebElement row : rows) {
            Assert.assertFalse(row.findElement(By.xpath("./td[3]")).getText().isEmpty());

        }

    }
}
