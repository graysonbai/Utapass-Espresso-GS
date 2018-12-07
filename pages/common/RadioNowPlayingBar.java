package com.kddi.android.UtaPass.sqa_espresso.pages.common ;

import com.kddi.android.UtaPass.R ;
import com.kddi.android.UtaPass.sqa_espresso.common.BasicButton;
import com.kddi.android.UtaPass.sqa_espresso.common.LazyString;
import com.kddi.android.UtaPass.sqa_espresso.common.StringObject;
import com.kddi.android.UtaPass.sqa_espresso.common.UtaPassUtil;

import static android.support.test.espresso.matcher.ViewMatchers.isDescendantOfA;
import static android.support.test.espresso.matcher.ViewMatchers.withId ;
import static org.hamcrest.Matchers.* ;


public class RadioNowPlayingBar extends BasicNowPlayingBar {

    public RadioNowPlayingBar() {
        this.label( "RadioNowPlayingBar" ) ;
    }

    public LazyString programName() {
        return new LazyString( String.format( "%s > ProgramName", this.label() ),
                () -> allOf( withId( R.id.indicator_track_title ),
                             isDescendantOfA( this.matcher() ) ) ) ;
    }

    public StringObject djName() {
        return new LazyString( String.format( "%s > DjName", this.label() ),
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
}
