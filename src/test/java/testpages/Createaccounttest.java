package testpages;

import com.ahmed.excelizer.ExcelReader;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.BaseTest;
import pages.Createaccountpage;

public class Createaccounttest extends BaseTest {
    public Createaccountpage accpage;

    @DataProvider(name = "datareader")
    public Object[][] userdata() {
        return ExcelReader.loadTestData(System.getProperty("user.dir") +
                "\\Data\\jumia_excel.xlsx", "CreateAccountData");
    }

    @Test(dataProvider = "datareader")
    public void usercancreateaccount(String FirstName, String LastName, String Email, String pass, String phone) {
        accpage = new Createaccountpage();
        accpage.selectcountry();
        accpage.selectlanguage();
        accpage.clickonaccount();
        accpage.clickonlogin();
        accpage.createaccount(FirstName, LastName, Email, pass, phone);
    }

}

