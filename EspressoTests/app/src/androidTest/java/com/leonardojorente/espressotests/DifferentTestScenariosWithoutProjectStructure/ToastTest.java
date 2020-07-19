package com.leonardojorente.espressotests.DifferentTestScenariosWithoutProjectStructure;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.rule.ActivityTestRule;

import com.leonardojorente.espressotests.MainActivity;
import com.leonardojorente.espressotests.R;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.not;

public class ToastTest {
    @Rule  //define wich will be the first screen to be open
    public ActivityTestRule<MainActivity> //Activity is each screen of the application
            mActivityRule = new ActivityTestRule<>(MainActivity.class, false,true);

    @Before // ctrl + space to import lib for the classses like junit or option + enter
    public void setup(){


    }

    @After
    public void finish(){


    }
    @Test
    public void TC01_isToastDisplayed(){
        //Validate if the toast is correctly displayed after click the toast button
        onView(ViewMatchers.withId(R.id.inputEmail)).perform(typeText("test@hotmail.com"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.inputPassword)).perform(typeText("password1"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.loginButton)).perform(click());
        onView(withId(R.id.SelectTestActivity)).check(matches(isDisplayed()));//android:id="@+id/SelectTestActivity" validate this element from layout->activity_select_test.xml, its the parent of the layout
        onView(withId(R.id.button_toast)).perform(click());
        onView(withText("This is a toast test message")).inRoot(new ToastMatcher()).check(matches(isDisplayed()));
    }

    @Test
    public void TC02_isToastNotDisplayed(){
        //Validate if the toast is not displayed after click the toas button. this test will fail since the toast is appearing
        onView(withId(R.id.inputEmail)).perform(typeText("test@hotmail.com"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.inputPassword)).perform(typeText("password1"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.loginButton)).perform(click());
        onView(withId(R.id.SelectTestActivity)).check(matches(isDisplayed()));//android:id="@+id/SelectTestActivity" validate this element from layout->activity_select_test.xml, its the parent of the layout
        onView(withId(R.id.button_toast)).perform(click());
        onView(withText("This is a toast test message")).inRoot(new ToastMatcher()).check(matches(not(isDisplayed())));
    }
}
