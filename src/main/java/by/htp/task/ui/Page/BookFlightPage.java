package by.htp.task.ui.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 20.08.17.
 */
public class BookFlightPage extends Page{

    {logger("Book Flight Page");}

    private static final By flightElement = By.xpath(".//button[@class='flight-result-button']");
    @FindBy(how= How.XPATH, xpath=".//*[@class='button button-primary' and @name='next_button']")
    WebElement nextButton;

    public WebDriver flightSelect (WebDriver driver) throws InterruptedException {
        logger("select flights");
        init(driver);
        Thread.sleep(5000);
        scrollPage(driver);

        List <WebElement> list = driver.findElements(flightElement);
        list.get(0).click();
        Thread.sleep(5000);
        List <WebElement> list2 = driver.findElements(flightElement);
        list2.get(list2.size()-1).submit();

        return driver;
    }

    public List<Double> ticketsPrices (WebDriver driver){
        init(driver);
        logger("ticketsPrices");

        List <WebElement> list = driver.findElements(flightElement);
        List <String> strings= new ArrayList<String>();
        List <Double> prices = new ArrayList<Double>();

        for (WebElement element : list) {
            strings.add(element.getText());
        }

        int startIndex;
        int i = 8;
        double price;
        for (String s : strings) {
            startIndex = s.indexOf("€");
            price = Double.parseDouble(s.substring(startIndex+2, s.length()-i).trim());
            prices.add(price);
            i = i-2;
        }

        logger(prices);

        return prices;
    }

    public void nextButton () throws InterruptedException {
        Thread.sleep(5000);
        logger("next button =>");
        nextButton.click();
    }

    @FindBy(how= How.XPATH, xpath=".//*[@class='notification-message notification-inline notification-error']/p")
    WebElement notification;
    public boolean verifyNotification (WebDriver driver, String message) throws InterruptedException {
        logger("verify Notification");
        logger("expected notification: "  + message);
        PageFactory.initElements(driver, this);

        Thread.sleep(_SLEEP);
        String alert = notification.getText();
        logger("result: " + alert);

        if (message.equals(alert))
            return true;
        return false;
    }


}
