package com.kddi.android.UtaPass.sqa_espresso.pages.stream.common ;

import android.support.test.espresso.ViewInteraction;
import android.support.test.espresso.action.ViewActions;
import android.view.View;

import com.kddi.android.UtaPass.R;
import com.kddi.android.UtaPass.sqa_espresso.common.LineUpObject;
import com.kddi.android.UtaPass.sqa_espresso.common.UtaPassUtil;

import org.hamcrest.Matcher;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.matcher.ViewMatchers.isDescendantOfA;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.allOf ;

// for temp
import static android.support.test.espresso.action.ViewActions.click;
import org.hamcrest.TypeSafeMatcher;

public class StreamLineUp extends LineUpObject {

    private TitleBar titleBar ;
    private final int SHOWMORE_BUTTON_POSITION = 11 ;

    public StreamLineUp() {
        this.setMaxIndexOfLineUpObject( 25 ) ;
    }

    protected Matcher<View> getMatcherToFindRecycleView() {
        return withId( R.id.detail_playlist_recycler_view ) ;
    }

    protected Matcher<View> getMatcherToCountMaxIndexOfWindow() {
        return withId( R.id.item_detail_stream_audio_image ) ;
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
        song.songName( this.songName( indexInWindow ) ) ;
        song.artistName( this.artistName( indexInWindow ) ) ;

        // This is a workaround to find cover photo
        // song.photo( this.coverPhoto( indexInWindow ) ) ;
        song.cover( () -> onView(
                UtaPassUtil.withIndex(
                        allOf( withId( R.id.item_detail_stream_audio_image ),
                               isDescendantOfA( this.getMatcherToFindRecycleView() ) ),
                        indexInWindow
                )
        ) ) ;

        song.myUtaButton( this.myUtaButton( indexInWindow ) ) ;
        return song ;
    }

    private String songName( int indexInWindow ) {
        return this.getText(
                UtaPassUtil.withIndex(
                        allOf( withId( R.id.item_detail_stream_audio_title ),
                               isDescendantOfA( this.getMatcherToFindRecycleView() ) ),
                        indexInWindow ) ) ;
    }

    private String artistName( int indexInWindow ) {
        return this.getText(
                UtaPassUtil.withIndex(
                        allOf( withId( R.id.item_detail_stream_audio_artist ),
                               isDescendantOfA( this.getMatcherToFindRecycleView() ) ),
                        indexInWindow ) ) ;
    }

    private ViewInteraction coverPhoto( int indexInWindow ) {
        return onView(
                UtaPassUtil.withIndex(
                    allOf( withId( R.id.item_detail_stream_audio_image ),
                           isDescendantOfA( this.getMatcherToFindRecycleView() ) ),
                    indexInWindow ) ) ;
    }

    private MyUtaButton myUtaButton( int indexInWindow ) {
        MyUtaButton button = new MyUtaButton() ;
        button.matcherForButton(
                UtaPassUtil.withIndex(
                    allOf( withId( R.id.item_detail_stream_audio_myuta_register ),
                           isDescendantOfA( this.getMatcherToFindRecycleView() ) ),
                    indexInWindow ) ) ;

        button.matcherForText(
                UtaPassUtil.withIndex(
                    allOf( withId( R.id.item_detail_stream_audio_myuta_text ),
                           isDescendantOfA( this.getMatcherToFindRecycleView() ) ),
                    indexInWindow ) ) ;

        return button ;
    }
}