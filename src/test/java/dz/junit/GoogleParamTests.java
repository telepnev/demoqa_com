package dz.junit;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class GoogleParamTests {
    @BeforeAll
    static void setUp() {
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
    }

    @BeforeEach
    public void preConditions() {
        open("https://duckduckgo.com");
    }

    @Test
    @Tag("SMOKE")
    @DisplayName("Проверка поиска и выдача результатов по слову 'selenide' ")
    public void shouldFindSomeText() {
        $("#searchbox_input").setValue("selenide").pressEnter();
        $$(".react-results--main li").shouldHave(sizeGreaterThan(0));
    }

    @ValueSource(strings = {
        "Selenide", "Junit 5"
    })
    @ParameterizedTest(name = "Проверка поиска по слову {0} и выдача карточек ")
    @Tag("SMOKE")
    public void shouldFindSomeTextParamsString(String searchQuery) {
        $("#searchbox_input").setValue(searchQuery).pressEnter();
        $$(".react-results--main li").shouldHave(sizeGreaterThan(0));

    }

    @ValueSource(strings = {
            "Selenide", "Junit 5"
    })
    @ParameterizedTest(name = "Проверка поиска по слову {0} и выдача карточек ")
    @Tag("SMOKE")
    public void shouldFindSomeTextPictures(String searchQuery) {
        $("#searchbox_input").setValue(searchQuery).pressEnter();
        $x("//li/a[text()='Изображения']").click();
        $$(".zci__main .tile").shouldHave(sizeGreaterThan(0));
    }

    @CsvSource(value = {
            "Selenide | https://selenide.org",
            "Junit 5 | https://junit.org"
    }, delimiter = '|')
    @ParameterizedTest(name = "Проверка поиска по слову {0} и в первой карточке должна быть ссылка {1} ")
    @Tag("SMOKE")
    void searchResultsShouldContainExpectedUrl(String searchQuery, String expectedLink) {
        $("#searchbox_input").setValue(searchQuery).pressEnter();
        $("[data-testid='mainline'] li[data-layout='organic']")
                .shouldHave(text(expectedLink));
    }

    @CsvFileSource(resources = "/test_data/searchResultsShouldContainExpectedUrl.csv")
    @ParameterizedTest(name = "Проверка поиска по слову {0} и в первой карточке должна быть ссылка {1} ")
    @Tag("SMOKE")
    void fromFileSearchResultsShouldContainExpectedUrl(String searchQuery, String expectedLink) {
        $("#searchbox_input").setValue(searchQuery).pressEnter();
        $("[data-testid='mainline'] li[data-layout='organic']")
                .shouldHave(text(expectedLink));
    }


}
