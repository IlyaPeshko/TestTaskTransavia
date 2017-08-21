package by.htp.task.ui.Page;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by user on 21.08.17.
 */
public class UtilityIlmpl implements Utility{
    private static JavascriptExecutor jse;
    private static final Logger log = Logger.getLogger(Utility.class);

    public WebDriver scrollPage (WebDriver driver) {
        jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        return driver;
    }
    public void logger (Object message){
        log.info(message);
    }

    public WebDriver init(WebDriver driver) {
        PageFactory.initElements(driver, this);
        return driver;
    }


}
