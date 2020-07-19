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
import static androidx.test.espresso.matcher.RootMatchers.isDialog;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withEffectiveVisibility;
import static androidx.test.espresso.matcher.ViewMatchers.withHint;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;



public class BasicLoginEspressoTests {
        @Rule  //define wich will be the first screen to be open
        public ActivityTestRule<MainActivity> //Activity is each screen of the application
                mActivityRule = new ActivityTestRule<>(MainActivity.class, false,true);

        @Before // ctrl + space to import lib for the classses like junit or option + enter
        public void setup(){


        }

        @After
        public void finish(){


        }
        //@Ignore this tags ignores this specific test and run all the others, its better than comment the test
        //The @tests are alphabeticaly run
        @Test
        public void TC01_isLoginScreenVisible(){
            //This test verifies all the elements of the login screen
            //uiautomatorviewer - resource-id: com.leonardojorente.espressotests:id/titleEmail
            onView(ViewMatchers.withId(R.id.titleEmail)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)));//alternative to is displayed
            onView(withId(R.id.titleEmail)).check(matches(isDisplayed()));
            onView(withId(R.id.titlePassword)).check(matches(isDisplayed()));
            onView(withId(R.id.inputEmail)).check(matches(isDisplayed()));
            onView(withId(R.id.inputPassword)).check(matches(isDisplayed()));
            onView(withId(R.id.loginButton)).check(matches(isDisplayed()));
            //uiautomatorviewer - text: Input your Email
            onView(withText("Input your Email")).check(matches(isDisplayed()));//checks a String witch can be found on strings.xml or on uiautomator or tools ->layout inspector -> your activity -> text->mtext
            onView(withText(R.string.title_email)).check(matches(isDisplayed()));//checks the string.xml content, its alternative for the above command or on activity_loginn.xml string field
            //verifica se o campo username esta aparecendo e que ele possui hint(dica) Type your username
            onView(withId(R.id.inputEmail)).check(matches(withHint("your email here")));
            onView(withId(R.id.inputPassword)).check(matches(withHint("your password here")));
        }
        @Test
        public void TC02_ValidateMandatoryFieldDialog(){
            //This test shall try to log in the application and check the data of the dialog that appears
            onView(withId(R.id.loginButton)).perform(click());
            //Verify the data of a dialog
            onView(withText("Failed to login")).inRoot(isDialog()).check(matches(isDisplayed()));
            onView(withText("Email or password is empty")).inRoot(isDialog()).check(matches(isDisplayed()));
        }

        @Test
        public void TC03_ValidateMandatoryFieldDialogAfterInsertEmail(){
            //This test shall verify that
            onView(withId(R.id.inputEmail)).perform(typeText("test@gmail.com"));
            Espresso.closeSoftKeyboard();
            onView(withText("Enter")).perform(click());
            //Verify the data of a dialog
            onView(withText("Failed to login")).inRoot(isDialog()).check(matches(isDisplayed()));
            onView(withText("Email or password is empty")).inRoot(isDialog()).check(matches(isDisplayed()));
        }

        @Test
        public void TC04_ValidateMandatoryFieldDialogAfterInsertPassword(){
            //
            onView(withId(R.id.inputPassword)).perform(typeText("password1"));
            Espresso.closeSoftKeyboard();
            onView(withId(R.id.loginButton)).perform(click());
            //Verify the data of a dialog
            onView(withText("Failed to login")).inRoot(isDialog()).check(matches(isDisplayed()));
            onView(withText("Email or password is empty")).inRoot(isDialog()).check(matches(isDisplayed()));
        }

        @Test
        public void TC05_ValidateSuccessLogin(){
            //This test verify the that screen after the login appears correctly
            onView(withId(R.id.inputEmail)).perform(typeText("test@hotmail.com"));
            Espresso.closeSoftKeyboard();
            onView(withId(R.id.inputPassword)).perform(typeText("password1"));
            Espresso.closeSoftKeyboard();
            onView(withId(R.id.loginButton)).perform(click());
            onView(withId(R.id.SelectTestActivity)).check(matches(isDisplayed()));//android:id="@+id/SelectTestActivity" validate this element from layout->activity_select_test.xml, its the parent of the layout
        }

        @Test
        public void TC06_ValidateSuccessLogout(){
            //This scenario makes a correct login and makes a logout after that
            onView(withId(R.id.inputEmail)).perform(typeText("test@hotmail.com"));
            Espresso.closeSoftKeyboard();
            onView(withId(R.id.inputPassword)).perform(typeText("password1"));
            Espresso.closeSoftKeyboard();
            onView(withId(R.id.loginButton)).perform(click());
            onView(withId(R.id.SelectTestActivity)).check(matches(isDisplayed()));//android:id="@+id/SelectTestActivity" validate this element from layout->activity_select_test.xml, its the parent of the layout
            Espresso.pressBack();//method 1
            //onView(withId(R.id.button_back_login)).perform(click());
            onView(withId(R.id.titleEmail)).check(matches(isDisplayed()));
        }

}
