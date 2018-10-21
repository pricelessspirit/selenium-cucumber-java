package info.seleniumcucumber.methods;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;


public class ClickElementsMethods extends SelectElementByType implements BaseTest {
    //SelectElementByType eleType= new SelectElementByType();
    private WebElement element = null;

    /**
     * Method to click on an element
     *
     * @param accessType : String : Locator type (id, name, class, xpath, css)
     * @param accessName : String : Locator value
     */
    public void click(String accessType, String accessName) {
        element = getWait().until(ExpectedConditions.presenceOfElementLocated(getelementbytype(accessType, accessName)));
        element.click();
    }

    /**
     * Method to click on an element with Text
     *
     * @param accessType : String : Locator type (id, name, class, xpath, css)
     * @param accessName : String : Locator value
     */
    public void click_text(String accessType, String accessName, String accessValue) throws TestCaseFailed {
        element = getWait().until(ExpectedConditions.presenceOfElementLocated(getelementbytype(accessType, accessName)));
        List<WebElement> elements = getDriver().findElements(getelementbytype(accessType, accessName));
        WebElement foundElement = elements.stream()
                .filter((element) -> element.isDisplayed())
                .filter((element) -> element.getText().trim().contains(accessValue))
                .findFirst()
                .orElse(null);

        if (foundElement == null)
            throw new TestCaseFailed("Could not find element having " + accessType + "\"" + accessName + "\"" + " and text value as \"" + accessValue + "\"");
        System.out.println("Tex:" + foundElement.getText());
        foundElement.click();
    }

    /**
     * Method to forcefully click on an element
     *
     * @param accessType : String : Locator type (id, name, class, xpath, css)
     * @param accessName : String : Locator value
     */
    public void clickForcefully(String accessType, String accessName) {
        element = getWait().until(ExpectedConditions.presenceOfElementLocated(getelementbytype(accessType, accessName)));
        JavascriptExecutor executor = (JavascriptExecutor) getDriver();
        executor.executeScript("arguments[0].click();", element);
    }

    /**
     * Method to Double click on an element
     *
     * @param accessType : String : Locator type (id, name, class, xpath, css)
     * @param accessName : String : Locator value
     */
    public void doubleClick(String accessType, String accessValue) {
        element = getWait().until(ExpectedConditions.presenceOfElementLocated(getelementbytype(accessType, accessValue)));

        Actions action = new Actions(getDriver());
        action.moveToElement(element).doubleClick().perform();
    }
}