import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBox {

    @BeforeAll
    static void setUp() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    public void textBoxTest() {
        open("/text-box");
        $("#userName").setValue("Evgeny");
        $("#userEmail").setValue("Evgeny@mail.ru");
        $("#currentAddress").setValue("Evgeny str. City-village");
        $("#permanentAddress").setValue("Evgeny str. City-village 777");

        $("#submit").click();

        $("#output").$("#name").shouldHave(text("Evgeny"));
        $("#output").$("#email").shouldHave(text("Evgeny@mail.ru"));

        $("#output #currentAddress").shouldHave(text("Evgeny str. City-village"));
        $("#output #permanentAddress").shouldHave(text("Evgeny str. City-village 777"));

    }
}
