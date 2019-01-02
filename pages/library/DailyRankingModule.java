package com.kddi.android.UtaPass.sqa_espresso.pages.library;

import android.support.test.espresso.NoMatchingViewException;
import android.support.test.espresso.action.ViewActions;
import android.view.View;

import com.kddi.android.UtaPass.R;
import com.kddi.android.UtaPass.sqa_espresso.common.BasicButton;
import com.kddi.android.UtaPass.sqa_espresso.common.BasicImage;
import com.kddi.android.UtaPass.sqa_espresso.common.LazyMatcher ;
import com.kddi.android.UtaPass.sqa_espresso.common.LazyString;
import com.kddi.android.UtaPass.sqa_espresso.common.LineUpObject;
import com.kddi.android.UtaPass.sqa_espresso.common.StringObject;
import com.kddi.android.UtaPass.sqa_espresso.common.UtaPassUtil ;
import com.kddi.android.UtaPass.sqa_espresso.common.card_behavior.IArtistName;
import com.kddi.android.UtaPass.sqa_espresso.common.card_behavior.ICover ;
import com.kddi.android.UtaPass.sqa_espresso.common.card_behavior.IPlayButton;
import com.kddi.android.UtaPass.sqa_espresso.common.card_behavior.ISongName;
import com.kddi.android.UtaPass.sqa_espresso.common.card_behavior.ITitle;
import com.kddi.android.UtaPass.sqa_espresso.pages.common.BasicPage;

import org.hamcrest.Matcher ;

import java.util.HashSet;
import java.util.Set;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.matcher.ViewMatchers.hasSibling;
import static android.support.test.espresso.matcher.ViewMatchers.isCompletelyDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.isDescendantOfA;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.anyOf;

public class DailyRankingModule extends BasicPage {
    private InternalLineUp lineup;
    private static final int MAX_INDEX_OF_LINEOBJECT = 9 ;

    public DailyRankingModule( String label ) {
        this.label( label + " > DailyRankingModule" ) ;
        this.swipeUp();
        this.swipeUp();
        this.swipeUp();
    }

    public void _ready() {
        this.lineUp().assertVisible() ;
        this.DailyRankingTitle().assertVisible() ;
        this.lineUp().card( 0 ).title().assertVisible() ;
        this.lineUp().card( 0 ).cover().assertVisible() ;
        this.lineUp().card( 0 ).songName().assertVisible() ;
        this.lineUp().card( 0 ).artistName().assertVisible() ;
    }

    public InternalLineUp lineUp() {
        if ( this.lineup == null) {
            this.lineup = new InternalLineUp( this.label()) ;
        }
        return this.lineup;
    }

    public BasicButton DailyRankingTitle(){
        return new BasicButton(
                this.label() + " > DailyRankingTitle",
                () -> allOf(
                        anyOf(
                                withText("デイリーランキング"),
                                withText("Daily Ranking") ),
                        isDescendantOfA( withId( R.id.lismo_ranking_title_layout ) ) ) ) ;
    }

    public void swipeUp() {
        onView( withId( R.id.main_container ) ).perform( ViewActions.swipeUp() ) ;
    }

    public class InternalLineUp extends LineUpObject {

        public InternalLineUp( String label ) {
            this.setMaxIndexOfLineUpObject( 10 ) ;
            this.label( label + " > LineUp" ) ;
        }

        protected Matcher<View> getMatcherToFindRecycleView() {
            return withId( R.id.lismo_ranking_recycler_view ) ;
        }

        protected Matcher<View> getMatcherToCountMaxIndexOfWindow() {
            return allOf( withId( R.id.item_library_ranking_content_layout ) ) ;
        }

