import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.itemWithText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

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

        String expectedJunitText = """
                @ExtendWith({SoftAssertsExtension.class})
                class Tests {
                  @Test
                  void test() {
                    Configuration.assertionMode = SOFT;
                    open("page.html");
                
                    $("#first").should(visible).click();
                    $("#second").should(visible).click();
                  }
                }
                """;

        $("[placeholder='Search or jump to...']").click();
        $("#query-builder-test").setValue("Selenide").pressEnter();
        $("[data-testid='results-list']").shouldHave(text("Selenide"));
        $$("[data-testid='results-list'] span").findBy(text("Selenide")).click();
        $("[data-content='Wiki']").click();
        $$(".markdown-body ul li a").shouldHave(itemWithText("Soft assertions"));

        $$(".markdown-body ul li a").findBy(text("Soft assertions")).click();
        $("#wiki-body").shouldHave(text(expectedJunitText));

    }
}

