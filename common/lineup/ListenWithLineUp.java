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

public class ListenWithLineUp extends LineUpObject {

    public static String titleInEnglish = "Listen with" ;
    public static String titleInJapanese = "Listen with" ;

    protected Matcher<View> getMatcherToCountMaxIndexOfWindow() {

        // TODO
        return withId( R.id.item_stream_list ) ;
    }

    protected String getTitleOfLineUpInEnglish() {
        return LiveLineUp.titleInEnglish ;
    }

    protected String getTitleOfLineUpInJapanese() {
        return LiveLineUp.titleInJapanese ;
    }
}


