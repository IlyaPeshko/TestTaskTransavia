package by.htp.task.ui.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

/**
 * Created by user on 21.08.17.
 */
public class FarePage extends Page {

    {logger("Fare Page");}

    private static final By luggageElement = By.xpath(".//*[@class='button button--selection' and @value='B']");

    public void selectFare (WebDriver driver, int option) throws InterruptedException {
        logger("selectFare: " + option);
        Thread.sleep(5000);
        scrollPage(driver);

        List<WebElement> luggageList = driver.findElements(luggageElement);

        luggageList.get(option-1).click();
    }

    @FindBy(how= How.XPATH, xpath=".//*[@class='price is-flipped']/div/div[2]")
    WebElement totalPriceDollar;

    public Double getTotalPrice (WebDriver driver){
        logger("getTotalPrice");
        init(driver);

        String priceString = totalPriceDollar.getText().substring(2).toString();
        double price = Double.parseDouble(priceString);

        logger(price);
        return price;
    }

}
