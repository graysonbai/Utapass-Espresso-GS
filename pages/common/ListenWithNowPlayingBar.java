package com.kddi.android.UtaPass.sqa_espresso.pages.common ;

import com.kddi.android.UtaPass.R ;
import com.kddi.android.UtaPass.sqa_espresso.common.BasicButton;
import com.kddi.android.UtaPass.sqa_espresso.common.LazyString;
import com.kddi.android.UtaPass.sqa_espresso.common.StringObject;

import static android.support.test.espresso.matcher.ViewMatchers.isDescendantOfA;
import static android.support.test.espresso.matcher.ViewMatchers.withId ;
import static org.hamcrest.Matchers.* ;


public class ListenWithNowPlayingBar extends BasicNowPlayingBar {

    public ListenWithNowPlayingBar() {
        this.label( "ListenWithNowPlayingBar" ) ;
    }

    public void _ready() {
        this.stopFollowingButton().assertVisible() ;
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

    public BasicButton stopFollowingButton() {
        return new BasicButton( String.format( "%s > StopFollowingButton", this.label() ),
                () -> allOf( withId( R.id.indicator_unfollow ),
                             isDescendantOfA( this.matcher() ) ) ) ;
    }

    public boolean isFollowing() {
        try {
            return this.stopFollowingButton().isVisible() ;

        } catch( RuntimeException e ) {
            return false ;
        }
    }

    public void assertFollowing() {
        this.stopFollowingButton().ready() ;
    }
}
