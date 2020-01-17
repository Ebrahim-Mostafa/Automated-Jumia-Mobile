package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Searchforitempage extends BaseTest {
    public Searchforitempage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "com.jumia.android:id/search_input_text")
    WebElement search_txt;

    @FindBy(id = "com.jumia.android:id/add_to_cart_button")
    WebElement add_to_cart_btn;

    @FindBy(xpath = "//android.widget.TextView[@text='Samsung Galaxy A70 - 6.7-inch 128GB/6GB Dual SIM 4G Mobile Phone - White']")
    WebElement product;

    public void searchitem(String item) {
        wait.until(ExpectedConditions.elementToBeClickable(search_txt));
        search_txt.click();
        search_txt.clear();
        search_txt.sendKeys(item);
        wait.until(ExpectedConditions.elementToBeClickable(product)).click();
    }

    public void addtocart() {
        wait.until(ExpectedConditions.elementToBeClickable(add_to_cart_btn)).click();
    }
}
