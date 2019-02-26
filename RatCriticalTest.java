package com.kddi.android.UtaPass.sqa_espresso ;

import android.support.test.runner.AndroidJUnit4 ;

import com.kddi.android.UtaPass.sqa_espresso.common.TestRailId;
import com.kddi.android.UtaPass.sqa_espresso.common.UtaPassUtil;

import org.junit.Test ;
import org.junit.runner.RunWith ;

@RunWith(AndroidJUnit4.class)
public class RatCriticalTest extends BasicTest {

    @Test
    @TestRailId( { "C1917148" } )
    public void play_whats_new_songs(){
        this.updateTestCaseInfo() ;

        this.navigator.streamPage()
                      .whatsNewModule()
                      .lineUp()
                      .card( 0 )
                      .playButton()
                      .tap() ;

        this.navigator.songNowPlayingBar()
                      .assertPlaying() ;

        this.navigator.streamPage()
                      .whatsNewModule()
                      .lineUp()
                      .card( 0 )
                      .cover()
                      .tap() ;

        this.navigator.whatsNewDetailPage()
                      .lineUp()
                      .card( 0 )
                      .cover()
                      .assertVisible() ;
    }

    @Test
    @TestRailId( { "C1917170" } )
    public void play_new_songs_hit_songs(){
        this.updateTestCaseInfo() ;

        this.navigator.streamPage()
                      .newSongsHitSongsModule()
                      .lineUp()
                      .card( 0 )
                      .playButton()
                      .tap() ;

        this.navigator.songNowPlayingBar()
                      .assertPlaying() ;

        this.navigator.streamPage()
                      .newSongsHitSongsModule()
                      .lineUp()
                      .card( 0 )
                      .cover()
                      .tap() ;

        this.navigator.newSongsHitSongsDetailPage()
                      .lineUp()
                      .card( 0 )
                      .cover()
                      .assertVisible() ;
    }

    @Test
    @TestRailId( { "C1917179"} )
    public void play_top_chart_songs(){
        this.updateTestCaseInfo() ;

        this.navigator.streamPage()
                      .topChartsModule()
                      .lineUp()
                      .card( 0 )
                      .playButton()
                      .tap() ;

        this.navigator.songNowPlayingBar()
                      .assertPlaying() ;

        this.navigator.streamPage()
                      .topChartsModule()
                      .lineUp()
                      .card( 0 )
                      .cover()
                      .tap() ;

        this.navigator.topChartsDetailPage()
                      .lineUp()
                      .card( 0 )
                      .cover()
                      .assertVisible() ;
    }

    @Test
    @TestRailId( { "C1917183" } )
    public void play_top_chart_songs_in_see_all(){
        this.updateTestCaseInfo() ;

        this.navigator.streamPage()
                      .topChartsModule()
                      .seeAll()
                      .tap() ;

        this.navigator.topChartPage()
                      .topChannelPanel()
                      .lineUp()
                      .card( 0 )
                      .playButton()
                      .tap() ;

        this.navigator.songNowPlayingBar()
                      .assertPlaying() ;

        this.navigator.topChartPage()
                      .topGrossingButton()
                      .tap() ;

        this.navigator.topChartPage()
                      .topGrossingPanel()
                      .lineUp()
                      .card( 1 )
                      .playButton()
                      .tap() ;

        this.navigator.songNowPlayingBar()
                      .assertPlaying() ;
    }

    @Test
    @TestRailId( { "C1917165" } )
    public void play_popular_artist_songs(){
        this.updateTestCaseInfo() ;

        this.navigator.streamPage()
                      .popularArtistModule()
                      .lineUp()
                      .card( 0 )
                      .playButton()
                      .tap() ;

        this.navigator.songNowPlayingBar()
                      .assertPlaying() ;

        this.navigator.streamPage()
                      .popularArtistModule()
                      .lineUp()
                      .card( 0 )
                      .cover()
                      .tap() ;

        this.navigator.popularArtistDetailPage()
                      .lineUp()
                      .card( 0 )
                      .cover()
                      .assertVisible() ;
    }

    @Test
    @TestRailId( { "C1917160" } )
    public void play_artist_new_release(){
        this.updateTestCaseInfo() ;

        this.navigator.streamPage()
                      .artistNewReleaseModule()
                      .lineUp()
                      .card( 0 )
                      .playButton()
                      .tap() ;

        this.navigator.songNowPlayingBar()
                      .assertPlaying() ;

        this.navigator.streamPage()
                      .artistNewReleaseModule()
                      .lineUp()
                      .card( 0 )
                      .cover()
                      .tap() ;

        this.navigator.whatsNewDetailPage()
                      .lineUp()
                      .card( 0 )
                      .cover()
                      .assertVisible() ;
    }

