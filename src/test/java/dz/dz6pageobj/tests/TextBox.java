package dz.dz6pageobj.tests;

import dz.dz6pageobj.base.BaseTest;
import dz.dz6pageobj.pages.CheckTextBoxPage;
import dz.dz6pageobj.pages.TextBoxPage;
import org.junit.jupiter.api.Test;

public class TextBox extends BaseTest {
    private static TextBoxPage textBoxPage;
    private static CheckTextBoxPage checkTextBoxPage;

    @Test
    public void textBoxTest() {
        textBoxPage = new TextBoxPage();
        textBoxPage.openTextBoxPage()
                .setName("Evgeny")
                .setUserEmail("Evgeny@mail.ru")
                .setCurrentAddress("Evgeny str. City-village")
                .setPermanentAddress("Evgeny str. City-village 777")
                .submit();

        checkTextBoxPage = new CheckTextBoxPage();
        checkTextBoxPage.checkName("Evgeny")
                .checkEmail("Evgeny@mail.ru")
                .checkCurrentAddress("Evgeny str. City-village")
                .checkPermanentAddress("Evgeny str. City-village 777");


    }
}
