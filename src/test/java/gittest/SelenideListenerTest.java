package gittest;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class SelenideListenerTest {

    private static final String REPOSITORY = "dariaAbramkina/qa_quru_homework7";

    @Test
    public void issueTabTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        $(".header-search-input").click();
        $(".header-search-input").sendKeys(REPOSITORY);
        $(".header-search-input").submit();
        $(By.linkText(REPOSITORY)).click();
        $("#issues-tab").shouldHave(Condition.text("Issues"));
    }

}

