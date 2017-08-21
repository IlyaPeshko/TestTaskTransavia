import by.htp.task.ui.Page.BookFlightPage;
import by.htp.task.ui.Page.HomePage;
import org.junit.Assert;
import org.testng.annotations.Test;

/**
 * Created by user on 20.08.17.
 */
public class Case_8 extends BaseTest {

    private static final String notification = "Unfortunately we do not fly from Dubai, United Arab Emirates to Agadir, Morocco. However, we do fly from Dubai, United Arab Emirates to other destinations. Please change your destination and try again.";

    @Test
    public void test () throws InterruptedException {
        logger("CASE 8 ____________________________");
        HomePage page = new HomePage();
        BookFlightPage bookFlight = new BookFlightPage();
        driver.get(INDEX_PAGE);

        page.fromTo(driver, "Dubai", "Agadir");
        page.addPassenger(driver);
        page.clickSearch();


        Assert.assertTrue (bookFlight.verifyNotification(driver, notification));

    }
}
