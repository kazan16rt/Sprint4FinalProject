package uitests;

import org.junit.Test;
import pageobjects.HomePageSamokat;

public class Questions extends BaseTest {

    @Test
    public void checkAnswersTextInAllQuestions() {
        new HomePageSamokat(driver)
                .open()
                .clickAcceptCookieButton()
                .checkAllAnswersInQuestions();
    }
}
