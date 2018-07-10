package com.kddi.android.UtaPass.sqatest.util;

import android.app.Activity;
import android.content.Context;
import android.os.PowerManager;
import android.support.test.espresso.NoMatchingViewException;
import android.support.test.espresso.UiController;
import android.support.test.espresso.ViewAction;
import android.support.test.espresso.ViewInteraction;
import android.support.test.espresso.action.GeneralLocation;
import android.support.test.espresso.action.GeneralSwipeAction;
import android.support.test.espresso.action.Press;
import android.support.test.espresso.action.Swipe;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.runner.lifecycle.ActivityLifecycleMonitorRegistry;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.kddi.android.UtaPass.R;
import com.kddi.android.UtaPass.data.db.internal.UtaPassDBOpenHelper;
import com.kddi.android.UtaPass.domain.usecase.media.AudioActionEvent;

import org.hamcrest.Matcher;
import org.testcorner.testlib.ScreenObject;
import org.testcorner.testlib.internal.ScreenShotter;
import org.testcorner.testlib.internal.ScreenShotterImpl;

import java.io.File;
import java.util.Collection;

import de.greenrobot.event.EventBus;

import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static android.support.test.InstrumentationRegistry.getTargetContext;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.doesNotExist;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isAssignableFrom;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.runner.lifecycle.Stage.RESUMED;
import static org.hamcrest.Matchers.any;
import static org.junit.Assert.assertTrue;

public class EspressoUtil {

    public static Boolean ignoreFlag=false;

    private static ScreenShotter screenShotter = new ScreenShotterImpl();

    public static boolean exists(ViewInteraction locator) {
        ignoreFlag = true;
        Boolean result = false;

        try {
            locator.check(doesNotExist());
        } catch (AssertionError ex) {
            result = true;
        }
        finally {
            ignoreFlag=false;
            return result;
        }
    }


    public static String toString(int resourceId) {
        return getTargetContext().getResources().getString(resourceId);
    }

    public static void takeScreenshot(String tag) {
        screenShotter.takeScreenshot(tag);
    }

    public static <T extends ScreenObject<T>> T transitTo(T next) {
        // TODO timeout and handlers
        long start = System.currentTimeMillis();
        long end = start + 15000;
        while (!(System.currentTimeMillis() < end)) { // TODO timeout
            try {
                next.assertOnThisScreen();
                return next;
            } catch (NoMatchingViewException ex) {
                // consult handlers
            } catch (AssertionError ex) {
                // consult handlers
            }
        }
        return next;
    }

    public static Activity getCurrentActivity() {
        final Activity[] currentActivity = new Activity[1];

        getInstrumentation().runOnMainSync(new Runnable() {
            public void run() {
                Collection resumedActivities = ActivityLifecycleMonitorRegistry.getInstance().getActivitiesInStage(RESUMED);
                if (resumedActivities.iterator().hasNext())
                    currentActivity[0] = (Activity) resumedActivities.iterator().next();
            }
        });

        return currentActivity[0];
    }

    public static void waitforExist(ViewInteraction locator, int timeout) {
        ignoreFlag = true;
        long start = System.currentTimeMillis();
        long end = start + timeout*1000;
        while (!(System.currentTimeMillis() < end)) { // TODO timeout
            try {
                locator.check(matches(ViewMatchers.isDisplayed()));
                ignoreFlag = false;
                break;
            } catch (NoMatchingViewException ex) {
                ignoreFlag = false;
                return;
            } catch (AssertionError ex) {
            }
        }
        ignoreFlag = false;
    }

    public static void waitVanish(ViewInteraction locator, int timeout) {
        ignoreFlag = true;
        long end = System.currentTimeMillis() + (timeout * 1000);
        while ((System.currentTimeMillis() < end)) { // TODO timeout
            try {
                locator.check(matches(ViewMatchers.isDisplayed()));
                ignoreFlag = false;
            } catch (AssertionError|NoMatchingViewException ex) {
                ignoreFlag = false;
                return;
            }
        }
        ignoreFlag = false;
    }

