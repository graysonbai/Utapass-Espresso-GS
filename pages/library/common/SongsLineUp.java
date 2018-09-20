package com.kddi.android.UtaPass.sqa_espresso.pages.library.common ;

import android.support.test.espresso.ViewInteraction;
import android.view.View;

import com.kddi.android.UtaPass.R;
import com.kddi.android.UtaPass.sqa_espresso.common.SongObject;
import com.kddi.android.UtaPass.sqa_espresso.common.UtaPassUtil;
import com.kddi.android.UtaPass.sqa_espresso.pages.library.common.LibraryLineUp;
import com.kddi.android.UtaPass.sqa_espresso.pages.library.common.TitleBar;

import org.hamcrest.Matcher;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.matcher.ViewMatchers.isDescendantOfA;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.allOf;

public class SongsLineUp extends LibraryLineUp {

    protected Matcher<View> getMatcherToFindRecycleView() {
        return withId( R.id.local_track_recycler_view ) ;
    }

    protected Matcher<View> getMatcherToCountMaxIndexOfWindow() {
        return withId( R.id.item_library_lazy_track_icon ) ;
    }

    public SongObject song( int index ) {
        int indexInWindow = this.swipeToCardViewAndGetIndexOfWindow( index ) ;

        SongObject song = new SongObject() ;

        song.songName( () ->
                UtaPassUtil.withIndex(
                        allOf( withId( R.id.item_library_lazy_track_title ),
                               isDescendantOfA( this.getMatcherToFindRecycleView() ) ),
                        indexInWindow ) ) ;

        song.artistName( () ->
                UtaPassUtil.withIndex(
                        allOf( withId( R.id.item_library_lazy_track_subtitle ),
                                isDescendantOfA( this.getMatcherToFindRecycleView() ) ),
                        indexInWindow ) ) ;

        song.cover( () ->
                UtaPassUtil.withIndex(
                        allOf( withId( R.id.item_library_lazy_track_icon ),
                               isDescendantOfA( this.getMatcherToFindRecycleView() ) ),
                        indexInWindow ) ) ;

        song.moreActionButton( () ->
                UtaPassUtil.withIndex(
                        allOf( withId( R.id.item_library_lazy_track_overflow ),
                                isDescendantOfA( this.getMatcherToFindRecycleView() ) ),
                        indexInWindow ) ) ;

        return song ;
    }
}
