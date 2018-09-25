package com.kddi.android.UtaPass.sqa_espresso.pages.stream._lineup ;

import android.view.View ;

import com.kddi.android.UtaPass.R ;
import com.kddi.android.UtaPass.sqa_espresso.common.LineUpObject;
import com.kddi.android.UtaPass.sqa_espresso.common.UtaPassUtil;
import com.kddi.android.UtaPass.sqa_espresso.pages.stream._lineup._card.CardObject;

import org.hamcrest.Matcher ;

import static android.support.test.espresso.matcher.ViewMatchers.* ;
import static org.hamcrest.Matchers.allOf ;


public class LiveLineUp extends LineUpObject {

    public static String titleInEnglish = "LIVE" ;
    public static String titleInJapanese = "LIVE" ;

    protected Matcher<View> getMatcherToCountMaxIndexOfWindow() {
        return withId( R.id.item_live_event_image ) ;
    }

    protected String getTitleOfLineUpInEnglish() {
        return LiveLineUp.titleInEnglish ;
    }

    protected String getTitleOfLineUpInJapanese() {
        return LiveLineUp.titleInJapanese ;
    }

    public CardObject card( int index ) {
        int indexInWindow = this.swipeToCardViewAndGetIndexOfWindow( index ) ;

        CardObject card = new CardObject() ;

        card.playButton( () -> UtaPassUtil.withIndex(
                allOf( withId( R.id.item_live_event_play ),
                       isDescendantOfA( this.getMatcherToFindRecycleView() ) ),
                indexInWindow ) ) ;

        return card ;
    }
}


