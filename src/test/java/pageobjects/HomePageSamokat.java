package pageobjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;

import static testdata.Questions.ANSWERS;

public class HomePageSamokat extends BasePage {
    public static final String HOME_URL = "https://qa-scooter.praktikum-services.ru/";
    public HomePageSamokat(WebDriver driver) {
        this.driver = driver;
    }

    // Шаблон вопросов в аккордионе
    private String questionTemplate = "accordion__heading-%s";
    // Шаблон ответов в аккордионе
    private String answerTemplate = ".//div[@id='accordion__panel-%s']/p";
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
    public OrderPageSamokat clickOrderHomeButton() {
        driver.findElement(orderHomeButton).click();
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
    public HomePageSamokat clickAccordionHeading(int questionNumber) {
        By accordionHeading = By.id(String.format(questionTemplate, questionNumber));
        driver.findElement(accordionHeading).click();
        return this;
    }
    public HomePageSamokat checkTextAccordionPanel(int answerNumber) {
        By accordionPanel = By.xpath(String.format(answerTemplate, answerNumber));
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(accordionPanel));
        String actual = driver.findElement(accordionPanel).getText();
        String expected = ANSWERS[answerNumber];
        Assert.assertEquals("Текст панели вопроса № " +answerNumber + " не совпадает с ожидаемым ответом", expected, actual);
        return this;
    }
    public void checkAllAnswersInQuestions() {
      for(int i = 0; i < ANSWERS.length; i++) {
          clickAccordionHeading(i);
          checkTextAccordionPanel(i);
      }
    };
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
