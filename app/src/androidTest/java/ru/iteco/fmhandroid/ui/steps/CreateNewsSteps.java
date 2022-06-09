package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import static org.hamcrest.Matchers.allOf;

import ru.iteco.fmhandroid.ui.elements.CreateNewsScreen;

public class CreateNewsSteps {

    CreateNewsScreen CreateNewsScreen = new CreateNewsScreen();

    public void isCreateNewsScreen() {
        Allure.step("Создать новость");
        CreateNewsScreen.title.check(matches(withText("Creating")));
        CreateNewsScreen.subTitle.check(matches(withText("News")));
    }

    public void isEditNewsScreen() {
        Allure.step("Отредактировать новость");
        CreateNewsScreen.title.check(matches(withText("Editing")));
        CreateNewsScreen.subTitle.check(matches(withText("News")));
    }

    public void selectNewsCategory() {
        Allure.step("Выбрать категорию");
        CreateNewsScreen.categoryList.perform(click());
        CreateNewsScreen.newsTitle.perform(click());
    }

    public void enterNewsTitle(String text) {
        Allure.step("Ввести заголовок новости");
        CreateNewsScreen.newsTitle.perform(replaceText(text), closeSoftKeyboard());
    }

    public void enterNewsPublicationDate(String text) {
        Allure.step("Ввести дату публикации новости");
        CreateNewsScreen.newsDate.perform(replaceText(text));
    }

    public void enterNewsTime(String text) {
        Allure.step("Ввести время новости");
        CreateNewsScreen.newsTime.perform(replaceText(text));
    }

    public void enterNewsDescription(String text) {
        Allure.step("Ввести описание новости");
        CreateNewsScreen.newsDescription.perform(replaceText(text), closeSoftKeyboard());
    }

    public void checkNewsTitle(String text) {
        Allure.step("Проверить заголовок новости");
        CreateNewsScreen.newsTitle.check(matches(withText(text))); 
    }

    public void checkNewsSwitcher() {
        Allure.step("Проверить переключатель новости");
        CreateNewsScreen.newsSwitcher.check(matches(allOf(withText("Active"), isDisplayed())));
    }

    public void clickNewsSwitcher() {
        Allure.step("Кликнуть на переключатель новости"); 
        CreateNewsScreen.newsSwitcher.perform(click());
    }

}
