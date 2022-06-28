package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withEffectiveVisibility;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import io.qameta.allure.kotlin.Allure;
import androidx.test.espresso.matcher.ViewMatchers;

import ru.iteco.fmhandroid.ui.elements.ControlPanelScreen;
import ru.iteco.fmhandroid.ui.elements.NewsScreen; 
import ru.iteco.fmhandroid.ui.utils.Utils.TextHelpers;

public class ControlPanelSteps {
    ControlPanelScreen ControlPanelScreen = new ControlPanelScreen();
    NewsScreen NewsScreen = new NewsScreen();

    public String getFirstNewsPublicationDate() {
        Allure.step("Получить первую дату публикации"); 
        return TextHelpers.getText(ControlPanelScreen.firstPublicationDate);
    }
 
    public String getFirstNewsCreationDate() {
        Allure.step("Получить первую дату создания новости"); 
        return TextHelpers.getText(ControlPanelScreen.firstCreationDate);
    }
 
    public String getFirstNewsPublicationDateAgain() {
         Allure.step("Получить первую дату публикации снова"); 
        return TextHelpers.getText(ControlPanelScreen.firstPublicationDateAgain);
    }

    public String getFirstNewsCreationDateAgain() {
         Allure.step("Получить  первую дату создания новости снова"); 
        return TextHelpers.getText(ControlPanelScreen.firstCreationDateAgain);
    }

    public String getLastNewsPublicationDate() {
        Allure.step("Получить последнюю дату публикации новости"); 
        return TextHelpers.getText(ControlPanelScreen.lastPublicationDate);
    }

    public void createNews() {
        Allure.step("Создать новость");
        ControlPanelScreen.buttonCreateNews.perform(click());
    }

    public void isControlPanel() {
        Allure.step("Перейти и убедиться что это главная панель");
        NewsScreen.controlPanel.check(matches(isDisplayed()));
    }

    public void checkFirstPublicationDate(String text) {
        Allure.step("Проверить дату публикации");
        ControlPanelScreen.firstPublicationDate.check(matches(withText(text)));
    }

    public void checkFirstPublicationDateNotActive(String text) {
        Allure.step("Получить первую дату неактивной публикации");
        ControlPanelScreen.firstPublicationDateNotActive.check(matches(withText(text)));
    }

    public void checkFirstPublicationDateActive(String text) {
        Allure.step("Получить первую дату активной публикации");
        ControlPanelScreen.firstPublicationDateActive.check(matches(withText(text)));
    }

    public void checkNewsStatus() {
        Allure.step("Проверить статус новости");
        ControlPanelScreen.newsStatus.check(matches(withText("Not active")));
    }

    public void checkNewsStatusActive() {
        Allure.step("Получить статуст активной новости");
        ControlPanelScreen.newsStatusActive.check(matches(withText("Active")));
    }

    public void clickEditNews() {
        Allure.step("Нажать Отредактировать новость");
        ControlPanelScreen.buttonEditNews.perform(click());
    }

    public void clickEditThisNews() {
        Allure.step("Нажать Отредактировать эту новость");
        ControlPanelScreen.newsEdit.perform(click());
    }

    public void checkNewsStatusNotActive() {
        Allure.step("Проверить что статус новости неактивен");
        ControlPanelScreen.buttonEditNewsNotActive.perform(click());
    }

    public void clickDeleteNews() {
        Allure.step("Нажать удалить новость");
        ControlPanelScreen.buttonDeleteNews.perform(click());
    }

    public void clickDeleteThisNews() {
        Allure.step("Нажать удалить эту новость");
        ControlPanelScreen.newsDelete.perform(click());
    }

    public void clickNewsTitle() {
        Allure.step("Нажать на заголовок новости");
        ControlPanelScreen.newsTitle.perform(click());
    }

    public void checkNewsDescription(boolean visible) { 
        Allure.step("Проверить описние новости");
        if (visible) {
            ControlPanelScreen.newsDescription.check(matches(isDisplayed()));
        } else {
            ControlPanelScreen.newsDescription.check(matches(withEffectiveVisibility(ViewMatchers.Visibility.GONE)));
        }
    }


}
