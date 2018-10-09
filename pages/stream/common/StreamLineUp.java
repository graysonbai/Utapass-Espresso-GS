package com.kddi.android.UtaPass.sqa_espresso.pages.stream.common ;

import android.support.test.espresso.NoMatchingViewException;
import android.support.test.espresso.action.ViewActions;
import android.view.View;

import com.kddi.android.UtaPass.R;
import com.kddi.android.UtaPass.sqa_espresso.common.LineUpObject;
import com.kddi.android.UtaPass.sqa_espresso.common.SongObject;
import com.kddi.android.UtaPass.sqa_espresso.common.StringObject;
import com.kddi.android.UtaPass.sqa_espresso.common.UtaPassUtil;

import org.hamcrest.Matcher;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.matcher.ViewMatchers.isCompletelyDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.isDescendantOfA;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.allOf ;


import java.util.HashSet;
import java.util.Set;

public class StreamLineUp extends LineUpObject {

    private TitleBar titleBar ;
    private final int SHOWMORE_BUTTON_POSITION = 10 ;

    public StreamLineUp() {
        this.setMaxIndexOfLineUpObject( 25 ) ;
    }

    protected Matcher<View> getMatcherToFindRecycleView() {
        return withId( R.id.detail_playlist_recycler_view ) ;
    }

    protected Matcher<View> getMatcherToCountMaxIndexOfWindow() {
        return withId( R.id.item_detail_stream_audio_image ) ;
    }

    protected Matcher<View> _getMatcherToCountMaxIndexOfWindow() {
        return allOf( withId( R.id.item_detail_stream_audio_layout ),
                      isCompletelyDisplayed(),
                      isDescendantOfA( this.getMatcherToFindRecycleView() ) ) ;
    }

    protected int swipeToCardViewAndGetIndexOfWindow( int index ) {
        if( this.titleBar().isVisible() ) {
            this.swipeUp() ;
            this.resetMaxIndexOfWindow() ;
        }
        this.swipeToPosition( 1 ) ;

        //                                 Max
        //         swipe      IndexOf    IndexOf
        // index    to        Window     Window
        // ========================================
        //  0        1          0           7
        //  1        2          1           7
        //  2        3          2           7
        //  ...      ...        ...         ...
        //  7        8          7           7
        //  8        9          8           8
        //  9       11          8           8
        // 10       12          8           8
        // 11       13          8           8
        //
        if( index > this.getMaxIndexOfWindow() ) {
            this.swipeToPosition( index + 2 ) ;
            return this.getMaxIndexOfWindow() + 1 ;
        }

        else {
            this.swipeToPosition( index + 1 ) ;
            return index ;
        }
    }

    public TitleBar titleBar() {
        if( this.titleBar == null ) {
            this.titleBar = new TitleBar() ;
        }
        return this.titleBar ;
    }

    private void swipeUp() {
        onView( withId( R.id.detail_playlist_coordinator_layout ) ).perform( ViewActions.swipeUp() ) ;
    }

    public void swipeToShowMoreButton() {
        this.swipeToCardViewAndGetIndexOfWindow( this._showMoreButtonPosition() ) ;
    }

    protected int _showMoreButtonPosition() {
        return this.SHOWMORE_BUTTON_POSITION ;
    }

    public SongObject song( int index ) {
        int indexInWindow = this.swipeToCardViewAndGetIndexOfWindow( index ) ;

        SongObject song = new SongObject() ;

        song.songName( () ->
                UtaPassUtil.withIndex(
                        allOf( withId( R.id.item_detail_stream_audio_title ),
                                isDescendantOfA( this.getMatcherToFindRecycleView() ) ),
                        indexInWindow ) ) ;

        song.artistName( () ->
                UtaPassUtil.withIndex(
                        allOf( withId( R.id.item_detail_stream_audio_artist ),
                               isDescendantOfA( this.getMatcherToFindRecycleView() ) ),
                        indexInWindow ) ) ;

        song.cover( () ->
                UtaPassUtil.withIndex(
                        allOf( withId( R.id.item_detail_stream_audio_image ),
                               isDescendantOfA( this.getMatcherToFindRecycleView() ) ),
                        indexInWindow ) ) ;

        song.myUtaButton( () ->
                allOf( withId( R.id.item_detail_stream_audio_myuta_register ),
                       isDescendantOfA(
                                UtaPassUtil.withIndex( this._getMatcherToCountMaxIndexOfWindow(),
                                                            indexInWindow ) ) ) ) ;
        return song ;
    }


    // ========================================
    // additional action
    // ========================================
    public StringObject countSongs() {
        Set<String> set = new HashSet<>() ;

        try {
            for( int i = 0 ; i <= this.getMaxIndexOfLineUpObject() ; i++ ) {
                SongObject song = this.song( i ) ;

                set.add( String.format( "%s,%s",
                                        song.songName().string(),
                                        song.artistName().string() ) ) ;
            }

        } catch( NoMatchingViewException e ) {
            this.dprint( e.getMessage() ) ;
        }

        return new StringObject( set.size() ) ;
    }
}
