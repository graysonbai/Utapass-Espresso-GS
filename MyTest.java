package com.kddi.android.UtaPass.sqa_espresso ;

import android.support.test.runner.AndroidJUnit4 ;

import com.kddi.android.UtaPass.sqa_espresso.common.Navigator;

import org.junit.Test ;
import org.junit.runner.RunWith ;


@RunWith(AndroidJUnit4.class)
public class MyTest extends BasicTest {

    private Navigator navigator = new Navigator() ;

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

        this.retry( () -> this.navigator.nowPlayingBar().isPlaying() ) ;

        this.assertEqual(
                this.navigator.songsPage().songsLineUp().song( 0 ).songName(),
                this.navigator.nowPlayingBar().songName()
        ) ;

        this.assertEqual(
                this.navigator.songsPage().songsLineUp().song( 0 ).artistName(),
                this.navigator.nowPlayingBar().artistName()
        ) ;
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
                      .song( 1 )
                      .tap() ;

        this.retry( () -> this.navigator.albumInfoPage().nowPlayingBar().isPlaying() ) ;
    }

    @Test
    public void play_song_in_artist() {
        this.navigator.streamPage()
                      .libraryTab()
                      .tap() ;

        this.navigator.libraryPage()
                      .artistsCategory()
                      .tap() ;

        this.navigator.artistsPage()
                      .artistsLineUp()
                      .artist( 9 )
                      .tap() ;

        this.sleep( 5 ) ;
    }

    @Test
    public void play_song_in_myuta() {
        // TestRails: 1934617

        // save any song to my uta
        this.navigator.streamPage()
                      .spotlightLineUp()
                      .getCard( 0 )
                      .tap() ;

        if( this.navigator.spotlightPage()
                          .songsLineUp()
                          .song( 0 )
                          .myUtaButton()
                          .isVisible() ) {

            this.navigator.spotlightPage()
                          .songsLineUp()
                          .song( 0 )
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

        this.retry( () ->
                this.navigator.myUtaPage().nowPlayingBar().isPlaying()
        ) ;
    }
}
