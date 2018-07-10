package com.kddi.android.UtaPass.sqatest.util;

import android.support.test.espresso.base.DefaultFailureHandler;
import android.util.Log;
import android.view.View;

import org.hamcrest.Matcher;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static android.support.test.InstrumentationRegistry.getTargetContext;

/**
 * Created by vanessatsai on 16/2/24.
 */

public class FailureHandler implements android.support.test.espresso.FailureHandler {

    static String TAG = "espresso";

    @Override
    public void handle(Throwable error, Matcher<View> viewMatcher) {

        if (!EspressoUtil.ignoreFlag) {
            EspressoUtil.takeScreenshot("Error_in_" + filename());
            logger(error);
        }
        new DefaultFailureHandler(getTargetContext()).handle(error, viewMatcher);
    }


    private String filename() {
        Date date = Calendar.getInstance().getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
        return sdf.format(date);
    }


    private String logger(Throwable ex) {
        final Writer result = new StringWriter();
        final PrintWriter printWriter = new PrintWriter(result);
        ex.printStackTrace(printWriter);
        String stacktrace = result.toString();
        printWriter.close();
        Log.i(TAG, stacktrace);
        return stacktrace;
    }


}


