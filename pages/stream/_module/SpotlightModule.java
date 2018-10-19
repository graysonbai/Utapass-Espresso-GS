package com.kddi.android.UtaPass.sqa_espresso.pages.stream._module ;

import android.view.View;

import com.kddi.android.UtaPass.R ;
import com.kddi.android.UtaPass.sqa_espresso.common.BasicImage;
import com.kddi.android.UtaPass.sqa_espresso.common.LazyMatcher;
import com.kddi.android.UtaPass.sqa_espresso.common.LineUpObject;
import com.kddi.android.UtaPass.sqa_espresso.common.UtaPassUtil;
import com.kddi.android.UtaPass.sqa_espresso.common.ViewObject;
import com.kddi.android.UtaPass.sqa_espresso.common.card_behavior.ICover;

import org.hamcrest.Matcher;

import static android.support.test.espresso.matcher.ViewMatchers.hasDescendant;
import static android.support.test.espresso.matcher.ViewMatchers.isCompletelyDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.isDescendantOfA;
import static android.support.test.espresso.matcher.ViewMatchers.withId ;
import static org.hamcrest.Matchers.allOf;


public class SpotlightModule extends ViewObject {
    private InternalLineUp lineup ;

    public SpotlightModule( String label ) {
        this.label( label + " > SpotlightModule" ) ;
        this.retryWhenNotReady( false ) ;
    }

    @Override
    public void _ready() {
        this.lineUp().ready() ;
        this.lineUp().card( 0 ).cover().ready() ;
    }

    public Matcher<View> matcher() {
        return allOf(
                withId( R.id.item_list_root_layout ),
                hasDescendant( withId( R.id.item_spotlight_root_layout ) ) ) ;
    }

    public InternalLineUp lineUp() {
        if( this.lineup == null ) {
            this.lineup = new InternalLineUp( this.label() ) ;
        }
        return this.lineup ;
    }

    public class InternalLineUp extends LineUpObject {

        public InternalLineUp( String label ) {
            this.label( label + " > LineUp" ) ;
        }

        protected Matcher<View> getMatcherToFindRecycleView() {
            return allOf(
                    withId( R.id.item_stream_list ),
                    hasDescendant( withId( R.id.item_spotlight_root_layout ) ) ) ;
        }

        protected Matcher<View> getMatcherToCountMaxIndexOfWindow() {
            return allOf(
                    withId( R.id.item_spotlight_root_layout ),
                    isCompletelyDisplayed() ) ;
        }

        public InternalCard card( int index ) {
            int indexInWindow = this.swipeToCardViewAndGetIndexOfWindow( index ) ;

            InternalCard card = new InternalCard() ;

            String label = String.format( "%s > Card(%s)",
                    this.label(),
                    index ) ;

            card.cover( label + " > Cover",
                    () -> allOf(
                            withId( R.id.item_spotlight_image ),
                            isDescendantOfA( UtaPassUtil.withIndex(
                                    this.getMatcherToCountMaxIndexOfWindow(),
                                    indexInWindow ) ) ) ) ;
            return card ;
        }
    }

    public class InternalCard implements ICover {

        String labelCover ;
        private LazyMatcher matcherCover ;

        public void cover( String label, LazyMatcher matcher ) {
            this.labelCover = label ;
            this.matcherCover = matcher ;
        }

        public BasicImage cover() {
            return new BasicImage( this.labelCover, this.matcherCover ) ;
        }

        public void tap() {
            this.cover().tap() ;
        }
    }
}




