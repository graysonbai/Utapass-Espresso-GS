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
import com.kddi.android.UtaPass.sqa_espresso.common.card_behavior.ICover;
import com.kddi.android.UtaPass.sqa_espresso.common.card_behavior.ILikeCount;
import com.kddi.android.UtaPass.sqa_espresso.common.card_behavior.IPlayButton;
import com.kddi.android.UtaPass.sqa_espresso.common.card_behavior.ITitle;

import org.hamcrest.Matcher;

import static android.support.test.espresso.matcher.ViewMatchers.hasDescendant;
import static android.support.test.espresso.matcher.ViewMatchers.isCompletelyDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.isDescendantOfA;
import static android.support.test.espresso.matcher.ViewMatchers.withId ;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.anyOf;


public class NewSongsHitSongsModule extends ViewObject {

    public static String titleInEnglish = "New songs/Hit songs" ;
    public static String titleInJapanese = "新曲/ヒットソング" ;
    private InternalLineUp lineup ;

    public NewSongsHitSongsModule( String label ) {
        this.label( label + " > NewSongsHitSongsModule" ) ;
        this.retryWhenNotReady( false ) ;
    }

    @Override
    public void _ready() {
        this.lineUp().assertVisible() ;
        this.lineUp().card( 0 ).cover().assertVisible() ;
    }

    public Matcher<View> matcher() {
        return allOf( withId( R.id.item_list_root_layout ),
                      hasDescendant( anyOf(
                              withText( NewSongsHitSongsModule.titleInEnglish ),
                              withText( NewSongsHitSongsModule.titleInJapanese ) ) ) ) ;
    }

    public LazyString title() {
        return new LazyString( this.label() + " > Title",
                () -> allOf(
                        withId( R.id.item_list_title ),
                        isDescendantOfA( this.matcher() ) ) ) ;
    }

    public BasicButton seeAll() {
        return new BasicButton( this.label() + " > See All Button",
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
            return NewSongsHitSongsModule.titleInEnglish ;
        }

        protected String getTitleOfLineUpInJapanese() {
            return NewSongsHitSongsModule.titleInJapanese ;
        }

        protected Matcher<View> getMatcherToCountMaxIndexOfWindow() {
            return allOf(
                    withId( R.id.item_three_cover_playlist_root_layout ),
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
                            withId( R.id.item_three_cover_playlist_cover_2 ),
                            isDescendantOfA( UtaPassUtil.withIndex(
                                    this.getMatcherToCountMaxIndexOfWindow(),
                                    indexInWindow ) ) ) ) ;

            card.playButton(label + " > PlayButton",
                    () -> allOf(
                            withId( R.id.view_playlist_play_icon ),
                            isDescendantOfA( UtaPassUtil.withIndex(
                                    this.getMatcherToCountMaxIndexOfWindow(),
                                    indexInWindow ) ) ) ) ;

            card.title( label + " > Title",
                    () -> allOf(
                            withId( R.id.item_three_cover_playlist_title ),
                            isDescendantOfA( UtaPassUtil.withIndex(
                                    this.getMatcherToCountMaxIndexOfWindow(),
                                    indexInWindow ) ) ) ) ;

            card.likeCount( label + " > LikeCount",
                    () -> allOf(
                            withId( R.id.item_three_cover_playlist_like_count ),
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




