package by.htp.task.ui.Page;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

/**
 * Created by user on 20.08.17.
 */
public class HomePage extends Page {

    {logger("Home page");}

    @FindBy(how= How.ID, id="routeSelection_DepartureStation-input")
    WebElement from;
    @FindBy(how= How.ID, id="routeSelection_ArrivalStation-input")
    WebElement to;
    @FindBy(how= How.XPATH, xpath=".//*[@class='results']/li[1]")
    WebElement toResult;
    public void fromTo (WebDriver driver, String fromString, String toString){
        logger("from: " + fromString + "/ to: " + toString);
        init(driver);

        from.sendKeys(fromString);
        to.sendKeys(toString);

        try{
            toResult.click();
        }catch (StaleElementReferenceException e){
            logger("HomePage" + e);
        }
    }

    @FindBy(how= How.XPATH, xpath=".//*[@id='desktop']/section/div[3]/div/button")
    WebElement searchButton;
    public void clickSearch (){
        logger("next =>");
        searchButton.click();

    }

    @FindBy(how= How.ID, id="booking-passengers-input")
    WebElement passengerButtonElement;
    private static final By passengerButton = By.xpath(".//*[@class='button button-secondary increase']");
    public void addPassenger (WebDriver driver){
        //init(driver);
        logger("addPassenger: Двое взрослых и один ребенок");

        passengerButtonElement.click();

        List<WebElement> list = driver.findElements(passengerButton);
        list.get(0).click(); //взрослый
        list.get(1).click(); //ребенок


    }

    @FindBy(how= How.XPATH, xpath=".//*[@class='bulletless']/li[2]")
    WebElement multipleDestinations;
    public void clickMultiple (WebDriver driver) throws InterruptedException {
        logger("clickMultipleDestinations =>");
        init(driver);
        Thread.sleep(5000);
        multipleDestinations.click();

    }

}
