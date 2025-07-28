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

        registrationPage.checkPositiveResult("Student Name", "Johnny Silverhand")
                        .checkPositiveResult("Student Email", "samurai23@nightcity.com")
                        .checkPositiveResult("Gender", "Male")
                        .checkPositiveResult("Mobile", "2023002077")
                        .checkPositiveResult("Date of Birth", "16 November,1988")
                        .checkPositiveResult("Subjects", "Chemistry")
                        .checkPositiveResult("Hobbies", "Sports, Reading, Music")
                        .checkPositiveResult("Picture", "jhony_silverhand.png")
                        .checkPositiveResult("Address", "North California, Night City")
                        .checkPositiveResult("State and City", "Uttar Pradesh Merrut");

    }

    @Test
    void fillRequiredFieldsTest() {
        registrationPage.openPage()
                .removeBanner()
                .setFirstName("Johnny")
                .setLastName("Silverhand")
                .setUserEmail("samurai23@nightcity.com")
                .setUserNumber("2023002077")
                .setGender(userGender)
                .clickSubmit();

        registrationPage.checkPositiveResult("Student Name", "Johnny Silverhand")
                .checkPositiveResult("Student Email", "samurai23@nightcity.com")
                .checkPositiveResult("Gender", "Male")
                .checkPositiveResult("Mobile", "2023002077");

    }

    @Test
    void negativeValidationFillTest() {
        registrationPage.openPage()
                .removeBanner()
                .setFirstName("Johnny")
                .setLastName("Silverhand")
                .setUserEmail("samurai23@nightcity.com")
                .setUserNumber("")
                .setGender(userGender)
                .clickSubmit();

        registrationPage.checkNegativeResult();

    }
}