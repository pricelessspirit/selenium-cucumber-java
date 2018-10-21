package util;

import cucumber.runtime.java.guice.ScenarioScoped;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.drivermanager.DriverManagerFactory;
import util.drivermanager.DriverType;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

// Scenario scoped it is used to show Guice what will be the shared classes/variables and instantiate them only in here
@ScenarioScoped
public class TestContext {

    public WebDriver driver;// = DriverManagerFactory.getManager(DriverType.CHROME).getDriver();
    public WebDriverWait wdWait;// = new WebDriverWait(driver, 10);

    private ThreadLocal<Map<String, Object>> context = ThreadLocal.withInitial(() -> new HashMap());

    public void put(String key, Object value) {
        context.get().put(key, value);
    }

    public Optional<Object> get(String key) {
        Map map = context.get();
        return map.containsKey(key) ? Optional.of(map.get(key)) : Optional.empty();
    }

}