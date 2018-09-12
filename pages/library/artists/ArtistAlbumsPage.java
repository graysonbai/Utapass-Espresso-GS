package com.kddi.android.UtaPass.sqa_espresso.pages.library.artists ;

import android.support.test.espresso.ViewInteraction;
import android.view.View;

import com.kddi.android.UtaPass.R;
import com.kddi.android.UtaPass.sqa_espresso.common.LineUpObject;
import com.kddi.android.UtaPass.sqa_espresso.common.UtaPassUtil;
import com.kddi.android.UtaPass.sqa_espresso.common.ViewObject;
import com.kddi.android.UtaPass.sqa_espresso.pages.common.BasicPage;
import com.kddi.android.UtaPass.sqa_espresso.pages.library.albums.AlbumObject;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.isDescendantOfA;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withParent;
import static org.hamcrest.core.AllOf.allOf;


public class ArtistAlbumsPage extends BasicPage {

    private ArtistAlbumsLineUp artistAlbumsLineUp ;
    private AllSongsButton allSongsButton ;

    public String getTotalSongs() {
        String raw = this.getText( withId( R.id.detail_artist_description ) ) ;
        return raw.split( " · " )[ 0 ] ;
    }

    public String getTotalTime() {
        String raw = this.getText( withId( R.id.detail_artist_description ) ) ;
        return raw.split( " · " )[ 1 ] ;
    }

    public void _ready() {
        this.retryWhenNotReady = false ;

        this.allSongsButton().ready() ;
    }

    public ArtistAlbumsLineUp artistAlbumsLineUp() {

        // Since the maxIndexOfLineUpObject will be changed after swiping,
        // We need to reuse the LibrarySongsLineUpObject ...
        if( this.artistAlbumsLineUp == null ) {
            this.artistAlbumsLineUp = new ArtistAlbumsLineUp() ;
        }
        return this.artistAlbumsLineUp ;
    }

    public AllSongsButton allSongsButton() {
        if( this.allSongsButton == null ) {
            this.allSongsButton = new AllSongsButton() ;
        }
        return this.allSongsButton ;
    }

    public class AllSongsButton extends ViewObject {
        public AllSongsButton() {
            this.item = onView( allOf( withId( R.id.view_shuffle_play_layout ),
                    withParent( withId( R.id.detail_album_recycler_view ) ) ) ) ;
        }

        public void _ready() {
            if( !this.isVisible( this.item ) ) {
                throw new RuntimeException( "All Songs button is not visible" ) ;
            }
        }

        public void tap() {
            this.item.perform( click() ) ;
        }

        public boolean isVisible() {
            return this.isVisible( this.item ) ;
        }

        public String text() {
            return this.getText( this.item ) ;
        }
    }

    public class ArtistAlbumsLineUp extends LineUpObject {
        protected Matcher<View> getMatcherToFindRecycleView() {
            return withId( R.id.detail_artist_recycler_view ) ;
        }

        protected Matcher<View> getMatcherToCountMaxIndexOfWindow() {
            return withId( R.id.item_detail_album_image ) ;
        }

        public AlbumObject album( int index ) {
            int indexInWindow = this.swipeToCardViewAndGetIndexOfWindow( index ) ;
            AlbumObject album = new AlbumObject() ;
            album.albumName( this.getAlbumName( indexInWindow ) ) ;
            album.artistName( this.getArtistName( indexInWindow ) ) ;
            album.photo( this.photo( indexInWindow ) ) ;
            return album ;
        }

        private String getAlbumName( int indexInWindow ) {
            return this.getText(
                    UtaPassUtil.withIndex(
                            Matchers.allOf( withId( R.id.item_detail_album_title ),
                                    isDescendantOfA( this.getMatcherToFindRecycleView() ) ),
                            indexInWindow ) ) ;
        }

        private String getArtistName( int indexInWindow ) {
            return this.getText(
                    UtaPassUtil.withIndex(
                            Matchers.allOf( withId( R.id.item_detail_album_artist ),
                                    isDescendantOfA( this.getMatcherToFindRecycleView() ) ),
                            indexInWindow ) ) ;
        }

        private ViewInteraction photo(int indexInWindow ) {
            return onView(
                    UtaPassUtil.withIndex(
                            Matchers.allOf( withId( R.id.item_detail_album_image ),
                                    isDescendantOfA( this.getMatcherToFindRecycleView() ) ),
                            indexInWindow ) ) ;
        }
    }
}
