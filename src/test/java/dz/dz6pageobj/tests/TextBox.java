package dz.dz6pageobj.tests;

import dz.dz6pageobj.base.BaseTest;
import dz.dz6pageobj.pages.CheckTextBoxPage;
import dz.dz6pageobj.pages.TextBoxPage;
import dz.dz6pageobj.util.GenerateRandomDate;
import org.junit.jupiter.api.Test;

public class TextBox extends BaseTest {
    private static TextBoxPage textBoxPage = new TextBoxPage();
    private static CheckTextBoxPage checkTextBoxPage = new CheckTextBoxPage();;
    private static GenerateRandomDate generateRandomDate = new GenerateRandomDate();

    String firstName = generateRandomDate.getFirstName;
    String email = generateRandomDate.getUserEmail;
    String currentAddress = generateRandomDate.getCurrentAddress;
    String permanentAddress = "Moscow village " + generateRandomDate.getCurrentAddress;

    @Test
    public void textBoxTest() {

        textBoxPage.openTextBoxPage()
                .setName(firstName)
                .setUserEmail(email)
                .setCurrentAddress(currentAddress)
                .setPermanentAddress(permanentAddress)
                .submit();

        checkTextBoxPage.checkName(firstName)
                .checkEmail(email)
                .checkCurrentAddress(currentAddress)
                .checkPermanentAddress(permanentAddress);
    }
}
