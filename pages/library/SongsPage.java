package com.kddi.android.UtaPass.sqa_espresso.pages.library ;

import android.view.View;

import com.kddi.android.UtaPass.R ;
import com.kddi.android.UtaPass.sqa_espresso.common.BasicButton;
import com.kddi.android.UtaPass.sqa_espresso.common.BasicImage;
import com.kddi.android.UtaPass.sqa_espresso.common.LazyMatcher;
import com.kddi.android.UtaPass.sqa_espresso.common.LazyString;
import com.kddi.android.UtaPass.sqa_espresso.common.LineUpObject;
import com.kddi.android.UtaPass.sqa_espresso.common.StringObject;
import com.kddi.android.UtaPass.sqa_espresso.common.UserStatus;
import com.kddi.android.UtaPass.sqa_espresso.common.UtaPassUtil;
import com.kddi.android.UtaPass.sqa_espresso.common.card_behavior.IArtistName;
import com.kddi.android.UtaPass.sqa_espresso.common.card_behavior.ICover;
import com.kddi.android.UtaPass.sqa_espresso.common.card_behavior.IMoreActionsButton;
import com.kddi.android.UtaPass.sqa_espresso.common.card_behavior.ISongName;
import com.kddi.android.UtaPass.sqa_espresso.pages.common.BasicPage;

import org.hamcrest.Matcher;

import static android.support.test.espresso.matcher.ViewMatchers.isCompletelyDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.isDescendantOfA;
import static android.support.test.espresso.matcher.ViewMatchers.withId ;
import static org.hamcrest.Matchers.allOf;


public class SongsPage extends BasicPage {
    private InternalLineUp lineUp ;
    private boolean readyFlag = false ;

    public SongsPage() {
        this.label( "LibraryPage > Songs" ) ;
        this.retryWhenNotReady( false ) ;
    }

    public void _ready() {
        if( this.readyFlag ) {
            return ;
        }

        if( ! UserStatus.isLibrarySongSynced ) {
            UtaPassUtil.sleep( 30, "for local song synced" ) ;
            UserStatus.isLibrarySongSynced = true ;
        }

        this.lineUp().ready() ;

        // there is no good point to check if 'sync local songs' is completed
        // just check songName should be unchanged for 5 seconds
        StringObject songName = this.lineUp().card( 0 ).songName() ;
        UtaPassUtil.sleep( 5 ) ;
        this.lineUp().card( 0 ).songName().assertEquals( songName ) ;

        // since SongsPage might be used many times in one case,
        // let _ready() process just be executed once
        this.readyFlag = true ;
    }

    public LazyString tapHere() {
        return new LazyString( this.label() + " > tapHere",
                () -> withId( R.id.link_library_notice_text ) ) ;
    }

    public LazyString totalTracks() {
        return new LazyString( this.label() + " > totalTracks",
                () -> withId( R.id.view_all_track_shuffle_play_length ) ) {

            public StringObject text() {
                String raw = super.text().string() ;
                StringObject strObj = new StringObject( raw.split( " tracks · " )[ 0 ] ) ;
                strObj.label( this.label() ) ;
                return strObj ;
            }
        } ;
    }

    public LazyString totalTime() {
        return new LazyString( this.label() + " > totalTime",
                () -> withId( R.id.view_all_track_shuffle_play_length ) ) {

            public StringObject text() {
                String raw = super.text().string() ;
                StringObject strObj = new StringObject( raw.split( " tracks · " )[ 1 ] ) ;
                strObj.label( this.label() ) ;
                return strObj ;
            }
        } ;
    }

    public InternalLineUp lineUp() {
        if( this.lineUp == null ) {
            this.lineUp = new InternalLineUp( this.label() ) ;
        }
        return this.lineUp ;
    }

    public class InternalLineUp extends LineUpObject {

        public InternalLineUp( String label ) {
            this.label( label + " > LineUp" ) ;
        }

        protected Matcher<View> getMatcherToFindRecycleView() {
            return withId( R.id.local_track_recycler_view ) ;
        }

        protected Matcher<View> getMatcherToCountMaxIndexOfWindow() {
            return allOf(
                    withId( R.id.item_library_lazy_track_layout ),
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
                            withId( R.id.item_library_lazy_track_icon ),
                            isDescendantOfA( UtaPassUtil.withIndex(
                                    this.getMatcherToCountMaxIndexOfWindow(),
                                    indexInWindow ) ) ) ) ;

            card.songName(  label + " > SongName",
                    () -> allOf(
                            withId( R.id.item_library_lazy_track_title ),
                            isDescendantOfA( UtaPassUtil.withIndex(
                                    this.getMatcherToCountMaxIndexOfWindow(),
                                    indexInWindow ) ) ) ) ;

            card.artistName( label + " > ArtistName",
                    () -> allOf(
                            withId( R.id.item_library_lazy_track_subtitle ),
                            isDescendantOfA( UtaPassUtil.withIndex(
                                    this.getMatcherToCountMaxIndexOfWindow(),
                                    indexInWindow ) ) ) ) ;

            card.moreActionsButton( label + " > MoreActionsButton",
                    () -> allOf(
                            withId( R.id.item_library_lazy_track_overflow ),
                            isDescendantOfA( UtaPassUtil.withIndex(
                                    this.getMatcherToCountMaxIndexOfWindow(),
                                    indexInWindow ) ) ) ) ;

            return card ;
        }
    }

    public class InternalCard implements ICover, IMoreActionsButton, ISongName, IArtistName {

        String labelCover ;
        String labelSongName ;
        String labelArtistName ;
        String labelMoreActionsButton ;

        private LazyMatcher matcherCover ;
        private LazyMatcher matcherSongName ;
        private LazyMatcher matcherArtistName ;
        private LazyMatcher matcherMoreActionsButton ;

        public void cover( String label, LazyMatcher matcher ) {
            this.labelCover = label ;
            this.matcherCover = matcher ;
        }

        public BasicImage cover() {
            return new BasicImage( this.labelCover, this.matcherCover ) ;
        }

        public void moreActionsButton( String label, LazyMatcher matcher ) {
            this.labelMoreActionsButton = label ;
            this.matcherMoreActionsButton = matcher ;
        }

        public BasicButton moreActionsButton() {
            return new BasicButton( this.labelMoreActionsButton, this.matcherMoreActionsButton ) ;
        }

        public void songName( String label, LazyMatcher matcher ) {
            this.labelSongName = label;
            this.matcherSongName = matcher;
        }

        public LazyString songName() {
            return new LazyString( this.labelSongName, this.matcherSongName ) ;
        }

        public void artistName( String label, LazyMatcher matcher ) {
            this.labelArtistName = label;
            this.matcherArtistName = matcher;
        }

        public LazyString artistName() {
            return new LazyString( this.labelArtistName, this.matcherArtistName ) ;
        }

        public void tap() {
            this.cover().tap() ;
        }
    }
}
