package qaGuruHomeWorkTests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import qaGuruHomeWorkTests.configuration.TestBase;

import static qaGuruHomeWorkTests.configuration.TestData.*;


public class RegistrationTestJavaFaker extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void fillingAllFieldsTest() {
        registrationPage.openPage()
                .removeBanner()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserEmail(userEmail)
                .setUserNumber(userNumber)
                .setGender(userGender)
                .setDateOfBirth(day, month, year)
                .setSubjects(subject)
                .setRandomHobbies(hobby)
                .uploadPicture(userAvatar)
                .setCurrentAddress(currentAddress)
                .selectState(state)
                .selectCity(city)
                .clickSubmit();

        registrationPage.checkPositiveResult("Student Name", firstName + " " + lastName)
                        .checkPositiveResult("Student Email", userEmail)
                        .checkPositiveResult("Gender", userGender)
                        .checkPositiveResult("Mobile", userNumber)
                        .checkPositiveResult("Date of Birth", day + " " + month + "," + year)
                        .checkPositiveResult("Subjects", subject)
                        .checkPositiveResult("Hobbies", hobby)
                        .checkPositiveResult("Picture", userAvatar)
                        .checkPositiveResult("Address", currentAddress)
                        .checkPositiveResult("State and City", state + " " + city);

    }

    @Test
    void fillRequiredFieldsTest() {
        registrationPage.openPage()
                .removeBanner()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserEmail(userEmail)
                .setUserNumber(userNumber)
                .setGender(userGender)
                .clickSubmit();

        registrationPage.checkPositiveResult("Student Name", firstName + " " + lastName)
                .checkPositiveResult("Student Email", userEmail)
                .checkPositiveResult("Gender", userGender)
                .checkPositiveResult("Mobile", userNumber);

    }

    @Test
    void negativeValidationFillTest() {
        registrationPage.openPage()
                .removeBanner()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserEmail(userEmail)
                .setUserNumber("")
                .setGender(userGender)
                .clickSubmit();

        registrationPage.checkNegativeResult();

    }
}