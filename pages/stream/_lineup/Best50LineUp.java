package com.kddi.android.UtaPass.sqa_espresso.pages.stream._lineup ;

import android.support.test.espresso.ViewInteraction ;
import android.view.View ;

import com.kddi.android.UtaPass.R ;

import com.kddi.android.UtaPass.sqa_espresso.common.LineUpObject;
import com.kddi.android.UtaPass.sqa_espresso.common.UtaPassUtil;
import com.kddi.android.UtaPass.sqa_espresso.common.ViewObject;
import com.kddi.android.UtaPass.sqa_espresso.pages.stream._lineup._card.CardObject;
import com.kddi.android.UtaPass.sqa_espresso.pages.stream.common.MyUtaButton;
import com.kddi.android.UtaPass.sqa_espresso.pages.stream.common.SongObject;

import org.hamcrest.Matcher ;

import static android.support.test.espresso.Espresso.onView ;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.* ;
import static org.hamcrest.Matchers.* ;


// temp
import static android.support.test.espresso.contrib.RecyclerViewActions.scrollToPosition ;


public class Best50LineUp extends LineUpObject {

    public static String titleInEnglish = "My Uta BEST 50" ;
    public static String titleInJapanese = "週間 Myうた BEST50" ;

    private static final int MAX_CARD_IN_COLUMN = 3 ;
    private static final int MAX_COLUMN = 5 ;
    private static final int MAX_INDEX_OF_LINEOBJECT = 14 ;

    public Best50LineUp() {
        this.setMaxIndexOfLineUpObject( Best50LineUp.MAX_INDEX_OF_LINEOBJECT ) ;
    }

    protected Matcher<View> getMatcherToFindRecycleView() {
        return withId( R.id.promotion_song_listview ) ;
    }

    protected Matcher<View> getMatcherToCountMaxIndexOfWindow() {
        return allOf( withId( R.id.promotion_song_root_layout ),
                      isCompletelyDisplayed(),
                      isDescendantOfA( this.getMatcherToFindRecycleView() ) ) ;
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
        return Best50LineUp.titleInEnglish ;
    }

    protected String getTitleOfLineUpInJapanese() {
        return Best50LineUp.titleInJapanese ;
    }

    protected int swipeToCardViewAndGetIndexOfWindow( int index ) {
        this.swipeToLeftmost() ;
        this.checkIndexValid( index ) ;
        this.swipeToPosition( index ) ;

        if( index <= this.getMaxIndexOfWindow() ) {
            return index ;
        }

        int offset = this.getMaxIndexOfWindow()
                     / Best50LineUp.MAX_CARD_IN_COLUMN
                     * Best50LineUp.MAX_CARD_IN_COLUMN ;

        return offset + ( index % Best50LineUp.MAX_CARD_IN_COLUMN ) ;
    }

    public SongObject song( int index ) {
        int indexInWindow = swipeToCardViewAndGetIndexOfWindow( index ) ;

        SongObject song = new SongObject() ;
        song.songName( this.songName( indexInWindow ) ) ;
        song.artistName( this.artistName( indexInWindow ) ) ;
        song.myUtaButton( this.myUtaButton( indexInWindow ) ) ;
        return song ;
    }

    private MyUtaButton myUtaButton( int indexInWindow ) {
        MyUtaButton button = new MyUtaButton() ;
        button.matcherForButton(
                UtaPassUtil.withIndex(
                        allOf( withId( R.id.promotion_song_myuta_register ),
                                isDescendantOfA( this.getMatcherToFindRecycleView() ) ),
                        indexInWindow ) ) ;

        button.matcherForText(
                UtaPassUtil.withIndex(
                        allOf( withId( R.id.promotion_song_myuta_text ),
                                isDescendantOfA( this.getMatcherToFindRecycleView() ) ),
                        indexInWindow ) ) ;

        return button ;
    }

    private String songName( int indexInWindow ) {
        return this.getText( this.matcherForSongName( indexInWindow ) ) ;
    }

    private String artistName( int indexInWindow ) {
        return this.getText( this.matcherForArtistName( indexInWindow ) ) ;
    }

    private Matcher<View> matcherForMyUtaButton( int indexInWindow ) {
        return UtaPassUtil.withIndex(
                    allOf( withId( R.id.promotion_song_myuta_register ),
                           isDescendantOfA( this.getMatcherToCountMaxIndexOfWindow() ) ),
                    indexInWindow ) ;
    }

    private Matcher<View> matcherForSongName( int indexInWindow ) {
        return UtaPassUtil.withIndex(
                    allOf( withId( R.id.promotion_song_title ),
                           isCompletelyDisplayed(),
                           isDescendantOfA( this.getMatcherToCountMaxIndexOfWindow() ) ),
                    indexInWindow ) ;
    }

    private Matcher<View> matcherForArtistName( int indexInWindow ) {
        return UtaPassUtil.withIndex(
                allOf( withId( R.id.promotion_song_artist ),
                        isCompletelyDisplayed(),
                        isDescendantOfA( this.getMatcherToCountMaxIndexOfWindow() ) ),
                indexInWindow ) ;
    }
}


