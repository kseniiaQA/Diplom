package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isChecked;
import static androidx.test.espresso.matcher.ViewMatchers.isNotChecked;
import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.ui.elements.NewsFilterScreen;

public class NewsFilterSteps {
    NewsFilterScreen NewsFilterScreen = new NewsFilterScreen();

    public void enterPublishDateStart(String text) {
        Allure.step("Ввести дату начала публикации");
        NewsFilterScreen.publishDateStart.perform(replaceText(text));
    }

    public void enterPublishDateEnd(String text) {
        Allure.step("ВВести дату конца публикации");
        NewsFilterScreen.publishDateEnd.perform(replaceText(text));
    }

    public void clickFilter() {
        Allure.step("Нажать отфильтровать");
        NewsFilterScreen.buttonFilter.perform(click());
    }

    public void clickCheckboxActive() {
        Allure.step("Нажать на чекбокс со статусом активный");
        NewsFilterScreen.checkboxActive.perform(click());
    }

    public void clickCheckboxNotActive() {
        Allure.step("Нажать на чекбокс со статусом неактивный");
        NewsFilterScreen.checkboxNotActive.perform(click());
    }

    public void checkCheckboxActive(boolean checked) {
        Allure.step("Проверить активен ли статус");
        if (checked) {
            NewsFilterScreen.checkboxActive.check(matches(isChecked()));
        } else {
            NewsFilterScreen.checkboxActive.check(matches(isNotChecked()));
        }
    }

    public void checkCheckboxNotActive(boolean checked) { 
        Allure.step("Проверить что статус неактивен");
        if (checked) {
            NewsFilterScreen.checkboxNotActive.check(matches(isChecked()));
        } else {
            NewsFilterScreen.checkboxNotActive.check(matches(isNotChecked()));
        }


    }
}
