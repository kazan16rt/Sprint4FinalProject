package pageobjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;

public class HomePageSamokat extends BasePage {
    public static final String HOME_URL = "https://qa-scooter.praktikum-services.ru/";
    public HomePageSamokat(WebDriver driver) {
        this.driver = driver;
    }

    // Вопрос в аккордионе № 1
    private By accordionHeading_1 = By.id("accordion__heading-0");
    // Вопрос в аккордионе № 2
    private By accordionHeading_2 = By.id("accordion__heading-1");
    // Вопрос в аккордионе № 3
    private By accordionHeading_3 = By.id("accordion__heading-2");
    // Вопрос в аккордионе № 4
    private By accordionHeading_4 = By.id("accordion__heading-3");
    // Вопрос в аккордионе № 5
    private By accordionHeading_5 = By.id("accordion__heading-4");
    // Вопрос в аккордионе № 6
    private By accordionHeading_6 = By.id("accordion__heading-5");
    // Вопрос в аккордионе № 7
    private By accordionHeading_7 = By.id("accordion__heading-6");
    // Вопрос в аккордионе № 8
    private By accordionHeading_8 = By.id("accordion__heading-7");
    // Панель в аккордионе № 1
    private By accordionPanel_1 = By.xpath(".//div[@id='accordion__panel-0']/p");
    // Панель в аккордионе № 2
    private By accordionPanel_2 = By.xpath(".//div[@id='accordion__panel-1']/p");
    // Панель в аккордионе № 3
    private By accordionPanel_3 = By.xpath(".//div[@id='accordion__panel-2']/p");
    // Панель в аккордионе № 4
    private By accordionPanel_4 = By.xpath(".//div[@id='accordion__panel-3']/p");
    // Панель в аккордионе № 5
    private By accordionPanel_5 = By.xpath(".//div[@id='accordion__panel-4']/p");
    // Панель в аккордионе № 6
    private By accordionPanel_6 = By.xpath(".//div[@id='accordion__panel-5']/p");
    // Панель в аккордионе № 7
    private By accordionPanel_7 = By.xpath(".//div[@id='accordion__panel-6']/p");
    // Панель в аккордионе № 8
    private By accordionPanel_8 = By.xpath(".//div[@id='accordion__panel-7']/p");
    // Кнопка "Заказать" в хедере
    private By orderHeaderButton = By.cssSelector("div.Header_Nav__AGCXC button.Button_Button__ra12g");
    // Кнопка "Заказать" на домашней странице
    private By orderHomeButton = By.cssSelector("div.Home_FinishButton__1_cWm button.Button_Button__ra12g");
    // Кнопка "Статус заказа"
    private By orderStatusButton = By.className("Header_Link__1TAG7");
    // Поле ввода номера заказа
    private By inputOrderNumber = By.className("Input_Input__1iN_Z");
    // Кнопка "Go"
    private By goButton = By.xpath(".//button[text()='Go!']");
    // Логотип Самокат на домашней странице
    private By samokatLogo = By.cssSelector("img[alt='Scooter']");
    // Логотип Яндекс на домашней странице
    private By yandexButton = By.cssSelector("div.Header_Logo__23yGT img[alt='Yandex']");
    // Div домашней страницы Самокат
    private By divSamokatHome = By.className("Home_HomePage__ZXKIX");
    // Логотип Яндекс на yandex.ru
    private By logoYandexPage = By.xpath(".//div[@aria-label='Яндекс']");
    // Кнопка "да все привыкли"
    private By acceptCoockieButton = By.id("rcc-confirm-button");
    // Картинка "Такого заказа нет"
    private By imgOrderNotFound = By.xpath(".//div[@class='Track_NotFound__6oaoY']/img[@alt='Not found' and @src='/assets/not-found.png']");
    // Заголовок Для кого самокат
    private By headerOrderPage = By.xpath(".//div[text()='Для кого самокат']");

