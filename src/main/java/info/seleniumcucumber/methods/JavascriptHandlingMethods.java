package info.seleniumcucumber.methods;

import env.DriverUtil;

public class JavascriptHandlingMethods implements BaseTest {
    //protected WebDriver driver = DriverUtil.getDefaultDriver();

    /**
     * Method to handle alert
     *
     * @param decision : String : Accept or dismiss alert
     */
    public void handleAlert(String decision) {
        if (decision.equals("accept"))
            DriverUtil.getDefaultDriver().switchTo().alert().accept();
        else
            DriverUtil.getDefaultDriver().switchTo().alert().dismiss();
    }
}
