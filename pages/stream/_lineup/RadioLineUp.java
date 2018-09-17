package com.kddi.android.UtaPass.sqa_espresso.pages.stream._lineup ;

import android.view.View ;
import com.kddi.android.UtaPass.R ;
import com.kddi.android.UtaPass.sqa_espresso.common.LineUpObject;

import org.hamcrest.Matcher ;
import static android.support.test.espresso.matcher.ViewMatchers.withId ;

public class RadioLineUp extends LineUpObject {

    public static String titleInEnglish = "TODAY'S RADIO" ;
    public static String titleInJapanese = "オリジナルラジオ番組" ;

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


