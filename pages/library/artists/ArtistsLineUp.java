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

    protected int swipeToCardViewAndGetIndexOfWindow( int index ) {
        if( this.titleBar().isVisible() ) {
            this.titleBar().swipeUp() ;
            this.resetMaxIndexOfWindow() ;
        }
        this.swipeToLeftmost() ;

        //                                 Max
        //         swipe      IndexOf    IndexOf
        // index    to        Window     Window
        // ========================================
        //  0        0          0           8
        //  1        1          1           8
        //  2        2          2           8
        //  ...      ...        ...         ...
        //  8        8          8           8
        //  9        9          8           8
        // 10       10          8           8
        // 11       11          8           8
        // 12       12          8           8
        //
        this.swipeToPosition( index ) ;

        if( index > this.getMaxIndexOfWindow() ) {
            return this.getMaxIndexOfWindow() ;
        }

        return index ;
    }

    public ArtistObject artist( int index ) {
        int indexInWindow = this.swipeToCardViewAndGetIndexOfWindow( index ) ;
        ArtistObject artist = new ArtistObject() ;
        artist.photo( this.photo( indexInWindow ) ) ;
        artist.name( this.name( indexInWindow ) ) ;
        artist.albums( this.albums( indexInWindow ) ) ;
        artist.totalSongs( this.songs( indexInWindow ) ) ;
        return artist ;
    }

    private String name( int indexInWindow ) {
        return this.getText(
                UtaPassUtil.withIndex(
                        allOf( withId( R.id.item_library_local_artist_title ),
                               isDescendantOfA( this.getMatcherToFindRecycleView() ) ),
                        indexInWindow ) ) ;
    }

    private String albums( int indexInWindow ) {
        java.util.regex.Matcher matcher =
                Pattern.compile( "([0-9]+).+([0-9]+).+" )
                       .matcher( this.subtitle( indexInWindow ) ) ;

        if( matcher.find() ) {
            return matcher.group( 1 ) ;
        }

        return "" ;
    }

    private String songs( int indexInWindow ) {
        java.util.regex.Matcher matcher =
                Pattern.compile( "([0-9]+).+([0-9]+).+" )
                       .matcher( this.subtitle( indexInWindow ) ) ;

        if( matcher.find() ) {
            return matcher.group( 2 ) ;
        }

        return "" ;
    }

    private String subtitle( int indexInWindow ) {
        return this.getText(
                UtaPassUtil.withIndex(
                        allOf( withId( R.id.item_library_local_artist_subtitle ),
                               isDescendantOfA( this.getMatcherToFindRecycleView() ) ),
                        indexInWindow ) ) ;
    }

    private ViewInteraction photo(int indexInWindow ) {
        return onView(
                UtaPassUtil.withIndex(
                        allOf( withId( R.id.item_library_local_artist_icon ),
                               isDescendantOfA( this.getMatcherToFindRecycleView() ) ),
                        indexInWindow ) ) ;
    }
}