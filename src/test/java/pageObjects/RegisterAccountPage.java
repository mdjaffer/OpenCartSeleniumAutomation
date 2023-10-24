package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class RegisterAccountPage extends BasePage{

    public RegisterAccountPage(WebDriver webDriver) {
        super(webDriver);
    }
    
    @FindBy(name = "firstname")
	WebElement txtFirstname;

	@FindBy(name = "lastname")
	WebElement txtLasttname;

    @FindBy(name = "email")
	WebElement txtEmail;

    @FindBy(name = "telephone")
	WebElement txtTelephone;

    @FindBy(name = "password")
	WebElement txtPassword;

    @FindBy(name = "confirm")
	WebElement txtConfirmPassword;

    @FindBy(name = "agree")
	WebElement chkdPolicy;

    @FindBy(xpath = "//input[@value='Continue']")
	WebElement btnContinue;

    @FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement msgConfirmation;

    @FindBy(xpath = "//a[normalize-space()='login page']")
    WebElement linkLoginPage;

    public void setFirstName(String fname) {
    	txtFirstname.sendKeys(fname);
    }

	public void setLastName(String lname) {
	    txtLasttname.sendKeys(lname);
    }

	public void setEmail(String email) {
	    txtEmail.sendKeys(email);
	}

	public void setTelephone(String tel) {
    	txtTelephone.sendKeys(tel);
    }

	public void setPassword(String pwd) {
    	txtPassword.sendKeys(pwd);
    }

    public void setConfirmPassword(String pwd) {
	    txtConfirmPassword.sendKeys(pwd);
    }

    public void setPrivacyPolicy() {  
	    chkdPolicy.click();
    }

    public void clickContinue() {
	    //sol1 
	    //btnContinue.click();
			
		//sol2 
		btnContinue.submit();
			
	    //sol3
	    //Actions act = new Actions(webDriver);
	    //act.moveToElement(btnContinue,5 ,5);
        //act.click().perform();
						
	    //sol4
	    //JavascriptExecutor js=(JavascriptExecutor)webDriver;
	    //js.executeScript("arguments[0].click();", btnContinue);
			
	    //Sol 5
	    //btnContinue.sendKeys(Keys.RETURN);
			
	    //Sol6  
	   // WebDriverWait mywait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
	   // mywait.until(ExpectedConditions.elementToBeClickable(btnContinue)).click();
			
	}

    public void clickLoginPageLink(){
        //linkLoginPage.click();
        Actions builder = new Actions(webDriver);
        builder.moveToElement(linkLoginPage).click(linkLoginPage);
        builder.perform();
    }

	public String getConfirmationMsg() {
		try {
			return (msgConfirmation.getText());
		} catch (Exception e) {
			return (e.getMessage());

	    }

	}
}
