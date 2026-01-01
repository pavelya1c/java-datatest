package utils;

import com.github.javafaker.Faker;


import java.security.SecureRandom;
import java.util.concurrent.ThreadLocalRandom;


public class RandomUtils {
    static Faker faker = new Faker();



    public static void main(String[] arg) {
        System.out.println(getRandomString(5));
        System.out.println(getRandomEmail("@gmail", ".ru"));
        System.out.println(getRandomInt(1, 333));
        System.out.println(getRandomRusNumberString());
        System.out.println(getRandomGenders());
        System.out.println(getRandomState());
        System.out.println(getRandomCity(getRandomState()));
        System.out.println(getRandomDay());
        System.out.println(getRandomMounth());
        System.out.println(getRandomYear());
        System.out.println(getRandomDay() + " " + getRandomMounth() + " " + getRandomYear());
        System.out.println(faker.address().fullAddress());
        System.out.println(faker.number().numberBetween(10, 28));

    }


    public static String getRandomString(int len) {
        //    String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghiiklmnopgrstuvwxxz";
        String AB = "ABCDEFGHIJKLMNOPQRSTUVWXYZakedefghiiklmnorarstuvwxyz";

        SecureRandom rnd = new SecureRandom();
        StringBuilder result = new StringBuilder();
        for
        (int i = 0; i < len; i++)
            result.append(AB.charAt(rnd.nextInt(AB.length())));

        return result.toString();

    }


    public static int getRandomInt(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    public static String getRandomRusNumberString() {
        return ("7") + getRandomInt(900, 999) + getRandomInt(100000, 999999) + "";
    }

    public static String getRandomEmail(String domain, String local) {
        return getRandomString(4) + domain + local;

    }


    public static String getRandomGenders() {
        return faker.options().option("Male", "Female", "Other");
    }



    public static String getRandomHobbiest() {
        return faker.options().option("Sports", "Reading", "Music");
    }


    public static String getRandomState() {
       return faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan");
    }




    public static String getRandomDay() {
        return faker.number().numberBetween(1, 30) + "";
    }



    public static String getRandomMounth() {
        return faker.options().option("January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December");
    }




    public static String getRandomYear() {
        return faker.number().numberBetween(1950, 2015) + "";
    }



    public static String getSubjects() {
        return faker.options().option("Maths", "Accounting", "Arts", "Social Studies");
    }


    public static String getRandomPicture() {
        return faker.options().option("qa_guru.jpg", "qa.jpg");
    }



    public static String getRandomCity(String state) {
        return switch (state) {
            case "NCR" -> faker.options().option("Delhi", "Gurgaon", "Noida");
            case "Uttar Pradesh" -> faker.options().option("Agra", "Lucknow", "Merrut");
            case "Haryana" -> faker.options().option("Karnal", "Panipat");
            case "Rajasthan" -> faker.options().option("Jaipur", "Jaiselmer");
            default -> null;
        };

    }


}


//    public static String getRandomGenders1() {
//        String[] genders = {"Male", "Female", "Other"};
//        int randomInt = getRandomInt(0, 2);
//        return genders[randomInt];
//    }

//    public static String getRandomHobbiest1() {
//        String[] hobbies = {"Sports", "Reading", "Music"};
//        int randomInt = getRandomInt(0, 2);
//        return hobbies[randomInt];
//   }

//    public static String getRandomState() {
//        String[] state = {"NCR", "Uttar Pradesh", "Haryana", "Rajasthan"};
//        int randomInt = getRandomInt(0, 3);
//        return state[randomInt];
//    }

//    public static String getRandomDay1(){
//        String[] date = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30"};
//        int randomDate = getRandomInt(0, 29);
//        return date[randomDate];
//}

//    public static String getRandomMounth1(){
//        String[] mounth = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
//        int randomMounth = getRandomInt(0, 11);
//        return mounth[randomMounth];
//}

//    public static String getRandomYear1() {
//        int startYear = 1930;
//        int endYear = 2007;
//        int randomYear = getRandomInt(startYear, endYear);
//        return valueOf(randomYear);
//    }

//    public static String getSubjects1 (){
//        String[] subjects = {"Maths", "Accounting", "Arts", "Social Studies"};
//        int randomSubjects = getRandomInt(0, 3);
//        return subjects[randomSubjects];
//   }

//   public static String getRandomPicture1(){
//       String[] picture = {"qa_guru.jpg", "qa.jpg"};
//       int randomPicture = getRandomInt(0, 1);
//       return picture[randomPicture];
//
//   }
//    public static String getRandomCity(String state) {
//        switch (state) {
//            case "NCR":
//                String[] cityNcr = {"Delhi", "Gurgaon", "Noida"};
//                int randomIntNrc = getRandomInt(0, 2);
//                return cityNcr[randomIntNrc];
//
//            case "Uttar Pradesh":
//                String[] uttarPradesh = {"Agra", "Lucknow", "Merrut"};
//                int randomIntUttarPradesh = getRandomInt(0, 2);
//                return uttarPradesh[randomIntUttarPradesh];
//
//            case "Haryana":
//                String[] haryana = {"Karnal", "Panipat",};
//                int randomIntHaryana = getRandomInt(0, 1);
//                return haryana[randomIntHaryana];
//
//            case "Rajasthan":
//                String[] rajasthan = {"Jaipur", "Jaiselmer",};
//                int randomIntRajasthan = getRandomInt(0, 1);
//                return rajasthan[randomIntRajasthan];
//            default:
//                return "Noida";
//        }
//  }