        public InternalCard card(int index) {
            int indexInWindow = this.swipeToCardViewAndGetIndexOfWindow( index ) ;

            InternalCard card = new InternalCard() ;

            String label = String.format( "%s > Card(%s)",
                    this.label(),
                    index ) ;

            card.cover(label + " > Cover",
                    () -> allOf(
                            withId( R.id.item_lismo_ranking_cover_layout ),
                            hasSibling( withId( R.id.item_lismo_ranking_cover_layout ) ),
                            isDescendantOfA(
                                    UtaPassUtil.withIndex(
                                            this.getMatcherToCountMaxIndexOfWindow(),
                                            indexInWindow ) ),
                            isCompletelyDisplayed() ) ) ;

            card.songName(label + " > SongName",
                    () -> allOf(
                            withId( R.id.item_lismo_ranking_track_name),
                            hasSibling( withId( R.id.item_lismo_ranking_artist_name) ),
                            isDescendantOfA(
                                    UtaPassUtil.withIndex(
                                            this.getMatcherToCountMaxIndexOfWindow(),
                                            indexInWindow ) ) ) ) ;

            card.artistName(label + " > ArtistName",
                    () -> allOf(
                            withId( R.id.item_lismo_ranking_artist_name),
                            hasSibling( withId( R.id.item_lismo_ranking_track_name) ),
                            isDescendantOfA(
                                    UtaPassUtil.withIndex(
                                            this.getMatcherToCountMaxIndexOfWindow(),
                                            indexInWindow ) ) ) ) ;

            card.playButton(label + " > PlayButton",
                    () -> allOf(
                            UtaPassUtil.withDrawable( R.drawable.ic_pre_listen ),
                            hasSibling( withId( R.id.item_lismo_ranking_cover ) ),
                            isDescendantOfA(
                                    UtaPassUtil.withIndex(
                                            this.getMatcherToCountMaxIndexOfWindow(),
                                            indexInWindow ) ) ) ) ;

            card.title(label + " > Title",
                    () -> allOf(
                            withId( R.id.item_lismo_ranking_rank ),
                            hasSibling( withId( R.id.item_lismo_ranking_cover_layout ) ),
                            isDescendantOfA(
                                    UtaPassUtil.withIndex(
                                            this.getMatcherToCountMaxIndexOfWindow(),
                                            indexInWindow ) ) ) ) ;
            return card ;
        }

        public StringObject countSongs() {
            Set<String> set = new HashSet<>() ;

            try {
                for( int i = 0; i <= MAX_INDEX_OF_LINEOBJECT; i++ ){

                    InternalCard card = this.card( i ) ;
                    card( i ).cover().assertVisible() ;
                    set.add( String.format( "%s,%s",
                        card.songName().string(),
                        card.artistName().string() ) ) ;
                    this.dprint( card.songName().string() ) ;
            }

            } catch( NoMatchingViewException e ) {
                this.dprint( e.getMessage() ) ;
            }

            return new StringObject( set.size() ) ;
        }

        public class InternalCard implements ICover, IPlayButton, ISongName, IArtistName, ITitle {

            String labelCover ;
            String labelSongName ;
            String labelArtistName ;
            String labelPlayButton ;
            String labelTitleButton ;

            private LazyMatcher matcherCover ;
            private LazyMatcher matcherSongName ;
            private LazyMatcher matcherArtistName ;
            private LazyMatcher matcherPlayButton ;
            private LazyMatcher matcherTitleButton ;

            public void cover(String label, LazyMatcher matcher) {
                this.labelCover = label ;
                this.matcherCover = matcher ;
            }

            public BasicImage cover() {
                return new BasicImage( this.labelCover, this.matcherCover ) ;
            }

            public void playButton(String label, LazyMatcher matcher) {
                this.labelPlayButton = label ;
                this.matcherPlayButton = matcher ;
            }

            public BasicButton playButton() {
                return new BasicButton( this.labelPlayButton, this.matcherPlayButton ) ;
            }

            public void songName(String label, LazyMatcher matcher) {
                this.labelSongName = label ;
                this.matcherSongName = matcher ;
            }

            public LazyString songName() {
                return new LazyString( this.labelSongName, this.matcherSongName ) ;
            }

            public void artistName(String label, LazyMatcher matcher) {
                this.labelArtistName = label ;
                this.matcherArtistName = matcher ;
            }

            public LazyString artistName() {
                return new LazyString( this.labelArtistName, this.matcherArtistName ) ;
            }

            public void title(String label, LazyMatcher matcher) {
                this.labelTitleButton = label ;
                this.matcherTitleButton = matcher ;
            }

            public LazyString title() {
                return new LazyString( this.labelTitleButton , this.matcherTitleButton ) ;
            }
        }
    }
}