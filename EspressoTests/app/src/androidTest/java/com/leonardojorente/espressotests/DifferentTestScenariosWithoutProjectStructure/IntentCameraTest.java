package com.leonardojorente.espressotests.DifferentTestScenariosWithoutProjectStructure;

import android.app.Activity;
import android.app.Instrumentation;
import android.content.Intent;
import android.provider.MediaStore;

import androidx.test.espresso.intent.rule.IntentsTestRule;
import androidx.test.espresso.matcher.ViewMatchers;

import com.leonardojorente.espressotests.R;
import com.leonardojorente.espressotests.SelectTestActivity;

import org.hamcrest.Matcher;
import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.intent.Intents.intended;
import static androidx.test.espresso.intent.Intents.intending;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasAction;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

public class IntentCameraTest {

    @Rule
    public IntentsTestRule<SelectTestActivity> intentsTestRule = new IntentsTestRule<>(SelectTestActivity.class);


    @Test
    public void TC01_validateGalleryIntent() {
        //This test scenario validates that the camera intent was correctly launched
        //Intent callCameraApplicationIntent = new Intent();
        //callCameraApplicationIntent.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
        //due to the code above, we are using only hasaction and not allof
        Matcher<Intent> expectedIntent = hasAction(MediaStore.ACTION_IMAGE_CAPTURE); // create the expected result

        Instrumentation.ActivityResult activityResult = new Instrumentation.ActivityResult(
                Activity.RESULT_OK, new Intent()); // checks that the intent was correctly created and if the result was ok

        intending(expectedIntent).respondWith(activityResult);

        onView(ViewMatchers.withId(R.id.button_camera))
                .perform(click());

            intended(expectedIntent); //it checks that the correct thing has happened


        }
    }

