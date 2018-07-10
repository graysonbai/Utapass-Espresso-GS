package com.kddi.android.UtaPass.sqa_espresso.common.lineup ;

import android.support.test.espresso.ViewInteraction ;
import android.view.View ;

import com.kddi.android.UtaPass.R ;
import com.kddi.android.UtaPass.sqa_espresso.common.* ;

import org.hamcrest.Matcher ;

import static android.support.test.espresso.Espresso.onView ;
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

    public CardObject getCard( int index ) {
        this.swipeToPosition( index ) ;

        CardObject card = new CardObject( index ) ;
        card.setPlayButton( this.getPlayButtonFromCardView( index ) ) ;
        return card ;
    }

    private ViewInteraction getPlayButtonFromCardView( int index ) {
        return onView( this.getMatcherForPlayButtonInCardView( index ) ) ;
    }

    private Matcher<View> getMatcherForPlayButtonInCardView( int index ) {
        int indexInWindow = this.swipeToCardViewAndGetIndexOfWindow( index ) ;

        return UtaPassUtil.withIndex(
                    allOf( withId( R.id.item_live_event_play ),
                           isDescendantOfA( this.getMatcherToFindRecycleView() ) ),
                    indexInWindow ) ;
    }
}


