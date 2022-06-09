package ru.iteco.fmhandroid.ui;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withChild;
import static androidx.test.espresso.matcher.ViewMatchers.withEffectiveVisibility;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static ru.iteco.fmhandroid.ui.utils.Utils.checkClaimStatus;
import static ru.iteco.fmhandroid.ui.utils.Utils.getCurrentDate;import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withChild;
import static androidx.test.espresso.matcher.ViewMatchers.withEffectiveVisibility;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static ru.iteco.fmhandroid.ui.utils.Utils.checkClaimStatus;
import static ru.iteco.fmhandroid.ui.utils.Utils.getCurrentDate;
import static ru.iteco.fmhandroid.ui.utils.Utils.getCurrentTime;
import static ru.iteco.fmhandroid.ui.utils.Utils.isDisplayedWithSwipe;

import android.os.SystemClock;

import androidx.test.espresso.NoMatchingViewException;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.rule.ActivityTestRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.NoSuchElementException;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.junit4.DisplayName;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.steps.AboutSteps;
import ru.iteco.fmhandroid.ui.steps.AuthorizationSteps;
import ru.iteco.fmhandroid.ui.steps.ClaimsSteps;
import ru.iteco.fmhandroid.ui.steps.CommonSteps;
import ru.iteco.fmhandroid.ui.steps.ControlPanelSteps;
import ru.iteco.fmhandroid.ui.steps.CreateClaimSteps;
import ru.iteco.fmhandroid.ui.steps.CreateNewsSteps;
import ru.iteco.fmhandroid.ui.steps.EditClaimSteps;
import ru.iteco.fmhandroid.ui.steps.MainSteps;
import ru.iteco.fmhandroid.ui.steps.NewsFilterSteps;
import ru.iteco.fmhandroid.ui.steps.NewsSteps;
import ru.iteco.fmhandroid.ui.steps.ThematicQuotesSteps;

@RunWith(AllureAndroidJUnit4.class)
public class AppActivityTest {
    AuthorizationSteps AuthorizationSteps = new AuthorizationSteps();
    MainSteps MainSteps = new MainSteps();
    NewsSteps NewsSteps = new NewsSteps();
    ClaimsSteps ClaimsSteps = new ClaimsSteps();
    EditClaimSteps EditClaimSteps = new EditClaimSteps();
    CreateClaimSteps CreateClaimSteps = new CreateClaimSteps();
    CommonSteps CommonSteps = new CommonSteps();
    ControlPanelSteps ControlPanelSteps = new ControlPanelSteps();
    CreateNewsSteps CreateNewsSteps = new CreateNewsSteps();
    NewsFilterSteps NewsFilterSteps = new NewsFilterSteps();
    AboutSteps AboutSteps = new AboutSteps();
    ThematicQuotesSteps ThematicQuotesSteps = new ThematicQuotesSteps();

    public static String newsTitleString = "Некий заголовок" + getCurrentDate() + "T" + getCurrentTime();
    public static String newsDescriptionString = "Пробе пера" + getCurrentDate() + "T" + getCurrentTime();
    public static String newNewsTitle = "Чудо чудесное" + getCurrentDate() + "T" + getCurrentTime();
    String newsPublicationDate = getCurrentDate();
    String newsTime = getCurrentTime();

    @Rule
    public ActivityTestRule<AppActivity> mActivityTestRule = new ActivityTestRule<>(AppActivity.class);

    @Before
    public void loginCheck() {
        SystemClock.sleep(7000);
        try {
            AuthorizationSteps.isAuthorizationScreen();
        } catch (NoMatchingViewException e) {
            return;
        }
        AuthorizationSteps.enterLogin("login2");
        AuthorizationSteps.enterPassword("password2");
        AuthorizationSteps.signIn();
        SystemClock.sleep(2000);
    }

   

    @Test
    @DisplayName("Открытие экрана новостей")
    public void openAllNews() {
        MainSteps.openAllNews();
        NewsSteps.isNewsScreen();
    }
    
     @Test
    @DisplayName("Разворачивание и сворачивание блока новостей и объявлений")
    public void expandAll() {
        MainSteps.expandAllNews();
        MainSteps.allNewsNotDisplayed();
        MainSteps.expandAllClaims();
        MainSteps.allClaimsNotDisplayed();

        MainSteps.expandAllNews();
        MainSteps.allNewsDisplayed();
        MainSteps.expandAllClaims();
        MainSteps.allClaimsDisplayed();
    }

