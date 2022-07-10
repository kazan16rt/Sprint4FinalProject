package uitests;

import org.junit.Test;
import pageobjects.HomePageSamokat;

public class Questions extends BaseTest {

    @Test
    public void checkFirstQuestionText() {
        new HomePageSamokat(driver)
                .open()
                .clickAcceptCookieButton()
                .clickAccordionHeading_1()
                .checkTextAccordionPanel_1();
    }
    @Test
    public void checkSecondQuestionText() {
        new HomePageSamokat(driver)
                .open()
                .clickAcceptCookieButton()
                .clickAccordionHeading_2()
                .checkTextAccordionPanel_2();
    }
    @Test
    public void checkThirdQuestionText() {
        new HomePageSamokat(driver)
                .open()
                .clickAcceptCookieButton()
                .clickAccordionHeading_3()
                .checkTextAccordionPanel_3();
    }
    @Test
    public void checkFourthQuestionText() {
        new HomePageSamokat(driver)
                .open()
                .clickAcceptCookieButton()
                .clickAccordionHeading_4()
                .checkTextAccordionPanel_4();
    }
    @Test
    public void checkFifthQuestionText() {
        new HomePageSamokat(driver)
                .open()
                .clickAcceptCookieButton()
                .clickAccordionHeading_5()
                .checkTextAccordionPanel_5();
    }
    @Test
    public void checkSixthQuestionText() {
        new HomePageSamokat(driver)
                .open()
                .clickAcceptCookieButton()
                .clickAccordionHeading_6()
                .checkTextAccordionPanel_6();
    }
    @Test
    public void checkSeventhQuestionText() {
        new HomePageSamokat(driver)
                .open()
                .clickAcceptCookieButton()
                .clickAccordionHeading_7()
                .checkTextAccordionPanel_7();
    }
    @Test
    public void checkEighthQuestionText() {
        new HomePageSamokat(driver)
                .open()
                .clickAcceptCookieButton()
                .clickAccordionHeading_8()
                .checkTextAccordionPanel_8();
    }



}
