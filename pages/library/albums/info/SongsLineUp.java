package com.kddi.android.UtaPass.sqa_espresso.pages.library.albums.info ;

import android.support.test.espresso.ViewInteraction;
import android.view.View;

import com.kddi.android.UtaPass.R;
import com.kddi.android.UtaPass.sqa_espresso.common.SongObject;
import com.kddi.android.UtaPass.sqa_espresso.common.UtaPassUtil;
import com.kddi.android.UtaPass.sqa_espresso.pages.library.common.LibraryLineUp;

import org.hamcrest.Matcher;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.matcher.ViewMatchers.isDescendantOfA;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.allOf;


public class SongsLineUp extends LibraryLineUp {

    protected Matcher<View> getMatcherToFindRecycleView() {
        return withId( R.id.detail_album_recycler_view ) ;
    }

    protected Matcher<View> getMatcherToCountMaxIndexOfWindow() {
        return withId( R.id.item_detail_local_audio_image ) ;
    }

    public SongObject song( int index ) {
        int indexInWindow = this.swipeToCardViewAndGetIndexOfWindow( index ) ;

        SongObject song = new SongObject() ;

        song.songName( () ->
                UtaPassUtil.withIndex(
                        allOf( withId( R.id.item_detail_local_audio_title ),
                               isDescendantOfA( this.getMatcherToFindRecycleView() ) ),
                        indexInWindow ) ) ;

        song.artistName( () ->
                UtaPassUtil.withIndex(
                        allOf( withId( R.id.item_detail_local_audio_artist ),
                               isDescendantOfA( this.getMatcherToFindRecycleView() ) ),
                        indexInWindow ) ) ;

        song.cover( () ->
                UtaPassUtil.withIndex(
                        allOf( withId( R.id.item_detail_local_audio_image ),
                               isDescendantOfA( this.getMatcherToFindRecycleView() ) ),
                        indexInWindow ) ) ;

        return song ;
    }

    private ViewInteraction photo( int indexInWindow ) {
        return onView(
                UtaPassUtil.withIndex(
                        allOf( withId( R.id.item_detail_local_audio_image ),
                               isDescendantOfA( this.getMatcherToFindRecycleView() ) ),
                        indexInWindow ) ) ;
    }
}
