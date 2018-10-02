package com.kddi.android.UtaPass.sqa_espresso.pages.library.artists ;

import android.view.View;

import com.kddi.android.UtaPass.R;
import com.kddi.android.UtaPass.sqa_espresso.common.BasicButton;
import com.kddi.android.UtaPass.sqa_espresso.common.LazyString;
import com.kddi.android.UtaPass.sqa_espresso.common.LineUpObject;
import com.kddi.android.UtaPass.sqa_espresso.common.UtaPassUtil;
import com.kddi.android.UtaPass.sqa_espresso.pages.common.BasicPage;
import com.kddi.android.UtaPass.sqa_espresso.pages.library.albums.AlbumObject;

import org.hamcrest.Matcher;

import static android.support.test.espresso.matcher.ViewMatchers.isDescendantOfA;
import static android.support.test.espresso.matcher.ViewMatchers.withClassName;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.endsWith;


public class ArtistAlbumsPage extends BasicPage {

    private ArtistAlbumsLineUp artistAlbumsLineUp ;
    private BasicButton allSongsButton ;

    public String getTotalSongs() {
        String raw = this.getText( withId( R.id.detail_artist_description ) ) ;
        return raw.split( " · " )[ 0 ] ;
    }

    public String getTotalTime() {
        String raw = this.getText( withId( R.id.detail_artist_description ) ) ;
        return raw.split( " · " )[ 1 ] ;
    }

    public void _ready() {
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

    public BasicButton allSongsButton() {
        if( this.allSongsButton == null ) {
            this.allSongsButton = new BasicButton( () ->
                    withId( R.id.item_detail_artist_all_song_root_layout ) ) {

                public LazyString text() {
                    return new LazyString( () -> allOf(
                            withClassName( endsWith( "TextView" ) ),
                            isDescendantOfA( super.matcher.execute() ) ) ) ;
                }
            } ;
        }
        return this.allSongsButton ;
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

            album.albumName( () -> UtaPassUtil.withIndex(
                    allOf( withId( R.id.item_detail_album_title ),
                           isDescendantOfA( this.getMatcherToFindRecycleView() ) ),
                    indexInWindow ) ) ;

            album.artistName( () -> UtaPassUtil.withIndex(
                    allOf( withId( R.id.item_detail_album_artist ),
                           isDescendantOfA( this.getMatcherToFindRecycleView() ) ),
                    indexInWindow ) ) ;

            album.cover( () -> UtaPassUtil.withIndex(
                    allOf( withId( R.id.item_detail_album_image ),
                            isDescendantOfA( this.getMatcherToFindRecycleView() ) ),
                    indexInWindow ) ) ;

            return album ;
        }
    }
}
