package com.kddi.android.UtaPass.sqa_espresso.pages.stream._lineup ;

import android.view.View;

import com.kddi.android.UtaPass.R ;
import com.kddi.android.UtaPass.sqa_espresso.common.LineUpObject;
import com.kddi.android.UtaPass.sqa_espresso.common.UtaPassUtil;
import com.kddi.android.UtaPass.sqa_espresso.pages.stream._lineup._card.CardObject;

import org.hamcrest.Matcher;

import static android.support.test.espresso.matcher.ViewMatchers.isDescendantOfA ;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.*;

public class NewSongsHitSongsLineUp extends LineUpObject {

    public static String titleInEnglish = "New songs/Hit songs" ;
    public static String titleInJapanese = "新曲/ヒットソング" ;

    protected Matcher<View> getMatcherToCountMaxIndexOfWindow() {
        return withId( R.id.item_three_cover_playlist_cover_1 ) ;
    }

    protected String getTitleOfLineUpInEnglish() {
        return NewSongsHitSongsLineUp.titleInEnglish ;
    }

    protected String getTitleOfLineUpInJapanese() {
        return NewSongsHitSongsLineUp.titleInJapanese ;
    }

    public CardObject getCard( int index ) {
        int indexInWindow = this.swipeToCardViewAndGetIndexOfWindow( index ) ;

        CardObject card = new CardObject() ;

        card.playButton( () -> UtaPassUtil.withIndex(
                allOf( withId( R.id.item_three_cover_playlist_play ),
                       isDescendantOfA( this.getMatcherToFindRecycleView() ) ),
                indexInWindow ) ) ;

        card.title( this.getTitleFromCardView( index ) ) ;
        card.likedCount( this.getLikedCountFromCardView( index ) ) ;
        return card ;
    }

    private String getTitleFromCardView( int index ) {
        return this.getText( this.getMatcherForTitleInCardView( index ) ) ;
    }

    private String getLikedCountFromCardView( int index ) {
        return this.getText( this.getMatcherForLikedCountInCardView( index ) ) ;
    }

    private Matcher<View> getMatcherForTitleInCardView( int index ) {
        return UtaPassUtil.withIndex(
                    allOf( withId( R.id.item_three_cover_playlist_title ),
                           isDescendantOfA( this.getMatcherToFindRecycleView() ) ),
                    index ) ;
    }

    private Matcher<View> getMatcherForLikedCountInCardView( int index ) {

        return UtaPassUtil.withIndex(
                    allOf( withId( R.id.item_three_cover_playlist_like_count ),
                           isDescendantOfA( this.getMatcherToFindRecycleView() ) ),
                    index ) ;
    }
}


