package com.kddi.android.UtaPass.sqatest.common ;

import com.kddi.android.UtaPass.R;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.test.espresso.Espresso;
import android.support.test.espresso.UiController;
import android.support.test.espresso.ViewAction;
import android.support.test.espresso.action.CoordinatesProvider;
import android.support.test.espresso.action.GeneralLocation;
import android.support.test.espresso.action.GeneralSwipeAction;
import android.support.test.espresso.action.Press;
import android.support.test.espresso.action.Swipe;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.actionWithAssertions;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

public class UtaPassUtil {

    public static Matcher<View> withIndex(final Matcher<View> matcher, final int index) {
        return new TypeSafeMatcher<View>() {
            int currentIndex = 0;

            @Override
            public void describeTo(Description description) {
                description.appendText("with index: ");
                description.appendValue(index);
                matcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                return matcher.matches(view) && currentIndex++ == index;
            }
        };
    }

    public static Matcher<View> withDrawable( final int resourceId ) {
        return new TypeSafeMatcher<View>() {

            @Override
            public void describeTo(Description description) {
                description.appendText( "with drawable from resource id: " ) ;
                description.appendValue( resourceId ) ;
//                if( resourceName != null ) {
//                    description.appendText( "[" ) ;
//                    description.appendText( resourceName ) ;
//                    description.appendText( "]" ) ;
//                }
            }

            @Override
            public boolean matchesSafely( View view ) {
                if( ! ( view instanceof ImageView ) ) {
                    return false ;
                }

                ImageView imageView = (ImageView) view ;
                if( resourceId < 0 ) {
                    return imageView.getDrawable() == null;
                }

                Resources resources = view.getContext().getResources() ;
                Drawable expectedDrawable = resources.getDrawable( resourceId ) ;

                if( imageView.getDrawable() == null || expectedDrawable == null) {
                    return false;
                }

                Bitmap bitmap = getBitmap( imageView.getDrawable() ) ;
                Bitmap otherBitmap = getBitmap( expectedDrawable ) ;
                return bitmap.sameAs(otherBitmap);
            }

            private Bitmap getBitmap( Drawable drawable ) {
                Bitmap bitmap = Bitmap.createBitmap( drawable.getIntrinsicWidth(),
                                                     drawable.getIntrinsicHeight(),
                                                     Bitmap.Config.ARGB_8888 ) ;
                Canvas canvas = new Canvas( bitmap ) ;
                drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight() ) ;
                drawable.draw( canvas ) ;
                return bitmap ;
            }
        };
    }

    public static ViewAction swipeUp() {
        return new GeneralSwipeAction( Swipe.FAST,
                                       GeneralLocation.CENTER,
                                       GeneralLocation.TOP_CENTER,
                                       Press.FINGER);
    }

    public static ViewAction swipeDown() {
        return new GeneralSwipeAction( Swipe.FAST,
                                       GeneralLocation.CENTER,
                                       GeneralLocation.BOTTOM_CENTER,
                                       Press.FINGER);
    }

    public static ViewAction swipeToBottom() {
        Log.d("xxxxxxxxxx", "swipToBottom()" ) ;

        return new GeneralSwipeAction(
                Swipe.FAST,
                GeneralLocation.CENTER,
                new CoordinatesProvider() {
                    @Override
                    public float[] calculateCoordinates(View view) {
                        float[] coordinates = GeneralLocation.CENTER.calculateCoordinates(view);
                        coordinates[1] = view.getContext().getResources().getDisplayMetrics().heightPixels;
                        return coordinates;
                    }
                },
                Press.FINGER);
    }

    public static void pressBack() {
        Espresso.pressBack() ;
    }
//    private class UtaPassSwipeAction implements ViewAction {
//        @Override public Matcher<View> getConstraints() {...}
//
//        @Override public String getDescription() {...}
//
//        @Override
//        public void perform(UiController uiController, View view) {
//    }
}


