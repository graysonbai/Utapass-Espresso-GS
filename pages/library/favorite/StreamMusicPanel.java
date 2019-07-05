package com.kddi.android.UtaPass.sqa_espresso.pages.library.favorite;

import android.view.View;

import com.kddi.android.UtaPass.R;
import com.kddi.android.UtaPass.sqa_espresso.common.BasicButton;
import com.kddi.android.UtaPass.sqa_espresso.common.BasicImage;
import com.kddi.android.UtaPass.sqa_espresso.common.LazyMatcher;
import com.kddi.android.UtaPass.sqa_espresso.common.LazyString;
import com.kddi.android.UtaPass.sqa_espresso.common.LineUpObject;
import com.kddi.android.UtaPass.sqa_espresso.common.UtaPassUtil;
import com.kddi.android.UtaPass.sqa_espresso.common.card_behavior.IArtistName;
import com.kddi.android.UtaPass.sqa_espresso.common.card_behavior.ICover;
import com.kddi.android.UtaPass.sqa_espresso.common.card_behavior.IMyUtaButton;
import com.kddi.android.UtaPass.sqa_espresso.common.card_behavior.IPlayButton;
import com.kddi.android.UtaPass.sqa_espresso.common.card_behavior.ITitle;
import com.kddi.android.UtaPass.sqa_espresso.pages.common.BasicPage;

import org.hamcrest.Matcher;

import static androidx.test.espresso.matcher.ViewMatchers.isCompletelyDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isDescendantOfA;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.allOf;

public class StreamMusicPanel extends BasicPage {
    private InternalLineUp lineUp ;

    public StreamMusicPanel( String label ) {
        this.label( label +  "StreamMusicPanel" ) ;
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
            return UtaPassUtil.withIndex( withId( R.id.liked_songs_recycler_view ), 0 ) ;
        }

        protected Matcher<View> getMatcherToCountMaxIndexOfWindow() {
            return allOf(
                    withId( R.id.item_detail_stream_audio_layout ),
                    isCompletelyDisplayed() ) ;
        }

        public InternalCard card(int index ) {
            int indexInWindow = this.swipeToCardViewAndGetIndexOfWindow( index ) ;

            InternalCard card = new InternalCard() ;

            String label = String.format( "%s > Card(%s)",
                    this.label(),
                    index ) ;

            card.cover( label + " > Cover",
                    () -> allOf(
                            withId( R.id.item_detail_stream_audio_image ),
                            isDescendantOfA( UtaPassUtil.withIndex(
                                    this.getMatcherToCountMaxIndexOfWindow(),
                                    indexInWindow ) ) ) ) ;

            card.playButton(label + " > PlayButton",
                    () -> allOf(
                            withId( R.id.item_detail_stream_audio_myuta_play ),
                            isDescendantOfA( UtaPassUtil.withIndex(
                                    this.getMatcherToCountMaxIndexOfWindow(),
                                    indexInWindow ) ) ) ) ;

            card.title( label + " > Title",
                    () -> allOf(
                            withId( R.id.item_detail_stream_audio_title ),
                            isDescendantOfA( UtaPassUtil.withIndex(
                                    this.getMatcherToCountMaxIndexOfWindow(),
                                    indexInWindow ) ) ) ) ;

            card.myUtaButton( label + " > myUtaButton",
                    () -> allOf(
                            withId( R.id.item_detail_stream_audio_myuta_register ),
                            isDescendantOfA( UtaPassUtil.withIndex(
                                    this.getMatcherToCountMaxIndexOfWindow(),
                                    indexInWindow ) ) ) ) ;

            card.artistName( label + " > artistName",
                    () -> allOf(
                            withId( R.id.item_detail_stream_audio_artist ),
                            isDescendantOfA( UtaPassUtil.withIndex(
                                    this.getMatcherToCountMaxIndexOfWindow(),
                                    indexInWindow ) ) ) ) ;

            return card ;
        }
    }

    public class InternalCard implements ICover, IPlayButton, ITitle, IMyUtaButton, IArtistName {

        String labelCover ;
        String labelTitle ;
        String labelPlayButton ;
        String labelMyUtaButton ;
        String labelArtistName ;

        private LazyMatcher matcherCover ;
        private LazyMatcher matcherTitle ;
        private LazyMatcher matcherPlayButton ;
        private LazyMatcher matcherMyUtaButton ;
        private LazyMatcher matcherArtistName ;

        public void cover( String label, LazyMatcher matcher ) {
            this.labelCover = label ;
            this.matcherCover = matcher ;
        }

        public BasicImage cover() {
            return new BasicImage( this.labelCover, this.matcherCover ) ;
        }

        public void playButton( String label, LazyMatcher matcher ) {
            this.labelPlayButton = label ;
            this.matcherPlayButton = matcher ;
        }

        public BasicButton playButton() {
            return new BasicButton( this.labelPlayButton, this.matcherPlayButton ) ;
        }

        public void title( String label, LazyMatcher matcher ) {
            this.labelTitle = label ;
            this.matcherTitle = matcher ;
        }

        public LazyString title() {
            return new LazyString( this.labelTitle, this.matcherTitle ) ;
        }


        @Override
        public void artistName(String label, LazyMatcher matcher) {
            this.labelArtistName = label ;
            this.matcherArtistName = matcher ;
        }

        @Override
        public LazyString artistName() {
            return new LazyString( this.labelArtistName, this.matcherArtistName ) ;
        }

        @Override
        public void myUtaButton( String label, LazyMatcher matcher ) {
            this.labelMyUtaButton = label;
            this.matcherMyUtaButton = matcher;
        }

        @Override
        public BasicButton myUtaButton() {
            return new BasicButton( this.labelMyUtaButton, this.matcherMyUtaButton ) ;
        }
    }
}
