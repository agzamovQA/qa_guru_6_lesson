package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

public class RegistrationTestJavaFaker extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void fillingAllFieldsTest() {
        TestData testData = new TestData();

        registrationPage.openPage()
                .removeBanner()
                .setFirstName(testData.getFirstName())
                .setLastName(testData.getLastName())
                .setUserEmail(testData.getUserEmail())
                .setUserNumber(testData.getUserNumber())
                .setGender(testData.getUserGender())
                .setDateOfBirth(testData.getDay(), testData.getMonth(), testData.getYear())
                .setSubjects(testData.getSubject())
                .setRandomHobbies(testData.getHobby())
                .uploadPicture(testData.getUserAvatar())
                .setCurrentAddress(testData.getCurrentAddress())
                .selectState(testData.getState())
                .selectCity(testData.getCity())
                .clickSubmit();

        registrationPage.checkPositiveResult("Student Name",
                        testData.getFirstName() + " " + testData.getLastName())
                .checkPositiveResult("Student Email", testData.getUserEmail())
                .checkPositiveResult("Gender", testData.getUserGender())
                .checkPositiveResult("Mobile", testData.getUserNumber())
                .checkPositiveResult("Date of Birth",
                        testData.getDay() + " " + testData.getMonth() + "," + testData.getYear())
                .checkPositiveResult("Subjects", testData.getSubject())
                .checkPositiveResult("Hobbies", testData.getHobby())
                .checkPositiveResult("Picture", testData.getUserAvatar())
                .checkPositiveResult("Address", testData.getCurrentAddress())
                .checkPositiveResult("State and City",
                        testData.getState() + " " + testData.getCity());
    }

    @Test
    void fillRequiredFieldsTest() {
        TestData testData = new TestData();

        registrationPage.openPage()
                .removeBanner()
                .setFirstName(testData.getFirstName())
                .setLastName(testData.getLastName())
                .setUserEmail(testData.getUserEmail())
                .setUserNumber(testData.getUserNumber())
                .setGender(testData.getUserGender())
                .clickSubmit();

        registrationPage.checkPositiveResult("Student Name",
                        testData.getFirstName() + " " + testData.getLastName())
                .checkPositiveResult("Student Email", testData.getUserEmail())
                .checkPositiveResult("Gender", testData.getUserGender())
                .checkPositiveResult("Mobile", testData.getUserNumber());
    }

    @Test
    void negativeValidationFillTest() {
        TestData testData = new TestData();

        registrationPage.openPage()
                .removeBanner()
                .setFirstName(testData.getFirstName())
                .setLastName(testData.getLastName())
                .setUserEmail(testData.getUserEmail())
                .setUserNumber("")
                .setGender(testData.getUserGender())
                .clickSubmit();

        registrationPage.checkNegativeResult();
    }
}