package steps;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AnnotatedTestSteps {

    private final static String REPOSITORY = "Xannara/qa_guru_allure";
    private TestSteps steps = new TestSteps();

    @BeforeAll
    static void setup() {
        Configuration.startMaximized = true;
    }

    @Test
    @Owner("ovchernyshenko")
    @Feature("Main menu")
    @Story("Menu Issue")
    @DisplayName("Steps test")
    public void issueSearchTest() {
        steps.openMainPage();
        steps.searchForRepository(REPOSITORY);
        steps.goToRepository(REPOSITORY);
        steps.clickOnIssueTab();
        steps.shouldSeeWelcomeText();
    }
}
