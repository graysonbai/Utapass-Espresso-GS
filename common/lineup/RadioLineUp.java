package com.kddi.android.UtaPass.sqatest.common.lineup ;

import android.view.View;

import com.kddi.android.UtaPass.R;
import com.kddi.android.UtaPass.sqatest.pages.StreamPage;

import org.hamcrest.Matcher;

import static android.support.test.espresso.matcher.ViewMatchers.hasSibling;
import static android.support.test.espresso.matcher.ViewMatchers.withChild;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.anyOf;

public class RadioLineUp extends LineUpObject {

    public static String titleInEnglish = "TODAY'S RADIO" ;
    public static String titleInJapanese = "PICK UP ラジオ" ;

    protected Matcher<View> getMatcherToCountMaxIndexOfWindow() {
        return withId( R.id.item_live_event_image ) ;
    }

    protected String getTitleOfLineUpInEnglish() {
        return RadioLineUp.titleInEnglish ;
    }

    protected String getTitleOfLineUpInJapanese() {
        return RadioLineUp.titleInJapanese ;
    }
}


