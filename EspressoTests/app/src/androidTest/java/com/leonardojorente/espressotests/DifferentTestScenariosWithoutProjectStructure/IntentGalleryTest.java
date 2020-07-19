package com.leonardojorente.espressotests.DifferentTestScenariosWithoutProjectStructure;

import android.app.Activity;
import android.app.Instrumentation;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.provider.MediaStore;

import androidx.test.InstrumentationRegistry;
import androidx.test.espresso.intent.OngoingStubbing;
import androidx.test.espresso.intent.rule.IntentsTestRule;
import androidx.test.espresso.matcher.ViewMatchers;

import com.leonardojorente.espressotests.GalleryActivity;
import com.leonardojorente.espressotests.R;

import org.hamcrest.Matcher;
import org.hamcrest.core.AllOf;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.intent.Intents.intended;
import static androidx.test.espresso.intent.Intents.intending;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasAction;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasData;
import static androidx.test.espresso.intent.matcher.IntentMatchers.isInternal;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.allOf;


public class IntentGalleryTest {


    @Rule
    public IntentsTestRule<GalleryActivity> intentsTestRule = new IntentsTestRule<>(GalleryActivity.class);

    @Test
    public void TC01_validateGalleryIntent() {
        Matcher<Intent> expectedIntent = allOf(
                hasAction(Intent.ACTION_PICK),
                hasData(MediaStore.Images.Media.EXTERNAL_CONTENT_URI));

        Instrumentation.ActivityResult activityResult = createGalleryPickActivityResultStub();
        intending(expectedIntent).respondWith(activityResult);// its saying what Im expecting to see, the expected intent

        onView(ViewMatchers.withId(R.id.button_gallery)).perform(click());
        intended(expectedIntent); //it checks that the correct thing has happened


    }

    public Instrumentation.ActivityResult createGalleryPickActivityResultStub() {
        Resources resources = InstrumentationRegistry.getTargetContext().getResources();
        Uri imageUri = Uri.parse(ContentResolver.SCHEME_ANDROID_RESOURCE + "://" +
                resources.getResourcePackageName(R.mipmap.ic_launcher) + '/' +
                resources.getResourceTypeName(R.mipmap.ic_launcher) + '/' +
                resources.getResourceEntryName(R.mipmap.ic_launcher));

        Intent resultIntent = new Intent();
        resultIntent.setData(imageUri);
        return new Instrumentation.ActivityResult(Activity.RESULT_OK, resultIntent);

        }







}
