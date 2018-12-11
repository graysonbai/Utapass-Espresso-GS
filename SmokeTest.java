package com.kddi.android.UtaPass.sqa_espresso ;

import android.support.test.runner.AndroidJUnit4 ;

import org.junit.Test ;
import org.junit.runner.RunWith ;


@RunWith(AndroidJUnit4.class)
public class SmokeTest extends BasicTest {

    @Test
    public void play_radio() {
        this.updateTestCaseName() ;

        this.navigator.streamPage()
                      .radioModule()
                      .lineUp()
                      .card( 0 )
                      .playButton()
                      .tap() ;

        this.sleep( 10, "to load Radio Station" ) ;

        this.navigator.radioNowPlayingBar()
                      .programName()
                      .assertVisible() ;

        this.navigator.radioNowPlayingBar()
                      .djName()
                      .assertVisible() ;

        this.navigator.radioNowPlayingBar()
                      .assertPlaying() ;
    }

    @Test
    public void play_listen_with() {
        this.updateTestCaseName() ;

        this.navigator.streamPage()
                      .listenWithModule()
                      .lineUp()
                      .card( 0 )
                      .playButton()
                      .tap() ;

        this.navigator.listenWithNowPlayingBar()
                      .assertFollowing() ;

        this.navigator.listenWithNowPlayingBar()
                      .stopFollowingButton()
                      .tap() ;

        this.sleep( 5, "stable reason for closing ListenWithNowPlayingBar" ) ;

        this.navigator.listenWithNowPlayingBar()
                      .assertInvisible() ;
    }

    @Test
    public void play_live_event() {
        this.updateTestCaseName() ;

        String randomToken = String.valueOf( System.currentTimeMillis() ) ;

        this.navigator.streamPage()
                      .liveModule()
                      .lineUp()
                      .card( 0 )
                      .playButton()
                      .tap() ;

        this.navigator.liveConcertPage()
                      .title()
                      .assertEquals( "KICK OFF VIVA!!! 2017" ) ;

        this.navigator.liveConcertPage()
                      .messageTextField()
                      .type( randomToken ) ;

        this.sleep( 3, "stable reason for tapping 'send' button" ) ;

        this.navigator.liveConcertPage()
                      .sendButton()
                      .tap() ;

        this.sleep( 3, "stable reason for uploading message to chatroom" ) ;

        this.navigator.liveConcertPage()
                      .chatroom()
                      .lastMessage()
                      .content()
                      .assertEquals( randomToken ) ;

        this.navigator.liveConcertPage()
                      .video()
                      .tap() ;

        this.navigator.liveConcertPage()
                      .arrowButton()
                      .tap() ;

        this.navigator.streamPage() ;
    }

    @Test
    public void play_artist_new_release() {
        this.updateTestCaseName() ;

        this.navigator.streamPage()
                      .artistNewReleaseModule()
                      .lineUp()
                      .card( 0 )
                      .playButton()
                      .tap() ;

        this.navigator.songNowPlayingBar()
                      .assertPlaying() ;
    }

    @Test
    public void play_daily_mix() {
        this.updateTestCaseName() ;

        this.navigator.streamPage()
                      .dailyMixModule()
                      .lineUp()
                      .card( 0 )
                      .playButton()
                      .tap() ;

        this.navigator.songNowPlayingBar()
                      .assertPlaying() ;

        this.navigator.songNowPlayingBar()
                      .tap();

        this.navigator.nowPlayingPage()
                      .playListDetailButton()
                      .tap();

        this.navigator.dailyMixDetailPage()
                      .lineUp()
                      .card( 0 )
                      .cover()
                      .assertVisible();
    }

    @Test
    public void play_top_charts() {
        this.updateTestCaseName() ;

        this.navigator.streamPage()
                      .topChartsModule()
                      .lineUp()
                      .card( 3 )
                      .playButton()
                      .tap() ;

        this.navigator.songNowPlayingBar()
                      .assertPlaying() ;
    }

    @Test
    public void play_best50() {
        this.updateTestCaseName() ;

        this.navigator.streamPage()
                      .best50Module()
                      .seeAll()
                      .tap() ;

        this.navigator.best50Page()
                      .playButton()
                      .tap() ;

        this.navigator.songNowPlayingBar()
                      .assertPlaying() ;
    }

