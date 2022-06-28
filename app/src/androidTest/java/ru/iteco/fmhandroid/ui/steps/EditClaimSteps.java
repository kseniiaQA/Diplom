package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import io.qameta.allure.kotlin.Allure;
import static ru.iteco.fmhandroid.ui.utils.Utils.nestedScrollTo;

import ru.iteco.fmhandroid.ui.elements.EditClaimScreen;

public class EditClaimSteps {

    EditClaimScreen EditClaimScreen = new EditClaimScreen();

    public void isClaimsEditScreen() {
        Allure.step("Убедиться что можно отредактироват объявление");
        EditClaimScreen.claimStatus.check(matches(isDisplayed()));
    }

    public void backFromClaim() {
        Allure.step("Уйти назад из раздела объявлений");
        EditClaimScreen.backButton.perform(nestedScrollTo());
        EditClaimScreen.backButton.perform(click());
    }

}
