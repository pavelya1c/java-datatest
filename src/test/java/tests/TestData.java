package tests;

import com.github.javafaker.Faker;

import static utils.RandomUtils.*;
import com.github.javafaker.Faker;
import utils.RandomUtils;

public class TestData {

    Faker faker = new Faker();

     public  String firstName = getRandomName();
     public  String lastName = getRandomName2();
     public  String userEmail = getRandomEmail("@gmail" ,".com");
     public  String userAdress = faker.address().fullAddress();
     public  String userNumber = getRandomRusNumberString();
     public  String userGender = getRandomGenders();
     public  String userHobbies = getRandomHobbiest();
     public  String userState = getRandomState();
     public  String userCity = getRandomCity(userState);
     public  String userCalendarMounth = getRandomMounth();
     public  String userCalendarDay = getRandomDay();
     public  String userCalendarYear = getRandomYear();
     public  String userSubjects = getSubjects();
     public  String userRandomPicture = getRandomPicture();


}
