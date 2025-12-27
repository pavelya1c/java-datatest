package tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;

import static tests.TestData.*;


public class RandomObjectHomeWork extends TestBase {


    tests.pages.FormPage formPage = new tests.pages.FormPage();
    Faker faker = new Faker();

    @Test
    void formTestRework() {

//String firstNameFaker = faker.name().firstName();
//String lastNameFaker = faker.name().lastName();



//С Заполнением всех полей
       formPage .openUrl()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(userEmail)
                .setGenterWrapper(userGender)
                .setUserNumber(userNumber)
                .setCalendat()
                .setDateOfBirth(userCalendarDay, userCalendarMounth, userCalendarYear)
                .setSubjectSendKeys("a", userSubjects)
                .setHobbies(userHobbies)
                .setPictureInput(userRandomPicture)
                .currentAddress(userAdress)
                .scrollPage()
                .setState(userState)
                .setCity(userCity)
                .setSubmit()

                //Проверка
                .checkResult(firstName, "Student name")
                .checkResult(userEmail, "Email")
                .checkResult(userGender, "Gender")
                .checkResult(userNumber, "Mobile")
                .checkResult(userCalendarDay + " " + userCalendarMounth + "," + userCalendarYear , "Date")
                .checkResult(userSubjects, "Subjects")
                .checkResult(userHobbies, "Hobbies")
                .checkResult(userRandomPicture, "Picture")
                .checkResult(userAdress, "Address")
                .checkResult(userState + " " + userCity, "State and City");

    }

//Заполнены только обязательные поля
@Test
    void notAll (){
    formPage .openUrl()
            .setFirstName(firstName)
            .setLastName(lastName)
            .setEmail(userEmail)
            .setGenterWrapper(userGender)
            .setUserNumber(userNumber)
            .setHobbies(userHobbies)
            .scrollPage()
            .setSubmit()

            //Проверка
            .checkResult(firstName, "Student name")
            .checkResult(userEmail, "Email")
            .checkResult(userGender, "Gender")
            .checkResult(userNumber, "Mobile");

}

//Негативный тест
@Test
    public void negativeTest(){
    formPage .openUrl()
            .setFirstName(firstName)
            .setLastName(lastName)
            .setEmail(userEmail)
            .setGenterWrapper(userGender)
            .setUserNumber(userNumber)
            .setCalendat()
            .setDateOfBirth(userCalendarDay, userCalendarMounth, userCalendarYear)
            .setSubjectSendKeys("a", userSubjects)
            .setHobbies(userHobbies)
            .setPictureInput(userRandomPicture)
            .currentAddress(userAdress)
            .scrollPage()
            .setState(userState)
            .setCity(userCity)
            .setSubmit()
            .setModul();


}


}
