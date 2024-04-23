package com.example.todoscheck;

import com.codeborne.selenide.Configuration;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.chrome.ChromeOptions;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Condition.*;

import static com.codeborne.selenide.Selenide.*;

public class MainPageTest {
    MainPage mainPage = new MainPage();

    @BeforeAll
    public static void setUpAll() {
        Configuration.browserSize = "1280x800";
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @BeforeEach
    public void setUp() {
        Configuration.browserCapabilities = new ChromeOptions().addArguments("--remote-allow-origins=*");
        open("https://todomvc.com/examples/react/dist/");
    }

    @BeforeEach
    public void createTask() {
        String taskName = RandomStringUtils.randomAlphabetic(5);
        mainPage.toDoInput.setValue("taskName");
        mainPage.toDoInput.pressEnter();
        mainPage.toDoItemLabel.shouldHave(text("taskName"));
    }

    @Test
    public void createTaskAndCheckName() {
        mainPage.toDoItemLabel.shouldHave(text("taskName"));
    }

    @Test
    public void deleteIncompleteTaskWithXIcon() {
        mainPage.toDoItemDeleteTaskButton.shouldNotBe(visible);
        mainPage.toDoItemLabel.hover();
        mainPage.toDoItemDeleteTaskButton.shouldBe(visible);
        mainPage.toDoItemDeleteTaskButton.click();
        mainPage.toDoItemLabel.shouldNot(exist);
    }

    @Test
    public void changeTaskStatus() {
        mainPage.toDoItemToggleCheckBox.click();
        mainPage.toDoItemToggleCheckBox.shouldBe(checked);
    }

    @Test
    public void deleteCompletedTaskWithXIcon() {
        mainPage.toDoItemDeleteTaskButton.shouldNotBe(visible);
        mainPage.toDoItemToggleCheckBox.click();
        mainPage.toDoItemLabel.hover();
        mainPage.toDoItemDeleteTaskButton.shouldBe(visible);
        mainPage.toDoItemDeleteTaskButton.click();
        mainPage.toDoItemLabel.shouldNot(exist);
    }

    @Test
    public void deleteCompleteTaskWithClearCompletedButton() {
        mainPage.toDoItemToggleCheckBox.click();
        mainPage.clearCompletedButton.shouldBe(visible);
        mainPage.clearCompletedButton.click();
        mainPage.toDoItemLabel.shouldNot(exist);
    }

    @Test
    public void deleteIncompleteTaskWithClearCompletedButton() {
        mainPage.clearCompletedButton.shouldBe(visible);
        mainPage.clearCompletedButton.shouldBe(disabled);
        mainPage.toDoItemLabel.should(exist);
    }

    @Test
    public void createEmptyTask() {
        mainPage.toDoItemToggleCheckBox.click();
        mainPage.clearCompletedButton.click();
        mainPage.toDoInput.setValue(" ");
        mainPage.toDoInput.pressEnter();
        mainPage.toDoItemLabel.shouldNotBe(visible);
    }
}
