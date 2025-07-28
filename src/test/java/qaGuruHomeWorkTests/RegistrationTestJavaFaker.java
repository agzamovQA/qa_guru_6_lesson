package qaGuruHomeWorkTests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import qaGuruHomeWorkTests.configuration.TestBase;


public class RegistrationTestJavaFaker extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void fillingAllFieldsTest() {
        registrationPage.openPage()
                .removeBanner()
                .setFirstName("Johnny")
                .setLastName("Silverhand")
                .setUserEmail("samurai23@nightcity.com")
                .setUserNumber("2023002077")
                .setGender()
                .setDateOfBirth("16","November","1988")
                .setSubjects("Chemistry")
                .setAllHobbies()
                .uploadPicture("jhony_silverhand.png")
                .setCurrentAddress("North California, Night City")
                .selectState("Uttar Pradesh")
                .selectCity("Merrut")
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
                .setGender()
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
                .setGender()
                .clickSubmit();

        registrationPage.checkNegativeResult();

    }
}