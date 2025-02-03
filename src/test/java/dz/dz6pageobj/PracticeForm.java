package dz.dz6pageobj;

import dz.dz6pageobj.base.BaseTest;
import dz.dz6pageobj.pages.CheckPracticeFormPage;
import dz.dz6pageobj.pages.PracticeFormPage;
import dz.dz6pageobj.pages.component.CalendarComponent;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeForm extends BaseTest {
    private static PracticeFormPage practiceFormPage;
    private static CalendarComponent calendarComponent;
    private static CheckPracticeFormPage checkPracticeFormPage;

    @Test
    public void practiceFormTest() {
        practiceFormPage = new PracticeFormPage();
        calendarComponent = new CalendarComponent();

        practiceFormPage.openPracticeFormPage();
        practiceFormPage.setFio("Evgen", "Pupkin");
        practiceFormPage.setEmail("pupkin@mail.com");
        practiceFormPage.setGender("Male");
        practiceFormPage.setMobile("1234567890");
        calendarComponent.setDate("9", "May", "1945");
        practiceFormPage.setSubjects("Art");
        practiceFormPage.setHobbiesAsMusic();
        practiceFormPage.upLoadImg("Screenshot.png");
        practiceFormPage.setCurrentAddress("Evgen str. Red Will");
        practiceFormPage.setStateandCity("Uttar Pradesh", "Agra");
        practiceFormPage.submit();

        // assertions table
        checkPracticeFormPage = new CheckPracticeFormPage();

        checkPracticeFormPage
                .checkStudentName("Evgen Pupkin")
                .checkStudentEmail("pupkin@mail.com")
                .checkGender("Male")
                .checkMobile("1234567890")
                .checkDateofBirth("9 May,1945")
                .checkSubjects("Art")
                .checkHobbies("Music")
                .checkPicture("Screenshot.png")
                .checkAddress("Evgen str. Red Will")
                .checkStateandCity("Uttar Pradesh Agra");

        checkPracticeFormPage.closeModal();
    }

}
