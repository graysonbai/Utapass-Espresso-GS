package com.kddi.android.UtaPass.sqa_espresso.pages.stream._module ;

import android.support.test.espresso.NoMatchingViewException;
import android.view.View;

import com.kddi.android.UtaPass.R;
import com.kddi.android.UtaPass.sqa_espresso.common.BasicButton;
import com.kddi.android.UtaPass.sqa_espresso.common.BasicImage;
import com.kddi.android.UtaPass.sqa_espresso.common.LazyMatcher;
import com.kddi.android.UtaPass.sqa_espresso.common.LazyString;
import com.kddi.android.UtaPass.sqa_espresso.common.LineUpObject;
import com.kddi.android.UtaPass.sqa_espresso.common.StringObject;
import com.kddi.android.UtaPass.sqa_espresso.common.UtaPassUtil;
import com.kddi.android.UtaPass.sqa_espresso.common.ViewObject;
import com.kddi.android.UtaPass.sqa_espresso.common.card_behavior.IArtistName;
import com.kddi.android.UtaPass.sqa_espresso.common.card_behavior.ICover;
import com.kddi.android.UtaPass.sqa_espresso.common.card_behavior.IMyUtaButton;
import com.kddi.android.UtaPass.sqa_espresso.common.card_behavior.IPlayButton;
import com.kddi.android.UtaPass.sqa_espresso.common.card_behavior.ISongName;

import org.hamcrest.Matcher;

import java.util.HashSet;
import java.util.Set;

import static android.support.test.espresso.matcher.ViewMatchers.hasDescendant;
import static android.support.test.espresso.matcher.ViewMatchers.isCompletelyDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.isDescendantOfA;
import static android.support.test.espresso.matcher.ViewMatchers.withClassName;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.Matchers.endsWith;


public class Best50Module extends ViewObject {

    public static String titleInEnglish = "My Uta BEST 50" ;
    public static String titleInJapanese = "週間 Myうた BEST50" ;
    private InternalLineUp lineup ;

    public Best50Module( String label ) {
        this.label( label + " > Best50Module" ) ;
        this.retryWhenNotReady( false ) ;
    }

    @Override
    public void _ready() {
        this.lineUp().ready() ;
        this.lineUp().card( 0 ).cover().ready() ;
    }

    public Matcher<View> matcher() {
        return allOf( withId( R.id.promotion_song_list_root_layout ),
                      hasDescendant( anyOf(
                              withText( Best50Module.titleInEnglish ),
                              withText( Best50Module.titleInJapanese ) ) ) ) ;
    }

    public LazyString title() {
        return new LazyString( this.label() + " > Title",
                () -> allOf(
                        withId( R.id.promotion_song_list_title ),
                        isDescendantOfA( this.matcher() ) ) ) ;
    }

    public BasicButton seeAll() {
        return new BasicButton( this.label() + " > See All",
                () -> allOf(
                        anyOf( withText( "See All" ),
                               withText( "すべて見る" ) ),
                        isDescendantOfA( this.matcher() ) ) ) ;
    }

    public LazyString subtitle() {
        return new LazyString( this.label() + " > Subtitle",
                () -> allOf(
                        withId( R.id.promotion_song_list_subtitle ),
                        isDescendantOfA( this.matcher() ) ) ) ;
    }

    public InternalLineUp lineUp() {
        if( this.lineup == null ) {
            this.lineup = new InternalLineUp( this.label() ) ;
        }
        return this.lineup ;
    }

    public class InternalLineUp extends LineUpObject {

        private static final int MAX_CARD_IN_COLUMN = 3 ;
        private static final int MAX_INDEX_OF_LINEOBJECT = 14 ;

        public InternalLineUp( String label ) {
            this.label( label + " > LineUp" ) ;
            this.setMaxIndexOfLineUpObject( InternalLineUp.MAX_INDEX_OF_LINEOBJECT ) ;
        }

        protected Matcher<View> getMatcherToFindRecycleView() {
            return withId( R.id.promotion_song_listview ) ;
        }

        protected Matcher<View> getMatcherToCountMaxIndexOfWindow() {
            return allOf(
                    withId( R.id.promotion_song_root_layout ),
                    isCompletelyDisplayed() ) ;
        }

        protected int calculateMaxIndexOfWindow() {
            int count = -1 ;
            for( int i = 0 ; i <= this.getMaxIndexOfLineUpObject(); i++ ) {
                if( this.isDisplayedCompletely(
                        UtaPassUtil.withIndex( this.getMatcherToCountMaxIndexOfWindow(), i ) ) ) {

                    count++ ;
                }
            }

            return count ;
        }

