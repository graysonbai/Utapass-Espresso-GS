package com.kddi.android.UtaPass.sqa_espresso.pages.stream._lineup ;

import android.view.View ;

import com.kddi.android.UtaPass.R ;
import com.kddi.android.UtaPass.sqa_espresso.common.LineUpObject;
import com.kddi.android.UtaPass.sqa_espresso.common.UtaPassUtil;
import com.kddi.android.UtaPass.sqa_espresso.pages.stream._lineup._card.CardObject;

import org.hamcrest.Matcher ;

import static android.support.test.espresso.matcher.ViewMatchers.* ;
import static org.hamcrest.Matchers.* ;


public class YouMayAlsoLikeLineUp extends LineUpObject {

    public static String titleInEnglish = "You may also like" ;
    public static String titleInJapanese = "あなたにオススメ" ;

    protected Matcher<View> getMatcherToCountMaxIndexOfWindow() {
        return withId( R.id.item_three_cover_playlist_cover_1 ) ;
    }

    protected String getTitleOfLineUpInEnglish() {
        return YouMayAlsoLikeLineUp.titleInEnglish ;
    }

    protected String getTitleOfLineUpInJapanese() {
        return YouMayAlsoLikeLineUp.titleInJapanese ;
    }

    public CardObject getCard(int index ) {
        int indexInWindow = this.swipeToCardViewAndGetIndexOfWindow( index ) ;

        CardObject card = new CardObject() ;

        card.image( () -> UtaPassUtil.withIndex(
                allOf( withId( R.id.item_three_cover_playlist_cover_2 ),
                       isDescendantOfA( this.getMatcherToFindRecycleView() ) ),
                indexInWindow ) ) ;

        card.playButton( () -> UtaPassUtil.withIndex(
                allOf( withId( R.id.item_three_cover_playlist_play ),
                       isDescendantOfA( this.getMatcherToFindRecycleView() ) ),
                indexInWindow ) ) ;

        card.title( () -> UtaPassUtil.withIndex(
                allOf( withId( R.id.item_three_cover_playlist_title ),
                       isDescendantOfA( this.getMatcherToFindRecycleView() ) ),
                indexInWindow ) ) ;

        return card ;
    }
}


