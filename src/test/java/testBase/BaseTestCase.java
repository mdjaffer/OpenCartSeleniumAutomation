package testBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.ResourceBundle;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseTestCase {
    
    public static WebDriver webDriver;
    public static Logger logger;
    public ResourceBundle rb;

    @BeforeClass
    @Parameters("browser")
    public void setup(String br) {

        logger = LoggerFactory.getLogger(this.getClass());

        rb = ResourceBundle.getBundle("ConfigData"); // Load ConfigData.properties file
        
        if(br.equals("chrome"))
		{
		    webDriver=new ChromeDriver();
		}
		else if(br.equals("edge"))
		{
			webDriver=new EdgeDriver();
		}
		else
		{
			webDriver=new FirefoxDriver();
		}
        /* Webdriver setup */
        //WebDriverManager.chromedriver().setup();
        //webDriver = new ChromeDriver();
        webDriver.get(rb.getString("appURL"));
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        webDriver.manage().window().maximize();
        webDriver.manage().deleteAllCookies();

        logger.debug("debugging.....");

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

	public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
				
		TakesScreenshot takesScreenshot = (TakesScreenshot) webDriver;
		File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timeStamp + ".png";

		try {
			FileUtils.copyFile(source, new File(destination));
		} catch (Exception e) {
			e.getMessage();
		}
		return destination;

	}
        
    @AfterClass
    public void tearDown(){
        webDriver.quit();
    }
}
