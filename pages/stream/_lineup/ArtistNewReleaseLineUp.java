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

public class ArtistNewReleaseLineUp extends LineUpObject {

    public static String titleInEnglish = "Artist new release" ;
    public static String titleInJapanese = "新着アーティスト" ;

    protected Matcher<View> getMatcherToCountMaxIndexOfWindow() {
        return withId( R.id.item_playlist_card_title ) ;
    }

    protected String getTitleOfLineUpInEnglish() {
        return ArtistNewReleaseLineUp.titleInEnglish ;
    }

    protected String getTitleOfLineUpInJapanese() {
        return ArtistNewReleaseLineUp.titleInJapanese ;
    }

    public CardObject getCard(int index ) {
        int indexInWindow = this.swipeToCardViewAndGetIndexOfWindow( index ) ;

        CardObject card = new CardObject() ;

        card.background( this.getBackgroundCard( indexInWindow ) ) ;

        card.playButton( () -> UtaPassUtil.withIndex(
                allOf( withId( R.id.item_playlist_card_play ),
                       isDescendantOfA( this.getMatcherToFindRecycleView() ) ),
                indexInWindow ) ) ;

        card.title( this.getTitleFromCardView( index ) ) ;
        card.likedCount( this.getLikedCountFromCardView( indexInWindow ) ) ;
        return card ;
    }

    private ViewInteraction getBackgroundCard( int index ) {
        return onView( this.getMatcherForBackgroundInCardView( index ) ) ;
    }

    private Matcher<View> getMatcherForBackgroundInCardView( int index ) {
        return UtaPassUtil.withIndex(
                allOf( withId( R.id.item_playlist_card_image ),
                       isDescendantOfA( this.getMatcherToFindRecycleView() ) ),
                index ) ;
    }

    private String getTitleFromCardView( int index ) {
        return this.getText( this.getMatcherForTitleInCardView( index ) ) ;
    }

    private String getLikedCountFromCardView( int index ) {
        return this.getText( this.getMatcherForLikedCountInCardView( index ) ) ;
    }

    private Matcher<View> getMatcherForTitleInCardView( int index ) {
        return UtaPassUtil.withIndex(
                    allOf( withId( R.id.item_playlist_card_title ),
                           isDescendantOfA( this.getMatcherToFindRecycleView() ) ),
                    index ) ;
    }

    private Matcher<View> getMatcherForLikedCountInCardView( int index ) {
        return UtaPassUtil.withIndex(
                    allOf( withId( R.id.item_playlist_card_like_count ),
                           isDescendantOfA( this.getMatcherToFindRecycleView() ) ),
                    index ) ;
    }
}


