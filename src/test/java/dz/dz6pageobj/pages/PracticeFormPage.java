package dz.dz6pageobj.pages;

import com.codeborne.selenide.SelenideElement;
import dz.dz6pageobj.pages.component.CalendarComponent;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormPage {
    private String url = "/automation-practice-form";
    protected SelenideElement submit = $("#submit");
    protected SelenideElement firstName = $("#firstName");
    protected SelenideElement lastName = $("#lastName");
    protected SelenideElement userEmail = $("#userEmail");
    protected SelenideElement userNumber = $("#userNumber");


    CalendarComponent calendarComp = new CalendarComponent();

    public void setDateOfBirth(String day, String month, String year) {
        calendarComp.setDate(day, month, year);
    }

    public void openPracticeFormPage() {
        open(url);
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
    }


    public void submit() {
        $(submit).click();
    }

    public void setStateandCity(String state, String city) {
        $("#state").click();
        $x("//div[text()='" + state + "']").click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText(city)).click();
    }

    public void setCurrentAddress(String address) {
        $("#currentAddress").setValue(address);
        $("#submit").scrollTo();
    }

    public void upLoadImg(String fileName) {
        $("#uploadPicture").uploadFromClasspath(fileName);
    }

    public void setHobbiesAsMusic() {
        $x("//label[text()='Music']").click();
    }

    public void setSubjects(String subject) {
        $("#subjectsContainer").click();
        $("#subjectsInput").setValue(subject).pressEnter();
    }



    public void setMobile(String phone) {
        $(userNumber).setValue(phone);
    }

    public void setGender(String gender) {
        $x("//label[text()='" + gender + "']").click();
    }

    public void setEmail(String mail) {
        $(userEmail).setValue(mail);
    }

    public void setFio(String nameFirst, String nameLast) {
        $(firstName).setValue(nameFirst);
        $(lastName).setValue(nameLast);
    }

}