    public static void delay(int sec){
        try {
            Thread.sleep(sec*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void waitVanish(ViewInteraction locator) {
        waitVanish(locator,25); //default value : 20 seconds * 1000 ms/sec
    }

    public static void wakeUpMonitor() {
        PowerManager pm = (PowerManager) getTargetContext().getSystemService(getTargetContext().POWER_SERVICE);
        PowerManager.WakeLock wakeLock = pm.newWakeLock((PowerManager.SCREEN_BRIGHT_WAKE_LOCK | PowerManager.FULL_WAKE_LOCK | PowerManager.ACQUIRE_CAUSES_WAKEUP), "TAG");
        wakeLock.acquire();
    }



    public static String getText(final ViewInteraction matcher) {
        final String[] stringHolder = { null };
        matcher.perform(new ViewAction() {
            @Override
            public Matcher<View> getConstraints() {
                return isAssignableFrom(TextView.class);
            }

            @Override
            public String getDescription() {
                return "getting text from a TextView";
            }

            @Override
            public void perform(UiController uiController, View view) {
                TextView tv = (TextView) view; //Save, because of check in getConstraints()
                stringHolder[0] = tv.getText().toString();
            }
        });
        return stringHolder[0];
    }


    public static void clearDBdata(Context appContext) {
        /*File cache = appContext.getCacheDir();
        File appDir = new File(cache.getParent());
        if (appDir.exists()) {
            String[] children = appDir.list();
            for (String s : children) {
                if (!s.equals("lib")) {
                    deleteDir(new File(appDir, s));

                }
            }
        }*/

//        appContext.deleteDatabase(UtaPassDBOpenHelper.DB_NAME_V3);
//        appContext.deleteDatabase(UtaPassDBOpenHelper.DB_NAME_V1);
//        appContext.deleteDatabase(UtaPassDBOpenHelper.DB_NAME_V2);
        delay(2);
    }

    private static void deleteFile(File file) {
        if (file.exists()) {
            assertTrue(file.delete());
        }
    }

    public static void stopMusic(){
        EventBus.getDefault().post(AudioActionEvent.stop());
        waitVanish(onView(withId(R.id.indicator_action_layout)));
    }
    public static boolean deleteDir(File dir) {
        if (dir != null && dir.isDirectory()) {
            String[] children = dir.list();
            for (int i = 0; i < children.length; i++) {
                boolean success = deleteDir(new File(dir, children[i]));
                if (!success) {
                    return false;
                }
            }
        }

        return dir.delete();
    }


    public static int getRecycleviewItemCount(final View view) {
        RecyclerView recyclerView = (RecyclerView) view;
        RecyclerView.Adapter adapter = recyclerView.getAdapter();
        return  adapter.getItemCount();
    }


    public static RecyclerViewMatcher withRecyclerView(final int recyclerViewId) {
        return new RecyclerViewMatcher(recyclerViewId);

    }

    public static ViewAction clickOnRecyclerView() {
        return new ViewAction() {

            @Override
            public Matcher<View> getConstraints() {
                return any(View.class);
            }

            @Override
            public String getDescription() {
                return "performing click() on recycler view item";
            }

            @Override
            public void perform(UiController uiController, View view) {
                view.performClick();
            }
        };
    }

    public static ViewAction swipeLeft() {
        return new GeneralSwipeAction(Swipe.FAST, GeneralLocation.TOP_RIGHT,
                GeneralLocation.TOP_LEFT, Press.FINGER);
    }


    public interface IntegrationTests {}
    public interface Priority {}
    public interface PerformanceTests {}
    public interface MediumTest extends Priority {}
    public interface LowTest extends Priority {}
    public interface HighTest extends Priority {}
    public interface CriticalTest extends Priority {}
    public interface RAT extends IntegrationTests {}
    public interface FAST extends IntegrationTests {}
    public interface TOFT extends IntegrationTests {}

}
