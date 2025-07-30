package tests;

import com.github.javafaker.Faker;
import java.util.Locale;

public class TestData {
    private final Faker faker;
    private String firstName;
    private String lastName;
    private String userEmail;
    private String userNumber;
    private String userGender;
    private String day;
    private String month;
    private String year;
    private String subject;
    private String hobby;
    private String userAvatar;
    private String currentAddress;
    private String state;
    private String city;

    public TestData() {
        this.faker = new Faker(new Locale("en-GB"));
        initializeData();
    }

    private void initializeData() {
        this.firstName = faker.name().firstName();
        this.lastName = faker.name().lastName();
        this.userEmail = faker.internet().emailAddress();
        this.userNumber = faker.phoneNumber().subscriberNumber(10);
        this.userGender = faker.options().option("Male", "Female", "Other");
        this.day = String.format("%02d", faker.number().numberBetween(1, 30));
        this.month = faker.options().option(
                "January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December"
        );
        this.year = String.valueOf(faker.number().numberBetween(1940, 2099));
        this.subject = faker.options().option("Arts", "Computer Science", "Chemistry", "English", "Maths");
        this.hobby = faker.options().option("Sports", "Reading", "Music");
        this.userAvatar = faker.options().option("jhony_silverhand.png");
        this.currentAddress = faker.address().fullAddress();
        this.state = faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan");
        this.city = getRandomCity(this.state);
    }

    private String getRandomCity(String state) {
        return switch (state) {
            case "NCR" -> faker.options().option("Delhi", "Gurgaon", "Noida");
            case "Uttar Pradesh" -> faker.options().option("Agra", "Lucknow", "Merrut");
            case "Haryana" -> faker.options().option("Karnal", "Panipat");
            case "Rajasthan" -> faker.options().option("Jaipur", "Jaiselmer");
            default -> null;
        };
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public String getUserNumber() {
        return userNumber;
    }

    public String getUserGender() {
        return userGender;
    }

    public String getDay() {
        return day;
    }

    public String getMonth() {
        return month;
    }

    public String getYear() {
        return year;
    }

    public String getSubject() {
        return subject;
    }

    public String getHobby() {
        return hobby;
    }

    public String getUserAvatar() {
        return userAvatar;
    }

    public String getCurrentAddress() {
        return currentAddress;
    }

    public String getState() {
        return state;
    }

    public String getCity() {
        return city;
    }
}