    @Test
    @TestRailId( { "C1917031" } )
    public void play_daily_mix(){
        this.updateTestCaseInfo() ;

        this.navigator.streamPage()
                      .dailyMixModule()
                      .lineUp()
                      .card( 0 )
                      .playButton()
                      .tap() ;
    }

    @Test
    @TestRailId( { "C1917913" } )
    public void play_song_in_library_songs_page(){
        this.updateTestCaseInfo() ;

        this.navigator.libraryTab()
                      .tap() ;

        this.navigator.libraryPage()
                      .songsCategory()
                      .tap() ;

        this.navigator.songsPage()
                      .lineUp()
                      .card( 0 )
                      .cover()
                      .tap() ;

        this.navigator.songNowPlayingBar()
                      .assertPlaying() ;
    }

    @Test
    @TestRailId( { "C1917729" } )
    public void play_video_in_library_videos_page(){
        this.updateTestCaseInfo() ;

        this.navigator.libraryTab()
                      .tap() ;

        this.navigator.libraryPage()
                      .videosCategory()
                      .tap() ;

        this.navigator.videosPage()
                      .playButton()
                      .tap() ;

        this.navigator.songNowPlayingBar()
                      .assertPlaying() ;
    }

    @Test
    @TestRailId( { "C1917735" } )
    public void play_album_song_in_library_album_page(){
        this.updateTestCaseInfo() ;

        this.navigator.libraryTab()
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
                      .tap() ;

        this.navigator.songNowPlayingBar()
                      .assertPlaying() ;
    }

//    @Test
//    @TestRailId( { "C2208774" } )
//    public void play_unregister_song_in_playhistory_songs_panel() {
//
//        this.updateTestCaseInfo() ;
//
//        this.navigator.streamPage()
//                      .popularArtistModule()
//                      .lineUp()
//                      .card( 0 )
//                      .playButton()
//                      .tap() ;
//
//        this.navigator.songNowPlayingBar()
//                      .assertPlaying() ;
//
//        this.navigator.libraryTab()
//                      .tap() ;
//
//        this.navigator.libraryPage()
//                      .playHistorySeeAllButton()
//                      .tap() ;
//
//        this.navigator.playHistoryPage()
//                      .songsPanelButton()
//                      .tap() ;
//
//        // just verify no crash, thus not to verify tap result...
//        this.navigator.playHistoryPage()
//                      .SongsPanel()
//                      .lineUp()
//                      .card( 0 )
//                      .cover()
//                      .tap() ;
//
//        this.sleep( 5, "for stability" ) ;
//    }

    @Test
    @TestRailId( { "C1922260" } )
    public void verify_title_name_in_myplaylist_page(){
        this.updateTestCaseInfo() ;

        this.navigator.libraryTab()
                      .tap() ;

        this.navigator.libraryPage()
                      .myPlaylistsCategory()
                      .tap() ;

        this.navigator.myPlayListPage()
                      .createNowButton()
                      .tap() ;

        this.navigator.createPlayListPage()
                      .createPlaylistTitle()
                      .type( "Hello World" ) ;

        this.navigator.createPlayListPage()
                      .addMusicButton()
                      .tap() ;


        this.navigator.addMusicPage()
                      .songsType()
                      .tap() ;

        this.navigator.myPlayListSongsPage()
                      .lineUp()
                      .card( 0 )
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
                      .card( 0 )
                      .title()
                      .assertEquals( "Hello World" ) ;
    }

    @Test
    @TestRailId( { "C1922170", "C1922171" } )
    public void unfavorite_playlist_does_not_exist_favorite_page(){
        this.updateTestCaseInfo() ;

        String artistTitleName = this.navigator.streamPage()
                      .artistNewReleaseModule()
                      .lineUp()
                      .card( 0 )
                      .title()
                      .string() ;

        this.navigator.streamPage()
                      .artistNewReleaseModule()
                      .lineUp()
                      .card( 0 )
                      .cover()
                      .tap() ;

        this.navigator.artistNewReleaseDetailPage()
                      .favoriteButton()
                      .tap() ;

        this.navigator.libraryTab()
                      .tap() ;

        this.navigator.libraryPage()
                      .favoriteCategory()
                      .tap() ;

        this.navigator.favoritePage()
                      .lineUp()
                      .card( 0 )
                      .title()
                      .assertEquals( artistTitleName ) ;

        this.navigator.favoritePage()
                      .lineUp()
                      .card( 0 )
                      .cover()
                      .tap() ;

        this.navigator.artistNewReleaseDetailPage()
                      .favoriteButton()
                      .tap() ;

        UtaPassUtil.pressBack() ;
        UtaPassUtil.pressBack() ;

        this.navigator.libraryPage()
                      .favoriteCategory()
                      .tap() ;

        this.navigator.favoritePage()
                      .lineUp()
                      .card( 0 )
                      .title()
                      .assertNotEquals( artistTitleName ) ;
    }

