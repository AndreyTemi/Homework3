package pages.components;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class VerifyResultComponent {
    public void verifyResultTable (String lable, String value) {
        $(".table-responsive").$(byText(lable)).parent().shouldHave(text(value));
    }

    public  void  closeTable () {
        $("#closeLargeModal").click();
    }
}
