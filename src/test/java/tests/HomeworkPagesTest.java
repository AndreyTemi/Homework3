package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static com.codeborne.selenide.Selenide.*;


public class HomeworkPagesTest extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    @Test
    void testDemoQaForm() {
        String firstName = "Andrey";
        String lastName = "Temirbaev";
        String userEmail = "test@test.ru";
        String userPhoneNumber = "9097776655";
        String subject = "English";
        String currentAddress = "Address";
        String state = "NCR";
        String city = "Delhi";
        String gender = "Male";
        String birthDate = "07 June,1988";
        String file = "test.png";
        String hobbies = "Sports, Reading, Music";

        String[] setHobbies = new String[] {"sports", "music", "reading"};

        registrationPage.openPage()
                .closeBanner()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserEmail(userEmail)
                .setGender("male")
                .setUserPhoneNumber(userPhoneNumber)
                .setBirthDay("07", "5", "1988")
                .setSubjects(subject)
                .setHobbies(setHobbies)
                .uploadFile("src/test/resources/test.png")
                .setCurrentAddress(currentAddress)
                .setState(state)
                .setCity(city)
                .pressSubmit()
                .verifyResults("Student Name", firstName + " " + lastName)
               // .verifyResults(lastName)
                .verifyResults("Student Email", userEmail)
                .verifyResults("Gender", gender)
                .verifyResults("Mobile", userPhoneNumber )
                .verifyResults("Date of Birth", birthDate)
                .verifyResults("Subjects", subject)
                .verifyResults("Hobbies", hobbies)
                .verifyResults("Picture", file)
                .verifyResults("Address", currentAddress)
                .verifyResults("State and City", state + " " + city)
                .closeResultTable();

        sleep(5000);
    }
}