        protected String getTitleOfLineUpInEnglish() {
            return Best50Module.titleInEnglish ;
        }

        protected String getTitleOfLineUpInJapanese() {
            return Best50Module.titleInJapanese ;
        }

        protected int swipeToCardViewAndGetIndexOfWindow( int index ) {
            this.swipeToLeftmost() ;
            this.checkIndexValid( index ) ;
            this.swipeToPosition( index ) ;

            if( index <= this.maxIndexFirstWindow() ) {
                return index ;
            }

            int offset = this.maxIndexFirstWindow()
                    / InternalLineUp.MAX_CARD_IN_COLUMN
                    * InternalLineUp.MAX_CARD_IN_COLUMN ;

            return offset + ( index % InternalLineUp.MAX_CARD_IN_COLUMN ) ;
        }

        public InternalCard card( int index ) {
            int indexInWindow = this.swipeToCardViewAndGetIndexOfWindow( index ) ;

            InternalCard card = new InternalCard() ;

            String label = String.format( "%s > Card(%s)",
                    this.label(),
                    index ) ;

            card.cover( label + " > Cover",
                    () -> allOf(
                            withId( R.id.promotion_song_image ),
                            isDescendantOfA( UtaPassUtil.withIndex(
                                    this.getMatcherToCountMaxIndexOfWindow(),
                                    indexInWindow ) ) ) ) ;

            card.songName( label + " > SongName",
                    () -> allOf(
                            withId( R.id.promotion_song_title ),
                            isDescendantOfA( UtaPassUtil.withIndex(
                                    this.getMatcherToCountMaxIndexOfWindow(),
                                    indexInWindow ) ) ) ) ;

            card.artistName( label + " > ArtistName",
                    () -> allOf(
                            withId( R.id.promotion_song_artist ),
                            isDescendantOfA( UtaPassUtil.withIndex(
                                    this.getMatcherToCountMaxIndexOfWindow(),
                                    indexInWindow ) ) ) ) ;

            card.playButton(label + " > PlayButton",
                    () -> allOf(
                            UtaPassUtil.withDrawable( R.drawable.btn_myuta_play),
                            isDescendantOfA( UtaPassUtil.withIndex(
                                    this.getMatcherToCountMaxIndexOfWindow(),
                                    indexInWindow ) ) ) ) ;

            card.myUtaButton(label + " > MyUtaButton",
                    () -> allOf(
                            withId( R.id.promotion_song_myuta_register ),
                            isDescendantOfA( UtaPassUtil.withIndex(
                                    this.getMatcherToCountMaxIndexOfWindow(),
                                    indexInWindow ) ) ) ) ;

            return card ;
        }

        // ========================================
        // additional action
        // ========================================
        public StringObject countSongs() {
            Set<String> set = new HashSet<>() ;

            try {
                for( int i = 0; i <= InternalLineUp.MAX_INDEX_OF_LINEOBJECT; i++ ) {

                    // this might throw out NoMatchingViewException when it is out of index
                    InternalCard card = this.card( i ) ;

                    set.add( String.format( "%s,%s",
                            card.songName().string(),
                            card.artistName().string() ) ) ;
                }

            } catch( NoMatchingViewException e ) {
                this.dprint( e.getMessage() ) ;
            }

            return new StringObject( set.size() ) ;
        }
    }

    public class InternalCard implements ICover, IPlayButton, IMyUtaButton, ISongName, IArtistName {

        String labelCover ;
        String labelSongName ;
        String labelArtistName ;
        String labelPlayButton ;
        String labelMyUtaButton ;

        private LazyMatcher matcherCover ;
        private LazyMatcher matcherSongName ;
        private LazyMatcher matcherArtistName ;
        private LazyMatcher matcherPlayButton ;
        private LazyMatcher matcherMyUtaButton ;

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

        public void myUtaButton( String label, LazyMatcher matcher ) {
            this.labelMyUtaButton = label ;
            this.matcherMyUtaButton = matcher ;
        }

        public BasicButton myUtaButton() {
            return new BasicButton( this.labelMyUtaButton, this.matcherMyUtaButton ) {
                public LazyString text() {
                    return new LazyString( this.label(), () -> allOf(
                            withClassName( endsWith( "TextView" ) ),
                            isDescendantOfA( super.matcher().execute() ) ) ) ;
                }
            } ;
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




