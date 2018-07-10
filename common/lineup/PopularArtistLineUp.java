package com.kddi.android.UtaPass.sqa_espresso.common.lineup ;

import android.support.test.espresso.ViewInteraction ;
import android.view.View ;

import com.kddi.android.UtaPass.R ;
import com.kddi.android.UtaPass.sqa_espresso.common.* ;

import org.hamcrest.Matcher ;

import static android.support.test.espresso.Espresso.onView ;
import static android.support.test.espresso.matcher.ViewMatchers.* ;
import static org.hamcrest.Matchers.* ;

public class PopularArtistLineUp extends LineUpObject {

    public static String titleInEnglish = "Popular Artist" ;
    public static String titleInJapanese = "人気アーティスト" ;

    @Override
    public void _ready() {
    }

    protected Matcher<View> getMatcherToCountMaxIndexOfWindow() {
        return withId( R.id.item_playlist_card_image ) ;
    }

    protected String getTitleOfLineUpInEnglish() {
        return PopularArtistLineUp.titleInEnglish ;
    }

    protected String getTitleOfLineUpInJapanese() {
        return PopularArtistLineUp.titleInJapanese ;
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
                    allOf( withId( R.id.item_playlist_card_play ),
                           isDescendantOfA( this.getMatcherToFindRecycleView() ) ),
                    indexInWindow ) ;
    }

    private Matcher<View> getMatcherForTitleInCardView( int index ) {
        int indexInWindow = this.swipeToCardViewAndGetIndexOfWindow( index ) ;

        return UtaPassUtil.withIndex(
                    allOf( withId( R.id.item_playlist_card_title ),
                           isDescendantOfA( this.getMatcherToFindRecycleView() ) ),
                    indexInWindow ) ;
    }

    private Matcher<View> getMatcherForLikedCountInCardView( int index ) {
        int indexInWindow = this.swipeToCardViewAndGetIndexOfWindow( index ) ;

        return UtaPassUtil.withIndex(
                allOf( withId( R.id.item_playlist_card_like_count ),
                        isDescendantOfA( this.getMatcherToFindRecycleView() ) ),
                indexInWindow ) ;
    }
}


