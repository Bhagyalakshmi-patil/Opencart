package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//input[@placeholder='E-Mail Address']")
    WebElement txtEmail;
    @FindBy(xpath = "//input[@placeholder='Password']")
    WebElement txtPassword;
    @FindBy(xpath = "//input[@value='Login']")
    WebElement submitbtn;

    public void setEmail(String e){
        txtEmail.sendKeys(e);
    }
    public void setPassword(String p){
        txtPassword.sendKeys(p);
    }
    public void clickLogin(){
        submitbtn.click();
    }
}
