package tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import pages.VerifyResultPage;
import utils.RandomUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import static com.codeborne.selenide.Selenide.sleep;


public class HomeworkJavaFakerTest extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    VerifyResultPage verifyResultPage = new VerifyResultPage();
    RandomUtils randomUtils = new RandomUtils();
    Faker faker = new Faker();
    @Test
    void testDemoQaForm() {
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String userEmail = faker.internet().emailAddress();
        String userPhoneNumber = faker.phoneNumber().subscriberNumber(10);

        String[] subjects = new String[] {"English", "Arts", "Commerce", "Social Studies", "Accounting", "Hindi"};
        String subject = randomUtils.getRandomValueFromArray(subjects);

        String currentAddress = faker.address().fullAddress();

        String state = "NCR";
        String[] cities = new String[] {"Delhi", "Gurgaon", "Noida"};
        String city = randomUtils.getRandomValueFromArray(cities);

        String gender = faker.demographic().sex();

        Date birthDate = faker.date().birthday();
        SimpleDateFormat sdf = new SimpleDateFormat("dd", new Locale("en"));
        String birthDateDay = sdf.format(birthDate);
        sdf.applyPattern("M");
        String birthDateMonth = sdf.format(birthDate);
        sdf.applyPattern("yyyy");
        String birthDateYear = sdf.format(birthDate);

        String file = "test.png";
        String hobbies = "Sports, Reading, Music";

        String[] setHobbies = new String[] {"sports", "music", "reading"};
        String[] namesMonth = new String[] {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};

        registrationPage.openPage()
                .closeBanner()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserEmail(userEmail)
                .setGender(gender)
                .setUserPhoneNumber(userPhoneNumber)
                .setBirthDay(birthDateDay, birthDateMonth, birthDateYear)
                .setSubjects(subject)
                .setHobbies(setHobbies)
                .uploadFile("src/test/resources/test.png")
                .setCurrentAddress(currentAddress)
                .setState(state)
                .setCity(city)
                .pressSubmit();

        verifyResultPage.verifyResults("Student Name", firstName + " " + lastName)
                .verifyResults("Student Email", userEmail)
                .verifyResults("Gender", gender)
                .verifyResults("Mobile", userPhoneNumber)
                .verifyResults("Date of Birth", birthDateDay + " " + namesMonth[Integer.parseInt(birthDateMonth) - 1] + "," + birthDateYear)
                .verifyResults("Subjects", subject)
                .verifyResults("Hobbies", hobbies)
                .verifyResults("Picture", file)
                .verifyResults("Address", currentAddress)
                .verifyResults("State and City", state + " " + city)
                .closeResultTable();

        sleep(5000);
    }
}
