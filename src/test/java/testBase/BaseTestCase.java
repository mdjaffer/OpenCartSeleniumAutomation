package testBase;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTestCase {
    
    public static WebDriver webDriver;
    
    @BeforeClass
    public void setup() {
        /* Webdriver setup */
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.get("https://demo.opencart.com/index.php");
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        webDriver.manage().window().maximize();
    }

    
    /* Generating random string */
    public String randomString(){
        String randomFiveCharString = RandomStringUtils.randomAlphabetic(5);
        return randomFiveCharString;
    }

    /* Generating random number */
    public String randomNumber(){
        String randomFiveDigitNumber = RandomStringUtils.randomNumeric(5);
        return randomFiveDigitNumber;
    }    

    /* Generate random e-mails */
    public String randomEmails(){
        String randomEmails = randomString() + "@" + "gmail.com";
        return randomEmails;
    }   

    @AfterClass
    public void tearDown(){
        webDriver.quit();
    }
}
