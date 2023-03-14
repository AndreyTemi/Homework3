package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import pages.VerifyResultPage;

import static com.codeborne.selenide.Selenide.sleep;


public class HomeworkJavaFakerTest extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();
    VerifyResultPage verifyResultPage = new VerifyResultPage();
    TestDataDemoQA testDataDemoQA = new TestDataDemoQA();
    @Test
    void testDemoQaForm() {
        testDataDemoQA.setTestData();

        registrationPage.openPage()
                .closeBanner()
                .setFirstName(testDataDemoQA.firstName)
                .setLastName(testDataDemoQA.lastName)
                .setUserEmail(testDataDemoQA.userEmail)
                .setGender(testDataDemoQA.gender)
                .setUserPhoneNumber(testDataDemoQA.userPhoneNumber)
                .setBirthDay(testDataDemoQA.birthDateDay, testDataDemoQA.birthDateMonth, testDataDemoQA.birthDateYear)
                .setSubjects(testDataDemoQA.subject)
                .setHobbies(testDataDemoQA.setHobbies)
                .uploadFile("src/test/resources/test.png")
                .setCurrentAddress(testDataDemoQA.currentAddress)
                .setState(testDataDemoQA.state)
                .setCity(testDataDemoQA.city)
                .pressSubmit();

        testDataDemoQA.sdf.applyPattern("MMMM");
        verifyResultPage.verifyResults("Student Name", testDataDemoQA.firstName + " " + testDataDemoQA.lastName)
                .verifyResults("Student Email", testDataDemoQA.userEmail)
                .verifyResults("Gender", testDataDemoQA.gender)
                .verifyResults("Mobile", testDataDemoQA.userPhoneNumber)
                .verifyResults("Date of Birth", testDataDemoQA.birthDateDay + " " +
                        testDataDemoQA.sdf.format(testDataDemoQA.birthDate) + "," + testDataDemoQA.birthDateYear)
                .verifyResults("Subjects", testDataDemoQA.subject)
                .verifyResults("Hobbies", testDataDemoQA.hobbies)
                .verifyResults("Picture", testDataDemoQA.file)
                .verifyResults("Address", testDataDemoQA.currentAddress)
                .verifyResults("State and City", testDataDemoQA.state + " " + testDataDemoQA.city)
                .closeResultTable();

        sleep(1000);
    }
}
