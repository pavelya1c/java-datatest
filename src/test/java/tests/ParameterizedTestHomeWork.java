package tests;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import tests.Data.Hobbies;

import java.util.stream.Stream;


public class ParameterizedTestHomeWork extends TestBase {


    tests.pages.FormPage formPage = new tests.pages.FormPage();
    TestData testData = new TestData();


    @DisplayName("Отправка формы со всеми заполненными полями с выбором различного пола ")
    @ValueSource(strings = {
            "Female", "Male", "Other"
    })
    @ParameterizedTest(name = "Отправка формы с выбором gender {0}")
    @Tag("Gendar")
    void annyGendersTest(String gender) {

//С Заполнением всех полей
       formPage .openUrl()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setEmail(testData.userEmail)
                .setGenterWrapper(gender)
                .setUserNumber(testData.userNumber)
                .setCalendat()
                .setDateOfBirth(testData.userCalendarDay, testData.userCalendarMounth, testData.userCalendarYear)
                .setSubjectSendKeys("a", testData.userSubjects)
                .setHobbies(testData.userHobbies)
                .setPictureInput(testData.userRandomPicture)
                .currentAddress(testData.userAdress)
                .scrollPage()
                .setState(testData.userState)
                .setCity(testData.userCity)
                .setSubmit()


                //Проверка
                .checkResult(testData.firstName, "Student name")
                .checkResult(testData.userEmail, "Email")
                .checkResult(gender, "Gender")
                .checkResult(testData.userNumber, "Mobile")
                .checkResult(testData.userCalendarDay + " " + testData.userCalendarMounth + "," + testData.userCalendarYear , "Date")
                .checkResult(testData.userSubjects, "Subjects")
                .checkResult(testData.userHobbies, "Hobbies")
                .checkResult(testData.userRandomPicture, "Picture")
                .checkResult(testData.userAdress, "Address")
                .checkResult(testData.userState + " " + testData.userCity, "State and City");

    }

//Заполнены только обязательные поля



    @DisplayName("Отправка формы с различными хобби")
    @CsvFileSource(resources = "/test_data/Hobbies.csv")
    @ParameterizedTest(name = "Отправка формы с выбором hobbies {0}")
    @Tag("Hobbies")
    void annyHobbiestTest (String hobbies){
    formPage .openUrl()
            .setFirstName(testData.firstName)
            .setLastName(testData.lastName)
            .setEmail(testData.userEmail)
            .setGenterWrapper(testData.userGender)
            .setUserNumber(testData.userNumber)
            .setHobbies(hobbies)
            .scrollPage()
            .setSubmit()

            //Проверка
            .checkResult(testData.firstName, "Student name")
            .checkResult(testData.userEmail, "Email")
            .checkResult(testData.userGender, "Gender")
            .checkResult(testData.userNumber, "Mobile");

}



    static Stream<Arguments> correspondenceFirstNameAndHobbiesTest(){
        return Stream.of(
                Arguments.of(
                        "Angelina",
                        String.valueOf(Hobbies.Sports)
                ),
                Arguments.of(
                        "Marina",
                        String.valueOf(Hobbies.Music)
                ),
                Arguments.of(
                        "Julia",
                        String.valueOf(Hobbies.Reading)
                )
        );
    }
    @DisplayName("Проверка соотвествия имени и хобби")
    @MethodSource()
    @ParameterizedTest(name = "Проверка соответствия выбора имени firstName = {0} и хобби hobbies = {1}")
    public void correspondenceFirstNameAndHobbiesTest(String firstName, String hobbies){
    formPage .openUrl()
            .setFirstName(firstName)
            .setLastName(testData.lastName)
            .setEmail(testData.userEmail)
            .setGenterWrapper(testData.userGender)
            .setUserNumber(testData.userNumber)
            .setCalendat()
            .setDateOfBirth(testData.userCalendarDay, testData.userCalendarMounth, testData.userCalendarYear)
            .setSubjectSendKeys("a", testData.userSubjects)
            .setHobbies(hobbies)
            .setPictureInput(testData.userRandomPicture)
            .currentAddress(testData.userAdress)
            .scrollPage()
            .setState(testData.userState)
            .setCity(testData.userCity)
            .setSubmit()
            .setModul();


}


}
