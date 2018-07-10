package com.kddi.android.UtaPass.sqatest.common.lineup ;

import android.support.test.espresso.ViewInteraction;
import android.view.View;

import com.kddi.android.UtaPass.R;
import com.kddi.android.UtaPass.sqatest.common.LibrarySongObject;
import com.kddi.android.UtaPass.sqatest.common.UtaPassUtil;

import org.hamcrest.Matcher;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.matcher.ViewMatchers.isDescendantOfA;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.allOf;

public class LibrarySongsLineUp extends LibraryLineUp {

    protected Matcher<View> getMatcherToFindRecycleView() {
        return withId( R.id.local_track_recycler_view ) ;
    }

    protected Matcher<View> getMatcherToCountMaxIndexOfWindow() {
        return withId( R.id.item_library_lazy_track_icon ) ;
    }

    public LibrarySongObject getSong(int index ) {
        int indexInWindow = this.swipeToCardViewAndGetIndexOfWindow( index ) ;
        LibrarySongObject song = new LibrarySongObject() ;
        song.setSongName( this.getSongName( indexInWindow ) ) ;
        song.setArtistName( this.getArtistName( indexInWindow ) ) ;
        song.setCoverPhoto( this.getCoverPhoto( indexInWindow ) ) ;
        return song ;
    }

    private String getSongName( int indexInWindow ) {
        return this.getText(
                UtaPassUtil.withIndex(
                        allOf( withId( R.id.item_library_lazy_track_title ),
                               isDescendantOfA( this.getMatcherToFindRecycleView() ) ),
                        indexInWindow ) ) ;
    }

    private String getArtistName( int indexInWindow ) {
        return this.getText(
                UtaPassUtil.withIndex(
                        allOf( withId( R.id.item_library_lazy_track_subtitle ),
                               isDescendantOfA( this.getMatcherToFindRecycleView() ) ),
                        indexInWindow ) ) ;
    }

    private ViewInteraction getCoverPhoto(int indexInWindow ) {
        return onView(
                UtaPassUtil.withIndex(
                        allOf( withId( R.id.item_library_lazy_track_icon ),
                               isDescendantOfA( this.getMatcherToFindRecycleView() ) ),
                        indexInWindow ) ) ;
    }
}