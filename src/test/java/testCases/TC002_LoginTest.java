package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass {

    @Test(groups = {"Sanity","Master"})
    public void verify_login(){
        logger.info("**** starting TC002_LoginTest ****** ");
        try {
            //Home Page
            HomePage hompage = new HomePage(driver);
            hompage.clickMyaccount();
            hompage.clickLogin();

            //Login Page
            LoginPage loginPage = new LoginPage(driver);
            loginPage.setEmail(p.getProperty("email"));
            loginPage.setPassword(p.getProperty("password"));
            loginPage.clickLogin();

            //My account page
            MyAccountPage myAccountPage = new MyAccountPage(driver);
            boolean targetPage = myAccountPage.isMyAccountExists();
            // Assert.assertEquals(targetPage,true,"Login Failed");
            Assert.assertTrue(targetPage);
        }catch (Exception e){
            Assert.fail();
        }
        logger.info("****Finished TC002_LoginTest *******");
    }
}
