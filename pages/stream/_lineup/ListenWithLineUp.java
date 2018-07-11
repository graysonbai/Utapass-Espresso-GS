package com.kddi.android.UtaPass.sqa_espresso.pages.stream._lineup ;

import android.view.View ;
import com.kddi.android.UtaPass.R ;
import com.kddi.android.UtaPass.sqa_espresso.common.LineUpObject;

import org.hamcrest.Matcher ;
import static android.support.test.espresso.matcher.ViewMatchers.withId ;

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


