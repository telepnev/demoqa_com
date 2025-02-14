package dz.dz6pageobj.tests;

import dz.dz6pageobj.base.BaseTest;
import dz.dz6pageobj.pages.CheckTextBoxPage;
import dz.dz6pageobj.pages.TextBoxPage;
import dz.dz6pageobj.util.GenerateRandomDate;
import org.junit.jupiter.api.Test;

public class TextBox extends BaseTest {
    private static TextBoxPage textBoxPage;
    private static CheckTextBoxPage checkTextBoxPage;
    private static GenerateRandomDate generateRandomDate;

    @Test
    public void textBoxTest() {
        textBoxPage = new TextBoxPage();
        generateRandomDate = new GenerateRandomDate();

        String firstName = generateRandomDate.getFirstName;
        String email = generateRandomDate.getUserEmail;
        String currentAddress = generateRandomDate.getCurrentAddress;
        String permanentAddress = "Moscow village " + generateRandomDate.getCurrentAddress;

        textBoxPage.openTextBoxPage()
                .setName(firstName)
                .setUserEmail(email)
                .setCurrentAddress(currentAddress)
                .setPermanentAddress(permanentAddress)
                .submit();

        checkTextBoxPage = new CheckTextBoxPage();
        checkTextBoxPage.checkName(firstName)
                .checkEmail(email)
                .checkCurrentAddress(currentAddress)
                .checkPermanentAddress(permanentAddress);
    }
}
