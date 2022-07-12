package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OrderPageSamokat extends BasePage {

    public OrderPageSamokat(WebDriver driver) {
        this.driver = driver;
    }

    // Шаблон для полей заказа
    private String orderFieldTemplate = ".//input[@placeholder='%s']";
    // Шаблон для ошибок в полях заказа
    private String orderFieldErrorTemplate = ".//div[text()='%s']";
    // Поле ввода Имя
    private By firstName = By.xpath(".//input[@placeholder='* Имя']");
    // Поле ввода Фамилия
    private By lastName = By.xpath(".//input[@placeholder='* Фамилия']");
    // Поле ввода Адрес доставки
    private By deliveryAddress = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    // Поле ввода Станция метро
    private By metroStation = By.xpath(".//input[@placeholder='* Станция метро']");
    // Поле ввода Телефон
    private By phoneNumber = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");

    // Кнопка "Далее"
    private By nextButton = By.xpath(".//button[contains(text(), 'Далее')]");

    // Поле ввода Когда привезти самокат
    private By deliveryDate = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    // Поле ввода Срок аренды
    private By rentalPeriod = By.className("Dropdown-placeholder");
    // Чекбокс чёрный жемчуг
    private By blackScooterCheckbox = By.id("black");
    // Чекбокс серая безысходность
    private By greyScooterCheckbox = By.id("grey");
    // Поле ввода Комментарий для курьера
    private By commentForCourier = By.xpath(".//input[@placeholder='Комментарий для курьера']");

    // Кнопка "Заказать"
    private By submitButton = By.xpath(".//div[@class='Order_Buttons__1xGrp']/button[contains(text(), 'Заказать')]");
    // Кнопка "Да"
    private By confirmButton = By.xpath(".//div[@class='Order_Buttons__1xGrp']/button[contains(text(), 'Да')]");
    // Заголовок модального окна "Заказ оформлен"
    private By successScreenHeader = By.xpath(".//div[@class='Order_ModalHeader__3FDaJ' and text()='Заказ оформлен']");
    // Заголовок Для кого самокат
    private By headerOrderPage = By.xpath(".//div[text()='Для кого самокат']");
    // Логотип Самокат на домашней странице
    private By samokatLogo = By.cssSelector("img[alt='Scooter']");

    public OrderPageSamokat setOrderField(String fieldName, String value) {
        By orderField = By.xpath(String.format(orderFieldTemplate, fieldName));
        driver.findElement(orderField).sendKeys(value + Keys.ESCAPE);
        clickNextButton();
        return this;
    }
        public String getErrorTextFromOrderField(String errorText) {
            By orderFieldError = By.xpath(String.format(orderFieldErrorTemplate, errorText));
            new WebDriverWait(driver, Duration.ofSeconds(3))
                    .until(ExpectedConditions.visibilityOfElementLocated(orderFieldError));
        String text = driver.findElement(orderFieldError).getText();
        return text;
    }
    public OrderPageSamokat setFirstName(String name) {
        driver.findElement(firstName).sendKeys(name + Keys.ESCAPE);
        return this;
    }
    public OrderPageSamokat setLastName(String surname) {
        driver.findElement(lastName).sendKeys(surname + Keys.TAB);
        return this;
    }
    public OrderPageSamokat setDeliveryAddress(String address) {
        driver.findElement(deliveryAddress).sendKeys(address + Keys.TAB);
        return this;
    }
    public OrderPageSamokat setMetroStation(String metro) {
        driver.findElement(metroStation).sendKeys(metro);
        By metroStation = By.xpath(".//*[text()='" + metro + "']");
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(metroStation));
        driver.findElement(metroStation).click();
        return this;
    }
    public OrderPageSamokat setPhoneNumber(String number) {
        driver.findElement(phoneNumber).sendKeys(number + Keys.TAB);
        return this;
    }
    public OrderPageSamokat clickNextButton() {
        driver.findElement(nextButton).click();
        return this;
    }
    public OrderPageSamokat setDeliveryDate(String date) {
        driver.findElement(deliveryDate).sendKeys(date);
        driver.findElement(By.xpath(".//div[text()='Про аренду']")).click();
        return this;
    }
    public OrderPageSamokat setRentalPeriod(String period) {
        driver.findElement(rentalPeriod).click();
        driver.findElement(By.xpath(".//div[contains(@class,'Dropdown-option') and text() = '" + period + "']")).click();
        return this;
    }
    public OrderPageSamokat setBlackScooterCheckbox(Boolean checkbox) {
        if (checkbox) {
            driver.findElement(blackScooterCheckbox).click();
        }
        return this;
    }
    public OrderPageSamokat setGreyScooterCheckbox(Boolean checkbox) {
        if (checkbox) {
            driver.findElement(greyScooterCheckbox).click();
        }
        return this;
    }
    public OrderPageSamokat setCommentForCourier(String comment) {
        driver.findElement(commentForCourier).sendKeys(comment);
        return this;
    }
    public OrderPageSamokat clickSubmitButton() {
        driver.findElement(submitButton).click();
        return this;
    }
    public OrderPageSamokat clickConfirmButton() {
        driver.findElement(confirmButton).click();
        return this;
    }

    public OrderPageSamokat waitSuccessScreen() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(successScreenHeader));
        return this;
    }
    public boolean isSuccessScreenDisplayed() {
        boolean successScreen = driver.findElement(successScreenHeader).isDisplayed();
        return successScreen;
    }
    public OrderPageSamokat waitOrderPage() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(headerOrderPage));
        return this;
    }
    public HomePageSamokat clickSamokatLogo() {
        driver.findElement(samokatLogo).click();
        return new HomePageSamokat(driver);
    }
}
