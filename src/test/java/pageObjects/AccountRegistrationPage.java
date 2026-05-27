package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AccountRegistrationPage extends  BasePage{

    public AccountRegistrationPage(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//input[@id=\"input-firstname\"]")
    WebElement txt_firstName;
    @FindBy(xpath = "//input[@id=\"input-lastname\"]")
    WebElement txt_lastName;
    @FindBy(xpath = "//input[@id=\"input-email\"]")
    WebElement txt_email;
    @FindBy(xpath = "//input[@id=\"input-telephone\"]")
    WebElement txt_telephone;
    @FindBy(xpath = "//input[@id=\"input-password\"]")
    WebElement txt_pwd;
    @FindBy(xpath = "//input[@id=\"input-confirm\"]")
    WebElement txt_confirmPwd;
    @FindBy(xpath = "//input[@name=\"agree\"]")
    WebElement chkdPolicy;
    @FindBy(xpath = "//input[@value=\"Continue\"]")
    WebElement btnContinue;
    @FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
    WebElement msgConfirmation;

    public void setFirstName(String fname){
        txt_firstName.sendKeys(fname);
    }
    public void setlastName(String lname){
        txt_lastName.sendKeys(lname);
    }
    public void setEmail(String email){
        txt_email.sendKeys(email);
    }
    public void setTelephone(String tel){
        txt_telephone.sendKeys(tel);
    }
    public void setPassword(String pwd){
        txt_pwd.sendKeys(pwd);
    }
    public void setConfirmPwd(String conPwd){
        txt_confirmPwd.sendKeys(conPwd);
    }
    public void setPrivacyPolicy(){
        chkdPolicy.click();
    }
    public void clickContinue(){
        //sol1
        btnContinue.click();
//        sol2
//        btnContinue.submit();
//        sol3
//        Actions actions = new Actions(driver);
//        actions.moveToElement(btnContinue).click().perform();
//        sol4
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("arguments[0].click();",btnContinue);
//        sol5
//             btnContinue.sendKeys(Keys.RETURN);
//         sol6
//        WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        mywait.until(ExpectedConditions.elementToBeClickable(btnContinue)).click();
    }

    public String getConfirmationMsg(){
        try {
            return (msgConfirmation.getText());
        }catch (Exception e){
            return (e.getMessage());
        }
    }


}