    @Test
    @DisplayName("Открытие экрана объявлений")
    public void openAllClaims() {
        MainSteps.openAllClaims(); 
        ClaimsSteps.isClaimsScreen();
    }

    @Test
    @DisplayName("Разворачивание и сворачивание одной новости")
    public void expandSingleNews() {
        MainSteps.expandSingleNews();
        MainSteps.collapseSingleNews();
    }

    @Test
    @DisplayName("Открытие объявления и возврат из нее")
    public void openSingleClaim() {
        MainSteps.openSingleClaim();
        EditClaimSteps.isClaimsEditScreen();
        EditClaimSteps.backFromClaim();
        MainSteps.isMainScreen();
    }

    @Test
    @DisplayName("Создание объявления")
    public void createClaim() {
        String claimTitleString = "Заголовок" + getCurrentDate() + "T" + getCurrentTime();
        String newClaimTitleString = "Описание" + getCurrentDate();
        String currentDate = getCurrentDate();
        String currentTime = getCurrentTime();
        MainSteps.createClaim();
        SystemClock.sleep(2000); 

        CreateClaimSteps.isCreateClaimsScreen();
        CreateClaimSteps.checkClaimTitleLength();

        CommonSteps.clickSave();
        CreateClaimSteps.checkToastEmptyFields();
        CommonSteps.clickOK();

        CreateClaimSteps.enterClaimTitle(claimTitleString);
        CreateClaimSteps.selectExecutor();
        CreateClaimSteps.enterClaimDate(currentDate);
        CreateClaimSteps.enterClaimTime(currentTime);
        CreateClaimSteps.enterClaimDescription(newClaimTitleString);

        CommonSteps.clickCancel();
        CommonSteps.clickCancelText();
        CreateClaimSteps.isCreateClaimsScreen();

        CommonSteps.clickCancel();
        CommonSteps.clickOK();
        MainSteps.isMainScreen();

        MainSteps.createClaim();
        CreateClaimSteps.isCreateClaimsScreen();
        CreateClaimSteps.enterClaimTitle(claimTitleString);
        CreateClaimSteps.selectExecutor();
        CreateClaimSteps.enterClaimDate(currentDate);
        CreateClaimSteps.enterClaimTime(currentTime);
        CreateClaimSteps.enterClaimDescription(newClaimTitleString);
        CommonSteps.clickSave();
        SystemClock.sleep(1000);
        MainSteps.openAllClaims();
    }

     
    @Test
    @DisplayName("Фильтрация объявлений")
    public void filteringClaims() {
        MainSteps.openAllClaims();
        ClaimsSteps.openFiltering();
        ClaimsSteps.clickCheckboxInProgress();
        ClaimsSteps.clickCancel();
        ClaimsSteps.openFiltering();
        ClaimsSteps.checkCheckboxInProgress(true);

        ClaimsSteps.clickCheckboxInProgress();
        ClaimsSteps.clickOK();
        checkClaimStatus("Open");
        ClaimsSteps.isClaimsScreen();

        ClaimsSteps.openFiltering();
        ClaimsSteps.clickCheckboxOpen();
        ClaimsSteps.checkCheckboxOpen(false);
        ClaimsSteps.clickCheckboxInProgress();
        ClaimsSteps.checkCheckboxInProgress(true);
        ClaimsSteps.clickOK();
        checkClaimStatus("In progress");
        ClaimsSteps.isClaimsScreen();

        ClaimsSteps.openFiltering();
        ClaimsSteps.clickCheckboxExecuted();
        ClaimsSteps.checkCheckboxExecuted(true);
        ClaimsSteps.clickCheckboxInProgress();
        ClaimsSteps.checkCheckboxInProgress(false);
        ClaimsSteps.clickOK();
        checkClaimStatus("Executed");
        ClaimsSteps.isClaimsScreen();

        ClaimsSteps.openFiltering();
        ClaimsSteps.clickCheckboxCancelled();
        ClaimsSteps.checkCheckboxCancelled(true);
        ClaimsSteps.clickCheckboxExecuted();
        ClaimsSteps.checkCheckboxExecuted(false);
        ClaimsSteps.clickOK();
        checkClaimStatus("Canceled");
        ClaimsSteps.isClaimsScreen();
    }

