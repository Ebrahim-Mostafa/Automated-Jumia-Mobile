package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Createaccountpage extends BaseTest {

    public Createaccountpage(AppiumDriver<?> driver) {
        this.driver=driver;
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

    @FindBy(xpath = "//android.widget.RadioButton[@text='Male']")
    WebElement radio_btn;

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

    @FindBy(id = "com.jumia.android:id/navigation_home")
    WebElement home_btn;


    public void selectcountry() {
        wait.until(ExpectedConditions.elementToBeClickable(Country)).click();
        //  Country.click();
    }

    public void selectlanguage() {
        wait.until(ExpectedConditions.elementToBeClickable(language)).click();
        //    language.click();
    }

    public void clickonaccount() {
        wait.until(ExpectedConditions.elementToBeClickable(Account)).click();
        BaseTest.Scroll();
    }

    public void clickonlogin() { wait.until(ExpectedConditions.elementToBeClickable(login)).click(); }

    public void createaccount(String FirstName, String LastName, String Email, String pass, String phone) {
        wait.until(ExpectedConditions.elementToBeClickable(createaccount)).click();
        firstname.click();
        firstname.clear();
        firstname.sendKeys(FirstName);
        lastname.click();
        lastname.clear();
        lastname.sendKeys(LastName);
        radio_btn.click();
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
        create_btn.click();
        wait.until(ExpectedConditions.elementToBeClickable(home_btn)).click();

    }
}
