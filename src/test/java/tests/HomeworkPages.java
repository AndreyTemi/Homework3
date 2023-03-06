package tests;

import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Selenide.*;


public class HomeworkPages extends TestBase {

    @Test
    void testDemoQaForm() {
        String firstName = "Andrey";
        String lastName = "Temirbaev";
        String userEmail = "test@test.ru";
        String userNumber = "9097776655";
        String subject = "English";
        String currentAddress = "Adress";
        String state = "NCR";
        String city = "Delhi";
        String gender = "Male";
        String birthDate = "07 June,1988";
        String file = "test.png";
        String hobbies = "Sports, Reading, Music";

        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserEmail(userEmail)
                .setGender()
                .setUserNumber(userNumber)
                .setBirthDay("07", "5", "1988")
                .setSubjects(subject)
                .setHobbies()
                .uploadFile()
                .setCurrentAddress(currentAddress)
                .setState(state)
                .setCity(city)
                .pressSabmint()
                .verifyResults(firstName)
                .verifyResults(lastName)
                .verifyResults(userEmail)
                .verifyResults(gender)
                .verifyResults(birthDate)
                .verifyResults(subject)
                .verifyResults(file)
                .verifyResults(hobbies)
                .verifyResults(currentAddress)
                .verifyResults(state)
                .verifyResults(city)
                .closeTable();

        sleep(5000);
    }
}
