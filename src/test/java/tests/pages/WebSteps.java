package tests.pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;


public class WebSteps {

    @Step("Переход на главную страницу")
    public void openMainPage(){
        open(" ");
    }

    @Step("Поиск репозитория {repo}")
    public void searchRepositoty(String repo){
        $("button.header-search-button").click();
        $("#query-builder-test").setValue(repo)
                .pressEnter();
    }

    @Step("Переход в найденный репозиторий {repo}")
    public void clickOnReposytoryLink (String repo){
        $(linkText(repo)).click();
    }

    @Step("Переход на вкладку ISSUE ")
    public void openIssueTab(){
        $("#issues-tab").click();
    }

    @Step("Поиск ISSUE по названию {issue}")
    public void shouldSeeIssueWithName(String issue){
        $(withText(issue)).should(Condition.exist);
    }


}
