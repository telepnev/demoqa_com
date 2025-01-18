import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.itemWithText;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$$;

public class GithubSearchTest {

    @BeforeAll
    static void setUp() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
    }


    @Test
    public void shouldFindSelenideRepositoryTest() {
        open("https://github.com/");

        $("[placeholder='Search or jump to...']").click();
        $("#query-builder-test").setValue("Selenide").pressEnter();
        $("[data-testid='results-list']").shouldHave(text("Selenide"));
        $$("[data-testid='results-list'] span").findBy(text("Selenide")).click();
        $("[data-content='Wiki']").click();
        $$(".markdown-body ul li a").shouldHave(itemWithText("Soft assertions"));

        $$(".markdown-body ul li a").findBy(text("Soft assertions")).click();
        $$(".heading-element").shouldHave(itemWithText("3. Using JUnit5 extend test class:"));
        $("#user-content-3-using-junit5-extend-test-class").parent().shouldBe(visible);
        $$(".markdown-heading").get(6).shouldBe(exist);

    }
}

