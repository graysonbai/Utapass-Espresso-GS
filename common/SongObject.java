package com.kddi.android.UtaPass.sqa_espresso.common ;

import com.kddi.android.UtaPass.sqa_espresso.common.exceptions.SongInvisibleException;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.isDescendantOfA;
import static android.support.test.espresso.matcher.ViewMatchers.withClassName;
import static org.hamcrest.Matchers.endsWith;
import static org.hamcrest.core.AllOf.allOf;

public class SongObject extends ViewObject {
    private LazyMatcher matcherSongName ;
    private LazyMatcher matcherArtistName ;
    private LazyMatcher matcherCoverPhoto ;
    private LazyMatcher matcherMyUtaButton ;
    private LazyMatcher matcherMoreActionButton ;

    public void assertVisible() {
        if( ! this.isVisible() ) {
            throw new SongInvisibleException( this.matcherCoverPhoto.toString() ) ;
        }
    }

    public boolean isVisible() {
        return this.isVisible( this.matcherCoverPhoto.execute() ) ;
    }

    public void songName( LazyMatcher matcher ) {
        this.matcherSongName = matcher ;
    }

    public StringObject songName() {
        return new LazyString( this.matcherSongName ).text() ;
    }

    public void artistName( LazyMatcher matcher ) {
        this.matcherArtistName = matcher ;
    }

    public StringObject artistName() {
        return new LazyString( this.matcherArtistName ).text() ;
    }

    public void myUtaButton( LazyMatcher matcher ) {
        this.matcherMyUtaButton = matcher ;
    }

    public BasicButton myUtaButton() {
        return new BasicButton( this.matcherMyUtaButton ) {

            public LazyString text() {
                return new LazyString( this.label(), () -> allOf(
                        withClassName( endsWith( "TextView" ) ),
                        isDescendantOfA( super.matcher.execute() ) ) ) ;
            }
        } ;
    }

    public void moreActionButton( LazyMatcher matcher ) {
        this.matcherMoreActionButton = matcher ;
    }

    public BasicButton moreActionButton() {
        return new BasicButton( this.matcherMoreActionButton ) {

            public void _ready() {
                if( ! this.isVisible() ) {
                    String msg = "NotReady: Song > MoreActionButton" ;
                    throw new RuntimeException( msg ) ;
                }
            }
        } ;
    }

    public void tap() {
        this.assertVisible() ;
        onView( this.matcherCoverPhoto.execute() ).perform( click() ) ;
    }

    public void cover( LazyMatcher matcher ) {
        this.matcherCoverPhoto = matcher ;
    }
}


