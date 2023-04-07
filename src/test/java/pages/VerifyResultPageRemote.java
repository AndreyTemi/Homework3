package pages;

import io.qameta.allure.Step;
import pages.components.VerifyResultComponent;

public class VerifyResultPageRemote {

    VerifyResultComponent verifyResultComponent = new VerifyResultComponent();

    @Step("Проверяем введенные данные")
    public VerifyResultPageRemote verifyResults(String lable, String value) {
        verifyResultComponent.verifyResultTable(lable, value);

        return this;
    }
    @Step("Закрываем проверочную форму")
    public VerifyResultPageRemote closeResultTable() {
        verifyResultComponent.closeTable();

        return this;
    }
}
