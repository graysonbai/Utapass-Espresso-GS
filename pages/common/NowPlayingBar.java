package com.kddi.android.UtaPass.sqa_espresso.pages.common ;

import com.kddi.android.UtaPass.R ;
import com.kddi.android.UtaPass.sqa_espresso.common.UtaPassUtil;
import com.kddi.android.UtaPass.sqa_espresso.common.ViewObject;

import android.view.View ;
import android.support.test.espresso.ViewInteraction ;

import org.hamcrest.Matcher;


import static android.support.test.espresso.Espresso.onView ;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.isDescendantOfA;
import static android.support.test.espresso.matcher.ViewMatchers.withId ;
import static org.hamcrest.Matchers.* ;

public class NowPlayingBar extends ViewObject {

    private Matcher<View> itemMatcher ;

    private ViewInteraction songName ;
    private ViewInteraction artistName ;
    private ViewInteraction playButton ;
    private ViewInteraction pauseButton ;
    private ViewInteraction nextButton ;

    public NowPlayingBar() {
        this.itemMatcher = withId( R.id.nowplaying_indicator ) ;
        this.item = onView( this.itemMatcher ) ;

        this.songName = onView(
                            allOf( withId( R.id.indicator_track_title ),
                                   isDescendantOfA( this.itemMatcher ) ) ) ;

        this.artistName = onView(
                            allOf( withId( R.id.indicator_artist_title ),
                                   isDescendantOfA( this.itemMatcher ) ) ) ;

        this.playButton = onView(
                            allOf( UtaPassUtil.withDrawable( R.drawable.ic_bar_play ),
                                   isDescendantOfA( this.itemMatcher ) ) ) ;

        this.pauseButton = onView(
                            allOf( UtaPassUtil.withDrawable( R.drawable.ic_bar_pause ),
                                   isDescendantOfA( this.itemMatcher ) ) ) ;

        this.nextButton = onView(
                            allOf( UtaPassUtil.withDrawable( R.drawable.ic_bar_next ),
                                   isDescendantOfA( this.itemMatcher ) ) ) ;
    }

    public void _ready() {
        if( ! this.isVisible( this.item ) ||
            ! this.isVisible( this.songName ) ||
            ! this.isVisible( this.artistName ) ||
            ! this.isVisible( this.nextButton ) ) {

            throw new RuntimeException( "NowPlayingBar is not ready" ) ;
        }
    }

    public String songName() {
        return this.getText( this.songName ) ;
    }

    public String artistName() {
        return this.getText( this.artistName ) ;
    }

    public boolean isPlaying() {
        return this.isVisible( this.pauseButton ) ;
    }

    public void assertPlaying() {
        UtaPassUtil.retry( () -> this.isPlaying() ) ;
    }

    public void tap() {
        this.item.perform( click() ) ;
    }

    public void play() {
        this.playButton.perform( click() ) ;
    }

    public void pause() {
        this.pauseButton.perform( click() ) ;
    }

    public void next() {
        this.nextButton.perform( click() ) ;
    }
}
