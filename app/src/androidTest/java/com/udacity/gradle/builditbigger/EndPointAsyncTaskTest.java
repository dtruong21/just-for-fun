package com.udacity.gradle.builditbigger;

import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.ExecutionException;

import static android.support.test.InstrumentationRegistry.getContext;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static junit.framework.Assert.assertNotNull;
import static org.hamcrest.CoreMatchers.not;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class EndPointAsyncTaskTest {

    @Rule
    public ActivityTestRule<MainActivity> mTestRule = new ActivityTestRule<>(MainActivity.class);

    private static final String TAG = EndPointAsyncTaskTest.class.getSimpleName();

    @Test
    public void checkEndpointsAsyncTask() {
        onView(withId(R.id.button)).perform(click());
        onView(withId(R.id.tv_joke)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_joke)).check(matches(not(withText(""))));
    }

    @Test
    public void testJokeNotNull() {
        EndPointAsyncTask endPointAsyncTask = new EndPointAsyncTask(getContext()) {
            @Override
            protected void onPostExecute(String s) {
                assert !s.isEmpty();
                assertNotNull(s);
                assert s.length() > 1;
            }
        };
        endPointAsyncTask.execute();

    }
}