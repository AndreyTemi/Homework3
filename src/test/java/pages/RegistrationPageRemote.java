package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pages.components.CalendarComponent;

import java.io.File;
import java.util.Arrays;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPageRemote {
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


    @Step("Открываем страницу регистрации")
    public RegistrationPageRemote openPage() {
        open("https://demoqa.com/automation-practice-form");

        return this;
    }
    @Step("Закрываем баннер")
    public RegistrationPageRemote closeBanner() {
        Selenide.executeJavaScript("$('#fixedban').remove()");
        Selenide.executeJavaScript("$('footer').remove()");

        return this;
    }
    @Step("Заполняем Имя")
    public RegistrationPageRemote setFirstName(String firstName) {
        InputFirstName.setValue(firstName);

        return this;
    }
    @Step("Заполняем Фамилию")
    public RegistrationPageRemote setLastName(String lastName) {
        InputLastName.setValue(lastName);

        return this;
    }
    @Step("Заполняем почту")
    public RegistrationPageRemote setUserEmail(String userEmail) {
        InputUserEmail.setValue(userEmail);

        return this;
    }
    @Step("Выбираем пол")
    public RegistrationPageRemote setGender(String gender) {
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
    @Step("Заполняем номер телефона")
    public RegistrationPageRemote setUserPhoneNumber(String userNumber) {
        InputUserNumber.setValue(userNumber);

        return this;
    }
    @Step("Заполняем Дату Рождения")
    public RegistrationPageRemote setBirthDay(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        calendarComponent.setDate(day, month, year);

        return this;
    }
    @Step("Заполняем предмет")
    public RegistrationPageRemote setSubjects(String subject) {
        InputSubjects.setValue(subject).pressEnter();

        return this;
    }
    @Step("Выбираем хобби")
    public RegistrationPageRemote setHobbies(String[] hobbies) {
        if (Arrays.asList(hobbies).contains("Sports")) {
            $("label[for='hobbies-checkbox-1']").click();
        }

        if (Arrays.asList(hobbies).contains("Reading")) {
            $("label[for='hobbies-checkbox-2']").click();
        }

        if (Arrays.asList(hobbies).contains("Music")) {
            $("label[for='hobbies-checkbox-3']").click();
        }

        return this;
    }
    @Step("Загружаем файл")
    public RegistrationPageRemote uploadFile(String path) {
        File fileToUpload = new File(path);
        $("#uploadPicture").uploadFile(fileToUpload);

        return this;
    }
    @Step("Указываем адрес")
    public RegistrationPageRemote setCurrentAddress(String currentAddress) {
        InputCurrentAddress.setValue(currentAddress);

        return this;
    }
    @Step("Выбираем штат")
    public RegistrationPageRemote setState(String state) {
        InputState.setValue(state).pressEnter();

        return this;
    }
    @Step("Выбираем город")
    public RegistrationPageRemote setCity(String city) {
        InputCity.setValue(city).pressEnter();

        return this;
    }
    @Step("Подтверждаем введенные данные")
    public RegistrationPageRemote pressSubmit() {
        $("#submit").click();

        return this;
    }
}