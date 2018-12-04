package com.kddi.android.UtaPass.sqa_espresso.pages.library ;

import android.view.View;

import com.kddi.android.UtaPass.R;
import com.kddi.android.UtaPass.sqa_espresso.common.BasicButton;
import com.kddi.android.UtaPass.sqa_espresso.common.BasicImage;
import com.kddi.android.UtaPass.sqa_espresso.common.LazyMatcher;
import com.kddi.android.UtaPass.sqa_espresso.common.LazyString;
import com.kddi.android.UtaPass.sqa_espresso.common.LineUpObject;
import com.kddi.android.UtaPass.sqa_espresso.common.UtaPassUtil;
import com.kddi.android.UtaPass.sqa_espresso.common.card_behavior.ICover;
import com.kddi.android.UtaPass.sqa_espresso.common.card_behavior.ILikeCount;
import com.kddi.android.UtaPass.sqa_espresso.common.card_behavior.IPlayButton;
import com.kddi.android.UtaPass.sqa_espresso.common.card_behavior.ITitle;
import com.kddi.android.UtaPass.sqa_espresso.pages.common.BasicPage;

import org.hamcrest.Matcher;

import static android.support.test.espresso.matcher.ViewMatchers.* ;
import static android.support.test.espresso.matcher.ViewMatchers.withText ;
import static org.hamcrest.Matchers.* ;


public class FavoritePage extends BasicPage {
    private InternalLineUp lineup ;

    public FavoritePage() {
        this.label( "FavoritePage" ) ;
    }

    public BasicButton playlists() {
        return new BasicButton( this.label() + " > Playlists",
                () -> allOf( anyOf( withText( "Playlists" ),
                                    withText( "プレイリスト" ) ),
                             isCompletelyDisplayed() ) ) ;
    }

    public BasicButton streamMusic() {
        return new BasicButton( this.label() + " > StreamMusic",
                () -> allOf( anyOf( withText( "Stream Music" ),
                                    withText( "聴き放題の楽曲" ) ),
                             isCompletelyDisplayed() ) ) ;
    }

    public BasicButton localMusic() {
        return new BasicButton( this.label() + " > LocalMusic",
                () -> allOf( anyOf( withText( "Local Music" ),
                                    withText( "ローカル楽曲" ) ),
                             isCompletelyDisplayed() ) ) ;
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
            return withId( R.id.liked_playlist_recycler_view ) ;
        }

        protected Matcher<View> getMatcherToCountMaxIndexOfWindow() {
            return allOf(
                    withId( R.id.item_playlist_content_layout ),
                    isCompletelyDisplayed() ) ;
        }

        public InternalCard card( int index ) {
            int indexInWindow = index ;

            InternalCard card = new InternalCard() ;

            String label = String.format( "%s > Card(%s)",
                    this.label(),
                    index ) ;

            card.cover( label + " > Cover",
                    () -> allOf(
                            withId( R.id.item_playlist_card_image ),
                            isDescendantOfA( UtaPassUtil.withIndex(
                                    this.getMatcherToCountMaxIndexOfWindow(),
                                    indexInWindow ) ) ) ) ;

            card.playButton( label + " > PlayButton",
                    () -> allOf(
                            withId( R.id.view_playlist_play_layout ),
                            isDescendantOfA( UtaPassUtil.withIndex(
                                    this.getMatcherToCountMaxIndexOfWindow(),
                                    indexInWindow ) ) ) ) ;

            card.title( label + " > Title",
                    () -> allOf(
                            withId( R.id.item_playlist_card_title ),
                            isDescendantOfA( UtaPassUtil.withIndex(
                                    this.getMatcherToCountMaxIndexOfWindow(),
                                    indexInWindow ) ) ) ) ;

            card.likeCount( label + " > LikeCount",
                    () -> allOf(
                            withId( R.id.item_playlist_card_like_count ),
                            isDescendantOfA( UtaPassUtil.withIndex(
                                    this.getMatcherToCountMaxIndexOfWindow(),
                                    indexInWindow ) ) ) ) ;

            return card ;
        }
    }

    public class InternalCard implements ICover, IPlayButton, ITitle, ILikeCount {

        String labelCover ;
        String labelTitle ;
        String labelPlayButton ;
        String labelLikeCount ;

        private LazyMatcher matcherCover ;
        private LazyMatcher matcherTitle ;
        private LazyMatcher matcherPlayButton ;
        private LazyMatcher matcherLikeCount ;

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

        public void likeCount( String label, LazyMatcher matcher ) {
            this.labelLikeCount = label ;
            this.matcherLikeCount = matcher ;
        }

        public LazyString likeCount() {
            return new LazyString( this.labelLikeCount, this.matcherLikeCount ) ;
        }
    }
}
