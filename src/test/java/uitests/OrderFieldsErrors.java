package uitests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import pageobjects.HomePageSamokat;

import static org.junit.Assert.assertEquals;
import static testdata.FieldNames.*;
import static testdata.OrderErrors.*;
@RunWith(Parameterized.class)
public class OrderFieldsErrors extends BaseTest {
    private final String fieldName;
    private final String value;
    private final String errorText;
    public OrderFieldsErrors(String fieldName, String value, String errorText) {
        this.fieldName = fieldName;
        this.value = value;
        this.errorText = errorText;
    }
    @Parameterized.Parameters
    public static Object[][] getFieldErrors() {
        return new Object[][] {
                {FIRST_NAME, "Q", FIRST_NAME_ERROR},
                {LAST_NAME, "Q", LAST_NAME_ERROR},
                {ADDRESS, "Q", ADDRESS_ERROR},
                {METRO_STATION, "Q", METRO_STATION_ERROR},
                {PHONE_NUMBER, "Q", PHONE_NUMBER_ERROR},
        };
    }
    @Test
    public void checkOrderFieldErrors() {
        String errorTextFromField = new HomePageSamokat(driver)
                .open()
                .clickAcceptCookieButton()
                .clickOrderHeaderButton()
                .setOrderField(fieldName, value)
                .getErrorTextFromOrderField(errorText);
        assertEquals("Ошибка в поле Имя отличается от ожидаемого текста ошибки: " + errorText, errorText, errorTextFromField);
    }
}

