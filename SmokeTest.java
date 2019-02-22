package com.kddi.android.UtaPass.sqa_espresso ;

import android.support.test.runner.AndroidJUnit4 ;

import com.kddi.android.UtaPass.sqa_espresso.common.TestRailId;

import org.junit.Test ;
import org.junit.runner.RunWith ;

@RunWith(AndroidJUnit4.class)
public class SmokeTest extends BasicTest {

    @Test
    @TestRailId( { "C2603307" } )
    public void play_radio() {
        this.updateTestCaseInfo() ;

        this.navigator.streamPage()
                      .radioModule()
                      .lineUp()
                      .lastCard()
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
    @TestRailId( { "C1917543", "C1917560", "C1917613" } )
    public void play_live_event() {
        this.updateTestCaseInfo() ;

        String randomToken = String.valueOf( System.currentTimeMillis() ) ;

        this.navigator.streamPage()
                      .liveModule()
                      .lineUp()
                      .card( 1 )
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
    @TestRailId( { "C1917160" } )
    public void play_artist_new_release() {
        this.updateTestCaseInfo() ;

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
    @TestRailId( { "C1917031" } )
    public void play_daily_mix() {
        this.updateTestCaseInfo() ;

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

        this.navigator.streamNowPlayingPage()
                      .playListDetailButton()
                      .tap();

        this.navigator.dailyMixDetailPage()
                      .lineUp()
                      .card( 0 )
                      .cover()
                      .assertVisible();
    }

    @Test
    @TestRailId( { "C1917179" } )
    public void play_top_charts() {
        this.updateTestCaseInfo() ;

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
    @TestRailId( { "C2571416" } )
    public void play_best50() {
        this.updateTestCaseInfo() ;

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
    @TestRailId( { "C1917165" } )
    public void play_popular_artist() {
        this.updateTestCaseInfo() ;

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
    @TestRailId( { "C1917148" } )
    public void play_whats_new() {
        this.updateTestCaseInfo() ;

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
        this.updateTestCaseInfo() ;

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
                      .card( 1 )
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
        this.updateTestCaseInfo() ;

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
        this.updateTestCaseInfo() ;

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
        this.updateTestCaseInfo() ;

        this.navigator.streamPage()
                      .libraryTab()
                      .tap() ;

        this.navigator.libraryPage()
                      .albumsCategory()
                      .tap() ;

        this.navigator.albumsPage()
                      .lineUp()
                      .card( 0 )
                      .cover()
                      .tap() ;

        this.navigator.albumsDetailPage()
                      .songsLineUp()
                      .song( 0 )
                      .cover()
                      .tap();

        this.navigator.songNowPlayingBar()
                      .assertPlaying() ;
    }

    @Test
    public void play_song_in_artists() {
        this.updateTestCaseInfo() ;

        this.navigator.streamPage()
                      .libraryTab()
                      .tap() ;

        this.navigator.libraryPage()
                      .artistsCategory()
                      .tap() ;

        int albums =  Integer.parseInt( this.navigator.artistsPage()
                                                      .lineUp()
                                                      .card( 0 )
                                                      .albumsCount()
                                                      .string() );
        this.navigator.artistsPage()
                      .lineUp()
                      .card( 0 )
                      .cover()
                      .tap();

        // ArtistAlbumsPage
        if( albums > 1 ) {
            this.navigator.artistAlbumsPage()
                          .lineUp()
                          .card( 0 )
                          .cover()
                          .tap() ;

        }

        // AlbumInfoPage
        this.navigator.albumsDetailPage()
                      .shuffleAllButton()
                      .tap() ;

        this.navigator.songNowPlayingBar()
                      .assertPlaying() ;
    }

    @Test
    public void play_videos() {
        this.updateTestCaseInfo() ;

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
        this.updateTestCaseInfo() ;

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
        this.updateTestCaseInfo() ;

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
