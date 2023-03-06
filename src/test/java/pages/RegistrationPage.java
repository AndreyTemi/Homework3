package pages;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import java.io.File;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {
    CalendarComponent calendarComponent = new CalendarComponent();
    private SelenideElement ImputFirstName = $("#firstName"),
                            ImputLastName = $("#lastName"),
                            ImputUserEmail = $("#userEmail"),
                            ImputGender = $("label[for='gender-radio-1']"),
                            ImputUserNumber = $("#userNumber"),
                            ImputSubjects = $("#subjectsInput"),
                            ImputCurrentAddress = $("#currentAddress"),
                            ImputState = $("#react-select-3-input"),
                            ImputCity = $("#react-select-4-input"),
                            VerifyModal = $(".modal-body"),
                            CloseResultTable = $("#closeLargeModal");


    public RegistrationPage openPage() {
        open("https://demoqa.com/automation-practice-form");
        Selenide.executeJavaScript("$('#fixedban').remove()");
        Selenide.executeJavaScript("$('footer').remove()");

        return this;
    }

    public RegistrationPage setFirstName(String firstName) {
        ImputFirstName.setValue(firstName);

        return this;
    }

    public RegistrationPage setLastName(String lastName) {
        ImputLastName.setValue(lastName);

        return this;
    }

    public RegistrationPage setUserEmail(String userEmail) {
        ImputUserEmail.setValue(userEmail);

        return this;
    }

    public RegistrationPage setGender() {
        ImputGender.click();

        return this;
    }

    public RegistrationPage setUserNumber(String userNumber) {
        ImputUserNumber.setValue(userNumber);

        return this;
    }

    public RegistrationPage setBirthDay(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        calendarComponent.setDate(day, month, year);

        return this;
    }

    public RegistrationPage setSubjects(String userNumber) {
        ImputSubjects.setValue(userNumber).pressEnter();

        return this;
    }

    public RegistrationPage setHobbies() {
        $("label[for='hobbies-checkbox-1']").click();
        $("label[for='hobbies-checkbox-2']").click();
        $("label[for='hobbies-checkbox-3']").click();

        return this;
    }

    public RegistrationPage uploadFile() {
        File fileToUpload = new File("src/test/resources/test.png");
        $("#uploadPicture").uploadFile(fileToUpload);

        return this;
    }

    public RegistrationPage setCurrentAddress(String currentAddress) {
        ImputCurrentAddress.setValue(currentAddress);

        return this;
    }

    public RegistrationPage setState(String State) {
        ImputState.setValue(State).pressEnter();

        return this;
    }

    public RegistrationPage setCity(String City) {
        ImputCity.setValue(City).pressEnter();

        return this;
    }

    public RegistrationPage pressSabmint() {
        $("#submit").click();

        return this;
    }

    public RegistrationPage verifyResults(String value) {
        VerifyModal.shouldHave(text(value));

        return this;
    }

    public RegistrationPage closeTable() {
        CloseResultTable.click();

        return this;
    }

}