package uitests;

import org.junit.Test;
import pageobjects.HomePageSamokat;

import static org.junit.Assert.assertTrue;

public class HomeNavigation extends BaseTest {

    @Test
    public void checkScooterLogoButton() {
        boolean isSamokatPageDisplayed = new HomePageSamokat(driver)
                .open()
                .clickOrderHeaderButton()
                .waitOrderPage()
                .clickSamokatLogo()
                .waitSamokatPage()
                .isHomePageDisplayed();
        assertTrue("Главная страница Самоката не отображается", isSamokatPageDisplayed);
    }

    @Test
    public void checkYandexLogoButton() {
        boolean isYandexLogoDisplayed = new HomePageSamokat(driver)
                .open()
                .clickYandexButton()
                .waitLogoYandexPage()
                .isLogoYandexDisplayed();
        assertTrue("Яндекс лого на странице Яндекс не отображается", isYandexLogoDisplayed);
    }
}
