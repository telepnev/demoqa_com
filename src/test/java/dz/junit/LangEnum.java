package dz.junit;

public enum LangEnum {
    RU("Что такое Selenide?"),
    EN("What is Selenide?");

    public final String description;

    LangEnum(String description) {
        this.description = description;
    }
}
