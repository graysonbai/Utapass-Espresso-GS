package com.kddi.android.UtaPass.sqa_espresso.common.lineup ;

import android.support.test.espresso.ViewInteraction ;
import android.view.View ;

import com.kddi.android.UtaPass.R ;
import com.kddi.android.UtaPass.sqa_espresso.common.* ;

import org.hamcrest.Matcher ;

import static android.support.test.espresso.Espresso.onView ;
import static android.support.test.espresso.matcher.ViewMatchers.* ;
import static org.hamcrest.Matchers.* ;

public class WhatsNewLineUp extends LineUpObject {

    public static String titleInEnglish = "What's New" ;
    public static String titleInJapanese = "What's New" ;


    protected Matcher<View> getMatcherToCountMaxIndexOfWindow() {
        return withId( R.id.item_three_cover_playlist_cover_1 ) ;
    }

    protected String getTitleOfLineUpInEnglish() {
        return WhatsNewLineUp.titleInEnglish ;
    }

    protected String getTitleOfLineUpInJapanese() {
        return WhatsNewLineUp.titleInJapanese ;
    }

    public CardObject getCard( int index ) {
        CardObject card = new CardObject( this.getPlayButtonFromCardView( index ) ) ;
        card.setTitle( this.getTitleFromCardView( index ) ) ;
        card.setLikedCount( this.getLikedCountFromCardView( index ) ) ;
        return card ;
    }

    private ViewInteraction getPlayButtonFromCardView( int index ) {
        return onView( this.getMatcherForPlayButtonInCardView( index ) ) ;
    }

    private String getTitleFromCardView( int index ) {
        return this.getText( this.getMatcherForTitleInCardView( index ) ) ;
    }

    private String getLikedCountFromCardView( int index ) {
        return this.getText( this.getMatcherForLikedCountInCardView( index ) ) ;
    }

    private Matcher<View> getMatcherForPlayButtonInCardView( int index ) {
        int indexInWindow = this.swipeToCardViewAndGetIndexOfWindow( index ) ;

        return UtaPassUtil.withIndex(
                    allOf( withId( R.id.item_three_cover_playlist_play ),
                           isDescendantOfA( this.getMatcherToFindRecycleView() ) ),
                    indexInWindow ) ;
    }

    private Matcher<View> getMatcherForTitleInCardView( int index ) {
        int indexInWindow = this.swipeToCardViewAndGetIndexOfWindow( index ) ;

        return UtaPassUtil.withIndex(
                    allOf( withId( R.id.item_three_cover_playlist_title ),
                           isDescendantOfA( this.getMatcherToFindRecycleView() ) ),
                    indexInWindow ) ;
    }

    private Matcher<View> getMatcherForLikedCountInCardView( int index ) {
        int indexInWindow = this.swipeToCardViewAndGetIndexOfWindow( index ) ;

        return UtaPassUtil.withIndex(
                    allOf( withId( R.id.item_three_cover_playlist_like_count ),
                           isDescendantOfA( this.getMatcherToFindRecycleView() ) ),
                    indexInWindow ) ;
    }
}