    @Test
    @DisplayName("Открытие экрана объявлений из меню и переход к экрану создания объявления")
    public void claimScreen() { 
        CommonSteps.goToScreen("Claims");
        ClaimsSteps.isClaimsScreen();

        ClaimsSteps.createClaim();
        CreateClaimSteps.isCreateClaimsScreen();
    }

    @Test
    @DisplayName("Сортировка новостей на экране новостей")
    public void newsScreenSorting() {
        CommonSteps.goToScreen("News");
        NewsSteps.isNewsScreen();

        String firstNews = NewsSteps.getFirstNewsTitle();
        NewsSteps.clickSortButton();
        String lastNews = NewsSteps.getLastNewsTitle();
        NewsSteps.clickSortButton();
        String firstNewsAgain = NewsSteps.getFirstNewsAgainTitle();
        assertEquals(firstNews, firstNewsAgain);
        assertNotEquals(firstNews, lastNews);
    }

    @Test
    @DisplayName("Сортировка новостей на экране управления")
    public void controlPanelSorting() {
        CommonSteps.goToScreen("News");
        NewsSteps.isNewsScreen();

        NewsSteps.goToControlPanel();

        String firstNews = NewsSteps.getFirstNewsTitle();
        String firstPublicationDate = ControlPanelSteps.getFirstNewsPublicationDate();
        String firstCreationDate = ControlPanelSteps.getFirstNewsCreationDate();
        NewsSteps.clickSortButton();
        String lastPublicationDate = ControlPanelSteps.getLastNewsPublicationDate();
        NewsSteps.clickSortButton();
        String firstNewsAgain = NewsSteps.getFirstNewsAgainTitle();
        String firstPublicationDateAgain = ControlPanelSteps.getFirstNewsPublicationDateAgain();
        String firstCreationDateAgain = ControlPanelSteps.getFirstNewsCreationDateAgain();
        assertEquals(firstNews, firstNewsAgain);
        assertEquals(firstPublicationDate, firstPublicationDateAgain);
        assertEquals(firstCreationDate, firstCreationDateAgain);
        assertNotEquals(firstPublicationDate, lastPublicationDate);
    }

    @Test
    @DisplayName("Создание новости")
    public void controlPanelCreateNews() {
        CommonSteps.goToScreen("News");
        NewsSteps.isNewsScreen();

        NewsSteps.goToControlPanel();

        ControlPanelSteps.createNews();
        CreateNewsSteps.isCreateNewsScreen();

        CreateNewsSteps.selectNewsCategory();
        CreateNewsSteps.enterNewsTitle(newsTitleString);
        CommonSteps.clickCancel();
        CommonSteps.clickCancelText();
        CreateNewsSteps.checkNewsTitle(newsTitleString);

        CommonSteps.clickCancel();
        CommonSteps.clickOK();
        ControlPanelSteps.isControlPanel();

        ControlPanelSteps.createNews();
        CreateNewsSteps.isCreateNewsScreen();
        CreateNewsSteps.selectNewsCategory();
        CreateNewsSteps.enterNewsTitle(newsTitleString);
        CreateNewsSteps.enterNewsPublicationDate(newsPublicationDate);
        CreateNewsSteps.enterNewsTime(newsTime);
        CreateNewsSteps.enterNewsDescription(newsDescriptionString);
        CreateNewsSteps.checkNewsSwitcher();

        CommonSteps.clickSave();
        ControlPanelSteps.isControlPanel();
        if (isDisplayedWithSwipe(onView(withText(newsTitleString)), 1, true)) {
            onView(withText(newsTitleString)).check(matches(isDisplayed()));
        }

        onView(allOf(withId(R.id.delete_news_item_image_view), withParent(withParent(allOf(withId(R.id.news_item_material_card_view), withChild(withChild(withText(newsTitleString)))))))).perform(click());
        CommonSteps.clickOK();
    }


