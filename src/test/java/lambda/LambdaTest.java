package lambda;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class LambdaTest {
    private final String BASE_URL = "https://github.com";
    private final static String REPOSITORY  = "Xannara/qa_guru_allure";

    @BeforeAll
    static void setup() {
        Configuration.startMaximized = true;
    }

    @Test
    @Owner("ovchernyshenko")
    @Feature("Main menu")
    @Story("Menu Issue")
    @DisplayName("Lambda test")
    public void issueSearchTest() {
        step("Главная страница", (step) -> {
            step.parameter("url", BASE_URL);
            open(BASE_URL);
        });
        step("Поиск репозитория", (step) -> {
            step.parameter("repository", REPOSITORY);

            $(".header-search-input").click();
            $(".header-search-input").sendKeys(REPOSITORY);
            $(".header-search-input").submit();
        });
        step("Переход в репозиторий", () -> {
            $(By.linkText(REPOSITORY)).click();
        });
        step("Переход в Issues", () -> {
            $(withText("Issues")).click();
        });
        step("Проверка текста", (step) -> {
            step.parameter("Expected result", "Welcome to issues!");

            $(".blankslate h3").shouldHave(text("Welcome to issues!"));
        });
    }
}
