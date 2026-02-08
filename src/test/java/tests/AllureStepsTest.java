package tests;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import tests.pages.WebSteps;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

@DisplayName("Поиск Issue через различную реализацию")
public class AllureStepsTest {

    private static final String REPOSITORY = "pavelya1c/java-datatest";
    private static final String ISSUE = "testIssue2";

    @BeforeAll
    public static void preCondition(){
        Configuration.baseUrl = "https://github.com";
    }

    @BeforeEach
    public void logger(){
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @DisplayName("Поиск Issue")
    @Test
    public void searchIssueFromGit(){
        open("");
        $("button.header-search-button").click();
        $("#query-builder-test").setValue(REPOSITORY)
                .pressEnter();
        $(linkText(REPOSITORY)).click();
        $("#issues-tab").click();
        $(withText(ISSUE)).should(Condition.exist);

    }
    @Test
    @DisplayName("Поиск issues по названию. Реализация: Lambda шаги через step")
    public void searchIssuesWithlambdaTest(){

        step("Переход на главную страницу", () -> {
            open("");
        });

        step("Поиск репозитория" + " " + REPOSITORY, () -> {
            $("button.header-search-button").click();
            $("#query-builder-test").setValue(REPOSITORY)
                    .pressEnter();
        });
        step("Переход в найденный репозиторий" + " " + REPOSITORY, () -> {
            $(linkText(REPOSITORY)).click();
        });

        step("Переход на вкладку ISSUE" + " " + ISSUE, () -> {
            $("#issues-tab").click();
        });

        step("Поиск ISSUE по названию" + " " + ISSUE, () ->{
            $(withText(ISSUE)).should(Condition.exist);
        });

    }

    @Test
    @DisplayName("Поиск issues по названию. Реализация: Шаги с аннотацией @Step")
    public void searchIssuesWithStepAnnotationTest(){
        WebSteps webSteps = new WebSteps();
        webSteps.openMainPage();
        webSteps.searchRepositoty(REPOSITORY);
        webSteps.clickOnReposytoryLink(REPOSITORY);
        webSteps.openIssueTab();
        webSteps.shouldSeeIssueWithName(ISSUE);


    }


}
