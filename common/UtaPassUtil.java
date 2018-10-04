package com.kddi.android.UtaPass.sqa_espresso.common ;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.content.res.Resources ;
import android.graphics.* ;
import android.graphics.drawable.Drawable ;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.* ;
import android.support.test.espresso.action.* ;
import android.support.test.rule.ActivityTestRule ;
import android.support.test.runner.lifecycle.ActivityLifecycleMonitorRegistry;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiSelector;
import android.util.Log ;
import android.view.View ;
import android.widget.ImageView ;

import com.kddi.android.UtaPass.main.MainActivity;
import com.kddi.android.UtaPass.sqa_espresso.common.exceptions.MaxRetryReachedException;
import com.kddi.android.UtaPass.sqa_espresso.pages.common.NowPlayingBar;
import com.squareup.spoon.Spoon;

import org.hamcrest.* ;

import java.util.Collection;

import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static android.support.test.runner.lifecycle.Stage.RESUMED;

public class UtaPassUtil {

    private static final int RETRY_INTERVAL = 5 ;
    private static final int RETRY_MAX_COUNT = 6 ;

    public static void dprint( String msg ) {
        android.util.Log.d( "UtapassAutomation", msg ) ;
    }

    private static void _sleep( int seconds ) {
        try {
            Thread.sleep( seconds * 1000 ) ;

        } catch( InterruptedException ex ) {
            UtaPassUtil.dprint( ex.toString() ) ;
        }
    }

    public static void sleep( int seconds, String info ) {
        UtaPassUtil.dprint( String.format( "Sleep %s second(s): %s", seconds, info ) ) ;
        UtaPassUtil._sleep( seconds ) ;
    }

    public static void sleep( int seconds ) {
        UtaPassUtil.dprint( String.format( "Sleep %s second(s)...", seconds ) ) ;
        UtaPassUtil._sleep( seconds ) ;
    }

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

                if( imageView.getDrawable() == null || expectedDrawable == null ) {
                    return false;
                }

                if( imageView.getDrawable().getIntrinsicHeight() < 0 ||
                    imageView.getDrawable().getIntrinsicWidth() < 0 ) {

                    return false ;
                }

                Bitmap bitmap = getBitmap( imageView.getDrawable() ) ;
                Bitmap otherBitmap = getBitmap( expectedDrawable ) ;
                return bitmap.sameAs(otherBitmap);
            }

            private Bitmap getBitmap( Drawable drawable ) {
                Bitmap bitmap = Bitmap.createBitmap(
                        drawable.getIntrinsicWidth(),
                        drawable.getIntrinsicHeight(),
                        Bitmap.Config.ARGB_8888 );
                Canvas canvas = new Canvas(bitmap);
                drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
                drawable.draw(canvas);
                return bitmap;

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

    public static void closeApp() {
        UtaPassUtil.getUiDeviceInstance().pressHome() ;
        UtaPassUtil.sleep( 5, "for launching next case" ) ;
    }

    public static void stopNowPlayingBar() {
        NowPlayingBar nowPlayingBar = new NowPlayingBar() ;
        if( nowPlayingBar.isPlaying() ) {
            nowPlayingBar.pause() ;
        }
    }

    // Workaround
    public static void tapOkButtonInAuidSettingPage() {
        try {
            UtaPassUtil.getUiDeviceInstance().findObject(
                    new UiSelector().instance(0).className("android.widget.Button")).click();

        } catch( UiObjectNotFoundException e ) {
            UtaPassUtil.dprint( e.getMessage() ) ;
        }
    }

    public static UiDevice getUiDeviceInstance() {
        return UiDevice.getInstance( InstrumentationRegistry.getInstrumentation() ) ;
    }

    public static UiObject findObjectInWebView( String className, int index ) {
        return UtaPassUtil.getUiDeviceInstance().findObject( new UiSelector()
                    .className( className )
                    .instance( index ) ) ;
    }

    public static void setScreenOrientationPortrait( ActivityTestRule<MainActivity> mActivityRule ) {
        mActivityRule.getActivity().setRequestedOrientation(
                ActivityInfo.SCREEN_ORIENTATION_PORTRAIT ) ;
    }

    public static void setScreenOrientationNatural( ActivityTestRule<MainActivity> mActivityRule ) {
        mActivityRule.getActivity().setRequestedOrientation(
                ActivityInfo.SCREEN_ORIENTATION_FULL_SENSOR ) ;
    }

    public static void retry( RetryUnit unit ) {
        UtaPassUtil.retry( unit,
                           true,
                           UtaPassUtil.RETRY_INTERVAL,
                           UtaPassUtil.RETRY_MAX_COUNT ) ;
    }

    public static void retry( RetryUnit unit, boolean isRetry ) {
        UtaPassUtil.retry( unit,
                           isRetry,
                           UtaPassUtil.RETRY_INTERVAL,
                           UtaPassUtil.RETRY_MAX_COUNT ) ;
    }

    public static void retry( RetryUnit unit, boolean isRetry, int interval, int maxCount ) {
        if( isRetry ) {
            UtaPassUtil.retry( unit, interval, maxCount ) ;
            return ;
        }

        UtaPassUtil.runStep( unit ) ;
    }

    public static void retry( RetryUnit unit, int interval, int maxCount ) {
        int count = 0 ;

        while( true ) {
            try {
                UtaPassUtil.runStep( unit ) ;
                return ;

            } catch( Exception e ) {
                if( count++ == maxCount ) {
                    throw new MaxRetryReachedException( String.format(
                            "MaxRetryReached: interval = %s, count = %s, %s",
                            interval,
                            maxCount,
                            e.getMessage() ) ) ;
                }

                UtaPassUtil.sleep( interval,
                                   String.format( "for next try (%s/%s), %s",
                                                  count,
                                                  maxCount,
                                                  e.getMessage() ) ) ;
            }
        }
    }

    public static void runStep( RetryUnit unit ) throws RuntimeException {
        if( ! unit.execute() ) {
            throw new RuntimeException() ;
        }
    }

    public static void takeScreenshot( String tag ) {
        Spoon.screenshot( UtaPassUtil.getCurrentActivity(), tag ) ;
    }

    // copied from google
    public static Activity getCurrentActivity() {
        final Activity[] currentActivity = new Activity[ 1 ] ;

        getInstrumentation().runOnMainSync( () -> {
                Collection resumedActivities =
                        ActivityLifecycleMonitorRegistry.getInstance().getActivitiesInStage( RESUMED ) ;
                if( resumedActivities.iterator().hasNext() ) {
                    currentActivity[0] = (Activity) resumedActivities.iterator().next() ;
                }
        } ) ;

        return currentActivity[ 0 ] ;
    }
}
