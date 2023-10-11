package testCases;

import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountLoginPage;
import pageObjects.HomePage;
import pageObjects.RegisterAccountPage;
import testBase.BaseTestCase;

public class TC_001_AccountRegistrationTest extends BaseTestCase{
    
    @Test
    public void test_Account_Regidtration(){

        String email = randomEmails();
        String passwd = "P@55w0rd";

        try{
            HomePage homePage = new HomePage(webDriver);
            homePage.clickMyAccount();
            homePage.clickRegister();

            RegisterAccountPage registerAccountPage = new RegisterAccountPage(webDriver);
            registerAccountPage.setFirstName(randomString());
            registerAccountPage.setLastName(randomString());
            registerAccountPage.setEmail(email);
            //registerAccountPage.setTelephone(randomNumber());
            registerAccountPage.setPassword(passwd);
            registerAccountPage.setPrivacyPolicy();
            registerAccountPage.clickContinue();

            registerAccountPage.clickLoginPageLink();

            AccountLoginPage accountLoginPage = new AccountLoginPage(webDriver);
            accountLoginPage.setLoginEmail(email);            
            accountLoginPage.setLoginPassword(passwd);
            accountLoginPage.clickLoginBtn();

            String confirmMessage = accountLoginPage.getMessageConfirmation();

            Assert.assertEquals(confirmMessage, "I am a returning customer");


        } catch (Exception excep) {

            Assert.fail(excep.getMessage());

            System.out.println("Exception Occured : " + excep.toString());
        } 
    }
}
