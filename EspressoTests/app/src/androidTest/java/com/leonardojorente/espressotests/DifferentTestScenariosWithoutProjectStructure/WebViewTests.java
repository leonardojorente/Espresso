package com.leonardojorente.espressotests.DifferentTestScenariosWithoutProjectStructure;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.web.webdriver.DriverAtoms;
import androidx.test.rule.ActivityTestRule;

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
import static androidx.test.espresso.web.sugar.Web.onWebView;
import static androidx.test.espresso.web.webdriver.DriverAtoms.clearElement;
import static androidx.test.espresso.web.webdriver.DriverAtoms.findElement;
import static androidx.test.espresso.web.webdriver.DriverAtoms.webClick;
import androidx.test.espresso.web.webdriver.Locator;

/**
 * USE chrome:://inspect/devices#devices to find the xpath of hybrid apps
 */

public class WebViewTests {
    @Rule  //define wich will be the first screen to be open
    public ActivityTestRule<MainActivity> //Activity is each screen of the application
            mActivityRule = new ActivityTestRule<>(MainActivity.class, false, true);

    @Before // ctrl + space to import lib for the classses like junit or option + enter
    public void setup() {


    }

    @After
    public void finish() {


    }

    @Test
    public void TC01_googleNavigation() throws InterruptedException {
        onView(withId(R.id.inputEmail)).perform(typeText("test@hotmail.com"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.inputPassword)).perform(typeText("password1"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.loginButton)).perform(click());
        onView(withId(R.id.SelectTestActivity)).check(matches(isDisplayed()));//android:id="@+id/SelectTestActivity" validate this element from layout->activity_select_test.xml, its the parent of the layout
        onView(withId(R.id.button_browser)).perform(click());

        onWebView()
                .withElement(findElement(Locator.XPATH,"//input[@name='q']"))
                .perform(clearElement())
                .perform(DriverAtoms.webKeys("teste"));//digita algo no campo

        Thread.sleep(3000);

        onWebView()
                .withElement(findElement(Locator.XPATH,"//*[@id='tsf']/div[2]/div[1]/div[1]/button[2]"))
                .perform(webClick());

        Thread.sleep(7000);


    }
}
