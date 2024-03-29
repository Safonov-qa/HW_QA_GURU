package ru.SafonovIll.tests.javafakerandpageobjecthw;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import ru.SafonovIll.helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

@Tag("HomeWork")
@Tag("Tg_Bot")

public class TestBase {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = System.getProperty("browser_size","1920x1080");
        Configuration.browser = System.getProperty("browser","chrome");
        Configuration.browserVersion = System.getProperty("browser_version","100.0");
        Configuration.baseUrl = System.getProperty("url","https://demoqa.com");
        Configuration.remote = "https://user1:1234@" + System.getProperty("selenoid_url", "selenoid.autotests.cloud/wd/hub");
        Configuration.pageLoadStrategy = "eager";

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));

        Configuration.browserCapabilities = capabilities;
    }

    @BeforeEach
    void addListener() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }
    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }
}
