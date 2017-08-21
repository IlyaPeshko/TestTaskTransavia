package by.htp.task.ui.Page;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

/**
 * Created by user on 21.08.17.
 */
public interface Utility {

     WebDriver scrollPage (WebDriver driver);

     void logger (Object message);

     WebDriver init (WebDriver driver);
}
