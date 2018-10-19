package com.kddi.android.UtaPass.sqa_espresso.pages.stream._module ;

import android.view.View;

import com.kddi.android.UtaPass.R ;
import com.kddi.android.UtaPass.sqa_espresso.common.BasicButton;
import com.kddi.android.UtaPass.sqa_espresso.common.BasicImage;
import com.kddi.android.UtaPass.sqa_espresso.common.LazyMatcher;
import com.kddi.android.UtaPass.sqa_espresso.common.LazyString;
import com.kddi.android.UtaPass.sqa_espresso.common.LineUpObject;
import com.kddi.android.UtaPass.sqa_espresso.common.UtaPassUtil;
import com.kddi.android.UtaPass.sqa_espresso.common.ViewObject;
import com.kddi.android.UtaPass.sqa_espresso.common.card_behavior.IArtistName;
import com.kddi.android.UtaPass.sqa_espresso.common.card_behavior.ICover;
import com.kddi.android.UtaPass.sqa_espresso.common.card_behavior.ILikeCount;
import com.kddi.android.UtaPass.sqa_espresso.common.card_behavior.IPlayButton;

import org.hamcrest.Matcher;

import static android.support.test.espresso.matcher.ViewMatchers.hasDescendant;
import static android.support.test.espresso.matcher.ViewMatchers.isCompletelyDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.isDescendantOfA;
import static android.support.test.espresso.matcher.ViewMatchers.withId ;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.anyOf;


public class PopularArtistModule extends ViewObject {
    public static String titleInEnglish = "Popular Artist" ;
    public static String titleInJapanese = "人気アーティスト" ;
    private InternalLineUp lineup ;

    public PopularArtistModule( String label ) {
        this.label( label + " > PopularArtistModule" ) ;
        this.retryWhenNotReady( false ) ;
    }

    @Override
    public void _ready() {
        this.lineUp().ready() ;
        this.lineUp().card( 0 ).cover().ready() ;
    }

    public Matcher<View> matcher() {
        return allOf( withId( R.id.item_list_root_layout ),
                      hasDescendant( anyOf(
                              withText( PopularArtistModule.titleInEnglish ),
                              withText( PopularArtistModule.titleInJapanese ) ) ) ) ;
    }

    public LazyString title() {
        return new LazyString( this.label() + " > Title",
                () -> allOf(
                        withId( R.id.item_list_title ),
                        isDescendantOfA( this.matcher() ) ) ) ;
    }

    public BasicButton seeAll() {
        return new BasicButton( this.label() + " > See All",
                () -> allOf(
                        anyOf( withText( "See All" ),
                               withText( "すべて見る" ) ),
                        isDescendantOfA( this.matcher() ) ) ) ;
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

        protected String getTitleOfLineUpInEnglish() {
            return PopularArtistModule.titleInEnglish ;
        }

        protected String getTitleOfLineUpInJapanese() {
            return PopularArtistModule.titleInJapanese ;
        }

        protected Matcher<View> getMatcherToCountMaxIndexOfWindow() {
            return allOf(
                    withId( R.id.item_playlist_content_layout ),
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
                            withId( R.id.item_playlist_card_image ),
                            isDescendantOfA( UtaPassUtil.withIndex(
                                    this.getMatcherToCountMaxIndexOfWindow(),
                                    indexInWindow ) ) ) ) ;

            card.playButton(label + " > PlayButton",
                    () -> allOf(
                            withId( R.id.view_playlist_play_icon ),
                            isDescendantOfA( UtaPassUtil.withIndex(
                                    this.getMatcherToCountMaxIndexOfWindow(),
                                    indexInWindow ) ) ) ) ;

            card.artistName( label + " > ArtistName",
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

    public class InternalCard implements ICover, IPlayButton, IArtistName, ILikeCount {

        String labelCover ;
        String labelArtistName ;
        String labelPlayButton ;
        String labelLikeCount ;

        private LazyMatcher matcherCover ;
        private LazyMatcher matcherArtistName ;
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

        public void artistName( String label, LazyMatcher matcher ) {
            this.labelArtistName = label;
            this.matcherArtistName = matcher;
        }

        public LazyString artistName() {
            return new LazyString( this.labelArtistName, this.matcherArtistName ) ;
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




