package testCases;



import org.testng.Assert;
import org.testng.annotations.*;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;
 

public class TC_001_AccountRegistrationTest extends BaseClass {
 
@Test(groups={"regression","master"})
public void verify_account_registration () 
{   
	
	
   logger.info("****starting TC_001_AccountRegistrationTest  *****");
   logger.debug("application logs");
	try
    {
	HomePage hp=new HomePage(driver);
    hp.clickMyAccount();
    logger.info("clicked MyAccount");
    hp.clickRegister();
    logger.info("clicked Registration");
   AccountRegistrationPage regpage=new  AccountRegistrationPage(driver); 
   logger.info("enter customer details");
   regpage.setFirstName(randomString().toUpperCase());
   regpage.setLastName(randomString().toUpperCase());
   regpage.setEmail(randomString()+"@gmail.com");// randomly generated the email
   regpage.setTelephone(randomNumber());
   String password=randomAlphaNumeric();
   regpage.setPassword(password);
   regpage.setConfirmPassword(password);
   regpage.setPrivacyPolicy();
   logger.info("click continue");
   regpage.clickContinue();
   String confmsg=regpage.getConfirmationMsg();
   if(confmsg.equals("Your Account Has Been Created!"))
   {
	   logger.info("test passed...");
		Assert.assertTrue(true);
   }
   else
   {
	   logger.error("test failed");
	   Assert.fail();
   }
 
    }
	catch(Exception e)
	{
		logger.error("test failed..");
		logger.debug("debug logs....");
		Assert.fail();
	}
	
	logger.debug("application logs end.......");
	logger.info("**** finished TC_001_AccountRegistrationTest  *****");

  }


}












