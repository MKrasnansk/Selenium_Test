package tests;

import helpers.ExcelReader;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;

public class PrimeTest {
    private static final String TEST_DATA_PATH = "src/test/resources/data.xlsx";
    private static final String SHEET = "prime";
    WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "../chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://localhost/dashboard/Testovanie/playground2-master/playground2-master/primenumber.php");
    }
    @After
    public void tearDown() {
        driver.quit();
    }
    @Test
    public void testPrime() throws IOException {
        WebElement numberInput = driver.findElement(By.xpath("//input[@type='number']"));//vytiahne element
        WebElement button = driver.findElement(By.cssSelector("button.btn"));//vytiahne element
        ExcelReader primeExcelReader = new ExcelReader(TEST_DATA_PATH);
        Sheet sheet = primeExcelReader.getSheetByName(SHEET);
        for (Row cells : sheet){
            if (cells.getRowNum() == 0){
                continue;
            }
            numberInput.clear();
            numberInput.sendKeys(String.valueOf(cells.getCell(0).getNumericCellValue()));
            button.click();
        }
    }
}
