package com.kddi.android.UtaPass.sqa_espresso.pages.library.myplaylist;

import android.support.test.espresso.action.ViewActions;
import android.view.View;

import com.kddi.android.UtaPass.R;
import com.kddi.android.UtaPass.sqa_espresso.common.BasicButton;
import com.kddi.android.UtaPass.sqa_espresso.common.BasicImage;
import com.kddi.android.UtaPass.sqa_espresso.common.LazyMatcher;
import com.kddi.android.UtaPass.sqa_espresso.common.LazyString;
import com.kddi.android.UtaPass.sqa_espresso.common.LineUpObject;
import com.kddi.android.UtaPass.sqa_espresso.common.UtaPassUtil;
import com.kddi.android.UtaPass.sqa_espresso.common.ViewObject;
import com.kddi.android.UtaPass.sqa_espresso.common.card_behavior.IArtistName;
import com.kddi.android.UtaPass.sqa_espresso.common.card_behavior.ICover;
import com.kddi.android.UtaPass.sqa_espresso.common.card_behavior.IMoreButton;
import com.kddi.android.UtaPass.sqa_espresso.common.card_behavior.ISongName;
import com.kddi.android.UtaPass.sqa_espresso.pages.common.BasicPage;

import org.hamcrest.Matcher;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.matcher.ViewMatchers.isCompletelyDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.isDescendantOfA;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withParent;
import static org.hamcrest.core.AllOf.allOf;

public class MyPlaylistDetailPage extends BasicPage {
    private InternalLineUp lineUp;

    public MyPlaylistDetailPage(){
        this.label( "MyPlaylistDetailPage" );
    }

    public void _ready(){
        this.ShuffleAllButton().assertVisible();
        this.lineUp().card( 0 ).cover().assertVisible();
        this.swipeUp() ;
        this.swipeUp() ;
    }

    public BasicButton ShuffleAllButton(){
        return new BasicButton( this.label() + "ShuffleAllButton" , () ->
                allOf( withId( R.id.view_shuffle_play_layout ),
                        withParent( withId( R.id.detail_playlist_recycler_view ) ) ) ) ;
    }

    public void swipeUp() {
        onView( withId( R.id.detail_playlist_coordinator_layout  ) ).perform( ViewActions.swipeUp() ) ;
    }

    public BasicButton moreButton(){
        return new BasicButton( this.label() + " > More Button",
                () -> allOf(
                        withId( R.id.detail_playlist_local_overflow ),
                        isDescendantOfA( withId( R.id.detail_playlist_normal_toolbar) ),
                        isCompletelyDisplayed() ) );
    }

    public InternalLineUp lineUp(){
        if( this.lineUp == null ) {
            this.lineUp = new InternalLineUp( this.label() ) ;
        }
        return this.lineUp ;
    }

    public class InternalLineUp extends LineUpObject{
        public InternalLineUp(String label) {
            this.label( label + " > SongsLineUp" );
        }

        protected Matcher<View> getMatcherToFindRecycleView () {
            return withId( R.id.detail_playlist_recycler_view );
        }

        protected Matcher<View> getMatcherToCountMaxIndexOfWindow () {
            return allOf( withId( R.id.item_detail_local_audio_layout ), isCompletelyDisplayed() );
        }

        public InternalCard card ( int index ){
            int indexInWindow = this.swipeToCardViewAndGetIndexOfWindow(index);
            InternalCard card = new InternalCard();

            String label = String.format( "%s > Card(%s)", this.label(), indexInWindow );

            card.songName(label + " > songName ",
                    () -> UtaPassUtil.withIndex(
                            allOf(
                                    withId( R.id.item_detail_local_audio_title ),
                                    isDescendantOfA( this.getMatcherToFindRecycleView())), indexInWindow));

            card.artistName(label + " > artistName ",
                    () -> UtaPassUtil.withIndex(
                           allOf(
                                   withId( R.id.item_detail_local_audio_artist ),
                                   isDescendantOfA( this.getMatcherToFindRecycleView())), indexInWindow));

            card.cover(label + " > cover ",
                    () -> UtaPassUtil.withIndex(
                           allOf(
                                   withId( R.id.layout_detail_local_audio_image ),
                                   isDescendantOfA( this.getMatcherToFindRecycleView())), indexInWindow));

            card.moreButton(label + " > moreButton ",
                    () -> UtaPassUtil.withIndex(
                           allOf(
                                   withId( R.id.item_detail_local_audio_overflow ),
                                   isDescendantOfA( this.getMatcherToFindRecycleView())), indexInWindow));

            return card;
        }

        public class InternalCard implements ICover, IArtistName, ISongName, IMoreButton {

            String labelSongName;
            String labelArtistName;
            String labelCover;
            String labelMoreButton;

            LazyMatcher matcherSongName;
            LazyMatcher matcherArtistName;
            LazyMatcher matcherCover;
            LazyMatcher matcherMoreButton;

            @Override
            public void cover(String label, LazyMatcher matcher) {
                this.labelCover = label;
                this.matcherCover = matcher;
            }

            @Override
            public BasicImage cover() {
                return new BasicImage(this.labelCover, this.matcherCover);
            }

            @Override
            public void artistName(String label, LazyMatcher matcher) {
                this.matcherArtistName = matcher;
                this.labelArtistName = label;
            }

            public LazyString artistName() {
                return new LazyString(this.labelArtistName, this.matcherArtistName);
            }

            @Override
            public void songName(String label, LazyMatcher matcher) {
                this.labelSongName = label;
                this.matcherSongName = matcher;
            }

            @Override
            public LazyString songName() {
                return new LazyString(this.labelSongName, this.matcherSongName);
            }

            @Override
            public void moreButton(String label, LazyMatcher matcher) {
                this.labelMoreButton = label;
                this.matcherMoreButton = matcher;
            }

            @Override
            public BasicButton moreButton() {
                return new BasicButton(this.labelMoreButton, this.matcherMoreButton);
            }
        }
    }
}
