package dz.dz5;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.DragAndDropOptions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class GitHubHover {
    @BeforeAll
    static void setUp() {
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = false;
    }

    @Test
    public void hoverGithubTest() {
        open("https://github.com/");

        $$(".HeaderMenu-nav button").findBy(text("Solutions")).hover();
        $$("ul li a").findBy(text("Enterprises")).click();
        $$("h1").get(3).shouldHave(text("The AI-powered developer platform"));
    }

    @Test
    public void dragAndDropTest() {
        open("https://the-internet.herokuapp.com/drag_and_drop");
        // - так будет работать
       // $("#column-a").dragAndDrop(DragAndDropOptions.to($("#column-b")));

        actions().dragAndDrop($("#column-a"), $("#column-b")).perform();
        $("#column-a").shouldHave(text("B"));
    }
}
