package com.leonardojorente.espressotests.DifferentTestScenariosWithoutProjectStructure;

import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.rule.ActivityTestRule;

import com.leonardojorente.espressotests.R;
import com.leonardojorente.espressotests.SelectTestActivity;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static androidx.core.util.Preconditions.checkNotNull;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.swipeUp;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.contrib.RecyclerViewActions.scrollToPosition;
import static androidx.test.espresso.matcher.ViewMatchers.hasDescendant;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static com.leonardojorente.espressotests.DifferentTestScenariosWithoutProjectStructure.RecyclerViewMatcher.withRecyclerView;


public class RecyclerViewTest {

    @Rule  //define wich will be the first screen to be open
    public ActivityTestRule<SelectTestActivity> //Activity is each screen of the application
            mActivityRule = new ActivityTestRule<>(SelectTestActivity.class, false, true);

    @Before // ctrl + space to import lib for the classses like junit or option + enter
    public void setup() {


    }

    @After
    public void finish() {


    }

    @Test
    public void TC01_isReciclerViewAppearing() throws InterruptedException {
        //This test verify that the description of an item of the recycler view appears correctly
        onView(ViewMatchers.withId(R.id.SelectTestActivity)).check(matches(isDisplayed()));//android:id="@+id/SelectTestActivity" validate this element from layout->activity_select_test.xml, its the parent of the layout
        onView(withId(R.id.button_recycler_view)).perform(click());
        Thread.sleep(4000);
        //1-always look for the id of the recycler view or the id of the content, one of them will work. its basic the id of the borders
        onView(withId(R.id.recycler_view)).check(matches(isDisplayed()));
    }
    @Test
    public void TC02_isReciclerViewScrolling() throws InterruptedException {
        //This test verify that the description of an item of the recycler view appears correctly
        onView(withId(R.id.SelectTestActivity)).check(matches(isDisplayed()));//android:id="@+id/SelectTestActivity" validate this element from layout->activity_select_test.xml, its the parent of the layout
        onView(withId(R.id.button_recycler_view)).perform(click());
        Thread.sleep(4000);
        //1-always look for the id of the recycler view or the id of the content, one of them will work. its basic the id of the borders
        onView(withId(R.id.recycler_view)).perform(swipeUp(),click());//the of the recycler view is on folder activity recycler view.xml and not on my recycler view row
        //the swipe up, would be also swipeDown(),swipeLeft() or swipeRight
        Thread.sleep(4000);
        onView(withId(R.id.recycler_view)).perform(scrollToPosition(0));//another way to use scroll
        Thread.sleep(4000);
    }

    @Test
    public void TC03_openItemDetails() throws InterruptedException {
        //This test verify that the description of an item of the recycler view appears correctly
        onView(withId(R.id.SelectTestActivity)).check(matches(isDisplayed()));//android:id="@+id/SelectTestActivity" validate this element from layout->activity_select_test.xml, its the parent of the layout
        onView(withId(R.id.button_recycler_view)).perform(click());
        Thread.sleep(4000);
        //1-always look for the id of the recycler view or the id of the content, one of them will work. its basic the id of the borders
        onView(withId(R.id.recycler_view)).perform(swipeUp(),click());//the of the recycler view is on folder activity recycler view.xml and not on my recycler view row
        //the swipe up, would be also swipeDown(),swipeLeft() or swipeRight
        Thread.sleep(4000);
        onView(withId(R.id.recycler_view)).perform(scrollToPosition(6));
        Thread.sleep(4000);
        onView(withId(R.id.recycler_view)).perform(RecyclerViewActions.actionOnItemAtPosition(6, click()));
        onView(withId(R.id.recycler_item_detail)).check(matches(isDisplayed()));
        Thread.sleep(4000);
    }

    @Test
    public void TC04_searchAndOpenItemByText() throws InterruptedException {
        //This test open the recycler view activity, scrolls until an specific element and opens it
        onView(withId(R.id.SelectTestActivity)).check(matches(isDisplayed()));
        onView(withId(R.id.button_recycler_view)).perform(click());
        onView(withId(R.id.recycler_view)).perform(RecyclerViewActions.actionOnItem(hasDescendant(withText("RecyclerViewItem5")), click()));
        onView(withId(R.id.recycler_item_detail)).check(matches(isDisplayed()));
        Thread.sleep(4000);
    }

    @Test
    public void TC05_searchItemAndVerifyText() throws InterruptedException {
        //This test open the recycler view activity, scrolls until an specific element and checks if it is displayed
        onView(withId(R.id.SelectTestActivity)).check(matches(isDisplayed()));
        onView(withId(R.id.button_recycler_view)).perform(click());
        onView(withId(R.id.recycler_view)).perform(scrollToPosition(6));
        onView(withRecyclerView(R.id.recycler_view).atPosition(6))
            .check(matches(hasDescendant(withText("RecyclerViewItem7"))));
        Thread.sleep(4000);
    }
}





