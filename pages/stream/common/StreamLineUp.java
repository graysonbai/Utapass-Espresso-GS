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
        return allOf( withId( R.id.item_detail_stream_audio_layout ),
                      isCompletelyDisplayed(),
                      isDescendantOfA( this.getMatcherToFindRecycleView() ) ) ;
    }

    protected int swipeToCardViewAndGetIndexOfWindow( int index ) {
        if( this.titleBar().isVisible() ) {
            this.swipeUp() ;
            this.swipeUp() ;
            this.resetMaxIndexOfWindow() ;
        }

        this.swipeToPosition( 1 ) ;

        if( index > this.maxIndexFirstWindow() ) {
            this.swipeToPosition( index + 2 ) ;
            return this.maxIndexFirstWindow() + 1 ;
        }

        this.swipeToPosition( index + 1 ) ;
        return index ;
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

        song.songName( () -> allOf(
                withId( R.id.item_detail_stream_audio_title ),
                isDescendantOfA( UtaPassUtil.withIndex(
                        this.getMatcherToCountMaxIndexOfWindow(),
                        indexInWindow ) ) ) ) ;


        song.artistName( () -> allOf(
                withId( R.id.item_detail_stream_audio_artist ),
                isDescendantOfA( UtaPassUtil.withIndex(
                        this.getMatcherToCountMaxIndexOfWindow(),
                        indexInWindow ) ) ) ) ;

        song.cover( () -> allOf(
                withId( R.id.item_detail_stream_audio_image ),
                isDescendantOfA( UtaPassUtil.withIndex(
                        this.getMatcherToCountMaxIndexOfWindow(),
                        indexInWindow ) ) ) ) ;

        song.myUtaButton( () -> allOf(
                withId( R.id.item_detail_stream_audio_myuta_register ),
                isDescendantOfA( UtaPassUtil.withIndex(
                        this.getMatcherToCountMaxIndexOfWindow(),
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
