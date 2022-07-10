package uitests;

import pageobjects.HomePageSamokat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertTrue;


@RunWith(Parameterized.class)
public class OrderSuccess extends BaseTest {
    private final String firstName;
    private final String lastName;
    private final String deliveryAddress;
    private final String metroStation;
    private final String phoneNumber;
    private final String deliveryDate;
    private final String rentalPeriod;
    private final boolean blackScooterCheckbox;
    private final boolean greyScooterCheckbox;
    private final String commentForCourier;

    public OrderSuccess(String firstName, String lastName, String address, String metroStation, String phoneNumber, String deliveryDate, String period, boolean blackScooterCheckbox, boolean greyScooterCheckbox, String comment) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.deliveryAddress = address;
        this.metroStation = metroStation;
        this.phoneNumber = phoneNumber;
        this.deliveryDate = deliveryDate;
        this.rentalPeriod = period;
        this.blackScooterCheckbox = blackScooterCheckbox;
        this.greyScooterCheckbox = greyScooterCheckbox;
        this.commentForCourier = comment;
    }

    @Parameterized.Parameters
    public static Object[][] getOrder() {

        return new Object[][] {
                {"Артемпятнадцать", "Моховпятнадцать", "г. Москва, ул. Московская, д. 2", "Черкизовская", "89991234567", "01.09.2022", "сутки", true, false, "Комментарий"},
                {"Ан", "По", "г. Иннополис", "Бульвар Рокоссовского", "71234567890", "31.12.2022", "двое суток", false, true, ""},
                {"Иван", "Петров", "г. Санкт-Петербург", "Преображенская площадь", "91234567890", "05.07.2022", "семеро суток", false, false, ""},
                {"Максим", "Крыльцов", "г. Воронеж", "Лихоборы", "11234567890", "01.01.2022", "шестеро суток", true, true, "Комментарий"},
        };
    }

    @Test
    public void checkSuccessOrder() {
        boolean isSuccessScreenDisplayed = new HomePageSamokat(driver)
                .open()
                .clickAcceptCookieButton()
                .clickOrderHeaderButton()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setDeliveryAddress(deliveryAddress)
                .setMetroStation(metroStation)
                .setPhoneNumber(phoneNumber)
                .clickNextButton()
                .setDeliveryDate(deliveryDate)
                .setRentalPeriod(rentalPeriod)
                .setBlackScooterCheckbox(blackScooterCheckbox)
                .setGreyScooterCheckbox(greyScooterCheckbox)
                .setCommentForCourier(commentForCourier)
                .clickSubmitButton()
                .clickConfirmButton()
                .waitSuccessScreen()
                .isSuccessScreenDisplayed();
        assertTrue("Экран успешного заказа самоката не отображается", isSuccessScreenDisplayed);
    }
}
