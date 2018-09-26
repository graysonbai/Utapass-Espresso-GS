package com.kddi.android.UtaPass.sqa_espresso.pages.stream._lineup ;

import android.view.View ;

import com.kddi.android.UtaPass.R ;
import com.kddi.android.UtaPass.sqa_espresso.common.LineUpObject;
import com.kddi.android.UtaPass.sqa_espresso.pages.stream._lineup._card.CardObject;

import org.hamcrest.Matcher;

import static android.support.test.espresso.matcher.ViewMatchers.withId ;


public class DailyMixLineUp extends LineUpObject {

    protected Matcher<View> getMatcherToFindRecycleView() {
        return withId( R.id.item_dailymix_root_layout ) ;
    }

    protected Matcher<View> getMatcherToCountMaxIndexOfWindow() {
        return withId( R.id.item_dailymix_cardview ) ;
    }

    public CardObject getCard() {
        CardObject card = new CardObject() ;

        card.image( () -> withId( R.id.item_dailymix_cardview ) ) ;

        card.playButton( () -> withId( R.id.item_dailymix_play ) ) ;

        card.title( () -> withId( R.id.item_dailymix_title ) ) ;

        return card ;
    }
}


