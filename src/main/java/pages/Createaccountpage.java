package pages;

import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Createaccountpage extends BaseTest {

    public Createaccountpage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//android.widget.TextView[@text='Egypt']")
    WebElement Country;

    @FindBy(xpath = "//android.widget.TextView[@text='English']")
    WebElement language;

    @FindBy(id = "com.jumia.android:id/navigation_account")
    WebElement Account;

    @FindBy(id = "com.jumia.android:id/button_bottom_login_logout")
    WebElement login;

    @FindBy(id = "com.jumia.android:id/login_email_create_account")
    WebElement createaccount;

    @FindBy(xpath = "//android.widget.EditText[@content-desc=\"first_name\"]")
    WebElement firstname;

    @FindBy(xpath = "//android.widget.EditText[@content-desc=\"last_name\"]")
    WebElement lastname;

    @FindBy(xpath = "//android.widget.EditText[@content-desc=\"email\"]")
    WebElement email;

    @FindBy(xpath = "//android.widget.EditText[@content-desc=\"password\"]")
    WebElement password;

    @FindBy(xpath = "//android.widget.EditText[@content-desc=\"phone\"]")
    WebElement mobile;

    @FindBy(id = "com.jumia.android:id/checkbox_terms")
    WebElement checkbox;

    @FindBy(id = "com.jumia.android:id/login_button_continue")
    WebElement create_btn;

    public void selectcountry() {
        wait.until(ExpectedConditions.elementToBeClickable(Country)).click();
    }

    public void selectlanguage() {
        wait.until(ExpectedConditions.elementToBeClickable(language)).click();
        //    language.click();
    }

    public void clickonaccount() {
        wait.until(ExpectedConditions.elementToBeClickable(Account)).click();
        //   Account.click;
    }

    public void clickonlogin() {
        BaseTest.Scroll();
//        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", login);
        wait.until(ExpectedConditions.elementToBeClickable(login)).click();
    }

    public void createaccount(String FirstName, String LastName, String Email, String pass, String phone) {
        wait.until(ExpectedConditions.elementToBeClickable(createaccount)).click();
//        createaccount.click();
        firstname.click();
        firstname.clear();
        firstname.sendKeys(FirstName);
        lastname.click();
        lastname.clear();
        lastname.sendKeys(LastName);
        email.click();
        email.clear();
        email.sendKeys(Email);
        password.click();
        password.clear();
        password.sendKeys(pass);
        mobile.click();
        mobile.clear();
        mobile.sendKeys(phone);
        checkbox.click();
        BaseTest.Scroll();
//        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", create_btn);
        create_btn.click();
    }
}