package pages;

import io.qameta.allure.Step;
import pages.components.VerifyResultComponent;

public class VerifyResultPage {

    VerifyResultComponent verifyResultComponent = new VerifyResultComponent();

    @Step("Проверяем введенные данные")
    public VerifyResultPage verifyResults(String lable, String value) {
        verifyResultComponent.verifyResultTable(lable, value);

        return this;
    }
    @Step("Закрываем проверочную форму")
    public VerifyResultPage closeResultTable() {
        verifyResultComponent.closeTable();

        return this;
    }
}
