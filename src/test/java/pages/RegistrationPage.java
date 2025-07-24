package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationPage {

    private SelenideElement firstNameImput = $("#firstName"),
                            lastNameImput = $("#lastName"),
                            userEmailImput = $("#userEmail"),
                            userNumberImput = $("#userNumber"),
                            genderWrapper = $("[for=gender-radio-1]"),
                            calendarInput = $("#dateOfBirthInput"),
                            subjectsInput = $(".subjects-auto-complete__menu"),
                            sportsHobbie = $("[for=hobbies-checkbox-1]"),
                            readingHobbie = $("[for=hobbies-checkbox-2]"),
                            musicHobbie = $("[for=hobbies-checkbox-3]"),
                            photoInput = $("#uploadPicture"),
                            addressInput = $("#currentAddress"),
                            stateDropdown = $("#state"),
                            cityDropdown = $("#city"),
                            submit = $("#submit"),
                            tableResponse = $(".table-responsive"),
                            tableContext = $(".modal-content");

    CalendarComponent calendarComponent = new CalendarComponent();

    public RegistrationPage openPage () {
        open("/automation-practice-form");
        executeJavaScript("$('footer').remove();");
        executeJavaScript("$('#fixedban').remove();");

        return this;
    }

    public RegistrationPage setFirstName (String  value) {
        firstNameImput.setValue(value);

        return this;
    }

    public RegistrationPage setLastName (String  value) {
        lastNameImput.setValue(value);

        return this;
    }

    public RegistrationPage setUserEmail (String  value) {
        userEmailImput.setValue(value);

        return this;
    }

    public RegistrationPage setUserNumber (String  value) {
        userNumberImput.setValue(value);

        return this;
    }

    public RegistrationPage setGender () {
        genderWrapper.click();

        return this;
    }

    public RegistrationPage setDateOfBirth (String day, String month, String year) {
        calendarInput.click();
        calendarComponent.setDate(day, month, year);

        return this;
    }

    public RegistrationPage setSubjects (String value) {
        $("#subjectsInput").setValue("E");
        $(".subjects-auto-complete__menu").shouldHave(text("Chemistry"));
        subjectsInput.$(byText(value)).click();

        return this;
    }

    public RegistrationPage setAllHobbies () {
        sportsHobbie.click();
        readingHobbie.click();
        musicHobbie.click();

        return this;
    }

    public RegistrationPage uploadPicture (String value) {
        photoInput.uploadFromClasspath(value);

        return this;
    }

    public RegistrationPage setCurrentAddress (String value) {
        addressInput.setValue(value);

        return this;
    }

    public RegistrationPage selectState (String value) {
        stateDropdown.click();
        $(".css-11unzgr").$(byText(value)).click();

        return this;
    }

    public RegistrationPage selectCity (String value) {
        cityDropdown.click();
        $(".css-11unzgr").$(byText(value)).click();

        return this;
    }

    public RegistrationPage clickSubmit () {
        submit.click();

        return this;
    }

    public RegistrationPage checkPositiveResult(String key, String value) {
        tableContext.shouldHave(text("Thanks for submitting the form"));
        tableResponse.$(byText(key)).parent().shouldHave(text(value));

        return this;
    }

    public RegistrationPage checkNegativeResult() {
        tableResponse.shouldNotBe(visible);

        return this;
    }

}
