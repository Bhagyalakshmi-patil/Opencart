package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;


public class TC001_AccountRegistrationTest extends BaseClass {


    @Test(groups = {"Regression","Master"})
    public void verify_account_registration() {
        try {
            logger.info("****** TC001_AccountRegistrationTest *******");
            HomePage homePage = new HomePage(driver);
            homePage.clickMyaccount();
            logger.info("Clicked on MyAccount Link");
            homePage.clickRegister();
            logger.info("Clicked on Register Link");

            AccountRegistrationPage regpage = new AccountRegistrationPage(driver);

            logger.info("Providing customer details....");
            regpage.setFirstName(randomestring().toUpperCase());
            regpage.setlastName(randomestring().toUpperCase());
            regpage.setEmail(randomestring() + "@gmail.com");
            regpage.setTelephone(randomNumber());

            String password = randomAlphaNumeric();
            regpage.setPassword(password);
            regpage.setConfirmPwd(password);

            regpage.setPrivacyPolicy();
            regpage.clickContinue();

            logger.info("Validating expected message...");
            String confmsg = regpage.getConfirmationMsg();
            if(confmsg.equals("Your Account Has Been Created!")) {
                Assert.assertTrue(true);
            }else{
                logger.error("Test Failed!!");
                logger.debug("Debug logs");
                Assert.fail();
            }
        }catch (Exception e){
            Assert.fail();
        }
        logger.info("******Finished TC001_AccountRegistrationTest *******");
    }
}
