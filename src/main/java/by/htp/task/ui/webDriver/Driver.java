package by.htp.task.ui.webDriver;

import by.htp.task.utility.Permanent;
import by.htp.task.utility.exception.UnknownDriverTypeExeption;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class Driver {

    private static final String drFF = "webdriver.gecko.driver";
    private static final String pFF = Permanent.FIREFOX_DRIVER_PATH;
    private static final String drGC = "webdriver.chrome.driver";
    private static final String pGC = Permanent.CHROME_DRIVER_PATH;

    private static final String DEFAULT_WEB_DRIVER = "DEFAULT_WEB_DRIVER";
    private static DriverTypes defaultDriverTypes = DriverTypes.FIREFOX;

    private static HashMap<String, WebDriver> instances;
    static {
        instances = new HashMap<String, WebDriver>();
    }

    public static WebDriver getWebDriverInstance(String name, DriverTypes driverTypes) {
        WebDriver driver;

        if (!instances.containsKey(name)) {
            switch (driverTypes) {
                case FIREFOX:
                    System.setProperty(drFF,pFF);
                    driver = new FirefoxDriver();
                    break;
                case GC:
                    System.setProperty(drGC, pGC);
                    driver = new ChromeDriver();
                    break;
                case IE:
                    //System.setProperty()  //дописать SetProperty
                    driver = new InternetExplorerDriver();
                default:
                    throw new UnknownDriverTypeExeption("Unknown by.htp.task.utility.exception.UnknownDriverTypeExeption" + driverTypes.getDriverName());
            }

            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            instances.put(name, driver);

        }else {
            driver = instances.get(name);
        }
        return driver;
    }

    public static WebDriver getWebDriverInstance() {
        return getWebDriverInstance(DEFAULT_WEB_DRIVER, defaultDriverTypes);
    }

}
