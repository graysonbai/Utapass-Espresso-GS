package com.kddi.android.UtaPass.sqatest.util;

import android.support.design.widget.CollapsingToolbarLayout;
import android.support.test.espresso.matcher.BoundedMatcher;
import android.view.View;
import android.view.ViewGroup;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

/**
 * Created by vanessatsai on 2017/5/8.
 */

public class CustomMatcher {

    public static Matcher<Object> withCollapsibleToolbarTitle(final Matcher<String> textMatcher)
    {
        return new BoundedMatcher<Object, CollapsingToolbarLayout>(CollapsingToolbarLayout.class)
        {
            @Override public void describeTo(Description description) {
                description.appendText("with toolbar title: ");
                textMatcher.describeTo(description);
            }
            @Override protected boolean matchesSafely(CollapsingToolbarLayout toolbarLayout) {
                return textMatcher.matches(toolbarLayout.getTitle());
            }
        };
    }

    public static Matcher<View> nthChildOf(final int nth , final Matcher<View> parentMatcher) {
        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("with "+ nth +"th child view of type parentMatcher");
            }

            @Override
            public boolean matchesSafely(View view) {

                if (!(view.getParent() instanceof ViewGroup)) {
                    return parentMatcher.matches(view.getParent());
                }

                ViewGroup group = (ViewGroup) view.getParent();

                return parentMatcher.matches(view.getParent()) && group.getChildAt(nth).equals(view);

            }
        };
    }


    public static Matcher<View> getMatchElementAtPosition(int position,final Matcher<View> matcher) {
        return getElementFromMatchAtPosition(position-1,matcher);
    }


    private static Matcher<View> getElementFromMatchAtPosition(final int position,final Matcher<View> matcher) {
        return new BaseMatcher<View>() {
            int counter = 0;

            @Override
            public boolean matches(final Object item) {
                if (matcher.matches(item)) {
                    if(counter == position) {
                        counter++;
                        return true;
                    }
                    counter++;
                }
                return false;
            }

            @Override
            public void describeTo(final Description description) {
                description.appendText("Element at hierarchy position "+position);
            }
        };
    }
}
