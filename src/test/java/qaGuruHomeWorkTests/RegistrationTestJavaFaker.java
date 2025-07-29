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