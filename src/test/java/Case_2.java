import by.htp.task.ui.Page.BookFlightPage;
import by.htp.task.ui.Page.FarePage;
import by.htp.task.ui.Page.HomePage;
import org.junit.Assert;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Created by user on 21.08.17.
 */
public class Case_2 extends BaseTest {

    @Test
    public void test () throws InterruptedException {
        logger("CASE 2 ____________________________");
        HomePage page = new HomePage();
        BookFlightPage bookFlight = new BookFlightPage();
        FarePage farePage = new FarePage();

        driver.get(INDEX_PAGE);
        page.fromTo(driver, "Munich", "Dublin");
        page.addPassenger(driver);
        page.clickSearch();

        bookFlight.flightSelect(driver);

        List <Double> listPrice = bookFlight.ticketsPrices(driver);
        double prePrice = listPrice.get(0)+listPrice.get(1);
        prePrice = (prePrice +36)*3; //
        System.out.println("prePrice: " + prePrice);
        bookFlight.nextButton();

        farePage.selectFare(driver,2);

        double totalPrice = farePage.getTotalPrice(driver);
        System.out.println("totalPrice: " + totalPrice);
        Assert.assertTrue(prePrice == totalPrice);
    }
}
