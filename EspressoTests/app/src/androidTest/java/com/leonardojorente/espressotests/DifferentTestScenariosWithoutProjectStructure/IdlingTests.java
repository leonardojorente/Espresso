package com.leonardojorente.espressotests.DifferentTestScenariosWithoutProjectStructure;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.IdlingRegistry;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.rule.ActivityTestRule;

import com.leonardojorente.espressotests.EspressoIdlingResource;
import com.leonardojorente.espressotests.MainActivity;
import com.leonardojorente.espressotests.R;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.doesNotExist;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.RootMatchers.isDialog;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

public class IdlingTests {

    @Rule  //define wich will be the first screen to be open
    public ActivityTestRule<MainActivity> //Activity is each screen of the application
            mActivityRule = new ActivityTestRule<>(MainActivity.class, false, true);

    @Before // ctrl + space to import lib for the classses like junit or option + enter
    public void setup() {
        IdlingRegistry.getInstance().register(EspressoIdlingResource.countingIdlingResource);

    }

    @After
    public void finish() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.countingIdlingResource);

    }

    @Test
    public void TC01_isDialogWorking() {
        //This test validates the data of a dialog
        onView(ViewMatchers.withId(R.id.inputEmail)).perform(typeText("test@hotmail.com"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.inputPassword)).perform(typeText("password1"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.loginButton)).perform(click());
        onView(withId(R.id.SelectTestActivity)).check(matches(isDisplayed()));//android:id="@+id/SelectTestActivity" validate this element from layout->activity_select_test.xml, its the parent of the layout
        onView(withId(R.id.button_idle)).perform(click());

        onView(withText(R.string.text_dialog_message)).check(matches(isDisplayed()));
        //Verify the data of a dialog
        onView(withText("Dialog Test")).inRoot(isDialog()).check(matches(isDisplayed()));
        onView(withText("Check this message")).inRoot(isDialog()).check(matches(isDisplayed()));
        onView(withText("Ok")).inRoot(isDialog()).perform(click());
        // make sure dialog is gone
        onView(withText(R.string.text_dialog_message)).check(doesNotExist());

    }
}
