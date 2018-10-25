package com.kddi.android.UtaPass.sqa_espresso.pages.common ;

import com.kddi.android.UtaPass.R ;
import com.kddi.android.UtaPass.sqa_espresso.common.BasicButton;
import com.kddi.android.UtaPass.sqa_espresso.common.BasicImage;
import com.kddi.android.UtaPass.sqa_espresso.common.LazyString;
import com.kddi.android.UtaPass.sqa_espresso.common.StringObject;
import com.kddi.android.UtaPass.sqa_espresso.common.UtaPassUtil;
import com.kddi.android.UtaPass.sqa_espresso.common.ViewObject;
import com.kddi.android.UtaPass.sqa_espresso.common.exceptions.InvisibleException;

import android.view.View ;

import org.hamcrest.Matcher;

import static android.support.test.espresso.matcher.ViewMatchers.isCompletelyDisplayed;

import static android.support.test.espresso.Espresso.onView ;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.isDescendantOfA;
import static android.support.test.espresso.matcher.ViewMatchers.withId ;
import static org.hamcrest.Matchers.* ;


public class NowPlayingBar extends ViewObject {

    public NowPlayingBar() {
        this.label( "NowPlayingBar" ) ;
    }

    public void _ready() {
        this.assertVisible() ;
    }

    public void assertVisible() {
        if( ! isVisible() ) {
            throw new InvisibleException( this.label() ) ;
        }
    }

    public boolean isVisible() {
        return this.isVisible( this.matcher() ) ;
    }

    public Matcher<View> matcher() {
        return allOf( withId( R.id.view_indicator_layout ),
                      isCompletelyDisplayed() ) ;
    }

    public BasicImage cover() {
        return new BasicImage( String.format( "%s > Cover", this.label() ),
                () -> allOf( withId( R.id.indicator_album_cover ),
                        isDescendantOfA( this.matcher() ) ) ) ;
    }

    public LazyString songName() {
        return new LazyString( String.format( "%s > SongName", this.label() ),
                () -> allOf( withId( R.id.indicator_track_title ),
                             isDescendantOfA( this.matcher() ) ) ) ;
    }

    public StringObject artistName() {
        return new LazyString( String.format( "%s > ArtistName", this.label() ),
                () -> allOf( withId( R.id.indicator_artist_title ),
                             isDescendantOfA( this.matcher() ) ) ) ;
    }

    public BasicButton playButton() {
        return new BasicButton( String.format( "%s > PlayButton", this.label() ),
                () -> allOf( UtaPassUtil.withDrawable( R.drawable.ic_bar_play ),
                             isDescendantOfA( this.matcher() ) ) ) ;
    }

    public BasicButton pauseButton() {
        return new BasicButton( String.format( "%s > PauseButton", this.label() ),
                () -> allOf( UtaPassUtil.withDrawable( R.drawable.ic_bar_pause ),
                             isDescendantOfA( this.matcher() ) ) ) ;
    }

    public BasicButton nextButton() {
        return new BasicButton( String.format( "%s > NextButton", this.label() ),
                () -> allOf( UtaPassUtil.withDrawable( R.drawable.ic_bar_next ),
                             isDescendantOfA( this.matcher() ) ) ) ;
    }

    public boolean isPlaying() {
        try {
            return this.pauseButton().isVisible() ;

        } catch( RuntimeException e ) {
            return false ;
        }
    }

    public void assertPlaying() {
        this.pauseButton().ready() ;
    }

    public void tap() {
        this.dprint_tap() ;

        this.handleNoMatchViewException(
                () -> onView( this.matcher() ).perform( click() ) ) ;
    }

    public void play() {
        this.playButton().tap() ;
    }

    public void pause() {
        this.pauseButton().tap() ;
    }

    public void next() {
        this.nextButton().tap() ;
    }
}
