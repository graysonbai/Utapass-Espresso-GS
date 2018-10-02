package com.kddi.android.UtaPass.sqa_espresso.pages.library.albums ;

import com.kddi.android.UtaPass.sqa_espresso.common.LazyMatcher;
import com.kddi.android.UtaPass.sqa_espresso.common.LazyString;
import com.kddi.android.UtaPass.sqa_espresso.common.ViewObject;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;

public class AlbumObject extends ViewObject {

    private LazyMatcher matcherAlbumName ;
    private LazyMatcher matcherArtistName ;
    private LazyMatcher matcherCoverPhoto ;

    public void albumName( LazyMatcher matcher ) {
        this.matcherAlbumName = matcher ;
    }

    public LazyString albumName() {
        return new LazyString( this.matcherAlbumName ) ;
    }

    public void artistName( LazyMatcher matcher ) {
        this.matcherArtistName = matcher ;
    }

    public LazyString artistName() {
        return new LazyString( this.matcherArtistName ) ;
    }

    public void cover( LazyMatcher matcher ) {
        this.matcherCoverPhoto = matcher ;
    }

    public void tap() {
        onView( this.matcherCoverPhoto.execute() ).perform( click() ) ;
    }
}


