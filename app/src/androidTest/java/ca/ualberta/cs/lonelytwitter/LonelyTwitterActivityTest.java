package ca.ualberta.cs.lonelytwitter;

import android.content.Intent;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.rule.ActivityTestRule;

/**
 * Created by wz on 14/09/15.
 */
public class LonelyTwitterActivityTest {

    @Rule
    ActivityTestRule<LonelyTwitterActivity> activityRule = new ActivityTestRule<LonelyTwitterActivity>(LonelyTwitterActivity.class);

    @Test
    public void addtext() {

        onView(withId(R.id.body)).perform(typeText("This is a test."));
    }

}