package com.kddi.android.UtaPass.sqa_espresso.pages.library.artists ;

import android.support.test.espresso.ViewInteraction;
import android.view.View;

import com.kddi.android.UtaPass.R;
import com.kddi.android.UtaPass.sqa_espresso.common.UtaPassUtil;
import com.kddi.android.UtaPass.sqa_espresso.pages.library.common.LibraryLineUp;

import org.hamcrest.Matcher;

import java.util.regex.Pattern;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.matcher.ViewMatchers.isDescendantOfA;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.allOf;

public class ArtistsLineUp extends LibraryLineUp {

    protected Matcher<View> getMatcherToFindRecycleView() {
        return withId( R.id.local_track_recycler_view ) ;
    }

    protected Matcher<View> getMatcherToCountMaxIndexOfWindow() {
        return withId( R.id.item_library_local_artist_icon ) ;
    }

    public ArtistObject getArtist(int index ) {
        int indexInWindow = this.swipeToCardViewAndGetIndexOfWindow( index ) ;
        ArtistObject artist = new ArtistObject() ;
        artist.setCoverPhoto( this.getCoverPhoto( indexInWindow ) ) ;
        artist.setArtistName( this.getArtistName( indexInWindow ) ) ;
        artist.setTotalAlbums( this.getTotalAlbums( indexInWindow ) ) ;
        artist.setTotalSongs( this.getTotalSongs( indexInWindow ) ) ;
        return artist ;
    }

    private String getArtistName( int indexInWindow ) {
        return this.getText(
                UtaPassUtil.withIndex(
                        allOf( withId( R.id.item_library_local_artist_title ),
                               isDescendantOfA( this.getMatcherToFindRecycleView() ) ),
                        indexInWindow ) ) ;
    }

    private String getTotalAlbums( int indexInWindow ) {
        java.util.regex.Matcher matcher =
                Pattern.compile( "([0-9]+) albums?" )
                       .matcher( this.getSubTitle( indexInWindow ) ) ;

        if( matcher.find() ) {
            return matcher.group( 1 ) ;
        }

        return "" ;
    }

    private String getTotalSongs( int indexInWindow ) {
        java.util.regex.Matcher matcher =
                Pattern.compile( "([0-9]+) songs?" )
                       .matcher( this.getSubTitle( indexInWindow ) ) ;

        if( matcher.find() ) {
            return matcher.group( 1 ) ;
        }

        return "" ;
    }

    private String getSubTitle( int indexInWindow ) {
        return this.getText(
                UtaPassUtil.withIndex(
                        allOf( withId( R.id.item_library_local_artist_subtitle ),
                               isDescendantOfA( this.getMatcherToFindRecycleView() ) ),
                        indexInWindow ) ) ;
    }

    private ViewInteraction getCoverPhoto(int indexInWindow ) {
        return onView(
                UtaPassUtil.withIndex(
                        allOf( withId( R.id.item_library_local_artist_icon ),
                               isDescendantOfA( this.getMatcherToFindRecycleView() ) ),
                        indexInWindow ) ) ;
    }
}