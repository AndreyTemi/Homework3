package pages.components;

import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {
    public void setDate(String day, String month, String year){
        int monthInt = Integer.parseInt(month);
        int correctMonthInt = monthInt - 1;
        String correctMonthString = Integer.toString(correctMonthInt);

        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOptionByValue(year);
        $(".react-datepicker__month-select").selectOptionByValue(correctMonthString);
        $(".react-datepicker__day.react-datepicker__day--0" + day).click();

    }
}
