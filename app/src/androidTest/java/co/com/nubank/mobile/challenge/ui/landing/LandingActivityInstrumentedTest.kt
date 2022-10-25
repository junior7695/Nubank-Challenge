package co.com.nubank.mobile.challenge.ui.landing

import android.os.SystemClock
import androidx.lifecycle.Lifecycle
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.runners.AndroidJUnit4
import co.com.nubank.mobile.challenge.ui.landing.activity.LandingActivity
import org.junit.runner.RunWith
import co.com.nubank.mobile.challenge.R
import org.junit.After
import org.junit.Before
import org.junit.Test

@RunWith(AndroidJUnit4::class)
class LandingActivityInstrumentedTest {

    private lateinit var activityScenario: ActivityScenario<LandingActivity>

    @Before
    fun setup() {

        activityScenario = ActivityScenario.launch(LandingActivity::class.java)
        activityScenario.moveToState(Lifecycle.State.RESUMED)
    }

    @After
    fun tearDown(){
        activityScenario.moveToState(Lifecycle.State.DESTROYED)
    }

    @Test
    fun invalidLinkWeb() {
        SystemClock.sleep(2000)

        Espresso.onView(ViewMatchers.withId(R.id.url_edit_text_field))
            .perform(ViewActions.typeText("Invalid Link"))

        Espresso.onView(ViewMatchers.withId(R.id.send_button)).perform(ViewActions.click())

        Espresso.onView(ViewMatchers.withId(R.id.progress_bar))
            .check(ViewAssertions.matches(ViewMatchers.withEffectiveVisibility(ViewMatchers.Visibility.GONE)))

        SystemClock.sleep(2000)

        Espresso.onView(ViewMatchers.withId(R.id.recently_links_recycler_view))
            .check(ViewAssertions.matches(ViewMatchers.withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)))

        Espresso.onView(ViewMatchers.withId(R.id.error_view))
            .check(ViewAssertions.matches(ViewMatchers.withEffectiveVisibility(ViewMatchers.Visibility.GONE)))

        Espresso.onView(ViewMatchers.withId(R.id.recently_links_recycler_view))
            .check(ViewAssertions.matches(ViewMatchers.hasChildCount(0)))
    }

    @Test
    fun urlAlreadyExist() {
        SystemClock.sleep(2000)

        Espresso.onView(ViewMatchers.withId(R.id.url_edit_text_field))
            .perform(ViewActions.typeText("www.youtube.com"))

        Espresso.onView(ViewMatchers.withId(R.id.send_button)).perform(ViewActions.click())

        SystemClock.sleep(2000)

        Espresso.onView(ViewMatchers.withId(R.id.url_edit_text_field))
            .perform(ViewActions.typeText("www.youtube.com"))

        Espresso.onView(ViewMatchers.withId(R.id.send_button)).perform(ViewActions.click())

        Espresso.onView(ViewMatchers.withId(R.id.progress_bar))
            .check(ViewAssertions.matches(ViewMatchers.withEffectiveVisibility(ViewMatchers.Visibility.GONE)))

        SystemClock.sleep(2000)

        Espresso.onView(ViewMatchers.withId(R.id.recently_links_recycler_view))
            .check(ViewAssertions.matches(ViewMatchers.withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)))

        Espresso.onView(ViewMatchers.withId(R.id.error_view))
            .check(ViewAssertions.matches(ViewMatchers.withEffectiveVisibility(ViewMatchers.Visibility.GONE)))

        Espresso.onView(ViewMatchers.withId(R.id.recently_links_recycler_view))
            .check(ViewAssertions.matches(ViewMatchers.hasChildCount(1)))
    }

    @Test
    fun shortOnlyUrl() {
        SystemClock.sleep(2000)

        Espresso.onView(ViewMatchers.withId(R.id.url_edit_text_field))
            .perform(ViewActions.typeText("www.youtube.com"))

        Espresso.onView(ViewMatchers.withId(R.id.send_button)).perform(ViewActions.click())

        Espresso.onView(ViewMatchers.withId(R.id.progress_bar))
            .check(ViewAssertions.matches(ViewMatchers.withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)))

        SystemClock.sleep(2000)

        Espresso.onView(ViewMatchers.withId(R.id.recently_links_recycler_view))
            .check(ViewAssertions.matches(ViewMatchers.withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)))

        Espresso.onView(ViewMatchers.withId(R.id.error_view))
            .check(ViewAssertions.matches(ViewMatchers.withEffectiveVisibility(ViewMatchers.Visibility.GONE)))

        Espresso.onView(ViewMatchers.withId(R.id.recently_links_recycler_view))
            .check(ViewAssertions.matches(ViewMatchers.hasChildCount(1)))
    }

    @Test
    fun shortTwoUrls() {
        SystemClock.sleep(2000)

        Espresso.onView(ViewMatchers.withId(R.id.url_edit_text_field))
            .perform(ViewActions.typeText("www.youtube.com"))

        Espresso.onView(ViewMatchers.withId(R.id.send_button)).perform(ViewActions.click())

        SystemClock.sleep(2000)

        Espresso.onView(ViewMatchers.withId(R.id.url_edit_text_field))
            .perform(ViewActions.typeText("www.facebook.com"))

        Espresso.onView(ViewMatchers.withId(R.id.send_button)).perform(ViewActions.click())

        SystemClock.sleep(2000)

        Espresso.onView(ViewMatchers.withId(R.id.recently_links_recycler_view))
            .check(ViewAssertions.matches(ViewMatchers.withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)))

        Espresso.onView(ViewMatchers.withId(R.id.error_view))
            .check(ViewAssertions.matches(ViewMatchers.withEffectiveVisibility(ViewMatchers.Visibility.GONE)))

        Espresso.onView(ViewMatchers.withId(R.id.recently_links_recycler_view))
            .check(ViewAssertions.matches(ViewMatchers.hasChildCount(2)))
    }
}