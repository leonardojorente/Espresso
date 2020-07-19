package com.leonardojorente.espressotests.TDDProjectStructureTests.Utils;

import androidx.test.espresso.Espresso;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

public class EspressoActions {

    protected void inputTextOnField(String text, int field){
        onView(withId(field)).perform(typeText(text));
        Espresso.closeSoftKeyboard();
    }

    protected void clickElement(int element){
        onView(withId(element)).perform(click());
    }

    protected void checkElementDisplayed(int element){
        onView(withId(element)).check(matches(isDisplayed()));
    }
}



