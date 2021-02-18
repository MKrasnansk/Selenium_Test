package tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class pokemonTest extends MainTest {

    @Before
    public void openBaseUrl() {
        driver.get(getBASE_URL() + "/vybersi.php");
    }


    @Test
    public void pokemonTest() {
        new Select(driver.findElement(By.className("form-control"))).selectByIndex(1);
        new Select(driver.findElement(By.className("form-control"))).selectByValue("01");
        new Select(driver.findElement(By.className("form-control"))).selectByVisibleText("Bulbasaur");
        new Select(driver.findElement(By.className("form-control"))).selectByVisibleText("Pikachu");
        System.out.println(driver.findElement(By.xpath("//div/h3")).getText());
        Assert.assertTrue(driver.findElement(By.xpath("//div/h3")).getText().contains("Pikachu"));

    }
    @Test
    public void test2() {
        List<WebElement> pages = driver.findElements(By.xpath("//nav//ul/li/a"));
        List<String> pageUrls = new ArrayList<>();
        for (WebElement page : pages) {
            pageUrls.add(page.getAttribute("href"));
        }
        for (String pageUrl : pageUrls) {
            driver.get(pageUrl);
            String expectedTitle = pageUrl.substring(pageUrl.lastIndexOf("/") + 1, pageUrl.indexOf(".php"));//
            expectedTitle = expectedTitle.substring(0, 1).toUpperCase() + expectedTitle.substring(1);//
            Assert.assertTrue(driver.getTitle().contains(expectedTitle));
            System.out.println(expectedTitle);
        }

    }
    @Test
    public void test3() {
        new Select(driver.findElement(By.className("form-control"))).selectByVisibleText("Charmander");
        String actualTitle = driver.findElement(By.xpath("//div[contains(@class, 'pokemon')]/h3")).getText();
        Assert.assertTrue(actualTitle.contains("Charmander"));
    }

}
