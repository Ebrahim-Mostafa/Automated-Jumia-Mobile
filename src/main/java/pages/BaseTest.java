package pages;


import com.testinium.deviceinformation.DeviceInfo;
import com.testinium.deviceinformation.DeviceInfoImpl;
import com.testinium.deviceinformation.device.DeviceType;
import com.testinium.deviceinformation.exception.DeviceNotFoundException;
import com.testinium.deviceinformation.model.Device;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    //public static AndroidDriver<MobileElement> driver;
    public static AppiumDriver<?> driver;
    public static WebDriverWait wait;
    public static Device device;

    @BeforeTest
    public void Setup() throws IOException, DeviceNotFoundException {
        DeviceInfo deviceInfo = new DeviceInfoImpl(DeviceType.ANDROID);
        device = deviceInfo.getFirstDevice();
        try {
            if (deviceInfo.anyDeviceConnected()) {
                System.out.println("Device Name - " + device.getDeviceProductName());
                System.out.println("Device id   - " + device.getUniqueDeviceID());
                System.out.println("Device Build – " + device.getBuildVersion());
                System.out.println("Device Model Name – " + device.getModelNumber());
                System.out.println("Device Android Version – " + device.getProductVersion());
                System.out.println("Device Serial Number – " + device.getSerialNumber());
                DesiredCapabilities capabilities = new DesiredCapabilities();
//        caps.setCapability("deviceName", "520059bcfe4d5451");
//        caps.setCapability("platformName", "Android");
//        caps.setCapability("platformVersion", "7.0");
//        caps.setCapability("skipUnlock", "true");
//        caps.setCapability("appPackage", "com.jumia.andriod");
//        caps.setCapability("appActivity", "com.mobile.view.SplashScreenActivity");
//        caps.setCapability("session-override","true");
//        try {
                //driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);
//        driver = new AppiumDriver<>(new URL("http://0.0.0.0:4723/wd/hub"), caps);
//        }
//        catch (SessionNotCreatedException e){
//            e.printStackTrace();
//        }
//        capabilities.setCapability("isHeadless", true);
//        capabilities.setCapability("avdArgs", "-no-window");
//        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "37c790e4");
//            capabilities.setCapability(MobileCapabilityType.APPIUM_VERSION, "1.15.1");
//            capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9");
//            capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
//            capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);

                capabilities.setCapability(CapabilityType.PLATFORM_NAME, device.getDeviceProductName());
                capabilities.setCapability("platformName", device.getDeviceProductName());
                capabilities.setCapability(CapabilityType.VERSION, device.getProductVersion());
                capabilities.setCapability("deviceName", device.getModelNumber());
//                capabilities.setCapability("udid", device.getUniqueDeviceID());
//       capabilities.setCapability("udid", udid);
                capabilities.setCapability("appActivity", "com.mobile.view.SplashScreenActivity");
                capabilities.setCapability("appPackage", "com.jumia.android");
//      capabilities.setCapability("bundleId", bundleId);
                capabilities.setCapability(MobileCapabilityType.NO_RESET, false);
                capabilities.setCapability("unicodeKeyboard", true);
                capabilities.setCapability("resetkeyboard", true);
                capabilities.setCapability("newCommandTimeout", 4000);
                capabilities.setCapability("adbExecTimeout", 4000);
                driver = new AppiumDriver<>(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
//        driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);


            }
        } catch (ArrayIndexOutOfBoundsException e) {
            e.getCause();
        }
    }

    public static void Scroll() {
        int pressX = 0;
        int topY = 0;
        int bottomY = 0;
        pressX = BaseTest.driver.manage().window().getSize().width / 2;
        bottomY = BaseTest.driver.manage().window().getSize().height;
        topY = BaseTest.driver.manage().window().getSize().height;
        TouchAction touchAction = new TouchAction(BaseTest.driver);
        touchAction.press(PointOption.point(pressX, bottomY * 4 / 5)).waitAction()
                .moveTo(PointOption.point(pressX, topY * 40 / 100)).release().perform();
    }

 /**   public void AeyeCheck(String Name) throws IOException {
// Aeye.takeAppScreenshot(driver, ObjectRepo.statusbar, actualRepo + Name);

        File fullScreenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        BufferedImage originalImage = ImageIO.read(fullScreenshot);
        ImageIO.write(originalImage, "png", new File(actualRepo + Name));
        System.out.println("Element screenshot was taken successfully: " + actualRepo + Name);

        try {
            boolean compareResult = Aeye.compareImages(actualRepo + Name, expectedRepo + Name, resultRepo + Name);
            reportResult(resultRepo + Name);
            if (!compareResult) {
// Assert.fail("Screenshot Mismatch");
            }
        } catch (javax.imageio.IIOException e) {
            e.printStackTrace();
        }
    }
**/
    @BeforeMethod
    public void projectwaits() {
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 50);
    }

    @AfterTest
    public void teardown() {
//        driver.quit();
        driver.closeApp();
    }
}
