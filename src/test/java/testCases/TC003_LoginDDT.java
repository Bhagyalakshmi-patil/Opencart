package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

/* Data is valid - login success - test pass - logout
Data is valid - login failed - test fail

Data is invalid - login success - test fail - loout
Data is invalid - login failed - test pass
 */

public class TC003_LoginDDT  extends BaseClass {


    @Test(dataProvider = "LoginData" , dataProviderClass = DataProviders.class,groups = "Datadriven")
    public void verify_loginDDT(String email, String pwd, String exp){
        logger.info("*****starting TC003_LoginDDT ******* ");
        try {
            //Home Page
            HomePage hompage = new HomePage(driver);
            hompage.clickMyaccount();
            hompage.clickLogin();

            //Login Page
            LoginPage loginPage = new LoginPage(driver);
            loginPage.setEmail(email);
            loginPage.setPassword(pwd);
            loginPage.clickLogin();

            //My account page
            MyAccountPage myAccountPage = new MyAccountPage(driver);
            boolean targetPage = myAccountPage.isMyAccountExists();

            if (exp.equalsIgnoreCase("Valid")) {
                if (targetPage == true) {
                    myAccountPage.clickLogout();
                    Assert.assertTrue(true);
                } else {
                    Assert.assertTrue(false);
                }
            }
            if (exp.equalsIgnoreCase("Invalid")) {
                if (targetPage == true) {
                    myAccountPage.clickLogout();
                    Assert.assertTrue(false);
                } else {
                    Assert.assertTrue(true);
                }
            }
        }catch (Exception e){
            Assert.fail();
        }
        logger.info("*****Finished TC003_LoginDDT ******* ");

    }

}
