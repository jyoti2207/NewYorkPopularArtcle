package com.pack.nytimearticle;

import android.view.View;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import androidx.recyclerview.widget.RecyclerView;
import androidx.test.espresso.Espresso;
import androidx.test.espresso.UiController;
import androidx.test.espresso.ViewAction;
import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.espresso.matcher.BoundedMatcher;
import androidx.test.espresso.matcher.RootMatchers;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;

import static androidx.test.espresso.matcher.ViewMatchers.withId;

@RunWith(AndroidJUnit4.class)
public class RecylerviewActivityUITestCases {

    @Rule
    public ActivityTestRule<MainActivity> menuActivityTestRule = new ActivityTestRule<>(MainActivity.class);


    @Test
    public void testCaseForRecyclerClick() {
        onView(withId(R.id.viewArticleList)).perform(RecyclerViewActions.actionOnItemAtPosition(2, click()));

    }

    @Test
    public void testCaseForRecyclerAddItem() {
       // int itemCount = recyclerView.getAdapter().getItemCount();
        onView(withId(R.id.viewArticleList))
                .perform(
                        RecyclerViewActions.actionOnItemAtPosition(0, click()));
    }

    @Test
    public void testCaseForPerformClickListenerForChild() {

        onView(withId(R.id.viewArticleList))
                .perform(
                        RecyclerViewActions.actionOnItemAtPosition(1,
                                ChildViewAction.clickChildViewWithId(
                                        R.id.tvArticleArrow)));
    }



        public static class ChildViewAction {
            public static  ViewAction clickChildViewWithId(
                    final int id) {
                return new ViewAction() {
                    @Override
                    public Matcher<View> getConstraints() {
                        return null;
                    }
                    @Override
                    public String getDescription() {
                        return "Click on a child view with specified id.";
                    }
                    @Override
                    public void perform(UiController uiController,
                                        View view) {
                        View v = view.findViewById(id);
                        v.performClick();
                    }
                };
            }
        }

}
