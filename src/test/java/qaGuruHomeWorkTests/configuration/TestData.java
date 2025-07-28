package qaGuruHomeWorkTests.configuration;

import com.github.javafaker.Faker;

import java.util.Locale;

public class TestData {

    public static final Faker faker = new Faker(new Locale("en-GB"));
    public static String firstName = faker.name().firstName();
    public static String lastName = faker.name().lastName();
    public static String userEmail = faker.internet().emailAddress();
    public static String userNumber = faker.phoneNumber().subscriberNumber(11);
    public static String userGender = faker.options().option("Male", "Female", "Other");
    public static String day = String.format("%02d", faker.number().numberBetween(1, 30));
    public static String month = faker.options().option(
            "January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December"
    );
    public static String year = String.valueOf(faker.number().numberBetween(1940, 2099));
    public static String subject = faker.options().option("Arts", "Computer Science", "Chemistry", "English", "Maths");
    public static String hobby = faker.options().option("Sports", "Reading", "Music");
    public static String userAvatar = faker.options().option("jhony_silverhand.png");
    public static String currentAddress = faker.address().fullAddress();
    public static String state = faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan");
    public static String city = faker.options().option("Karnal", "Panipat");
}
