import by.htp.task.ui.Page.HomePage;
import by.htp.task.ui.Page.MultiplePage;
import org.junit.Assert;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Created by user on 21.08.17.
 */
public class Case_9 extends BaseTest{

    @Test
    public void test () throws InterruptedException {
        logger("CASE 9 ____________________________");
        HomePage page = new HomePage();
        MultiplePage multiplePage = new MultiplePage();
        driver.get(INDEX_PAGE);

        page.clickMultiple(driver);
        multiplePage.putData(driver, "Bologna, Italy", "Eindhoven, Netherlands", "23 Aug 2017",
                "Amsterdam (Schiphol), Netherlands", "Casablanca, Morocco", "23 Aug 2017");
        multiplePage.searchButton();
        multiplePage.dateSelect(driver);
        multiplePage.flightSelect(driver);

        List<Double> listPrice = multiplePage.ticketsPrices(driver);
        double prePrice = listPrice.get(0)+listPrice.get(1);
        double totalPrice = multiplePage.getTotalPrice(driver);
        System.out.println("totalPrice: " + totalPrice);

        Assert.assertTrue(prePrice == totalPrice);
        Assert.assertTrue(multiplePage.verifyNextButton());
    }
}
