package tests;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;

import java.util.List;

public class ColorsTest extends MainTest {

    @Before
    public void openBaseUrl() {
        driver.get(getBASE_URL() + "/stroopeffect.php");
    }

    @Test
    public void colorTest() throws InterruptedException {
        List<WebElement> titles = driver.findElements(By.xpath("//div[contains(@class,'colours')]/h1"));
        for (WebElement title : titles) {
            System.out.println(title.getText());
            System.out.println(title.getCssValue("color"));
            String hexColor = Color.fromString(title.getCssValue("color")).asHex();
            System.out.println(hexColor);
        }
    }
}
