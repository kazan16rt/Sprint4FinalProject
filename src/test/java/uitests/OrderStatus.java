package uitests;

import org.junit.Test;
import pageobjects.HomePageSamokat;

import static org.junit.Assert.assertTrue;

public class OrderStatus extends BaseTest {

    @Test
    public void checkStatusNonexistentOrder() {
        boolean isOrderNotFoundPageDisplayed = new HomePageSamokat(driver)
                .open()
                .clickOrderStatusButton()
                .setInputOrderNumber("123456789")
                .clickGoButton()
                .waitImgOrderNotFound()
                .isOrderNotFoundPageDisplayed();
        assertTrue("Не отображается страница: Такого заказа нет" ,isOrderNotFoundPageDisplayed);
    }
}
