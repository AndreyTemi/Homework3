package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import pages.RegistrationPageRemote;
import pages.VerifyResultPage;
import pages.VerifyResultPageRemote;
import tests.TestBase;
import tests.TestDataDemoQA;

import static com.codeborne.selenide.Selenide.sleep;

@Tag("java_faker_remote")
public class HomeworkRemoteJavaFakerTest extends TestBaseRemote {
    RegistrationPageRemote registrationPageRemote = new RegistrationPageRemote();
    VerifyResultPageRemote verifyResultPageRemote = new VerifyResultPageRemote();
    TestDataDemoQA testDataDemoQA = new TestDataDemoQA();

    @Test
    @DisplayName("Проверка формы регистрации")
    void testDemoQaForm() {
        testDataDemoQA.setTestData();

        registrationPageRemote.openPage()
                .closeBanner()
                .setFirstName(testDataDemoQA.firstName)
                .setLastName(testDataDemoQA.lastName)
                .setUserEmail(testDataDemoQA.userEmail)
                .setGender(testDataDemoQA.gender)
                .setUserPhoneNumber(testDataDemoQA.userPhoneNumber)
                .setBirthDay(testDataDemoQA.birthDateDay, testDataDemoQA.birthDateMonth, testDataDemoQA.birthDateYear)
                .setSubjects(testDataDemoQA.subject)
                .setHobbies(testDataDemoQA.hobbies)
                .uploadFile(testDataDemoQA.pathFile)
                .setCurrentAddress(testDataDemoQA.currentAddress)
                .setState(testDataDemoQA.state)
                .setCity(testDataDemoQA.city)
                .pressSubmit();

        verifyResultPageRemote.verifyResults("Student Name", testDataDemoQA.firstName + " " + testDataDemoQA.lastName)
                .verifyResults("Student Email", testDataDemoQA.userEmail)
                .verifyResults("Gender", testDataDemoQA.gender)
                .verifyResults("Mobile", testDataDemoQA.userPhoneNumber)
                .verifyResults("Date of Birth", testDataDemoQA.birthDateDay + " " +
                        testDataDemoQA.birthDateMonthName + "," + testDataDemoQA.birthDateYear)
                .verifyResults("Subjects", testDataDemoQA.subject)
                .verifyResults("Hobbies", String.join(", ", testDataDemoQA.hobbies))
                .verifyResults("Picture", testDataDemoQA.file)
                .verifyResults("Address", testDataDemoQA.currentAddress)
                .verifyResults("State and City", testDataDemoQA.state + " " + testDataDemoQA.city);
              //  .closeResultTable();

        //sleep(1000);
    }
}
