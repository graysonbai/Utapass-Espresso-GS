package com.kddi.android.UtaPass.sqa_espresso.common.lineup ;

import android.view.View ;
import com.kddi.android.UtaPass.R ;
import org.hamcrest.Matcher ;
import static android.support.test.espresso.matcher.ViewMatchers.withId ;

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


