import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;

public class Simple {

    @Test
    public void openSite() {
        Selenide.open("https://demoqa.com/automation-practice-form");
    }
}
