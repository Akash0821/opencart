package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_001_AccRegTest extends BaseClass{

	@Test(groups= {"Regression","Master"})
	public void test_acc_reg() {
		
		logger.debug("Application logs...");
		
		logger.info("Starting TC_001_AccRegTest");
		
		try {
		HomePage hp=new HomePage(driver);
		
		hp.clickMyAccount();
		logger.info("Clicked on my account");
		
		hp.clickRegister();
		logger.info("Clicked on register link");
		
		AccountRegistrationPage regPage=new AccountRegistrationPage(driver);
		
		logger.info("Providing customer data");
		
		regPage.setFirstName(randomString().toUpperCase());
			
		regPage.setLastName(randomString().toUpperCase());
		
		regPage.setEmail(randomString()+"@gmail.com"); 
		
		regPage.setPassword(randomAlphaNumeric());
	
		Thread.sleep(3000);
		regPage.setSubscribe();
		Thread.sleep(3000);
		regPage.setPrivacypolicy();
	    Thread.sleep(3000);
		regPage.clickContinue();
		
		logger.info("Cliked on continue");
		
		String confmsg=regPage.getConfirmationMsg();
		
		logger.info("Validating expected message");
		
		Assert.assertEquals(confmsg, "Your Account Has Been Created!","Test Failed");
		
		}
		catch(Exception e) {
            logger.error("Test Failed");
			Assert.fail();
		}
		logger.info("Finished TC_001_AccRegTest");
	}
}
