import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.selector.ByText;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeForm {
    @BeforeAll
    static void setUp() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    public void practiceFormTest() {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        $("#firstName").setValue("Evgen");
        $("#lastName").setValue("Pupkin");
        $("#userEmail").setValue("pupkin@mail.com");
        $x("//label[text()='Male']").click();
        $("#userNumber").setValue("1234567890");

        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOptionContainingText("May");
        $(".react-datepicker__year-select").selectOptionContainingText("1945");
        $x("//div[@class='react-datepicker__week']/div[text()='9']").click();

        $("#subjectsContainer").click();
        $("#subjectsInput").setValue("Art").pressEnter();
        $x("//label[text()='Music']").click();
        $("#uploadPicture").uploadFromClasspath("Screenshot.png");
        $("#currentAddress").setValue("Evgen str. Red Will");
        $("#submit").scrollTo();

        $("#state").click();
        $x("//div[text()='Uttar Pradesh']").click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Agra")).click();
        $("#submit").click();

        // assertions table
        $(".table").$(byText("Student Name")).parent().shouldHave(text("Evgen Pupkin"));
        $(".table").$(byText("Student Email")).parent().shouldHave(text("pupkin@mail.com"));
        $(".table").$(byText("Gender")).parent().shouldHave(text("Male"));
        $(".table").$(byText("Mobile")).parent().shouldHave(text("1234567890"));
        $(".table").$(byText("Date of Birth")).parent().shouldHave(text("9 May,1945"));
        $(".table").$(byText("Subjects")).parent().shouldHave(text("Art"));
        $(".table").$(byText("Hobbies")).parent().shouldHave(text("Music"));
        $(".table").$(byText("Picture")).parent().shouldHave(text("Screenshot.png"));
        $(".table").$(byText("Address")).parent().shouldHave(text("Evgen str. Red Will"));
        $(".table").$(byText("State and City")).parent().shouldHave(text("Uttar Pradesh Agra"));

        $("#closeLargeModal").click();
    }
}
