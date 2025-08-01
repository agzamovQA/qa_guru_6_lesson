package tests;

import com.github.javafaker.Faker;
import java.util.Locale;

public class TestData {

    private final Faker faker = new Faker(new Locale("en-GB"));
    public String firstName = faker.name().firstName();
    public String lastName = faker.name().lastName();
    public String userEmail = faker.internet().emailAddress();
    public String userNumber = faker.phoneNumber().subscriberNumber(10);
    public String userGender = faker.options().option("Male", "Female", "Other");
    public String day = String.format("%02d", faker.number().numberBetween(1, 9));
    public String month = faker.options().option(
                "January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December"
        );
    public String year = String.valueOf(faker.number().numberBetween(1940, 2099));
    public String subject = faker.options().option("Arts", "Computer Science", "Chemistry", "English", "Maths");
    public String hobby = faker.options().option("Sports", "Reading", "Music");
    public String userAvatar = faker.options().option("jhony_silverhand.png");
    public String currentAddress = faker.address().fullAddress();
    public String state = faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan");
    public String city = getRandomCity(state);

    private String getRandomCity(String state) {
        return switch (state) {
            case "NCR" -> faker.options().option("Delhi", "Gurgaon", "Noida");
            case "Uttar Pradesh" -> faker.options().option("Agra", "Lucknow", "Merrut");
            case "Haryana" -> faker.options().option("Karnal", "Panipat");
            case "Rajasthan" -> faker.options().option("Jaipur", "Jaiselmer");
            default -> null;
        };
    }
}