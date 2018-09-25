package com.kddi.android.UtaPass.sqa_espresso.pages.stream._lineup ;

import android.support.test.espresso.ViewInteraction ;
import android.view.View ;

import com.kddi.android.UtaPass.R ;

import com.kddi.android.UtaPass.sqa_espresso.common.LineUpObject;
import com.kddi.android.UtaPass.sqa_espresso.common.UtaPassUtil;
import com.kddi.android.UtaPass.sqa_espresso.pages.stream._lineup._card.CardObject;

import org.hamcrest.Matcher ;

import static android.support.test.espresso.Espresso.onView ;
import static android.support.test.espresso.matcher.ViewMatchers.* ;
import static org.hamcrest.Matchers.* ;

public class TopChartsLineUp extends LineUpObject {

    public static String titleInEnglish = "Top Charts" ;
    public static String titleInJapanese = "ランキング" ;

    protected Matcher<View> getMatcherToCountMaxIndexOfWindow() {
        return withId( R.id.item_three_cover_playlist_title ) ;
    }

    protected String getTitleOfLineUpInEnglish() {
        return TopChartsLineUp.titleInEnglish ;
    }

    protected String getTitleOfLineUpInJapanese() {
        return TopChartsLineUp.titleInJapanese ;
    }

    public CardObject getCard( int index ) {
        int indexInWindow = this.swipeToCardViewAndGetIndexOfWindow( index ) ;

        CardObject card = new CardObject() ;

        card.background( this.getBackgroundFromCardView( index ) ) ;

        card.playButton( () -> UtaPassUtil.withIndex(
                allOf( withId( R.id.item_three_cover_playlist_play ),
                       isDescendantOfA( this.getMatcherToFindRecycleView() ) ),
                indexInWindow ) ) ;

        card.title( () -> UtaPassUtil.withIndex(
                allOf( withId( R.id.item_three_cover_playlist_title ),
                       isDescendantOfA( this.getMatcherToFindRecycleView() ) ),
                indexInWindow ) ) ;

        card.likedCount( () -> UtaPassUtil.withIndex(
                allOf( withId( R.id.item_three_cover_playlist_like_count ),
                       isDescendantOfA( this.getMatcherToFindRecycleView() ) ),
                indexInWindow ) ) ;

        return card ;
    }

    private ViewInteraction getBackgroundFromCardView( int index ) {
        return onView( this.getMatcherForBackgroundInCardView( index ) ) ;
    }

    private Matcher<View> getMatcherForBackgroundInCardView( int index ) {
        int indexInWindow = this.swipeToCardViewAndGetIndexOfWindow( index ) ;

        return UtaPassUtil.withIndex(
                    allOf( withId( R.id.item_three_cover_playlist_cover_2 ),
                           isDescendantOfA( this.getMatcherToFindRecycleView() ) ),
                    indexInWindow ) ;
    }
}


