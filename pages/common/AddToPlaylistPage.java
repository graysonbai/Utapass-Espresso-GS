package com.kddi.android.UtaPass.sqa_espresso.pages.common;

import android.view.View;

import com.kddi.android.UtaPass.R;
import com.kddi.android.UtaPass.sqa_espresso.common.BasicButton;
import com.kddi.android.UtaPass.sqa_espresso.common.BasicImage;
import com.kddi.android.UtaPass.sqa_espresso.common.LazyMatcher;
import com.kddi.android.UtaPass.sqa_espresso.common.LazyString;
import com.kddi.android.UtaPass.sqa_espresso.common.LineUpObject;
import com.kddi.android.UtaPass.sqa_espresso.common.UtaPassUtil;
import com.kddi.android.UtaPass.sqa_espresso.common.ViewObject;
import com.kddi.android.UtaPass.sqa_espresso.common.card_behavior.ICover;
import com.kddi.android.UtaPass.sqa_espresso.common.card_behavior.IPlayButton;
import com.kddi.android.UtaPass.sqa_espresso.common.card_behavior.ITitle;

import org.hamcrest.Matcher;

import static android.support.test.espresso.matcher.ViewMatchers.isCompletelyDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.isDescendantOfA;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.allOf;

public class AddToPlaylistPage extends ViewObject{
    private InternalLineUp lineUp;

    public AddToPlaylistPage(){
           this.label( "AddToPlaylistPage" );
    }

    public void _ready(){
        this.createNowButton().assertVisible();
    }

    public BasicButton createNowButton(){
        return new BasicButton( this.label() + "> CreateNowButton" ,
                () -> allOf(
                        withId( R.id.add_tracks_to_playlist_fab ),
                        isCompletelyDisplayed() ) );
    }

    public InternalLineUp lineUp(){
        if( this.lineUp == null ) {
            this.lineUp = new InternalLineUp( this.label() ) ;
        }
        return this.lineUp ;
    }

    public class InternalLineUp extends LineUpObject {

        public InternalLineUp( String label ){
            this.label( label + " > LineUp" );
        }

        @Override
        protected Matcher<View> getMatcherToFindRecycleView() {
            return withId( R.id.add_tracks_to_playlist_recycler_view );
        }

        @Override
        protected Matcher<View> getMatcherToCountMaxIndexOfWindow() {
            return allOf( withId( R.id.item_playlist_content_layout ), isCompletelyDisplayed() );
        }

        public void _ready(){
            card( 0 ).cover().assertVisible();
        }

        public InternalCard card( int index ){
            int indexInWindow = this.swipeToCardViewAndGetIndexOfWindow( index ) ;
            InternalCard card = new InternalCard();

            String label = String.format( "%s > Card(%s)", this.label(), indexInWindow );

            card.cover( label + " > Cover",
                    () -> allOf(
                            withId(R.id.item_playlist_cardview ),
                            isDescendantOfA( UtaPassUtil.withIndex(
                                    this.getMatcherToCountMaxIndexOfWindow(),
                                    indexInWindow))) );

            card.playButton(label + " > PlayButton",
                    () -> allOf(
                            withId(R.id.item_playlist_card_play ),
                            isDescendantOfA( UtaPassUtil.withIndex(
                                    this.getMatcherToCountMaxIndexOfWindow(),
                                    indexInWindow))) );

            card.title( label + " > Title",
                    () -> allOf(
                            withId(R.id.item_playlist_card_title ),
                            isDescendantOfA( UtaPassUtil.withIndex(
                                    this.getMatcherToCountMaxIndexOfWindow(),
                                    indexInWindow)) ));

            return card;
        }

        public class InternalCard implements ICover, IPlayButton, ITitle {
            String labelCover ;
            String labelPlayButton ;
            String labelTitle ;

            private LazyMatcher matcherCover ;
            private LazyMatcher matcherPlayButton ;
            private LazyMatcher matcherTitle ;

            public void cover( String label, LazyMatcher matcher ) {
                this.labelCover = label;
                this.matcherCover = matcher;
            }

            public BasicImage cover() {
                return new BasicImage( this.labelCover, this.matcherCover );
            }

            public void playButton( String label, LazyMatcher matcher ) {
                this.labelPlayButton = label;
                this.matcherPlayButton = matcher;
            }

            public BasicButton playButton() {
                return new BasicButton( this.labelPlayButton, this.matcherPlayButton );
            }

            public void title( String label, LazyMatcher matcher ) {
                this.labelTitle = label ;
                this.matcherTitle = matcher ;
            }

            public LazyString title() {
                return new LazyString( this.labelTitle, this.matcherTitle ) ;
            }
        }
    }
}
