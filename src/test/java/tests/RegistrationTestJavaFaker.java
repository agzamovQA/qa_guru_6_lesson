package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

public class RegistrationTestJavaFaker extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void fillingAllFieldsTest() {
        TestData td = new TestData();

        registrationPage.openPage()
                .removeBanner()
                .setFirstName(td.firstName)
                .setLastName(td.lastName)
                .setUserEmail(td.userEmail)
                .setUserNumber(td.userNumber)
                .setGender(td.userGender)
                .setDateOfBirth(td.day, td.month, td.year)
                .setSubjects(td.subject)
                .setRandomHobbies(td.hobby)
                .uploadPicture(td.userAvatar)
                .setCurrentAddress(td.currentAddress)
                .selectState(td.state)
                .selectCity(td.city)
                .clickSubmit();

        registrationPage.checkPositiveResult("Student Name",
                        td.firstName + " " + td.lastName)
                .checkPositiveResult("Student Email", td.userEmail)
                .checkPositiveResult("Gender", td.userGender)
                .checkPositiveResult("Mobile", td.userNumber)
                .checkPositiveResult("Date of Birth",
                        td.day + " " + td.month + "," + td.year)
                .checkPositiveResult("Subjects", td.subject)
                .checkPositiveResult("Hobbies", td.hobby)
                .checkPositiveResult("Picture", td.userAvatar)
                .checkPositiveResult("Address", td.currentAddress)
                .checkPositiveResult("State and City",
                        td.state + " " + td.city);
    }

    @Test
    void fillRequiredFieldsTest() {
        TestData td = new TestData();

        registrationPage.openPage()
                .removeBanner()
                .setFirstName(td.firstName)
                .setLastName(td.lastName)
                .setUserEmail(td.userEmail)
                .setUserNumber(td.userNumber)
                .setGender(td.userGender)
                .clickSubmit();

        registrationPage.checkPositiveResult("Student Name",
                        td.firstName + " " + td.lastName)
                .checkPositiveResult("Student Email", td.userEmail)
                .checkPositiveResult("Gender", td.userGender)
                .checkPositiveResult("Mobile", td.userNumber);
    }

    @Test
    void negativeValidationFillTest() {
        TestData td = new TestData();

        registrationPage.openPage()
                .removeBanner()
                .setFirstName(td.firstName)
                .setLastName(td.lastName)
                .setUserEmail(td.userEmail)
                .setUserNumber("")
                .setGender(td.userGender)
                .clickSubmit();

        registrationPage.checkNegativeResult();
    }
}