package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.ui.elements.NewsScreen;
import ru.iteco.fmhandroid.ui.utils.Utils;

public class NewsSteps {
    NewsScreen NewsScreen = new NewsScreen();

    public void isNewsScreen() {
        Allure.step("Удиться что это раздел новостей");
        NewsScreen.news.check(matches(isDisplayed()));
        NewsScreen.buttonSort.check(matches(isDisplayed()));
    }

    public String getFirstNewsTitle() {
        Allure.step("Получить заголовок первой новости");
        return Utils.TextHelpers.getText(NewsScreen.firstNews);
    }

    public String getLastNewsTitle() {
        Allure.step("Получить заголовок последней новости");
        return Utils.TextHelpers.getText(NewsScreen.lastNews);
    }

    public String getFirstNewsAgainTitle() {
        Allure.step("Получить заголовок первой новости снова");
        return Utils.TextHelpers.getText(NewsScreen.firstNewsAgain);
    }

    public void clickSortButton() {
        Allure.step("Кликнуть отсортировать");
        NewsScreen.buttonSort.perform(click());
    }

    public void goToControlPanel() {
        Allure.step("Перейти на главную панель");
        NewsScreen.buttonControlPanel.perform(click());
        NewsScreen.controlPanel.check(matches(isDisplayed()));
    }

    public void openFilter() {
        Allure.step("Открыть фильтр");
        NewsScreen.buttonFilter.perform(click());
    }

    public void checkFirstNewsDate(String text) {
        Allure.step("Проверить дату первой новости");
        NewsScreen.firstNewsDate.check(matches(withText(text)));
    }

}
