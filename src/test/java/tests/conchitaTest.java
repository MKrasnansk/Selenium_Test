package tests;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class conchitaTest extends MainTest {

    @Before
    public void openBaseUrl() {
        driver.get(getBASE_URL() + "/zenaalebomuz.php");
    }


    @Test
    public void test() {
        driver.findElement(By.xpath("//input[@value='wurst']")).click();
        System.out.println(driver.findElement(By.xpath("//h1[@class='description text-center']")).getText());

        System.out.println(driver.findElement(By.xpath("//input[@value='wurst']")).isSelected());
        System.out.println(driver.findElement(By.xpath("//input[@value='conchita']")).isSelected());

    }
}