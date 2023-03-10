package pages;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.VerifyResultComponent;

import java.io.File;

import java.util.Arrays;


import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {
    CalendarComponent calendarComponent = new CalendarComponent();
    private final SelenideElement InputFirstName = $("#firstName"),
                            InputLastName = $("#lastName"),
                            InputUserEmail = $("#userEmail"),
                            InputGenderMale = $("label[for='gender-radio-1']"),
                            InputGenderFemale = $("label[for='gender-radio-2']"),
                            InputGenderOther = $("label[for='gender-radio-3']"),
                            InputUserNumber = $("#userNumber"),
                            InputSubjects = $("#subjectsInput"),
                            InputCurrentAddress = $("#currentAddress"),
                            InputState = $("#react-select-3-input"),
                            InputCity = $("#react-select-4-input");



    public RegistrationPage openPage() {
        open("https://demoqa.com/automation-practice-form");

        return this;
    }

    public RegistrationPage closeBanner() {
        Selenide.executeJavaScript("$('#fixedban').remove()");
        Selenide.executeJavaScript("$('footer').remove()");

        return this;
    }

    public RegistrationPage setFirstName(String firstName) {
        InputFirstName.setValue(firstName);

        return this;
    }

    public RegistrationPage setLastName(String lastName) {
        InputLastName.setValue(lastName);

        return this;
    }

    public RegistrationPage setUserEmail(String userEmail) {
        InputUserEmail.setValue(userEmail);

        return this;
    }

    public RegistrationPage setGender(String gender) {
        switch (gender) {
            case ("Male"):
                InputGenderMale.click();
                break;
            case ("Female"):
                InputGenderFemale.click();
                break;
            case ("Other"):
                InputGenderOther.click();
                break;
        }

        return this;
    }

    public RegistrationPage setUserPhoneNumber(String userNumber) {
        InputUserNumber.setValue(userNumber);

        return this;
    }

    public RegistrationPage setBirthDay(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        calendarComponent.setDate(day, month, year);

        return this;
    }

    public RegistrationPage setSubjects(String subject) {
        InputSubjects.setValue(subject).pressEnter();

        return this;
    }

    public RegistrationPage setHobbies(String[] hobbies) {
        if (Arrays.asList(hobbies).contains("sports")) {
            $("label[for='hobbies-checkbox-1']").click();
        }

        if (Arrays.asList(hobbies).contains("reading")) {
            $("label[for='hobbies-checkbox-2']").click();
        }

        if (Arrays.asList(hobbies).contains("music")) {
            $("label[for='hobbies-checkbox-3']").click();
        }

        return this;
    }

    public RegistrationPage uploadFile(String path) {
        File fileToUpload = new File(path);
        $("#uploadPicture").uploadFile(fileToUpload);

        return this;
    }

    public RegistrationPage setCurrentAddress(String currentAddress) {
        InputCurrentAddress.setValue(currentAddress);

        return this;
    }

    public RegistrationPage setState(String state) {
        InputState.setValue(state).pressEnter();

        return this;
    }

    public RegistrationPage setCity(String city) {
        InputCity.setValue(city).pressEnter();

        return this;
    }

    public RegistrationPage pressSubmit() {
        $("#submit").click();

        return this;
    }
}