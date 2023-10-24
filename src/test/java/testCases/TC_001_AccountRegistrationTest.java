package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountLoginPage;
import pageObjects.HomePage;
import pageObjects.RegisterAccountPage;
import testBase.BaseTestCase;

public class TC_001_AccountRegistrationTest extends BaseTestCase {
    
    @Test
    public void test_Account_Regidtration() throws InterruptedException {

        String email = rb.getString("email"); //randomEmails();
        String passwd = rb.getString("password"); //P@55w0rd";

        logger.debug("application logs......");
		logger.info("***  Starting TC_001_AccountRegistrationTest ***");
        
        try{
            HomePage homePage = new HomePage(webDriver);
            homePage.clickMyAccount();
            homePage.clickRegister();

            RegisterAccountPage registerAccountPage = new RegisterAccountPage(webDriver);
            registerAccountPage.setFirstName(randomString());
            registerAccountPage.setLastName(randomString());
            registerAccountPage.setEmail(email);
            logger.info("___________Email Set_______________");
            registerAccountPage.setTelephone(randomNumber());
            registerAccountPage.setPassword(passwd);
            registerAccountPage.setConfirmPassword(passwd);
            registerAccountPage.setPrivacyPolicy();
            logger.info("___________click Continue_______________");
            registerAccountPage.clickContinue();
            Thread.sleep(5000);
            registerAccountPage.clickLoginPageLink();
            logger.info("___________click LoginPage_______________");
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
