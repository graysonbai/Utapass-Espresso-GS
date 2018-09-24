package com.kddi.android.UtaPass.sqa_espresso.pages.common ;

import com.kddi.android.UtaPass.R ;
import com.kddi.android.UtaPass.sqa_espresso.common.NextButton;
import com.kddi.android.UtaPass.sqa_espresso.common.PauseButton;
import com.kddi.android.UtaPass.sqa_espresso.common.PlayButton;
import com.kddi.android.UtaPass.sqa_espresso.common.StringObject;
import com.kddi.android.UtaPass.sqa_espresso.common.UtaPassUtil;
import com.kddi.android.UtaPass.sqa_espresso.common.ViewObject;

import android.support.test.espresso.AmbiguousViewMatcherException;
import android.view.View ;

import org.hamcrest.Matcher;

import static android.support.test.espresso.matcher.ViewMatchers.isCompletelyDisplayed;

import static android.support.test.espresso.Espresso.onView ;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.isDescendantOfA;
import static android.support.test.espresso.matcher.ViewMatchers.withId ;
import static org.hamcrest.Matchers.* ;


public class NowPlayingBar extends ViewObject {

    private Matcher<View> itemMatcher ;

    private StringObject songName ;
    private StringObject artistName ;
    private PlayButton playButton ;
    private PauseButton pauseButton ;
    private NextButton nextButton ;

    public NowPlayingBar() {
        this.itemMatcher = withId( R.id.nowplaying_indicator ) ;
        this.item = onView( this.itemMatcher ) ;
    }

    public void _ready() {
        if( ! this.pauseButton().isVisible() &&
            ! this.playButton().isVisible() ) {

            throw new RuntimeException( "NowPlayingBar is not ready" ) ;
        }
    }

    public StringObject songName() {
        if( this.songName == null ) {
            this.songName = new StringObject( this.getText(
                    allOf( withId( R.id.indicator_track_title ),
                           isDescendantOfA( this.itemMatcher ) ) ) ) ;
        }
        return this.songName ;
    }

    public StringObject artistName() {
        if( this.artistName == null ) {
            this.artistName = new StringObject( this.getText(
                    allOf( withId( R.id.indicator_artist_title ),
                            isDescendantOfA( this.itemMatcher ) ) ) ) ;
        }
        return this.artistName ;
    }

    public PlayButton playButton() {
        if( this.playButton == null ) {
            this.playButton = new PlayButton( () ->
                    allOf( UtaPassUtil.withDrawable( R.drawable.ic_bar_play ),
                           isDescendantOfA( this.itemMatcher ) ) ) ;
        }

        return this.playButton ;
    }

    public PauseButton pauseButton() {
        if( this.pauseButton == null ) {
            this.pauseButton = new PauseButton( () -> UtaPassUtil.withIndex(
                    allOf( UtaPassUtil.withDrawable( R.drawable.ic_bar_pause ),
                           isCompletelyDisplayed(),
                           isDescendantOfA( this.itemMatcher ) ),
                   0 ) ) ;
        }

        return this.pauseButton ;
    }

    public NextButton nextButton() {
        if( this.nextButton == null ) {
            this.nextButton = new NextButton( () ->
                    allOf( UtaPassUtil.withDrawable( R.drawable.ic_bar_next ),
                           isDescendantOfA( this.itemMatcher ) ) ) ;
        }

        return this.nextButton ;
    }


    public boolean isPlaying() {
        try {
            return this.pauseButton().isVisible() ;

        } catch( AmbiguousViewMatcherException exp ) {
            UtaPassUtil.dprint( exp.getMessage() ) ;
            return false ;
        }
    }

    public void assertPlaying() {
        UtaPassUtil.retry( () -> this.isPlaying() ) ;
    }

    public void tap() {
        this.item.perform( click() ) ;
    }

    public void play() {
        this.playButton().tap() ;
    }

    public void pause() {
        this.pauseButton().tap() ;
    }

    public void next() {
        this.nextButton.tap() ;
    }
}
