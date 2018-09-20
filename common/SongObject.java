package com.kddi.android.UtaPass.sqa_espresso.common ;

import com.kddi.android.UtaPass.sqa_espresso.pages.stream.common.MyUtaButton;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;

public class SongObject extends ViewObject {
    private LazyMatcher matcherSongName ;
    private LazyMatcher matcherArtistName ;
    private LazyMatcher matcherCoverPhoto ;
    private LazyMatcher matcherMyUtaButton ;
    private LazyMatcher matcherMoreActionButton ;

    public boolean isVisible() {
        return this.isVisible( this.matcherCoverPhoto.execute() ) ;
    }

    public void songName( LazyMatcher workaround ) {
        this.matcherSongName = workaround ;
    }

    public LazyString songName() {
        return new LazyString( this.matcherSongName ) ;
    }

    public void artistName( LazyMatcher workaround ) {
        this.matcherArtistName = workaround ;
    }

    public LazyString artistName() {
        return new LazyString( this.matcherArtistName ) ;
    }

    public void myUtaButton( LazyMatcher workaround ) {
        this.matcherMyUtaButton = workaround ;
    }

    public MyUtaButton myUtaButton() {
        return new MyUtaButton( this.matcherMyUtaButton ) ;
    }

    public void moreActionButton( LazyMatcher workaround ) {
        this.matcherMoreActionButton = workaround ;
    }

    public MoreActionButton moreActionButton() {
        return new MoreActionButton( this.matcherMoreActionButton ) ;
    }

    public void tap() {
        onView( this.matcherCoverPhoto.execute() ).perform( click() ) ;
    }

    public void cover( LazyMatcher workaround ) {
        this.matcherCoverPhoto = workaround ;
    }
}


