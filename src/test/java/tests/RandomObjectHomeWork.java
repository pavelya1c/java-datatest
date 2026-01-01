package tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;

import static tests.TestData.*;


public class RandomObjectHomeWork extends TestBase {


    tests.pages.FormPage formPage = new tests.pages.FormPage();
    TestData testData = new TestData();


    @Test
    void formTestRework() {


//С Заполнением всех полей
       formPage .openUrl()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setEmail(testData.userEmail)
                .setGenterWrapper(testData.userGender)
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
                .checkResult(testData.userGender, "Gender")
                .checkResult(testData.userNumber, "Mobile")
                .checkResult(testData.userCalendarDay + " " + testData.userCalendarMounth + "," + testData.userCalendarYear , "Date")
                .checkResult(testData.userSubjects, "Subjects")
                .checkResult(testData.userHobbies, "Hobbies")
                .checkResult(testData.userRandomPicture, "Picture")
                .checkResult(testData.userAdress, "Address")
                .checkResult(testData.userState + " " + testData.userCity, "State and City");

    }

//Заполнены только обязательные поля
@Test
    void notAll (){
    formPage .openUrl()
            .setFirstName(testData.firstName)
            .setLastName(testData.lastName)
            .setEmail(testData.userEmail)
            .setGenterWrapper(testData.userGender)
            .setUserNumber(testData.userNumber)
            .setHobbies(testData.userHobbies)
            .scrollPage()
            .setSubmit()

            //Проверка
            .checkResult(testData.firstName, "Student name")
            .checkResult(testData.userEmail, "Email")
            .checkResult(testData.userGender, "Gender")
            .checkResult(testData.userNumber, "Mobile");

}

//Негативный тест
@Test
    public void negativeTest(){
    formPage .openUrl()
            .setFirstName(testData.firstName)
            .setLastName(testData.lastName)
            .setEmail(testData.userEmail)
            .setGenterWrapper(testData.userGender)
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
            .setModul();


}


}
