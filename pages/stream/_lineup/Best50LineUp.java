package com.kddi.android.UtaPass.sqa_espresso.pages.stream._lineup ;

import android.support.test.espresso.NoMatchingViewException;
import android.view.View ;

import com.kddi.android.UtaPass.R ;

import com.kddi.android.UtaPass.sqa_espresso.common.LineUpObject;
import com.kddi.android.UtaPass.sqa_espresso.common.SongObject;
import com.kddi.android.UtaPass.sqa_espresso.common.StringObject;
import com.kddi.android.UtaPass.sqa_espresso.common.UtaPassUtil;

import org.hamcrest.Matcher ;

import java.util.HashSet;
import java.util.Set;

import static android.support.test.espresso.matcher.ViewMatchers.* ;
import static org.hamcrest.Matchers.* ;


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

        song.songName( () -> allOf(
                withId( R.id.promotion_song_title ),
                isDescendantOfA(
                        UtaPassUtil.withIndex( this.getMatcherToCountMaxIndexOfWindow(),
                                               indexInWindow ) ) ) ) ;

        song.artistName( () -> allOf(
                withId( R.id.promotion_song_artist ),
                isDescendantOfA(
                        UtaPassUtil.withIndex( this.getMatcherToCountMaxIndexOfWindow(),
                                               indexInWindow ) ) ) ) ;

        song.cover( () -> allOf(
                withId( R.id.promotion_song_image ),
                isDescendantOfA(
                        UtaPassUtil.withIndex( this.getMatcherToCountMaxIndexOfWindow(),
                                               indexInWindow ) )
                ) ) ;


        song.myUtaButton( () -> allOf(
                withId( R.id.promotion_song_myuta_register ),
                isDescendantOfA(
                        UtaPassUtil.withIndex( this.getMatcherToCountMaxIndexOfWindow(),
                                               indexInWindow ) ) ) ) ;

        return song ;
    }


    // ========================================
    // additional action
    // ========================================
    public StringObject countSongs() {
        Set<String> set = new HashSet<>() ;

        try {
            for (int i = 0; i <= Best50LineUp.MAX_INDEX_OF_LINEOBJECT; i++) {

                // this might throw out NoMatchingViewException when it is out of index
                SongObject song = this.song(i);

                set.add(String.format("%s,%s",
                        song.songName().text().string(),
                        song.artistName().text().string()));
            }

        } catch( NoMatchingViewException e ) {
            this.dprint( e.getMessage() ) ;
        }

        return new StringObject( set.size() ) ;
    }
}


