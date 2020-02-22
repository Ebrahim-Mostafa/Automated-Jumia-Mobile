package testpages;

import com.ahmed.excelizer.ExcelReader;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.BaseTest;
import pages.Searchforitempage;

public class searchitemtest extends BaseTest {

    @DataProvider(name = "readata")
    public Object[][] userdata() {
        return ExcelReader.loadTestData(System.getProperty("user.dir") +
                "\\Data\\jumia_excel.xlsx", "SearchData");
    }

    @Test(dataProvider = "readata")
    public void usercansearch(String item, String price) {
        Searchforitempage sfip = new Searchforitempage(driver);
        sfip.searchitem(item);
        sfip.addtocart();

    }
}
