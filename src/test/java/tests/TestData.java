package tests;

import com.github.javafaker.Faker;

import static utils.RandomUtils.*;
import com.github.javafaker.Faker;

public class TestData {
    static Faker faker = new Faker();


    static String firstName = faker.name().firstName();
    static String lastName = faker.name().lastName();
    static String userEmail = getRandomEmail("@gmail" ,".com");
    static String userAdress = faker.address().fullAddress();
    static String userNumber = getRandomRusNumberString();
    static String userGender = getRandomGenders();
    static String userHobbies = getRandomHobbiest();
    static String userState = getRandomState();
    static String userCity = getRandomCityFaker(userState);
    static String userCalendarMounth = getRandomMounth();
    static String userCalendarDay = getRandomDayFaker();
    static String userCalendarYear = getRandomYear();
    static String userSubjects = getSubjects();
    static String userRandomPicture = getRandomPicture();

//Maths Accounting Arts Social Studies


}
