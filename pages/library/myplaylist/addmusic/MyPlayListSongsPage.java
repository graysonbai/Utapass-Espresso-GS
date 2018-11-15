package com.kddi.android.UtaPass.sqa_espresso.pages.library.myplaylist.addmusic;

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
import com.kddi.android.UtaPass.sqa_espresso.common.card_behavior.ISongName;

import org.hamcrest.Matcher;

import static android.support.test.espresso.matcher.ViewMatchers.isCompletelyDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.isDescendantOfA;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.allOf;

public class MyPlayListSongsPage extends ViewObject {

    private InternalLineUp internalLineUp;

    public MyPlayListSongsPage(){
        this.label( "MyPlaylistSongsPage" );
    }

    public void _ready(){
        this.lineUp().card( 0 ).cover().assertVisible();
    }

    public BasicButton nextButton(){
        return new BasicButton( this.label() + " > NextButton" ,
                () -> allOf(
                        withId( R.id.done ),
                        isDescendantOfA( withId( R.id.find_local_music_toolbar ) ) ) );
    }

    public InternalLineUp lineUp(){
        if( this.internalLineUp == null ){
            this.internalLineUp = new InternalLineUp( this.label() );
        }
        return this.internalLineUp;
    }

    public class InternalLineUp extends LineUpObject{

        public InternalLineUp( String label ) {
            this.label( label + " > lineUp" ) ;
            this.setMaxIndexOfLineUpObject( 99 );
        }

        protected Matcher<View> getMatcherToFindRecycleView() {
            return withId( R.id.find_local_music_recycler_view ) ;
        }

        protected Matcher<View> getMatcherToCountMaxIndexOfWindow() {
            return allOf(
                    withId( R.id.item_select_music_layout ),
                    isCompletelyDisplayed() ) ;
        }

        protected int calculateMaxIndexOfWindow() {
            int count = -1 ;
            for( int i = 0 ; i <= this.getMaxIndexOfLineUpObject(); i++ ) {
                if( ! this.isDisplayedCompletely(
                        UtaPassUtil.withIndex( this.getMatcherToCountMaxIndexOfWindow(), i ) ) ) {
                    return count;
                }

                count++ ;
            }

            return count ;
        }

        public InternalCard card( int index ){

            int indexInWindow = this.swipeToCardViewAndGetIndexOfWindow( index ) ;

            InternalCard card = new InternalCard();

            String label = String.format( "%s > Card(%s)",
                    this.label(),
                    index ) ;

            card.cover( label + " > Cover" ,
                    () -> allOf(
                        withId( R.id.item_select_music_album_icon ),
                        isDescendantOfA( UtaPassUtil.withIndex(
                            this.getMatcherToCountMaxIndexOfWindow(),
                            indexInWindow ) ) ) );

            card.songName(label + " > songName" ,
                    () -> allOf(
                        withId( R.id.item_select_music_title ),
                        isDescendantOfA( UtaPassUtil.withIndex(
                                this.getMatcherToCountMaxIndexOfWindow(),
                                indexInWindow ) ) ) );

            card.artistName( label + " > artistName" ,
                    () -> allOf(
                        withId(R.id.item_select_music_subtitle),
                        isDescendantOfA( UtaPassUtil.withIndex(
                                this.getMatcherToCountMaxIndexOfWindow(),
                                indexInWindow) ) ) );

            return card;
        }
    }

    public class InternalCard implements ICover, ISongName, IArtistName {

        String labelCover ;
        String labelArtistName ;
        String labelSongName ;

        private LazyMatcher matcherCover ;
        private LazyMatcher matcherArtistName ;
        private LazyMatcher matcherSongName ;

        public void cover( String label, LazyMatcher matcher ) {
            this.labelCover = label ;
            this.matcherCover = matcher ;
        }

        public BasicImage cover() {
            return new BasicImage( this.labelCover, this.matcherCover ) ;
        }

        public void artistName( String label, LazyMatcher matcher ) {
            this.labelArtistName = label;
            this.matcherArtistName =  matcher;
        }

        public LazyString artistName() {
            return new LazyString( this.labelArtistName, this.matcherArtistName ) ;
        }

        public void songName( String label, LazyMatcher matcher ) {
            this.labelSongName = label;
            this.matcherSongName = matcher;
        }

        public LazyString songName() {
            return new LazyString( this.labelSongName, this.matcherSongName ) ;
        }
    }
}
