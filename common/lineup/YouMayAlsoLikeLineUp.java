package com.kddi.android.UtaPass.sqatest.common.lineup ;

import android.support.test.espresso.NoMatchingViewException;
import android.support.test.espresso.ViewInteraction;
import android.view.View;

import com.kddi.android.UtaPass.R ;
import com.kddi.android.UtaPass.sqatest.common.CardObject;
import com.kddi.android.UtaPass.sqatest.common.UtaPassUtil;
import com.kddi.android.UtaPass.sqatest.pages.StreamPage;

import org.hamcrest.Matcher;

import static android.support.test.espresso.Espresso.onView ;
import static android.support.test.espresso.contrib.RecyclerViewActions.scrollToPosition;
import static android.support.test.espresso.matcher.ViewMatchers.hasSibling;
import static android.support.test.espresso.matcher.ViewMatchers.isAssignableFrom;
import static android.support.test.espresso.matcher.ViewMatchers.isDescendantOfA ;
import static android.support.test.espresso.matcher.ViewMatchers.withChild;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static android.support.test.espresso.action.ViewActions.*;
import static org.hamcrest.Matchers.*;

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

    public CardObject getCard( int index ) {
        CardObject card = new CardObject( this.getPlayButtonFromCardView( index ) ) ;
        card.setTitle( this.getTitleFromCardView( index ) ) ;
        card.setBackground( this.getBackgroundFromCardView( index ) ) ;
        return card ;
    }

    private ViewInteraction getPlayButtonFromCardView( int index ) {
        return onView( this.getMatcherForPlayButtonInCardView( index ) ) ;
    }

    private ViewInteraction getBackgroundFromCardView( int index ) {
        return onView( this.getMatcherForBackgroundInCardView( index ) ) ;
    }
    private String getTitleFromCardView( int index ) {
        return this.getText( this.getMatcherForTitleInCardView( index ) ) ;
    }

    private Matcher<View> getMatcherForPlayButtonInCardView( int index ) {
        int indexInWindow = this.swipeToCardViewAndGetIndexOfWindow( index ) ;

        return UtaPassUtil.withIndex(
                    allOf( withId( R.id.item_three_cover_playlist_play ),
                           isDescendantOfA( this.getMatcherToFindRecycleView() ) ),
                    indexInWindow ) ;
    }

    private Matcher<View> getMatcherForBackgroundInCardView( int index ) {
        int indexInWindow = this.swipeToCardViewAndGetIndexOfWindow( index ) ;

        return UtaPassUtil.withIndex(
                allOf( withId( R.id.item_three_cover_playlist_cover_2 ),
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
}


