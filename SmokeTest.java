package com.kddi.android.UtaPass.sqa_espresso ;

import android.support.test.runner.AndroidJUnit4 ;

import org.junit.Test ;
import org.junit.runner.RunWith ;


@RunWith(AndroidJUnit4.class)
public class SmokeTest extends BasicTest {

    @Test
    public void play_spotlight() {
        this.navigator.streamPage()
                      .spotlightModule()
                      .lineUp()
                      .card( 0 )
                      .tap() ;

        this.navigator.spotlightPage()
                      .playButton()
                      .tap() ;

        this.navigator.nowPlayingBar()
                      .assertPlaying() ;
    }

    @Test
    public void play_radio() {
        this.navigator.streamPage()
                      .radioModule()
                      .lineUp()
                      .card( 0 )
                      .playButton()
                      .tap() ;

        this.navigator.nowPlayingBar()
                      .songName()
                      .assertVisible() ;

        this.navigator.nowPlayingBar()
                      .artistName()
                      .assertVisible() ;

        this.navigator.nowPlayingBar()
                      .assertPlaying() ;
    }

    @Test
    public void play_live_event() {
        this.navigator.streamPage()
                      .liveModule()
                      .lineUp()
                      .card( 0 )
                      .playButton()
                      .tap() ;

        this.navigator.liveConcertPage()
                      .liveTitleBar()
                      .title()
                      .assertEquals( "KICK OFF VIVA!!! 2017" ) ;
    }

    @Test
    public void play_artist_new_release() {
        this.navigator.streamPage()
                      .artistNewReleaseModule()
                      .lineUp()
                      .card( 0 )
                      .playButton()
                      .tap() ;

        this.navigator.nowPlayingBar()
                      .assertPlaying() ;
    }

    @Test
    public void play_daily_mix() {
        this.navigator.streamPage()
                      .dailyMixModule()
                      .lineUp()
                      .card( 0 )
                      .playButton()
                      .tap() ;

        this.navigator.nowPlayingBar()
                      .assertPlaying() ;
    }

    @Test
    public void play_top_charts() {
        this.navigator.streamPage()
                      .topChartsModule()
                      .lineUp()
                      .card( 3 )
                      .playButton()
                      .tap() ;

        this.navigator.nowPlayingBar()
                      .assertPlaying() ;
    }

    @Test
    public void play_best50() {
        this.navigator.streamPage()
                      .best50Module()
                      .seeAll()
                      .tap() ;

        this.navigator.best50Page()
                      .playButton()
                      .tap() ;

        this.navigator.nowPlayingBar()
                      .assertPlaying() ;
    }

    @Test
    public void play_popular_artist() {
        this.navigator.streamPage()
                      .popularArtistModule()
                      .lineUp()
                      .card( 0 )
                      .playButton()
                      .tap() ;

        this.navigator.nowPlayingBar()
                      .assertPlaying() ;
    }

    @Test
    public void play_whats_new() {
        this.navigator.streamPage()
                      .whatsNewModule()
                      .lineUp()
                      .card( 0 )
                      .playButton()
                      .tap() ;

        this.navigator.nowPlayingBar()
                      .assertPlaying() ;
    }

    @Test
    public void play_new_songs_hit_songs() {
        this.navigator.streamPage()
                      .newSongsHitSongsModule()
                      .lineUp()
                      .card( 0 )
                      .playButton()
                      .tap() ;

        this.navigator.nowPlayingBar()
                      .assertPlaying() ;

        this.navigator.nowPlayingBar()
                      .pauseButton()
                      .tap() ;

        this.navigator.streamPage()
                      .newSongsHitSongsModule()
                      .seeAll()
                      .tap() ;

        this.navigator.newSongsHitSongsPage()
                      .lineUp()
                      .card( 0 )
                      .playButton()
                      .tap() ;

        this.navigator.nowPlayingBar()
                      .assertPlaying() ;
    }

    @Test
    public void play_you_may_also_like() {
        this.navigator.streamPage()
                      .youMayAlsoLikeModule()
                      .lineUp()
                      .card( 0 )
                      .playButton()
                      .tap() ;

        this.navigator.nowPlayingBar()
                      .assertPlaying() ;
    }

    @Test
    public void play_song_in_songs() {
        this.navigator.streamPage()
                      .libraryTab()
                      .tap() ;

        this.navigator.libraryPage()
                      .songsCategory()
                      .assertVisible() ;

        this.navigator.libraryPage()
                      .albumsCategory()
                      .assertVisible() ;

        this.navigator.libraryPage()
                      .artistsCategory()
                      .assertVisible() ;

        this.navigator.libraryPage()
                      .videosCategory()
                      .assertVisible() ;

        this.navigator.libraryPage()
                      .favoriteCategory()
                      .assertVisible() ;

        this.navigator.libraryPage()
                      .myPlaylistsCategory()
                      .assertVisible() ;

        this.navigator.libraryPage()
                      .myUtaCategory()
                      .assertVisible() ;

        this.navigator.libraryPage()
                      .songsCategory()
                      .tap() ;

        this.navigator.songsPage()
                      .lineUp()
                      .card( 0 )
                      .tap() ;

        this.navigator.nowPlayingBar()
                      .assertPlaying() ;

        this.navigator.songsPage()
                      .lineUp()
                      .card( 0 )
                      .songName()
                      .assertEquals( this.navigator.nowPlayingBar().songName() ) ;

        this.navigator.songsPage()
                      .lineUp()
                      .card( 0 )
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
