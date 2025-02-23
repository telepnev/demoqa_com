package dz.practiceForm.tests;

import dz.practiceForm.base.BaseTest;
import dz.practiceForm.pages.CheckTextBoxPage;
import dz.practiceForm.pages.TextBoxPage;
import dz.practiceForm.util.GenerateRandomDate;
import org.junit.jupiter.api.Test;

public class TextBox extends BaseTest {
    private TextBoxPage textBoxPage = new TextBoxPage();
    private CheckTextBoxPage checkTextBoxPage = new CheckTextBoxPage();
    private GenerateRandomDate generateRandomDate = new GenerateRandomDate();

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
