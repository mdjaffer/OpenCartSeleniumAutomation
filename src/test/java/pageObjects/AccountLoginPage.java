package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountLoginPage extends BasePage{

    public AccountLoginPage(WebDriver webDriver) {
        super(webDriver);
    }
    
    @FindBy(xpath = "//input[@id='input-email']")
    WebElement txtLoginEmail;

    @FindBy(xpath = "//input[@id='input-password']")
    WebElement txtLoginPassword;

    @FindBy(xpath = "//button[normalize-space()='Login']")
    WebElement btnLogin;

    @FindBy(xpath = "//strong[normalize-space()='I am a returning customer']")
    WebElement msgConfirmation;

    public void setLoginEmail(String email){
        txtLoginEmail.sendKeys(email);
    }

    public void setLoginPassword(String passwd){
        txtLoginPassword.sendKeys(passwd);
    }

    public void clickLoginBtn(){
        btnLogin.click();
    }

    public String getMessageConfirmation(){
        return msgConfirmation.getText();
    }
}
