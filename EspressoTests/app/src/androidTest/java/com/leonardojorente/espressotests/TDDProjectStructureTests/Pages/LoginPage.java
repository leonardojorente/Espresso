package com.leonardojorente.espressotests.TDDProjectStructureTests.Pages;

import androidx.test.espresso.Espresso;

import com.leonardojorente.espressotests.TDDProjectStructureTests.Utils.EspressoActions;

import static com.leonardojorente.espressotests.TDDProjectStructureTests.ConstantMapping.LoginMapping.INPUT_EMAIL_FIELD;
import static com.leonardojorente.espressotests.TDDProjectStructureTests.ConstantMapping.LoginMapping.INPUT_PASSWORD_FIELD;
import static com.leonardojorente.espressotests.TDDProjectStructureTests.ConstantMapping.LoginMapping.LOGIN_BUTTON;
import static com.leonardojorente.espressotests.TDDProjectStructureTests.ConstantMapping.SelectTestMapping.SELECT_ACTIVITY_SCREEN;

public class LoginPage  extends EspressoActions {

    public LoginPage inputEmail(String email){
        inputTextOnField(email,INPUT_EMAIL_FIELD);
        Espresso.closeSoftKeyboard();
        return this;
    }
    public LoginPage inputPassword(String password){
        inputTextOnField(password, INPUT_PASSWORD_FIELD);
        Espresso.closeSoftKeyboard();
        return this;
    }

    public SelectTestPage finishLogin(){
        clickElement(LOGIN_BUTTON);
        checkElementDisplayed(SELECT_ACTIVITY_SCREEN);
        return new SelectTestPage();
    }

}


