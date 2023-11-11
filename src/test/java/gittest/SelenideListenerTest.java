package gittest;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SelenideListenerTest {

    private static final String REPOSITORY = "dariaAbramkina/qa_quru_homework7";

    @Test
    public void issueTabTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        open("https://github.com");
        $(".header-search-button").click();
        $("#query-builder-test").sendKeys(REPOSITORY);
        $("#query-builder-test").submit();
        $(By.linkText(REPOSITORY)).click();
        $("#issues-tab").shouldHave(Condition.text("Issues"));
    }

}

