package by.htp.task.ui.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 21.08.17.
 */
public class MultiplePage extends Page{

    {logger("Multiple destination Page");}

    @FindBy(how= How.ID, id="openJawRouteSelection_DepartureStationOutbound-input")
    WebElement outFromElement;
    @FindBy(how= How.ID, id="openJawRouteSelection_ArrivalStationOutbound-input")
    WebElement outToElement;
    @FindBy(how= How.ID, id="dateSelection_OutboundDate-datepicker")
    WebElement outDateElement;
    @FindBy(how= How.ID, id="openJawRouteSelection_DepartureStationInbound-input")
    WebElement inFromElement;
    @FindBy(how= How.ID, id="openJawRouteSelection_ArrivalStationInbound-input")
    WebElement inToElement;
    @FindBy(how= How.ID, id="dateSelection_InboundDate-datepicker")
    WebElement inDateElement;
    public void putData(WebDriver driver, String outFrom, String outTo,
                        String outDate, String inFrom, String inTo, String inDate) {
        logger("multiplePage: putData");
        init(driver);

        outFromElement.sendKeys(outFrom);
        outToElement.sendKeys(outTo);
        outDateElement.clear();
        outDateElement.sendKeys(outDate);

        inFromElement.sendKeys(inFrom);
        inToElement.sendKeys(inTo);
        inDateElement.clear();
        inDateElement.sendKeys(inDate);
        inDateElement.sendKeys(Keys.ENTER);

    }

    @FindBy(how= How.XPATH, xpath=".//button[@class='button button-primary'][2]")
    WebElement searchButtonElement;
    public void searchButton () throws InterruptedException {
        Thread.sleep(1000);
        logger("searchButton");
        searchButtonElement.click();

    }

    private static final By dateElement = By.xpath(".//*[@class='price-prefix']");
    public void dateSelect (WebDriver driver) throws InterruptedException {
        logger("select date");
        init(driver);
        Thread.sleep(5000);
        //scrollPage(driver);

        List <WebElement> list = driver.findElements(dateElement);
        list.get(0).click();


    }

    private static final By flightElement = By.xpath(".//button[@class='flight-result-button']");
    public WebDriver flightSelect (WebDriver driver) throws InterruptedException {
        logger("select flights");
        //init(driver);
        Thread.sleep(5000);
        scrollPage(driver);
        System.out.println();

        List <WebElement> list = driver.findElements(flightElement);
        list.get(0).click();
        Thread.sleep(5000);
        List <WebElement> list2 = driver.findElements(flightElement);
        list2.get(list2.size()-1).submit();

        return driver;
    }

    public List<Double> ticketsPrices (WebDriver driver){
        logger("ticketsPrices");
        init(driver);

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
            //System.out.println(s);
            startIndex = s.indexOf("€");
            price = Double.parseDouble(s.substring(startIndex+2, s.length()-i).trim());
            prices.add(price);
            i = i -2;
        }

        logger(prices);

        return prices;
    }

    @FindBy(how= How.XPATH, xpath=".//*[@class='back']")
    WebElement totalPriceDollar;
    public Double getTotalPrice (WebDriver driver) throws InterruptedException {
        logger("getTotalPrice");
        init(driver);
        Thread.sleep(2000);

        String priceString = totalPriceDollar.getText().substring(2).toString();
        double price = Double.parseDouble(priceString);

        logger(price);
        return price;
    }

    @FindBy(how= How.XPATH, xpath=".//*[@class='button button-primary']")
    WebElement nextButtonElement;
    public boolean verifyNextButton () {
        boolean result = nextButtonElement.isEnabled();
        logger("to booking: " + result);

        return result;
    }

}
