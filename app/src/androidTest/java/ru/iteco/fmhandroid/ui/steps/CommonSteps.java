package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.action.ViewActions.click;
import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.ui.elements.CommonElements;

public class CommonSteps {

    CommonElements CommonElements = new CommonElements();

    public void logout() {
        Allure.step("разлогиниться из приложения");
        CommonElements.manImage.perform(click()); 
        CommonElements.exitButton.perform(click());
    }

    public void clickSave() {
        Allure.step("Нажать "Сохранить"); 
        CommonElements.buttonSave.perform(click());
    }

    public void clickOK() {
        Allure.step("Нажать "ок"); 
        CommonElements.buttonOkText.perform(click());
    }

    public void clickCancel() {
         Allure.step("Нажать "Отменить"); 
        CommonElements.buttonCancel.perform(click());
    }

    public void clickCancelText() {
         Allure.step("Нажать "Отменить текст"); 
        CommonElements.buttonCancelText.perform(click());
    }

    public void goToThematicQuotes() {
         Allure.step("Перейти в цитаты"); 
        CommonElements.thematicQuotes.perform(click());
    }

    public void goToScreen(String screen) { 
         Allure.step("Перейти на экран"); 
        CommonElements.mainMenu.perform(click());
        switch (screen) {
            case ("Main"):
                CommonElements.menuMain.perform(click());
                break;
            case ("News"):
                CommonElements.menuNews.perform(click());
                break;
            case ("About"):
                CommonElements.menuAbout.perform(click());
                break;
            case ("Claims"):
                CommonElements.menuClaims.perform(click());
                break;
        }
    }
}
