package dz.dz6pageobj.tests;

import dz.dz6pageobj.base.BaseTest;
import dz.dz6pageobj.pages.CheckPracticeFormPage;
import dz.dz6pageobj.pages.PracticeFormPage;
import dz.dz6pageobj.pages.component.CalendarComponent;
import dz.dz6pageobj.util.GenerateRandomDate;
import org.junit.jupiter.api.Test;

public class PracticeForm extends BaseTest {
    private static PracticeFormPage practiceFormPage = new PracticeFormPage();
    ;
    private static CalendarComponent calendarComponent = new CalendarComponent();
    ;
    private static CheckPracticeFormPage checkPracticeFormPage = new CheckPracticeFormPage();
    private static GenerateRandomDate generateRandomDate = new GenerateRandomDate();

    String firstName = generateRandomDate.getFirstName;
    String lastName = generateRandomDate.getLastName;
    String email = generateRandomDate.getUserEmail;
    String gender = generateRandomDate.getGender;
    String phone = generateRandomDate.getUserPhoneNumber;
    String day = generateRandomDate.getDay;
    String month = generateRandomDate.getMonth;
    String year = generateRandomDate.getYear;
    String state = generateRandomDate.state;
    String city = generateRandomDate.selectCity(state);
    String subject = generateRandomDate.getSubject;
    String hobbies = generateRandomDate.getHobbies;
    String picture = generateRandomDate.getPicture;
    String currentAddress = generateRandomDate.getCurrentAddress;


    @Test
    public void practiceFormTest() {

        practiceFormPage.openPracticeFormPage();
        deletBaner();
        practiceFormPage.setFio(firstName, lastName);
        practiceFormPage.setEmail(email);
        practiceFormPage.setGender(gender);
        practiceFormPage.setMobile(phone);
        calendarComponent.setDate(day, month, year);
        practiceFormPage.setSubjects(subject);
        practiceFormPage.setHobbies(hobbies);
        practiceFormPage.upLoadImg(picture);
        practiceFormPage.setCurrentAddress(currentAddress);
        practiceFormPage.setStateandCity(state, city);
        practiceFormPage.submit();

        // assertions table
        checkPracticeFormPage = new CheckPracticeFormPage();
        checkPracticeFormPage.modalWindowShouldAppear();
        checkPracticeFormPage
                .checkStudentName(firstName + " " + lastName)
                .checkStudentEmail(email)
                .checkGender(gender)
                .checkMobile(phone)
                .checkDateofBirth(day + " " + month + "," + year)
                .checkSubjects(subject)
                .checkHobbies(hobbies)
                .checkPicture(picture)
                .checkAddress(currentAddress)
                .checkStateandCity(state + " " + city);
        checkPracticeFormPage.closeModal();
    }

    @Test
    public void minimumAmountDataTest() {

        practiceFormPage.openPracticeFormPage();
        deletBaner();
        practiceFormPage.setFio(firstName, lastName);
        practiceFormPage.setEmail(email);
        practiceFormPage.setGender(gender);
        practiceFormPage.setMobile(phone);
        calendarComponent.setDate(day, month, year);
        practiceFormPage.submit();

        // assertions table
        checkPracticeFormPage = new CheckPracticeFormPage();
        checkPracticeFormPage.modalWindowShouldAppear();
        checkPracticeFormPage
                .checkStudentName(firstName + " " + lastName)
                .checkStudentEmail(email)
                .checkGender(gender)
                .checkMobile(phone)
                .checkDateofBirth(day + " " + month + "," + year);
        checkPracticeFormPage.closeModal();
    }

    @Test
    public void errorTest() {

        practiceFormPage.openPracticeFormPage();
        deletBaner();
        practiceFormPage.setFio(firstName, lastName);
        practiceFormPage.setEmail(email);
        practiceFormPage.setGender(gender);
        practiceFormPage.setMobile(phone);
        calendarComponent.setDate(day, month, year);
        calendarComponent.clearDate();
        practiceFormPage.submit();

        // assertions table
        checkPracticeFormPage = new CheckPracticeFormPage();
        checkPracticeFormPage.modalWindowShouldBeVizible();
    }

    @Test
    public void negativeSendFormWithoutData() {
        practiceFormPage.openPracticeFormPage();
        deletBaner();
        practiceFormPage.setFio("", "");
        practiceFormPage.submit();

        checkPracticeFormPage = new CheckPracticeFormPage();
        checkPracticeFormPage.modalWindowShouldNotAppear();
    }

}
