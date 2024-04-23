package com.example.todoscheck;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class MainPage {
    public SelenideElement toDoInput = $x("//*[@data-testId='text-input']");
    public SelenideElement toDoItemLabel = $x("//*[@data-testId='todo-item-label']");
    public SelenideElement toDoItemDeleteTaskButton = $x("//*[@data-testId='todo-item-button']");
    public SelenideElement toDoItemToggleCheckBox = $x("//*[@data-testId='todo-item-toggle']");
    public SelenideElement clearCompletedButton = $x("/html/body/section/footer/button");

//    public SelenideElement seeDeveloperToolsButton = $x("//*[@data-test-marker='Developer Tools']");
//    public SelenideElement findYourToolsButton = $x("//*[@data-test='suggestion-action']");
//    public SelenideElement toolsMenu = $x("//div[@data-test='main-menu-item' and @data-test-marker = 'Developer Tools']");
//    public SelenideElement searchButton = $("[data-test='site-header-search-action']");
}
