package gittest;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class LambdaTest {

    private static final String REPOSITORY = "dariaAbramkina/qa_quru_homework7";

    @Test
    public void issueTabTest() {
        step("Открываем главную страницу", () -> open("https://github.com"));
        step("Ищем репоизторий " + REPOSITORY, () -> {
            $(".header-search-button").click();
            $("#query-builder-test").sendKeys(REPOSITORY);
            $("#query-builder-test").submit();
        });
        step("Открываем репозиторий " + REPOSITORY, () -> $(By.linkText(REPOSITORY)).click());
        step("Проверяем что существует вкладка Issues", () -> {
            $("#issues-tab").shouldHave(Condition.text("Issues"));
        });
    }
}
