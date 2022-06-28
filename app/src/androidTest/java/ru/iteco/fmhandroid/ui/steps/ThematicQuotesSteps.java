package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.Matchers.allOf;
import io.qameta.allure.kotlin.Allure; 
import ru.iteco.fmhandroid.ui.elements.ThematicQuotesScreen;

public class ThematicQuotesSteps {
    ThematicQuotesScreen ThematicQuotesScreen = new ThematicQuotesScreen();

    public void checkAll() {
        Allure.step("проверить все цитаты");
        ThematicQuotesScreen.title.check(matches(allOf(withText("Love is all"), isDisplayed())));
        ThematicQuotesScreen.icon.check(matches(isDisplayed()));
        ThematicQuotesScreen.thematicTitle.check(matches(isDisplayed()));
    }

    public void expandQuote() {
        Allure.step("Развернуть цитату");
        ThematicQuotesScreen.thematicTitleClickable.perform(click());
        ThematicQuotesScreen.thematicDescription.check(matches(isDisplayed()));
    }

    public void collapseQuote() {
        Allure.step("Свернуть цитату");
        ThematicQuotesScreen.thematicTitleClickable2.perform(click());
        ThematicQuotesScreen.thematicDescriptionAfterClick.check(matches(not(isDisplayed())));
    }

}
