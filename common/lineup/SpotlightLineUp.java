package com.kddi.android.UtaPass.sqatest.common.lineup ;

import android.support.test.espresso.NoMatchingViewException;
import android.support.test.espresso.ViewInteraction;
import android.view.View;

import com.kddi.android.UtaPass.R ;
import com.kddi.android.UtaPass.sqatest.common.CardObject;
import com.kddi.android.UtaPass.sqatest.common.UtaPassUtil;
import com.kddi.android.UtaPass.sqatest.pages.StreamPage;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

import static android.support.test.espresso.Espresso.onView ;
import static android.support.test.espresso.contrib.RecyclerViewActions.scrollToPosition;
import static android.support.test.espresso.matcher.ViewMatchers.hasDescendant;
import static android.support.test.espresso.matcher.ViewMatchers.hasSibling;
import static android.support.test.espresso.matcher.ViewMatchers.isAssignableFrom;
import static android.support.test.espresso.matcher.ViewMatchers.isDescendantOfA ;
import static android.support.test.espresso.matcher.ViewMatchers.withChild;
import static android.support.test.espresso.matcher.ViewMatchers.withClassName;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static android.support.test.espresso.action.ViewActions.*;
import static org.hamcrest.Matchers.*;

public class SpotlightLineUp extends LineUpObject {

    @Override
    public void _ready() {
        boolean isVisible = this.isVisible(
                                UtaPassUtil.withIndex( this.getMatcherToCountMaxIndexOfWindow(),
                                                      0 ) ) ;

        if( !isVisible ) {
             throw new RuntimeException( "SpotlightLineUp is not ready" ) ;
        }
    }

    protected Matcher<View> getMatcherToFindRecycleView() {
        return allOf( withId( R.id.item_stream_list ),
                      hasDescendant( withId( R.id.item_spotlight_root_layout ) ) ) ;
    }

    protected Matcher<View> getMatcherToCountMaxIndexOfWindow() {
        return withId( R.id.item_spotlight_image ) ;
    }

    public CardObject getCard( int index ) {
        this.swipeToPosition( index ) ;

        CardObject card = new CardObject( index ) ;
        card.setBackground( this.getBackgroundCard( index ) ) ;
        card.setTitle( "最近聴いたものからオススメする50曲" ) ;
        return card ;
    }

    private ViewInteraction getBackgroundCard( int index ) {
        return onView( this.getMatcherForBackgroundInCardView( index ) ) ;
    }

    private Matcher<View> getMatcherForBackgroundInCardView( int index ) {
        int indexInWindow = this.swipeToCardViewAndGetIndexOfWindow( index ) ;

        return UtaPassUtil.withIndex(
                    allOf( withId( R.id.item_spotlight_image ),
                           isDescendantOfA( this.getMatcherToFindRecycleView() ) ),
                    indexInWindow ) ;
    }
}


