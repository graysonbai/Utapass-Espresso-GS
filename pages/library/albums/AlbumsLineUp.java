package com.kddi.android.UtaPass.sqa_espresso.pages.library.albums ;

import android.view.View;

import com.kddi.android.UtaPass.R;
import com.kddi.android.UtaPass.sqa_espresso.common.UtaPassUtil;
import com.kddi.android.UtaPass.sqa_espresso.pages.library.common.LibraryLineUp;

import org.hamcrest.Matcher;
import static android.support.test.espresso.matcher.ViewMatchers.isDescendantOfA;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.allOf;


public class AlbumsLineUp extends LibraryLineUp {

    protected Matcher<View> getMatcherToFindRecycleView() {
        return withId( R.id.local_track_recycler_view ) ;
    }

    protected Matcher<View> getMatcherToCountMaxIndexOfWindow() {
        return withId( R.id.item_library_local_album_icon ) ;
    }

    public AlbumObject album( int index ) {
        int indexInWindow = this.swipeToCardViewAndGetIndexOfWindow( index ) ;

        AlbumObject album = new AlbumObject() ;

        album.albumName( () -> UtaPassUtil.withIndex(
                allOf( withId( R.id.item_library_local_album_title ),
                       isDescendantOfA( this.getMatcherToFindRecycleView() ) ),
                indexInWindow ) ) ;

        album.artistName( () -> UtaPassUtil.withIndex(
                allOf( withId( R.id.item_library_local_album_subtitle ),
                       isDescendantOfA( this.getMatcherToFindRecycleView() ) ),
                indexInWindow ) ) ;

        album.cover( () -> UtaPassUtil.withIndex(
                allOf( withId( R.id.item_library_local_album_icon ),
                       isDescendantOfA( this.getMatcherToFindRecycleView() ) ),
                indexInWindow ) ) ;

        return album ;
    }
}