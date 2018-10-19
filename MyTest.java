package com.kddi.android.UtaPass.sqa_espresso ;

import android.support.test.runner.AndroidJUnit4 ;

import com.kddi.android.UtaPass.sqa_espresso.common.Navigator;

import org.junit.Test ;
import org.junit.runner.RunWith ;


@RunWith(AndroidJUnit4.class)
public class MyTest extends BasicTest {

    @Test
    public void play_song_in_songs() {
        this.navigator.streamPage()
                      .libraryTab()
                      .tap() ;

        this.navigator.libraryPage()
                      .songsCategory()
                      .tap() ;

        this.navigator.songsPage()
                      .songsLineUp()
                      .song( 0 )
                      .tap() ;

        this.navigator.nowPlayingBar()
                      .assertPlaying() ;

        this.navigator.songsPage()
                      .songsLineUp()
                      .song( 0 )
                      .songName()
                      .assertEquals( this.navigator.nowPlayingBar().songName() ) ;

        this.navigator.songsPage()
                      .songsLineUp()
                      .song( 0 )
                      .artistName()
                      .assertEquals( this.navigator.nowPlayingBar().artistName() ) ;
    }

    @Test
    public void play_song_in_albums() {
        this.navigator.streamPage()
                      .libraryTab()
                      .tap() ;

        this.navigator.libraryPage()
                      .albumsCategory()
                      .tap() ;

        this.navigator.albumsPage()
                      .albumsLineUp()
                      .album( 0 )
                      .tap() ;

        this.navigator.albumInfoPage()
                      .songsLineUp()
                      .song( 0 )
                      .tap() ;

        this.navigator.nowPlayingBar()
                      .assertPlaying() ;
    }

    @Test
    public void play_song_in_artist() {
        this.navigator.streamPage()
                      .libraryTab()
                      .tap() ;

        this.navigator.libraryPage()
                      .artistsCategory()
                      .tap() ;

        int albums = Integer.parseInt( this.navigator.artistsPage()
                                                     .artistsLineUp()
                                                     .artist( 0 )
                                                     .albums() ) ;

        this.navigator.artistsPage()
                      .artistsLineUp()
                      .artist( 0 )
                      .tap() ;

        // ArtistAlbumsPage
        if( albums > 1 ) {
            this.navigator.artistAlbumsPage()
                          .artistAlbumsLineUp()
                          .album(0 )
                          .tap();
        }

        // AlbumInfoPage
        this.navigator.albumInfoPage()
                      .shuffleAllButton()
                      .tap() ;

        this.navigator.nowPlayingBar()
                      .assertPlaying() ;
    }

    @Test
    public void play_song_in_myuta() {
        // TestRails: 1934617

        // save any song to my uta
        this.navigator.streamPage()
                      .spotlightModule()
                      .lineUp()
                      .card( 9 )
                      .tap() ;

        if( this.navigator.spotlightPage()
                          .lineUp()
                          .card( 0 )
                          .myUtaButton()
                          .isVisible() ) {

            this.navigator.spotlightPage()
                          .lineUp()
                          .card( 0 )
                          .myUtaButton()
                          .tap() ;

            this.navigator.saveMyUtaPopupMessage()
                          .saveButton()
                          .tap() ;

            this.sleep( 5 ) ;
            if( this.navigator.saveMyUtaConfirmPopupMessage().isVisible() ) {
                this.navigator.saveMyUtaConfirmPopupMessage()
                              .closeButton()
                              .tap();
            }
        }

        this.navigator.spotlightPage()
                      .libraryTab()
                      .tap() ;

        this.navigator.libraryPage()
                      .myUtaCategory()
                      .tap() ;

        this.navigator.myUtaPage()
                      .playButton()
                      .tap() ;

        this.navigator.nowPlayingBar()
                      .assertPlaying() ;
    }
}
