
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import java.io.File;

import static com.codeborne.selenide.Condition.*;

import static com.codeborne.selenide.Selenide.*;



public class Homework3 {
    @BeforeAll
     static void beforeAll() {
        Configuration.browserSize = "1920x1080";
    }

    @Test
     void testDemoQaForm() {
       open("https://demoqa.com/automation-practice-form");
       Selenide.executeJavaScript("$('#fixedban').remove()");
       Selenide.executeJavaScript("$('footer').remove()");


        $("#firstName").setValue("Andrey");
        $("#lastName").setValue("Temirbaev");
        $("#userEmail").setValue("test@test.ru");
        $("label[for='gender-radio-1']").click(); //$(byText("Male")).click(); // или //  $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("9097776655");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOptionByValue("1999");
        $(".react-datepicker__month-select").selectOptionByValue("5");
        $(".react-datepicker__day.react-datepicker__day--007").click();
        $("#subjectsInput").setValue("English");
        $("#react-select-2-option-0").click();
        $("label[for='hobbies-checkbox-1']").click();
        $("label[for='hobbies-checkbox-2']").click();
        $("label[for='hobbies-checkbox-3']").click();
        File fileToUpload = new File("src/test/resources/test.png");
        $("#uploadPicture").uploadFile(fileToUpload);
        $("#currentAddress").setValue("Adress");
        $("#react-select-3-input").setValue("NCR");
        $("#react-select-3-option-0").click();
        $("#react-select-4-input").setValue("Delhi");
        $("#react-select-4-option-0").click();
        $("#submit").click();

       $(".modal-body").shouldHave(text("Andrey"));
       $(".modal-body").shouldHave(text("Temirbaev"));
       $(".modal-body").shouldHave(text("test@test.ru"));
       $(".table-hover").shouldHave(text("9097776655"));
       $(".modal-body").shouldHave(text("07 June,1999"));
       $(".modal-body").shouldHave(text("English"));
       $(".modal-body").shouldHave(text("test.png"));
       $(".modal-body").shouldHave(text("Sports"));
       $(".modal-body").shouldHave(text("Reading"));
       $(".modal-body").shouldHave(text("Music"));
       $(".modal-body").shouldHave(text("Adress"));
       $(".modal-body").shouldHave(text("NCR"));
       $(".modal-body").shouldHave(text("Delhi"));
       $("#closeLargeModal").click();
       sleep(5000);
    }
}
