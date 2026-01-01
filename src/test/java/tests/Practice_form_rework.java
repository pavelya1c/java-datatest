import org.junit.jupiter.api.Test;
import tests.TestBase;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static utils.RandomUtils.getRandomEmail;
import static utils.RandomUtils.getRandomString;


public class Practice_form_rework extends TestBase {

    @Test
    void formTestRework() {
        String firstName = getRandomString(8);
        String lastName = "Yatmanov";
        String userEmail = getRandomEmail("gmail", ".com");
        String userNumber = "9999999999";


        open("/automation-practice-form");


        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(userEmail);


        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue(userNumber);


        $(".react-datepicker__input-container").click();

        $(".react-datepicker__month-select").$(byText("January")).click();
        $(".react-datepicker__year-select").$(byText("1992")).click();
        $(".react-datepicker__month").$(byText("19")).click();


        $(".subjects-auto-complete__input").click();
        $("[aria-autocomplete=list]").sendKeys("a");
        $(byText("Arts")).click();


        $("#hobbiesWrapper").$(byText("Sports")).click();
       $("#uploadPicture").uploadFromClasspath("qa_guru.jpg");
        $("#currentAddress").setValue("Аблукова 105");

        $("#submit").scrollTo();

        $("#state").click();
        $(byText("Uttar Pradesh")).click();
        $("#city").click();
        $(byText("Merrut")).click();

        $("#submit").click();


        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));

        $(".table-dark").shouldHave(text("yatmanov@qa_guru_39.com"));
        $(".table-dark").shouldHave(text("Male"));
        $(".table-dark").shouldHave(text("9999999999"));
        $(".table-dark").shouldHave(text("19 January,1992"));
        $(".table-dark").shouldHave(text("Arts"));
        $(".table-dark").shouldHave(text("Sports"));
        $(".table-dark").shouldHave(text("Аблукова 105"));
        $(".table-dark").shouldHave(text("Uttar Pradesh Merrut"));





    }





}
