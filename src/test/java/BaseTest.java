import by.htp.task.ui.webDriver.Driver;
import by.htp.task.ui.webDriver.DriverTypes;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

abstract class BaseTest {
    protected static WebDriver driver;
    private static final Logger log = Logger.getLogger(BaseTest.class);
    protected static final String INDEX_PAGE = "https://www.transavia.com/en-EU/home/";

    @BeforeClass
    public void init (){
        PageFactory.initElements(driver, this);
        driver = Driver.getWebDriverInstance("chrome", DriverTypes.GC);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Before
    public void start () {
        driver.manage().window().fullscreen();
    }


    @AfterClass
    public void cleanUp () {

    }

    public static void logger (Object message){
        log.info(message);
    }
}
