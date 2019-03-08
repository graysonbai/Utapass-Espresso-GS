package com.kddi.android.UtaPass.sqa_espresso.pages.stream.detail;

import android.view.View;

import com.kddi.android.UtaPass.R;
import com.kddi.android.UtaPass.sqa_espresso.common.BasicButton;
import com.kddi.android.UtaPass.sqa_espresso.common.LazyMatcher;
import com.kddi.android.UtaPass.sqa_espresso.common.LazyString;
import com.kddi.android.UtaPass.sqa_espresso.common.LineUpObject;
import com.kddi.android.UtaPass.sqa_espresso.common.UtaPassUtil;
import com.kddi.android.UtaPass.sqa_espresso.common.ViewObject;
import com.kddi.android.UtaPass.sqa_espresso.common.card_behavior.IArtistName;
import com.kddi.android.UtaPass.sqa_espresso.common.card_behavior.IDate;
import com.kddi.android.UtaPass.sqa_espresso.common.card_behavior.IMyUtaButton;
import com.kddi.android.UtaPass.sqa_espresso.common.card_behavior.ISongName;
import com.kddi.android.UtaPass.sqa_espresso.common.card_behavior.ITime;

import org.hamcrest.Matcher;

import static android.support.test.espresso.matcher.ViewMatchers.hasSibling;
import static android.support.test.espresso.matcher.ViewMatchers.isCompletelyDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.isDescendantOfA;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.core.AllOf.allOf;

public class OnAirSonglistPage extends ViewObject {
    private InternalLineUp lineUp;

    public OnAirSonglistPage(){
        this.label( "on-ari songlist Page" );
    }

    public void _ready(){
        this.onAriSonglistDescription().assertVisible();
        this.onAriSonglistTitle().assertVisible();
    }

    public LazyString onAriSonglistTitle(){
        return new LazyString(this.label() + " > on-Ari Songlist Title",
                () -> allOf(
                        withId(R.id.title_text),
                        isDescendantOfA( withId( R.id.historyDescription) ),
                        isCompletelyDisplayed() ) );
    }

    public LazyString onAriSonglistDescription(){
        return new LazyString( this.label() + " > on-Ari Songlist Description",
                () -> allOf(
                        withId(R.id.description_text),
                        isDescendantOfA( withId( R.id.historyDescription) ),
                        isCompletelyDisplayed() ) );
    }

    public BasicButton onAriSonglistPlaylistButton(){
        return new BasicButton( this.label() + " > on-Ari Songlist PlaylistButton",
                () -> allOf(
                        withId(R.id.playlistButton),
                        hasSibling( withId( R.id.historyDescription ) ),
                        isDescendantOfA( withId( R.id.programHistoryRecyclerView) ),
                        isCompletelyDisplayed() ) );
    }

    public InternalLineUp lineUp(){
        if( this.lineUp == null ) {
            this.lineUp = new InternalLineUp( this.label() ) ;
        }
        return this.lineUp ;
    }

    public class InternalLineUp extends LineUpObject {
        public InternalLineUp(String label) {
            this.label( label + " > SongsLineUp" );
        }

        protected Matcher<View> getMatcherToFindRecycleView () {
            return withId( R.id.programHistoryRecyclerView );
        }

        protected Matcher<View> getMatcherToCountMaxIndexOfWindow () {
            return allOf( withId( R.id.history_radio_program_root_layout ), isCompletelyDisplayed() );
        }

        public InternalCard card ( int index ){
            int indexInWindow = this.swipeToCardViewAndGetIndexOfWindow(index);
            InternalCard card = new InternalCard();

            String label = String.format( "%s > Card(%s)", this.label(), indexInWindow );

            card.songName(label + " > song Name ",
                    () -> UtaPassUtil.withIndex(
                            allOf(
                                    withId( R.id.songName ),
                                    isDescendantOfA( this.getMatcherToFindRecycleView())), indexInWindow ) );

            card.artistName(label + " > artist Name ",
                    () -> UtaPassUtil.withIndex(
                            allOf(
                                    withId( R.id.artistName ),
                                    isDescendantOfA( this.getMatcherToFindRecycleView())), indexInWindow ) );

            card.time(label + " > time text ",
                    () -> UtaPassUtil.withIndex(
                            allOf(
                                    withId( R.id.time_text ),
                                    isDescendantOfA( this.getMatcherToFindRecycleView())), indexInWindow ) );

            card.date(label + " > date ",
                    () -> UtaPassUtil.withIndex(
                            allOf(
                                    withId( R.id.date_text ),
                                    isDescendantOfA( this.getMatcherToFindRecycleView())), indexInWindow ) );

            card.myUtaButton(label + " > myUta Button ",
                    () -> UtaPassUtil.withIndex(
                            allOf(
                                    withId( R.id.item_detail_stream_audio_button_wrapper ),
                                    isDescendantOfA( this.getMatcherToFindRecycleView())), indexInWindow ) );

            return card;
        }

        public class InternalCard implements IDate, IArtistName, ISongName, IMyUtaButton, ITime {

            String labelSongName;
            String labelArtistName;
            String labelTime;
            String labelDate;
            String labelMyUtaButton;



            LazyMatcher matcherSongName;
            LazyMatcher matcherArtistName;
            LazyMatcher matcherTime;
            LazyMatcher matcherDate;
            LazyMatcher matcherMyUtaButton;

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
            public void date(String label, LazyMatcher matcher) {
                this.labelDate = label;
                this.matcherDate = matcher;
            }

            @Override
            public LazyString date() {
                return new LazyString( this.labelDate, this.matcherDate );
            }

            @Override
            public void myUtaButton(String label, LazyMatcher matcher) {
                this.labelMyUtaButton = label;
                this.matcherMyUtaButton = matcher;
            }

            @Override
            public BasicButton myUtaButton() {
                return new BasicButton( this.labelMyUtaButton, this.matcherMyUtaButton );
            }

            @Override
            public void time(String label, LazyMatcher matcher) {
                this.labelTime = label;
                this.matcherTime = matcher;
            }

            @Override
            public LazyString time() {
                return new LazyString( this.labelTime, this.matcherTime );
            }
        }
    }

}