    @Test
    @DisplayName("Сортировка новостей")
    public void newsScreenFiltering() {
        CommonSteps.goToScreen("News");
        NewsSteps.isNewsScreen();

        NewsSteps.goToControlPanel();
        ControlPanelSteps.isControlPanel();

        ControlPanelSteps.createNews();
        CreateNewsSteps.isCreateNewsScreen();
        CreateNewsSteps.selectNewsCategory();
        CreateNewsSteps.enterNewsTitle(newsTitleString);
        CreateNewsSteps.enterNewsPublicationDate(newsPublicationDate);
        CreateNewsSteps.enterNewsTime(newsTime);
        CreateNewsSteps.enterNewsDescription(newsDescriptionString);
        CreateNewsSteps.checkNewsSwitcher();

        CommonSteps.clickSave();
        ControlPanelSteps.isControlPanel();

        CommonSteps.goToScreen("News");
        NewsSteps.isNewsScreen();

        NewsSteps.openFilter();
        NewsFilterSteps.enterPublishDateStart(newsPublicationDate);
        NewsFilterSteps.enterPublishDateEnd(newsPublicationDate);
        NewsFilterSteps.clickFilter();

        NewsSteps.checkFirstNewsDate(newsPublicationDate);

        NewsSteps.goToControlPanel();
        ControlPanelSteps.isControlPanel();

        NewsSteps.openFilter();
        NewsFilterSteps.enterPublishDateStart(newsPublicationDate);
        NewsFilterSteps.enterPublishDateEnd(newsPublicationDate);
        NewsFilterSteps.clickFilter();

        ControlPanelSteps.checkFirstPublicationDate(newsPublicationDate);

        ControlPanelSteps.clickEditNews(); 
        CreateNewsSteps.clickNewsSwitcher();
        CommonSteps.clickSave();

        NewsSteps.openFilter();
        NewsFilterSteps.enterPublishDateStart(newsPublicationDate);
        NewsFilterSteps.enterPublishDateEnd(newsPublicationDate);
        NewsFilterSteps.clickCheckboxActive();
        NewsFilterSteps.checkCheckboxActive(false);
        NewsFilterSteps.checkCheckboxNotActive(true);
        NewsFilterSteps.clickFilter();

        ControlPanelSteps.checkFirstPublicationDateNotActive(newsPublicationDate);
        ControlPanelSteps.checkNewsStatus();

        ControlPanelSteps.checkNewsStatusNotActive();
        CreateNewsSteps.clickNewsSwitcher();
        CommonSteps.clickSave();


}
      @Test
    @DisplayName("Редактирование и удаление новости")
    public void newsEditingDeleting() {
        CommonSteps.goToScreen("News");
        NewsSteps.isNewsScreen();

        NewsSteps.goToControlPanel();
        ControlPanelSteps.isControlPanel();

        ControlPanelSteps.createNews();
        CreateNewsSteps.isCreateNewsScreen();
        CreateNewsSteps.selectNewsCategory();
        CreateNewsSteps.enterNewsTitle(newsTitleString);
        CreateNewsSteps.enterNewsPublicationDate(newsPublicationDate);
        CreateNewsSteps.enterNewsTime(newsTime);
        CreateNewsSteps.enterNewsDescription(newsDescriptionString);
        CreateNewsSteps.checkNewsSwitcher();

        CommonSteps.clickSave();
        ControlPanelSteps.isControlPanel();

        ControlPanelSteps.checkNewsDescription(true);
        ControlPanelSteps.clickNewsTitle();
        SystemClock.sleep(1500);
        ControlPanelSteps.checkNewsDescription(false);

        ControlPanelSteps.clickEditThisNews();
        CreateNewsSteps.isEditNewsScreen();
        CreateNewsSteps.checkNewsTitle(newsTitleString);
        CreateNewsSteps.enterNewsTitle(newNewsTitle);
        CommonSteps.clickSave();

        ControlPanelSteps.isControlPanel();
        if (isDisplayedWithSwipe(onView(withText(newNewsTitle)), 1, true)) {
            onView(withText(newNewsTitle)).check(matches(isDisplayed()));
        }

        ControlPanelSteps.clickDeleteThisNews();
        CommonSteps.clickOK(); 
        SystemClock.sleep(1500);
        if (isDisplayedWithSwipe(onView(withText(newNewsTitle)), 1, false)) {
            throw new NoSuchElementException("Not delete!");
        }
    }

    @Test
    @DisplayName("Открытие экрана о приложение и возврат на главный экран")
    public void aboutScreenAndBackToMain() {
        CommonSteps.goToScreen("About");
        AboutSteps.checkEverythingYouWant();
        AboutSteps.goBack();
        MainSteps.isMainScreen();
    }

    @Test
    @DisplayName("Открытие экрана тематических цитат и взаимодействие с цитатами")
    public void thematicQuotes() {
        CommonSteps.goToThematicQuotes();
        ThematicQuotesSteps.checkAll();
        ThematicQuotesSteps.expandQuote();
        ThematicQuotesSteps.collapseQuote();
    }
}

