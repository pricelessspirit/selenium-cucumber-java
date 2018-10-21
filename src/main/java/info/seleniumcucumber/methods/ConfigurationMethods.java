package info.seleniumcucumber.methods;

import env.DriverUtil;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ConfigurationMethods implements BaseTest {
    private WebDriver driver;

    public ConfigurationMethods() {
        driver = DriverUtil.getDefaultDriver();
    }

    /**
     * Method to print desktop configuration
     */
    public void printDesktopConfiguration() {
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss");
        Calendar cal = Calendar.getInstance();

        System.out.println("Following are machine configurations : \n");
        System.out.println("Date (MM/DD/YYYY) and Time (HH:MM:SS) : " + dateFormat.format(cal.getTime()));

        Capabilities cap = (Capabilities) ((RemoteWebDriver) getDriver()).getCapabilities();
        System.out.println("Browser : " + cap.getBrowserName());
        System.out.println("Platform : " + cap.getPlatform());
    }

    public void resetBrowser() {
        getDriver().manage().deleteAllCookies();
    }

    private WebDriver getDriver() {
        return DriverUtil.getDefaultDriver();
    }
}
