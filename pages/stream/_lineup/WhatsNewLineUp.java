package com.kddi.android.UtaPass.sqa_espresso.pages.stream._lineup ;

import android.view.View ;

import com.kddi.android.UtaPass.R ;
import com.kddi.android.UtaPass.sqa_espresso.common.LineUpObject;
import com.kddi.android.UtaPass.sqa_espresso.common.UtaPassUtil;
import com.kddi.android.UtaPass.sqa_espresso.pages.stream._lineup._card.CardObject;

import org.hamcrest.Matcher ;

import static android.support.test.espresso.matcher.ViewMatchers.* ;
import static org.hamcrest.Matchers.* ;

public class WhatsNewLineUp extends LineUpObject {

    public static String titleInEnglish = "What's New" ;
    public static String titleInJapanese = "What's New" ;


    protected Matcher<View> getMatcherToCountMaxIndexOfWindow() {
        return withId( R.id.item_three_cover_playlist_root_layout ) ;
    }

    protected String getTitleOfLineUpInEnglish() {
        return WhatsNewLineUp.titleInEnglish ;
    }

    protected String getTitleOfLineUpInJapanese() {
        return WhatsNewLineUp.titleInJapanese ;
    }

    public CardObject getCard(int index ) {
        int indexInWindow = this.swipeToCardViewAndGetIndexOfWindow( index ) ;

        CardObject card = new CardObject() ;

        card.playButton( () -> allOf(
                withId( R.id.view_playlist_play_icon ),
                isDescendantOfA( UtaPassUtil.withIndex(
                        this.getMatcherToCountMaxIndexOfWindow(),
                        indexInWindow ) ) ) ) ;

        card.title( () -> allOf(
                withId( R.id.item_three_cover_playlist_title ),
                isDescendantOfA( UtaPassUtil.withIndex(
                        this.getMatcherToCountMaxIndexOfWindow(),
                        indexInWindow ) ) ) ) ;

        card.likedCount( () -> allOf(
                withId( R.id.item_three_cover_playlist_like_count ),
                isDescendantOfA( UtaPassUtil.withIndex(
                        this.getMatcherToCountMaxIndexOfWindow(),
                        indexInWindow ) ) ) ) ;

        return card ;
    }
}


