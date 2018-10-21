package info.seleniumcucumber.methods;

import env.DriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SelectElementByType {
    private WebDriver driver;
    private WebDriverWait wait;

    public SelectElementByType() {
        driver = DriverUtil.getDefaultDriver();
        wait = DriverUtil.getWait();
    }

    /**
     * Method to select element 'by' type
     *
     * @param type        : String : 'By' type
     * @param access_name : String : Locator value
     * @return By
     */
    public By getelementbytype(String type, String access_name) {
        switch (type) {
            case "id":
                return By.id(access_name);
            case "name":
                return By.name(access_name);
            case "class":
                return By.className(access_name);
            case "xpath":
                return By.xpath(access_name);
            case "css":
                return By.cssSelector(access_name);
            case "linkText":
                return By.linkText(access_name);
            case "partialLinkText":
                return By.partialLinkText(access_name);
            case "tagName":
                return By.tagName(access_name);
            default:
                return null;

        }

    }

    public WebDriver getDriver() {
        return DriverUtil.getDefaultDriver();
    }

    public WebDriverWait getWait() {
        return DriverUtil.getWait();
    }
}
