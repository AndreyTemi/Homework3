package pages;

import pages.components.VerifyResultComponent;

public class VerifyResultPage {

    VerifyResultComponent verifyResultComponent = new VerifyResultComponent();

    public VerifyResultPage verifyResults(String lable, String value) {
        verifyResultComponent.verifyResultTable(lable, value);

        return this;
    }

    public VerifyResultPage closeResultTable() {
        verifyResultComponent.closeTable();

        return this;
    }
}
