package uitests;

import org.junit.Test;
import pageobjects.HomePageSamokat;

import static org.junit.Assert.assertEquals;
import static testdata.OrderErrors.*;

public class OrderFieldsErrors extends BaseTest {

    @Test
    public void checkErrorFirstNameField() {
        String errorTextFromFirstName = new HomePageSamokat(driver)
                .open()
                .clickOrderHeaderButton()
                .setFirstName("S")
                .getErrorTextFromFirstName();
        assertEquals("Ошибка в поле Имя отличается от ожидаемого текста ошибки: " + FIRST_NAME_ERROR, FIRST_NAME_ERROR, errorTextFromFirstName);
    }
    @Test
    public void checkErrorLastNameField() {
        String errorTextFromLastName = new HomePageSamokat(driver)
                .open()
                .clickOrderHeaderButton()
                .setLastName("S")
                .getErrorTextFromLastName();
        assertEquals("Ошибка в поле Фамилия отличается от ожидаемого текста ошибки: " + LAST_NAME_ERROR, LAST_NAME_ERROR, errorTextFromLastName);
    }
    @Test
    public void checkErrorAddressField() {
        String errorTextFromAddress = new HomePageSamokat(driver)
                .open()
                .clickOrderHeaderButton()
                .setDeliveryAddress("S")
                .getErrorTextFromAddress();
        assertEquals("Ошибка в поле Адресс отличается от ожидаемого текста ошибки: " + ADDRESS_ERROR, ADDRESS_ERROR, errorTextFromAddress);
    }
    @Test
    public void checkErrorMetroStationField() {
        String errorTextFromMetroStation = new HomePageSamokat(driver)
                .open()
                .clickOrderHeaderButton()
                .clickNextButton()
                .getErrorTextFromMetroStation();
        assertEquals("Ошибка в поле Станция метро отличается от ожидаемого текста ошибки: " + METRO_STATION_ERROR, METRO_STATION_ERROR, errorTextFromMetroStation);
    }
    @Test
    public void checkErrorPhoneNumberField() {
        String errorTextFromPhoneNumber = new HomePageSamokat(driver)
                .open()
                .clickOrderHeaderButton()
                .setPhoneNumber("1")
                .getErrorTextFromPhoneNumber();
        assertEquals("Ошибка в поле Телефон отличается от ожидаемого текста ошибки: " + PHONE_NUMBER_ERROR, PHONE_NUMBER_ERROR, errorTextFromPhoneNumber);
    }
}

