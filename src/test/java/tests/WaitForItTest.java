package tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitForItTest extends MainTest {

    @Before
    public void openBaseUrl() {
        driver.get("http://localhost/dashboard/Testovanie/playground2-master/playground2-master/waitforit.php");
    }

    @Test
    public void checkTitle() {
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//h1")));
        Assert.assertEquals("WAIT FOR IT !", driver.findElement(By.xpath("//h1")).getText());
    }
}