    @Test
    public void play_popular_artist() {
        this.updateTestCaseName() ;

        this.navigator.streamPage()
                      .popularArtistModule()
                      .lineUp()
                      .card( 0 )
                      .playButton()
                      .tap() ;

        this.navigator.songNowPlayingBar()
                      .assertPlaying() ;
    }

    @Test
    public void play_whats_new() {
        this.updateTestCaseName() ;

        this.navigator.streamPage()
                      .whatsNewModule()
                      .lineUp()
                      .card( 0 )
                      .playButton()
                      .tap() ;

        this.navigator.songNowPlayingBar()
                      .assertPlaying() ;
    }

    @Test
    public void play_new_songs_hit_songs() {
        this.updateTestCaseName() ;

        this.navigator.streamPage()
                      .newSongsHitSongsModule()
                      .lineUp()
                      .card( 0 )
                      .playButton()
                      .tap() ;

        this.navigator.songNowPlayingBar()
                      .assertPlaying() ;

        this.navigator.songNowPlayingBar()
                      .pauseButton()
                      .tap() ;

        this.navigator.streamPage()
                      .liveModule()
                      .lineUp()
                      .card( 0 )
                      .playButton()
                      .tap() ;

        this.navigator.liveConcertPage()
                      .video()
                      .tap() ;

        this.navigator.liveConcertPage()
                      .arrowButton()
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

        this.navigator.songNowPlayingBar()
                      .assertPlaying() ;
    }

    @Test
    public void play_you_may_also_like() {
        this.updateTestCaseName() ;

        this.navigator.streamPage()
                      .youMayAlsoLikeModule()
                      .lineUp()
                      .card( 0 )
                      .playButton()
                      .tap() ;

        this.navigator.songNowPlayingBar()
                      .assertPlaying() ;
    }

    @Test
    public void play_song_in_songs() {
        this.updateTestCaseName() ;

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

        this.navigator.songNowPlayingBar()
                      .assertPlaying() ;

        this.navigator.songsPage()
                      .lineUp()
                      .card( 0 )
                      .songName()
                      .assertEquals( this.navigator.songNowPlayingBar().songName() ) ;

        this.navigator.songsPage()
                      .lineUp()
                      .card( 0 )
                      .artistName()
                      .assertEquals( this.navigator.songNowPlayingBar().artistName() ) ;
    }

    @Test
    public void play_song_in_albums() {
        this.updateTestCaseName() ;

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

        this.navigator.songNowPlayingBar()
                      .assertPlaying() ;
    }

    @Test
    public void play_song_in_artists() {
        this.updateTestCaseName() ;

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

        this.navigator.songNowPlayingBar()
                      .assertPlaying() ;
    }

    @Test
    public void play_videos() {
        this.updateTestCaseName() ;

        this.navigator.streamPage()
                      .libraryTab()
                      .tap() ;

        this.navigator.libraryPage()
                      .videosCategory()
                      .tap() ;

        this.navigator.videosPage()
                      .playButton()
                      .tap() ;
    }

    @Test
    public void play_favorite() {
        this.updateTestCaseName() ;

        this.navigator.streamPage()
                      .libraryTab()
                      .tap() ;

        this.navigator.libraryPage()
                      .favoriteCategory()
                      .tap() ;

        this.navigator.favoritePage()
                      .playlists()
                      .tap() ;

        this.navigator.playlistsPage()
                      .lineUp()
                      .card( 0 )
                      .playButton()
                      .tap() ;

        this.navigator.songNowPlayingBar()
                      .assertPlaying() ;
    }

    @Test
    public void play_myplaylist(){
        this.updateTestCaseName() ;

        this.navigator.streamPage()
                      .libraryTab()
                      .tap() ;

        this.navigator.libraryPage()
                      .myPlaylistsCategory()
                      .tap() ;

        this.navigator.myPlayListPage()
                      .createNowButton()
                      .tap() ;

        this.navigator.createPlayListPage()
                      .addMusicButton()
                      .tap() ;

        this.navigator.addMusicPage()
                      .songsType()
                      .tap() ;

        this.navigator.myPlayListSongsPage()
                      .lineUp()
                      .card(1)
                      .cover()
                      .tap() ;

        this.navigator.myPlayListSongsPage()
                      .nextButton()
                      .tap() ;

        this.navigator.createPlayListPage()
                      .doneButton()
                      .tap() ;

        this.navigator.myPlayListPage()
                      .lineUp()
                      .card(0)
                      .playButton()
                      .tap() ;

        this.navigator.songNowPlayingBar()
                      .assertPlaying() ;
    }
}
