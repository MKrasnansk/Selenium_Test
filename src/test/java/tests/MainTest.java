package tests;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MainTest {
    public WebDriver driver;

    public String getBASE_URL() {
        return BASE_URL;
    }

    private final String BASE_URL = "http://localhost/dashboard/Testovanie/playground";


    @Before
    public void setUp() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/test/java/tests/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }

    @After
    public void tearDown() throws InterruptedException {
        driver.close();
        driver.quit();
        //        File screenShot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); //vytvori screen
        //        FileUtils.copyFile(screenShot,  new File("C://SCREEN_TESTS/scren.png")); //ulozi screen
        //        driver.getPageSource(); //+ source code
    }


}
