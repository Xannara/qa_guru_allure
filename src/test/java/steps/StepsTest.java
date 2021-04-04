package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class StepsTest {
    private final String BASE_URL = "https://github.com";

    @Step("Главная страница")
    public void openMainPage() {
        open(BASE_URL);
    }

    @Step("Поиск репозитория {repository}")
    public void searchForRepository(String repository) {
        $(".header-search-input").click();
        $(".header-search-input").sendKeys(repository);
        $(".header-search-input").submit();
    }

    @Step("Переход в репозиторий {repository}")
    public void goToRepository(String repository) {
        $(By.linkText(repository)).click();
    }

    @Step("Переходим в Issues")
    public void clickOnIssueTab() {
        $(withText("Issues")).click();
    }

    @Step("Проверка текста")
    public void shouldSeeWelcomeText() {
        $(".blankslate h3").shouldHave(text("Welcome to issues!"));
    }
}
