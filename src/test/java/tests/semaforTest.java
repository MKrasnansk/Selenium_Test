package tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class semaforTest extends MainTest {

    @Before
    public void openBaseUrl() {
        driver.get(getBASE_URL() + "/semafor.php");
    }


    @Test
    public void test() {
        String expectRed = "rgba(205, 58, 63, 1)";
        String expectGreen = "rgba(10, 129, 0, 1)";
        String expectOrange = "rgba(191, 111, 7, 1)";

        WebElement traficlight = driver.findElement(By.className("light"));

        String red = traficlight.getCssValue("background-color");
        Assert.assertEquals(expectRed, red);

        Actions actions = new Actions(driver);
        actions.moveToElement(traficlight).build().perform();

        String green = traficlight.getCssValue("background-color");
        Assert.assertEquals(expectGreen, green);

        actions.clickAndHold(traficlight).build().perform();
        String orange = traficlight.getCssValue("background-color");
        Assert.assertEquals(expectOrange, orange);
    }
}
