package com.leonardojorente.espressotests.TDDProjectStructureTests.TestScenarios;

import androidx.test.rule.ActivityTestRule;

import com.leonardojorente.espressotests.MainActivity;
import com.leonardojorente.espressotests.TDDProjectStructureTests.Pages.LoginPage;

import org.junit.Rule;
import org.junit.Test;

import static com.leonardojorente.espressotests.TDDProjectStructureTests.ConstantMapping.LoginMapping.EMAIL;
import static com.leonardojorente.espressotests.TDDProjectStructureTests.ConstantMapping.LoginMapping.PASSWORD;

public class LoginTests {
    @Rule
    public ActivityTestRule<MainActivity>
            mActivityRule = new ActivityTestRule<>(MainActivity.class, false,true);


    @Test
    public void TC01_ValidateSuccessLogin(){
        new LoginPage()
        .inputEmail(EMAIL)
        .inputPassword(PASSWORD)
        .finishLogin();
    }



}
