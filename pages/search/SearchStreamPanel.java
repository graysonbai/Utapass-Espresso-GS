package com.kddi.android.UtaPass.sqa_espresso.pages.search;

import android.view.View;

import com.kddi.android.UtaPass.R;
import com.kddi.android.UtaPass.sqa_espresso.common.BasicImage;
import com.kddi.android.UtaPass.sqa_espresso.common.LazyMatcher;
import com.kddi.android.UtaPass.sqa_espresso.common.LazyString;
import com.kddi.android.UtaPass.sqa_espresso.common.LineUpObject;
import com.kddi.android.UtaPass.sqa_espresso.common.UtaPassUtil;
import com.kddi.android.UtaPass.sqa_espresso.common.card_behavior.IArtistName;
import com.kddi.android.UtaPass.sqa_espresso.common.card_behavior.ICover;
import com.kddi.android.UtaPass.sqa_espresso.common.card_behavior.ISongName;
import com.kddi.android.UtaPass.sqa_espresso.pages.common.BasicPage;

import org.hamcrest.Matcher;

import static androidx.test.espresso.matcher.ViewMatchers.isCompletelyDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isDescendantOfA;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.core.AllOf.allOf;

public class SearchStreamPanel extends BasicPage {
    private InternalLineUp lineUp;

    public SearchStreamPanel( String label ){
        this.label( label + " > SearchStreamPanel" );
    }

    public InternalLineUp lineUp() {
        if( this.lineUp == null ) {
            this.lineUp = new InternalLineUp( this.label() ) ;
        }
        return this.lineUp ;
    }

    public class InternalLineUp extends LineUpObject {

        public InternalLineUp(  String label ) {
            this.setMaxIndexOfLineUpObject( 50 ) ;
            this.label( label + " > LineUp" ) ;
        }

        protected Matcher<View> getMatcherToFindRecycleView() {
            return withId( R.id.search_stream_inner_recycler_view ) ;
        }

        protected Matcher<View> getMatcherToCountMaxIndexOfWindow() {
            return allOf( withId( R.id.item_playlist_linear_root_layout ),
                    isCompletelyDisplayed(),
                    isDescendantOfA( this.getMatcherToFindRecycleView() ) ) ;
        }


        public InternalCard card( int index ) {
            int indexInWindow = this.swipeToCardViewAndGetIndexOfWindow( index ) ;

            InternalCard card = new InternalCard() ;

            String label = String.format( "%s > Card(%s)",
                    this.label(),
                    index ) ;

            card.songName(label + " > SongName",
                    () -> allOf(
                            withId( R.id.item_playlist_linear_title ),
                            isDescendantOfA( UtaPassUtil.withIndex(
                                    this.getMatcherToFindRecycleView(),
                                    indexInWindow ) ) ) ) ;

            card.artistName(label + " > artistName",
                    () -> allOf(
                            withId( R.id.item_detail_stream_audio_artist ),
                            isDescendantOfA( UtaPassUtil.withIndex(
                                    this.getMatcherToFindRecycleView(),
                                    indexInWindow ) ) ) ) ;

            card.cover( label + "Cover",
                    () -> allOf(
                            withId( R.id.item_playlist_linear_image ),
                            isDescendantOfA( UtaPassUtil.withIndex(
                                    this.getMatcherToFindRecycleView(),
                                    indexInWindow ) ) ) );

            return card ;
        }
    }

    public class InternalCard implements ISongName, IArtistName, ICover {

        String labelSongName ;
        String labelArtistName ;
        String labelCover ;


        private LazyMatcher matcherSongName ;
        private LazyMatcher matcherArtistName ;
        private LazyMatcher matcherCover ;


        @Override
        public void artistName(String label, LazyMatcher matcher) {
            this.labelArtistName = label;
            this.matcherArtistName = matcher;
        }

        @Override
        public LazyString artistName() {
            return new LazyString( this.labelArtistName , this.matcherArtistName );
        }

        @Override
        public void songName( String label, LazyMatcher matcher ) {
            this.labelSongName = label;
            this.matcherSongName = matcher;
        }

        @Override
        public LazyString songName() {
            return new LazyString( this.labelSongName, this.matcherSongName);
        }

        @Override
        public void cover( String label, LazyMatcher matcher ) {
            this.labelCover = label;
            this.matcherCover = matcher;
        }

        @Override
        public BasicImage cover() {
            return new BasicImage( this.labelCover, this.matcherCover );
        }
    }
}