    @Test
    @TestRailId( { "C1917242" } )
    public void ensure_play_status_in_stream_now_playing_page(){
        this.updateTestCaseInfo() ;

        this.navigator.streamPage()
                      .popularArtistModule()
                      .lineUp()
                      .card( 0 )
                      .playButton()
                      .tap() ;

        this.navigator.songNowPlayingBar()
                      .assertPlaying() ;

        this.navigator.songNowPlayingBar()
                      .tap() ;

        this.navigator.streamNowPlayingPage()
                      .nextButton()
                      .assertVisible() ;

        this.navigator.streamNowPlayingPage()
                      .pauseButton()
                      .assertVisible() ;

        this.navigator.streamNowPlayingPage()
                      .pauseButton()
                      .tap() ;

        this.navigator.streamNowPlayingPage()
                      .playButton()
                      .assertVisible() ;

        this.navigator.streamNowPlayingPage()
                      .arrowButton()
                      .tap() ;
    }

    @Test
    @TestRailId( { "C1917243" } )
    public void ensure_play_next_song_in_stream_now_playing_page(){
        this.updateTestCaseInfo() ;

        this.navigator.streamPage()
                      .popularArtistModule()
                      .lineUp()
                      .card( 0 )
                      .playButton()
                      .tap() ;

        this.navigator.songNowPlayingBar()
                      .assertPlaying() ;

        this.navigator.songNowPlayingBar()
                      .tap() ;

        String songName = this.navigator.streamNowPlayingPage()
                      .songTitle()
                      .string() ;

        this.navigator.streamNowPlayingPage()
                      .nextButton()
                      .tap() ;

        this.navigator.streamNowPlayingPage()
                      .songTitle()
                      .assertNotEquals( songName ) ;

        this.navigator.streamNowPlayingPage()
                      .arrowButton()
                      .tap() ;
    }

    @Test
    @TestRailId( { "C1917244" } )
    public void ensure_play_status_in_local_now_playing_page(){
        this.updateTestCaseInfo() ;

        this.navigator.libraryTab()
                      .tap() ;

        this.navigator.libraryPage()
                      .songsCategory()
                      .tap() ;

        this.navigator.songsPage()
                      .lineUp()
                      .card( 0 )
                      .cover()
                      .tap() ;

        this.navigator.songNowPlayingBar()
                      .assertPlaying() ;

        this.navigator.songNowPlayingBar()
                      .tap() ;

        this.navigator.localNowPlayingPage()
                      .nextButton()
                      .assertVisible() ;

        this.navigator.localNowPlayingPage()
                      .pauseButton()
                      .assertVisible() ;

        this.navigator.localNowPlayingPage()
                      .pauseButton()
                      .tap() ;

        this.navigator.localNowPlayingPage()
                      .playButton()
                      .assertVisible() ;

        this.navigator.localNowPlayingPage()
                      .arrowButton()
                      .tap() ;
    }

    @Test
    @TestRailId( { "C1917247" } )
    public void ensure_play_next_song_in_local_now_playing_page(){
        this.updateTestCaseInfo() ;

        this.navigator.libraryTab()
                      .tap() ;

        this.navigator.libraryPage()
                      .songsCategory()
                      .tap() ;

        this.navigator.songsPage()
                      .lineUp()
                      .card( 0 )
                      .cover()
                      .tap() ;

        this.navigator.songNowPlayingBar()
                      .assertPlaying() ;

        this.navigator.songNowPlayingBar()
                      .tap() ;

        String localSongName = this.navigator.localNowPlayingPage()
                      .songTitle()
                      .string() ;

        this.navigator.localNowPlayingPage()
                      .nextButton()
                      .tap() ;

        this.navigator.localNowPlayingPage()
                      .songTitle()
                      .assertNotEquals( localSongName ) ;


        this.navigator.localNowPlayingPage()
                      .arrowButton()
                      .tap() ;
    }

    @Test
    @TestRailId( { "C1917677" } )
    public void ensure_daily_ranking_number_of_cards(){
        this.updateTestCaseInfo() ;

        this.navigator.libraryTab()
                      .tap() ;

        this.navigator.libraryPage()
                      .dailyRankingModule()
                      .lineUp()
                      .countSongs()
                      .assertEquals( 10 ) ;
    }

