package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withEffectiveVisibility;
import io.qameta.allure.kotlin.Allure;
import static org.hamcrest.CoreMatchers.not;

import android.os.SystemClock;
 
import androidx.test.espresso.matcher.ViewMatchers;

import ru.iteco.fmhandroid.ui.elements.MainScreen;

public class MainSteps {
    MainScreen MainScreen = new MainScreen();

    public void isMainScreen() {
        Allure.step("убедиться что это главная страница");
        MainScreen.allNews.check(matches(isDisplayed()));
        MainScreen.allClaims.check(matches(isDisplayed()));
    }

    public void expandAllNews() {
        Allure.step("Развернуть все новости");
        MainScreen.expandAllNews.check(matches(isDisplayed()));
        MainScreen.expandAllNews.perform(click());
    }

    public void expandAllClaims() {
        Allure.step("Развернуть все объявления");
        MainScreen.expandClaims.check(matches(isDisplayed()));
        MainScreen.expandClaims.perform(click());
    }

    public void allNewsNotDisplayed() {
        Allure.step("Проверить непоказанные новости");
        MainScreen.allNews.check(matches(not(isDisplayed())));
    }

    public void allNewsDisplayed() {
        Allure.step("Проверить все отображенные новости");
        MainScreen.allNews.check(matches(isDisplayed()));
    }

    public void allClaimsNotDisplayed() {
        Allure.step("Проверить неразвернутые объявления");
        MainScreen.allClaims.check(matches(not(isDisplayed())));
    }

    public void allClaimsDisplayed() {
        Allure.step("Проверить отображенные объявления");
        MainScreen.allClaims.check(matches(isDisplayed()));
    }

    public void openAllNews() {
        Allure.step("Открыть все новости");
        MainScreen.allNews.check(matches(isDisplayed()));
        MainScreen.allNews.perform(click());
    }

    public void openAllClaims() {
        Allure.step("Открыть все объявления");
        MainScreen.allClaims.check(matches(isDisplayed()));
        MainScreen.allClaims.perform(click());
    }

    public void expandSingleNews() {
        Allure.step("Развернуть одну новость");
        MainScreen.expandSingleNews.perform(actionOnItemAtPosition(0, click()));
        MainScreen.newsDescription.check(matches(isDisplayed()));
    }

    public void collapseSingleNews() {
        Allure.step("Закрыть одну новость");
        MainScreen.categoryIcon.perform(click());
        MainScreen.newsDescriptionAfterCollapse.check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)));
    }

    public void openSingleClaim() {
        Allure.step("Развернуть одно объявление");
        MainScreen.firstClaimExecutorName.perform(click());
    }

    public void createClaim() { 
        Allure.step("Создать объяление");
        MainScreen.addNewClaimButton.perform(click());
        SystemClock.sleep(1000);
    }
    }
