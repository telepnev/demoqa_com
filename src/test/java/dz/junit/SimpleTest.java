package dz.junit;

import org.junit.jupiter.api.*;


@DisplayName("Тесты на email ")
public class SimpleTest {
    @Test
    @Tag("WEB")
    @DisplayName("Письмо должно быть отправлено новому юзеру")
    public void emailShoudbeSentNewUser() {
        System.out.println("Письмо должно быть отправлено новому юзеру");
    }

    @Test
    @Tag("WEB")
    @DisplayName("Письмо должно быть отправлено за баненому юзеру")
    public void emailShoudbeSentBannerUser() {
        System.out.println("Письмо должно быть отправлено за баненому юзеру");
    }

    @Test
    @Tags(
            {
                    @Tag("SMOKE"),
                    @Tag("INTEGRATION")
            }
    )
    @DisplayName("Письмо должно быть отправлено за баненому юзеру")
    public void emailShoudbeSentBanner() {
        System.out.println("Письмо должно быть отправлено за баненому юзеру");
    }

    @Disabled("Jira - 12314324")
    @Test
    @Tag("API")
    @DisplayName("Письмо должно быть отправлено в случаи изменения платежной системы")
    public void emailShoudbeSentChangePaimant() {
        System.out.println("Письмо должно быть отправлено в случаи изменения платежной системы");
        throw new AssertionError("Падаем!!!");
    }

}