    public OrderPageSamokat clickOrderHeaderButton() {
        driver.findElement(orderHeaderButton).click();
        return new OrderPageSamokat(driver);
    }
    public HomePageSamokat clickOrderStatusButton() {
        driver.findElement(orderStatusButton).click();
        return this;
    }
    public HomePageSamokat setInputOrderNumber(String orderNumber) {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(inputOrderNumber));
        driver.findElement(inputOrderNumber).sendKeys(orderNumber);
        return this;
    }
    public HomePageSamokat clickGoButton() {
        driver.findElement(goButton).click();
        return this;
    }
    public void clickSamokatLogo() {
        driver.findElement(samokatLogo).click();
    }
    public HomePageSamokat clickYandexButton() {
        driver.findElement(yandexButton).click();
        return this;
    }
    public HomePageSamokat waitSamokatPage() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(divSamokatHome));
        return this;
    }
    public HomePageSamokat waitLogoYandexPage() {
        ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(logoYandexPage));
        return this;
    }
    public boolean isLogoYandexDisplayed() {
        boolean yandexLogo = driver.findElement(logoYandexPage).isDisplayed();
        return yandexLogo;
    }
    public HomePageSamokat waitImgOrderNotFound() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(imgOrderNotFound));
        return this;
    }
    public boolean isOrderNotFoundPageDisplayed() {
        boolean orderNotFound = driver.findElement(imgOrderNotFound).isDisplayed();
        return orderNotFound;
    }
    public HomePageSamokat clickAcceptCookieButton() {
        if (driver.findElement(acceptCoockieButton).isDisplayed()) {
            driver.findElement(acceptCoockieButton).click();
        }
        return this;
    }
    public HomePageSamokat clickAccordionHeading_1() {
        driver.findElement(accordionHeading_1).click();
        return this;
    }
    public HomePageSamokat clickAccordionHeading_2() {
        driver.findElement(accordionHeading_2).click();
        return this;
    }
    public HomePageSamokat clickAccordionHeading_3() {
        driver.findElement(accordionHeading_3).click();
        return this;
    }
    public HomePageSamokat clickAccordionHeading_4() {
        driver.findElement(accordionHeading_4).click();
        return this;
    }
    public HomePageSamokat clickAccordionHeading_5() {
        driver.findElement(accordionHeading_5).click();
        return this;
    }
    public HomePageSamokat clickAccordionHeading_6() {
        driver.findElement(accordionHeading_6).click();
        return this;
    }
    public HomePageSamokat clickAccordionHeading_7() {
        driver.findElement(accordionHeading_7).click();
        return this;
    }
    public HomePageSamokat clickAccordionHeading_8() {
        driver.findElement(accordionHeading_8).click();
        return this;
    }
    public HomePageSamokat checkTextAccordionPanel_1() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(accordionPanel_1));
        String actual = driver.findElement(accordionPanel_1).getText();
        String expected = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";
        Assert.assertEquals("Текст панели вопроса № 1 не совпадает с ожидаемым", expected, actual);
        return this;
    }
    public HomePageSamokat checkTextAccordionPanel_2() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(accordionPanel_2));
        String actual = driver.findElement(accordionPanel_2).getText();
        String expected = "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.";
        Assert.assertEquals("Текст панели вопроса № 2 не совпадает с ожидаемым", expected, actual);
        return this;
    }
    public HomePageSamokat checkTextAccordionPanel_3() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(accordionPanel_3));
        String actual = driver.findElement(accordionPanel_3).getText();
        String expected = "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.";
        Assert.assertEquals("Текст панели вопроса № 3 не совпадает с ожидаемым", expected, actual);
        return this;
    }
    public HomePageSamokat checkTextAccordionPanel_4() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(accordionPanel_4));
        String actual = driver.findElement(accordionPanel_4).getText();
        String expected = "Только начиная с завтрашнего дня. Но скоро станем расторопнее.";
        Assert.assertEquals("Текст панели вопроса № 4 не совпадает с ожидаемым", expected, actual);
        return this;
    }
    public HomePageSamokat checkTextAccordionPanel_5() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(accordionPanel_5));
        String actual = driver.findElement(accordionPanel_5).getText();
        String expected = "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.";
        Assert.assertEquals("Текст панели вопроса № 5 не совпадает с ожидаемым", expected, actual);
        return this;
    }
    public HomePageSamokat checkTextAccordionPanel_6() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(accordionPanel_6));
        String actual = driver.findElement(accordionPanel_6).getText();
        String expected = "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.";
        Assert.assertEquals("Текст панели вопроса № 6 не совпадает с ожидаемым", expected, actual);
        return this;
    }
    public HomePageSamokat checkTextAccordionPanel_7() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(accordionPanel_7));
        String actual = driver.findElement(accordionPanel_7).getText();
        String expected = "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.";
        Assert.assertEquals("Текст панели вопроса № 7 не совпадает с ожидаемым", expected, actual);
        return this;
    }
    public HomePageSamokat checkTextAccordionPanel_8() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(accordionPanel_8));
        String actual = driver.findElement(accordionPanel_8).getText();
        String expected = "Да, обязательно. Всем самокатов! И Москве, и Московской области.";
        Assert.assertEquals("Текст панели вопроса № 8 не совпадает с ожидаемым", expected, actual);
        return this;
    }
    public OrderPageSamokat waitOrderPage() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(headerOrderPage));
        return new OrderPageSamokat(driver);
    }
    public boolean isHomePageDisplayed() {
        boolean isDisplayed = driver.findElement(divSamokatHome).isDisplayed();
        return isDisplayed;
    }
    public HomePageSamokat open() {
        driver.get(HOME_URL);
        return this;
    }

}