    @Test
    @TestRailId( { "C2207544" } )
    public void ensure_500_account_stream_songs_play_mode(){
        this.updateTestCaseInfo() ;

        this.navigator.streamPage()
                      .dailyMixModule()
                      .lineUp()
                      .card( 0 )
                      .playButton()
                      .tap() ;

        this.navigator.songNowPlayingBar()
                      .tap() ;

        this.navigator.streamNowPlayingPage()
                      .playModeButton()
                      .text()
                      .assertEquals( "RepeatAll" ) ;

        this.navigator.streamNowPlayingPage()
                      .playModeButton()
                      .tap() ;

        this.navigator.streamNowPlayingPage()
                      .playModeButton()
                      .text()
                      .assertEquals( "ShuffleRepeat" ) ;

        this.navigator.streamNowPlayingPage()
                      .arrowButton()
                      .tap() ;
    }

    @Test
    @TestRailId( { "C1917704" } )
    public void albums_songs_add_to_my_playlist(){
        this.updateTestCaseInfo() ;

        this.navigator.libraryTab()
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
                      .card( 1 )
                      .cover()
                      .tap() ;

        this.navigator.myPlayListSongsPage()
                      .nextButton()
                      .tap() ;

        this.navigator.createPlayListPage()
                      .doneButton()
                      .tap() ;

        this.navigator.streamTab()
                      .tap() ;

        this.navigator.libraryTab()
                      .tap() ;


        this.navigator.libraryPage()
                      .albumsCategory()
                      .tap() ;

        this.navigator.albumsPage()
                      .lineUp()
                      .card( 0 )
                      .cover()
                      .tap() ;

        String songname  = this.navigator.albumsDetailPage()
                      .songsLineUp()
                      .song( 0 )
                      .songName()
                      .string() ;

        UtaPassUtil.pressBack() ;

        this.navigator.albumsPage()
                      .lineUp()
                      .card( 0 )
                      .moreButton()
                      .tap() ;

        this.navigator.albumsPage()
                      .addToPlaylistButton()
                      .tap() ;

        this.navigator.addToPlaylistPage()
                      .lineUp()
                      .card( 0 ).cover()
                      .tap() ;

        this.navigator.streamTab()
                      .tap() ;

        this.navigator.libraryTab()
                      .tap() ;


        this.navigator.libraryPage()
                      .myPlaylistsCategory()
                      .tap() ;

        this.navigator.myPlayListPage()
                      .lineUp()
                      .card( 0 )
                      .cover()
                      .tap() ;

        this.navigator.myPlaylistDetailPage()
                      .lineUp()
                      .card( 1 )
                      .songName()
                      .assertEquals( songname ) ;
    }
    @Test
    @TestRailId( { "C2290751" } )
    public void Reminder_about_the_quota(){
        this.updateTestCaseInfo() ;

        this.navigator.libraryTab()
                      .tap();

        this.navigator.libraryPage()
                      .myUtaCategory()
                      .tap();

        this.navigator.myUtaPage()
                      .tooltip()
                      .tap();

        this.navigator.myUtaPage()
                      .myUtaHistoryButton()
                      .tap();

        this.navigator.myUtaPage()
                      .myUtaHistoryPage()
                      .title()
                      .assertVisible();

        this.navigator.myUtaPage()
                      .myUtaHistoryPage()
                      .checkbox()
                      .tap();

        this.navigator.myUtaPage()
                      .myUtaHistoryPage()
                      .closeButton()
                      .tap();

        UtaPassUtil.pressBack();

        this.navigator.myUtaPage()
                      .myUtaHistoryButton()
                      .tap();

        this.navigator.myUtaPage()
                      .myUtaHistoryPage()
                      .title()
                      .assertInvisible();
    }

    @Test
    @TestRailId( { "C2603291" } )
    public void play_radio_songs_from_radio_page(){
        this.updateTestCaseInfo() ;

        this.navigator.streamPage()
                      .radioModule()
                      .lineUp()
                      .lastCard()
                      .cover()
                      .tap() ;

        this.navigator.radioDetailPage()
                      .playButton()
                      .tap();

        this.navigator.radioNowPlayingBar()
                      .assertPlaying();

        this.navigator.radioDetailPage()
                      .playButton()
                      .text()
                      .assertVisible();
    }

    @Test
    @TestRailId( {  "C12323453" } )
    public void live(){
        this.updateTestCaseInfo();

        this.navigator.streamPage()
                      .liveModule()
                      .lineUp()
                      .card( 1 )
                      .playButton()
                      .tap() ;

        this.navigator.liveConcertPage()
                      .icon()
                      .tap() ;

        this.navigator.liveDetailPage()
                      .onAirVideio()
                      .tap() ;

        this.navigator.liveConcertPage()
                      .title()
                      .assertEquals( "KICK OFF VIVA!!! 2017" ) ;

        this.navigator.liveConcertPage()
                      .video()
                      .assertVisible() ;

        this.navigator.liveConcertPage()
                      .icon()
                      .tap() ;
    }
}