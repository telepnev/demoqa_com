package dz.junit;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class EnumProviderTest {
    @EnumSource(LangEnum.class)
    @ParameterizedTest
    public void enumSelenideShouldHaveCorrectDisplayLang(LangEnum langEnum) {
        open("https://selenide.org/");
        $$("#languages a").find(text(langEnum.name())).click();
        $("h3").shouldHave(text(langEnum.description));
    }


    static Stream<Arguments> shouldDispalayCorrectButton() {
        return Stream.of(
                Arguments.of(
                        LangEnum.RU, List.of("С чего начать?", "Док", "ЧАВО",
                                "Блог", "Javadoc", "Пользователи", "Отзывы"
                        )),
                Arguments.of(
                        LangEnum.EN, List.of("Quick start",
                                "Docs", "FAQ", "Blog", "Javadoc", "Users", "Quotes"
                        ))
        );
    }

    @MethodSource
    @ParameterizedTest
    public void shouldDispalayCorrectButton(LangEnum langEnum, List<String> expectedButtons) {
        open("https://selenide.org/");
        $$("#languages a").find(text(langEnum.name())).click();
        $$(".main-menu-pages a").filter(visible)
                .shouldHave(texts(expectedButtons));

        $("h3").shouldHave(text(langEnum.description));
    }
}
