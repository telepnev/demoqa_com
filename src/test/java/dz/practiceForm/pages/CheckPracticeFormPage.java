package dz.practiceForm.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class CheckPracticeFormPage {

    protected SelenideElement studentName = $(".table").$(byText("Student Name")).parent();
    protected SelenideElement StudentEmail = $(".table").$(byText("Student Email")).parent();
    protected SelenideElement gender = $(".table").$(byText("Gender")).parent();
    protected SelenideElement mobile = $(".table").$(byText("Mobile")).parent();
    protected SelenideElement dateofBirth = $(".table").$(byText("Date of Birth")).parent();
    protected SelenideElement subjects = $(".table").$(byText("Subjects")).parent();
    protected SelenideElement hobbies = $(".table").$(byText("Hobbies")).parent();
    protected SelenideElement picture = $(".table").$(byText("Picture")).parent();
    protected SelenideElement address = $(".table").$(byText("Address")).parent();
    protected SelenideElement stateandCity = $(".table").$(byText("State and City")).parent();


    public CheckPracticeFormPage checkForm(String colm, String text) {
        $(".table").$(byText(colm)).parent().shouldHave(text(text));
        return this;
    }

    public CheckPracticeFormPage checkStudentName(String expectedText) {
        studentName.shouldHave(text(expectedText));
        return this;
    }

    public CheckPracticeFormPage checkStudentEmail(String expectedText) {
        StudentEmail.shouldHave(text(expectedText));
        return this;
    }

    public CheckPracticeFormPage checkGender(String expectedText) {
        gender.shouldHave(text(expectedText));
        return this;
    }

    public CheckPracticeFormPage checkMobile(String expectedText) {
        mobile.shouldHave(text(expectedText));
        return this;
    }

    public CheckPracticeFormPage checkDateofBirth(String expectedText) {
        dateofBirth.shouldHave(text(expectedText));
        return this;
    }

    public CheckPracticeFormPage checkSubjects(String expectedText) {
        subjects.shouldHave(text(expectedText));
        return this;
    }

    public CheckPracticeFormPage checkHobbies(String expectedText) {
        hobbies.shouldHave(text(expectedText));
        return this;
    }

    public CheckPracticeFormPage checkPicture(String expectedText) {
        picture.shouldHave(text(expectedText));
        return this;
    }

    public CheckPracticeFormPage checkAddress(String expectedText) {
        address.shouldHave(text(expectedText));
        return this;
    }

    public CheckPracticeFormPage checkStateandCity(String expectedText) {
        stateandCity.shouldHave(text(expectedText));
        return this;
    }

    public void closeModal() {
        $("#closeLargeModal").click();
    }

    public void modalWindowShouldNotAppear() {
        $("#closeLargeModal").shouldNot(appear);
    }

    public void modalWindowShouldAppear() {
        $("#closeLargeModal").should(appear);
    }

    public void modalWindowShouldBeVizible() {
        $("#closeLargeModal").should(appear);
    }
}
