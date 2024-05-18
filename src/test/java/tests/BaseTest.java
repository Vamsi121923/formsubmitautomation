package tests;

import Utils.CommonUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseTest {
    public static WebDriver driver = null;

    /*
    Start chromedriver using Webdriver Manager
     */
    public void startWebDriver(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        //options.addArguments("--headless");
        driver = new ChromeDriver(options);
        driver.get(CommonUtils.getValueFromProperties("FORM_URL"));
        driver.manage().window().maximize();
    }
}
