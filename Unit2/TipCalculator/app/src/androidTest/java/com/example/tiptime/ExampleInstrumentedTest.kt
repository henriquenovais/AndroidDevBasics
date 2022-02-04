package com.example.tiptime

import androidx.core.content.MimeTypeFilter.matches
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.hamcrest.CoreMatchers.containsString
import androidx.test.espresso.assertion.ViewAssertions.matches

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Rule

@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @get:Rule()
    val activity = ActivityScenarioRule(MainActivity::class.java) //tells to launch specific activity

    @Test
    fun calculate_20_percent_tip() {
    }

    @Test
    fun calculate_default_tip() {
        //Arrange
        onView(withId(R.id.cost_of_service_edit_text)).perform(typeText("50.00"))
        //Act
        onView(withId(R.id.calculate_button)).perform(click())
        //Assert
        onView(withId(R.id.tip_amount)).check(matches(withText(containsString("$10.00"))))
    }
}