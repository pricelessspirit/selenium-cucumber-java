package util.drivermanager;

public class DriverManagerFactory {

    public static DriverManager getManager(DriverType type) {

        DriverManager driverManager;

        switch (type) {
            case CHROME:
                driverManager = new ChromeDriverManager();
                break;
            case FIREFOX:
                //driverManager = new FirefoxDriverManager();
                driverManager = new ChromeDriverManager();
                break;
            default:
                //driverManager = new SafariDriverManager();
                driverManager = new ChromeDriverManager();
                break;
        }
        return driverManager;

    }
}
