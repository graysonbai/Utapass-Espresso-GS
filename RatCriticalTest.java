package com.kddi.android.UtaPass.sqa_espresso ;


import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.kddi.android.UtaPass.sqa_espresso.common.TestRailId;
import com.kddi.android.UtaPass.sqa_espresso.common.UtaPassUtil;

import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class RatCriticalTest extends BasicTest {
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
    @TestRailId( { "C1917031" } )
    public void play_daily_mix(){
        this.updateTestCaseInfo() ;

        this.navigator.streamPage()
                .dailyMixModule()
                .lineUp()
                .card( 0 )
                .playButton()
                .tap() ;

        this.navigator.songNowPlayingBar()
                      .assertPlaying();
    }

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
    @TestRailId( { "C1922260", "C1922176" } )
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

        this.navigator.myPlayListPage()
                      .lineUp()
                      .card( 0 )
                      .playButton()
                      .tap() ;

        this.navigator.songNowPlayingBar()
                      .assertPlaying() ;
    }

    @Test
    @TestRailId( { "C1922170", "C1922171", "C3080414", "C1917982", "C1917977" } )
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
    @TestRailId( { "C2290751", "C1922750" } )
    public void Reminder_about_the_quota(){
        this.updateTestCaseInfo() ;

        this.navigator.libraryTab()
                      .tap() ;

        this.navigator.libraryPage()
                      .myUtaCategory()
                      .tap() ;

        if ( this.navigator.myUtaPage().tooltip().isVisible() ){
            this.navigator.myUtaPage()
                    .tooltip()
                    .tap() ;
        }

        this.navigator.myUtaPage()
                      .myUtaHistoryButton()
                      .tap() ;

        this.navigator.myUtaPage()
                      .myUtaHistoryPage()
                      .title()
                      .assertVisible() ;

        this.navigator.myUtaPage()
                      .myUtaHistoryPage()
                      .checkbox()
                      .tap() ;

        this.navigator.myUtaPage()
                      .myUtaHistoryPage()
                      .closeButton()
                      .tap() ;

        this.navigator.myUtaPage()
                      .myUtaHistoryPage()
                      .toolBar()
                      .tap() ;

        this.navigator.myUtaPage()
                      .myUtaHistoryPage()
                      .allMyUtaButton()
                      .text()
                      .assertVisible() ;

        this.navigator.myUtaPage()
                      .myUtaHistoryPage()
                      .notDownLoadedButton()
                      .text()
                      .assertVisible() ;

        this.navigator.myUtaPage()
                      .myUtaHistoryPage()
                      .forQuotaRefundButton()
                      .text()
                      .assertVisible() ;

        UtaPassUtil.pressBack() ;
        UtaPassUtil.pressBack() ;

        this.navigator.myUtaPage()
                      .myUtaHistoryButton()
                      .tap() ;

        this.navigator.myUtaPage()
                      .myUtaHistoryPage()
                      .title()
                      .assertInvisible() ;
    }

//    @Test
//    @TestRailId( { "C2603291" } )
//    public void play_radio_songs_from_radio_page(){
//        this.updateTestCaseInfo() ;
//
//        this.navigator.streamPage()
//                      .radioModule()
//                      .lineUp()
//                      .card( 6 )
//                      .cover()
//                      .tap() ;
//
//        this.navigator.radioDetailPage()
//                      .playButton()
//                      .tap() ;
//
//
//        this.navigator.radioNowPlayingBar()
//                      .assertPlaying() ;
//
//
//        this.navigator.radioDetailPage()
//                      .playButton()
//                      .text()
//                      .assertVisible() ;
//
//    }

    @Test
    @TestRailId( {  "C1917511" } )
    public void play_live_video_in_detail_page(){
        this.updateTestCaseInfo() ;


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

    @Test
    @TestRailId( { "C1922033" } )
    public void search_result_recommend_string(){
        this.updateTestCaseInfo() ;

        this.navigator.searchTab()
                      .tap() ;

        this.navigator.searchPage()
                      .searchBar()
                      .type("P" ) ;

        UtaPassUtil.closesoftboard() ;

        for ( int count = 0; count < 10; count++ ){
            this.navigator.searchPage()
                          .lineUp()
                          .searchResult( count )
                          .recommendString()
                          .assertStringTitle( "(^P|p).*" ) ;
        }
    }

    @Test
    @TestRailId( { "C1917372" } )
    public void local_songs_open_add_to_playlist_page(){
        this.updateTestCaseInfo() ;

        this.navigator.streamTab()
                .tap() ;

        this.navigator.libraryTab()
                .tap() ;

        this.navigator.libraryPage()
                .myPlaylistsCategory()
                .tap() ;

        while ( this.navigator.myPlayListPage().lineUp().card( 0 ).title().isVisible() ){
            this.navigator.myPlayListPage()
                          .lineUp()
                          .card( 0 ).cover()
                          .tap() ;

            this.navigator.myPlaylistDetailPage()
                          .moreButton()
                          .tap() ;

            this.navigator.moreMenuPage()
                          .moreDeletePlaylistButton()
                          .tap() ;

            this.navigator.moreMenuPage()
                          .deleteButton()
                          .tap() ;
        }

        this.navigator.streamTab()
                      .tap() ;

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
                      .cover()
                      .tap() ;

        this.navigator.localNowPlayingPage()
                      .addMyplaylistButton()
                      .tap() ;

        this.navigator.createPlayListPage()
                      .doneButton()
                      .assertVisible() ;

        this.navigator.createPlayListPage()
                      .closeButton()
                      .tap() ;

        this.navigator.localNowPlayingPage()
                      .arrowButton()
                      .tap() ;

        this.navigator.streamTab()
                      .tap() ;

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

        this.navigator.songNowPlayingBar()
                      .cover()
                      .tap() ;

        this.navigator.localNowPlayingPage()
                      .addMyplaylistButton()
                      .tap() ;

        this.navigator.addToPlaylistPage()
                      .createNowButton()
                      .assertVisible() ;


        this.navigator.addToPlaylistPage().closeButton().tap() ;

        this.navigator.localNowPlayingPage().arrowButton().tap() ;
    }

//    @Test
////    @TestRailId( { "C2603367" } )
////    public void Play_history_1st_view_Radio_Playlist(){
////        this.updateTestCaseInfo() ;
////
////        this.navigator.streamPage()
////                      .radioModule()
////                      .lineUp()
////                      .card( 6 )
////                      .playButton()
////                      .tap() ;
////
////        this.navigator.radioNowPlayingBar()
////                      .tap() ;
////
////        this.navigator.radioNowPlayingPage()
////                      .onAirSonglistButton()
////                      .tap() ;
////
////        this.navigator.onAriSonglistPage()
////                      .onAriSonglistPlaylistButton()
////                      .tap() ;
////
////        String songname = this.navigator.artistNewReleaseDetailPage()
////                      .title()
////                      .string() ;
////
////        this.navigator.artistNewReleaseDetailPage()
////                      .shuffleAllButton()
////                      .tap() ;
////
////        this.navigator.songNowPlayingBar()
////                      .assertPlaying() ;
////
////        this.navigator.libraryTab()
////                      .tap() ;
////
////        this.navigator.libraryPage()
////                      .playHistorySeeAllButton()
////                      .tap() ;
////
////        this.navigator.playHistoryPage()
////                      .playlistsPanel()
////                      .lineUp()
////                      .card( 0 )
////                      .title()
////                      .assertEquals( songname ) ;
////
////        this.navigator.streamTab()
////                      .tap() ;
////
////        this.navigator.streamPage()
////                      .liveModule()
////                      .lineUp()
////                      .card( 1 )
////                      .playButton()
////                      .tap() ;
////
////        this.navigator.liveConcertPage()
////                      .video()
////                      .tap() ;
////
////        this.navigator.liveConcertPage()
////                      .arrowButton()
////                      .tap() ;
////
////        this.navigator.libraryTab()
////                      .tap() ;
////
////        this.navigator.libraryPage()
////                      .playHistorySeeAllButton()
////                      .tap() ;
////
////        this.navigator.playHistoryPage()
////                      .playlistsPanel()
////                      .lineUp()
////                      .card( 0 )
////                      .playButton()
////                      .tap() ;
////
////        this.navigator.songNowPlayingBar()
////                      .tap() ;
////
////        this.navigator.streamNowPlayingPage()
////                      .playModeButton()
////                      .text()
////                      .assertEquals( "RepeatAll" ) ;
////
////        this.navigator.streamNowPlayingPage()
////                      .arrowButton()
////                      .tap() ;
////    }

    @Test
    @TestRailId( { "C1917983" } )
    public void ensure_favorite_playlists_likedCount_and_Liked_Time(){
        this.updateTestCaseInfo() ;

        this.navigator.libraryTab()
                      .tap() ;

        this.navigator.libraryPage()
                      .favoriteCategory()
                      .tap() ;

        this.navigator.favoritePage()
                      .playlistsButton()
                      .tap() ;

        this.navigator.favoritePage()
                      .sortButton()
                      .tap() ;

        this.navigator.favoritePage()
                      .likedCountButton()
                      .tap() ;

        String likecount = this.navigator.favoritePage()
                      .lineUp()
                      .card( 0 )
                      .likeCount()
                      .string() ;

        this.navigator.favoritePage()
                      .lineUp()
                      .card( 1 )
                      .likeCount()
                      .assertLessThan( likecount ) ;

        this.navigator.favoritePage()
                      .lineUp()
                      .card( 2 )
                      .cover()
                      .tap() ;

        String titlename = this.navigator.artistNewReleaseDetailPage()
                      .title()
                      .string() ;

        this.navigator.artistNewReleaseDetailPage()
                      .favoriteButton()
                      .tap() ;

        this.navigator.artistNewReleaseDetailPage()
                      .favoriteButton()
                      .tap() ;

        UtaPassUtil.pressBack() ;

        this.navigator.favoritePage()
                      .sortButton()
                      .tap() ;

        this.navigator.favoritePage()
                      .likedTimeButton()
                      .tap() ;

        this.navigator.favoritePage()
                      .lineUp()
                      .card( 0 )
                      .title()
                      .assertEquals( titlename ) ;
    }

    @Test
    @TestRailId( { "C1922153", "C1922067" } )
    public void Play_search_results_in_playlists(){
        this.updateTestCaseInfo() ;

        this.navigator.searchTab()
                .tap() ;

        this.navigator.searchPage()
                .searchBar()
                .typeReturn( "Coldplay" );

        this.navigator.searchPage()
                .streamPanelButton()
                .text()
                .assertEquals( "Stream" );

        this.navigator.searchPage()
                .localMusicPanelButton()
                .text()
                .assertEquals( "Local Music" );

        this.navigator.searchPage()
                .searchStreamPanel()
                .lineUp()
                .card( 2 )
                .songName()
                .tap() ;

        this.navigator.searchArtistPage()
                .songPanelButton()
                .tap();

        this.navigator.searchArtistPage()
                .songPanel()
                .lineUp()
                .card( 2 )
                .songName()
                .tap();

        this.navigator.songInfoPage()
                .songInfoPlayButton()
                .tap() ;

        this.navigator.songInfoPage()
                .songInfoPauseButton()
                .assertVisible() ;
    }

    @Test
    @TestRailId( { "C2398863", "C1934617", "C2398886", "C2208786" } )
    public void delete_And_Play_MyUta_Song(){
        this.updateTestCaseInfo() ;

        this.navigator.streamPage()
                      .artistNewReleaseModule()
                      .lineUp()
                      .card( 0 )
                      .cover()
                      .tap() ;

        this.navigator.artistNewReleaseDetailPage()
                      .lineUp()
                      .card( 0 )
                      .myUtaButton()
                      .tap() ;

        this.navigator.saveMyUtaPopupMessage()
                      .saveButton()
                      .tap() ;

        if( this.navigator.saveMyUtaConfirmPopupMessage().messageTitle().isVisible() ){
            this.navigator.saveMyUtaConfirmPopupMessage()
                    .closeButton()
                    .tap() ;
        }

        this.navigator.artistNewReleaseDetailPage()
                      .lineUp()
                      .card( 1 )
                      .myUtaButton()
                      .tap() ;

        this.navigator.saveMyUtaPopupMessage()
                      .saveButton()
                      .tap() ;

        this.navigator.libraryTab()
                      .tap() ;

        this.navigator.libraryPage()
                      .myUtaCategory()
                      .tap() ;

        if ( this.navigator.myUtaPage().tooltip().isVisible() ){
            this.navigator.myUtaPage()
                    .tooltip()
                    .tap() ;
        }

        this.navigator.myUtaPage()
                      .lineUp()
                      .card( 0 )
                      .tap() ;

        this.navigator.songNowPlayingBar()
                      .assertPlaying() ;

        this.navigator.myUtaPage()
                      .playButton()
                      .tap() ;

        this.navigator.songNowPlayingBar()
                      .assertPlaying() ;

        this.navigator.myUtaPage()
                      .lineUp()
                      .card( 1 )
                      .songName()
                      .tap() ;

        this.navigator.songNowPlayingBar()
                      .assertPlaying() ;

        this.navigator.myUtaPage()
                      .lineUp()
                      .card( 0 )
                      .moreActionsButton()
                      .tap() ;

        this.navigator.songMoreActionMenu()
                      .SongInfoMenuItem()
                      .tap() ;

        this.navigator.songInfoPage()
                      .songInfoPlayButton()
                      .tap() ;

        this.navigator.songNowPlayingBar()
                      .assertPlaying() ;

        this.navigator.streamTab()
                      .tap() ;

        this.navigator.songNowPlayingBar()
                      .assertPlaying() ;
    }

    @Test
    @TestRailId({ "C2207538" })
    public void Premium_NowPlaying_Register_Song(){
        this.updateTestCaseInfo() ;

        this.navigator.streamPage()
                      .whatsNewModule()
                      .lineUp()
                      .card( 0 )
                      .playButton()
                      .tap() ;

        this.navigator.songNowPlayingBar()
                      .assertPlaying() ;

        this.navigator.songNowPlayingBar()
                      .cover()
                      .tap() ;

        this.navigator.streamNowPlayingPage()
                      .myUtaButton()
                      .tap() ;

        this.navigator.saveMyUtaPopupMessage()
                      .cancelButton()
                      .tap() ;

        this.navigator.streamNowPlayingPage()
                      .myUtaButton()
                      .assertVisible() ;

        this.navigator.streamNowPlayingPage()
                      .myUtaButton()
                      .tap() ;

        this.navigator.saveMyUtaPopupMessage()
                      .saveButton()
                      .tap() ;

        if( this.navigator.saveMyUtaConfirmPopupMessage().messageTitle().isReady() ){
            this.navigator.saveMyUtaConfirmPopupMessage()
                          .closeButton()
                          .tap() ;
        }

        this.navigator.streamNowPlayingPage()
                      .saveMyUtaImage()
                      .assertVisible() ;

        String songname = this.navigator.streamNowPlayingPage()
                      .songTitle()
                      .string() ;

        this.navigator.streamNowPlayingPage()
                      .arrowButton()
                      .tap() ;

        this.navigator.libraryTab()
                      .tap() ;

        this.navigator.libraryPage()
                      .myUtaCategory()
                      .tap() ;

        this.navigator.myUtaPage()
                      .lineUp()
                      .card( 0 )
                      .songName()
                      .text()
                      .assertEquals( songname ) ;
    }

    @Test
    @TestRailId( { "C2867768" } )
    public void play_MyUta_Song_in_Best50_Module(){
        this.updateTestCaseInfo() ;

        this.navigator.streamPage()
                      .best50Module()
                      .lineUp()
                      .card( 1 )
                      .myUtaButton()
                      .tap() ;

        this.navigator.saveMyUtaPopupMessage()
                      .saveButton()
                      .tap() ;

        if( this.navigator.saveMyUtaConfirmPopupMessage().messageTitle().isVisible() ){
            this.navigator.saveMyUtaConfirmPopupMessage()
                          .closeButton()
                          .tap() ;
        }

        this.navigator.streamPage()
                      .best50Module()
                      .lineUp()
                      .card( 1 )
                      .playButton()
                      .tap() ;

        this.navigator.streamPage()
                      .best50Module()
                      .lineUp()
                      .card( 1 )
                      .playButton()
                      .assertVisible() ;

        String songname = this.navigator.streamPage()
                      .best50Module()
                      .lineUp()
                      .card( 1 )
                      .songName()
                      .string() ;

        this.navigator.libraryTab()
                      .tap() ;

        this.navigator.libraryPage()
                      .myUtaCategory()
                      .tap() ;

        if ( this.navigator.myUtaPage().tooltip().isVisible() ){
            this.navigator.myUtaPage()
                          .tooltip()
                          .tap() ;
        }

        this.navigator.myUtaPage()
                      .lineUp()
                      .card( 0 )
                      .songName()
                      .text()
                      .assertEquals( songname ) ;
    }

    @Test
    @TestRailId( { "C1917296", "C1917981" } )
    public void favorite_stream_song_check_favorite_playlists_page(){
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
                      .cover()
                      .tap() ;

        this.navigator.streamNowPlayingPage()
                      .favoriteButton()
                      .tap() ;

        this.navigator.streamNowPlayingPage()
                      .savefavoriteImage()
                      .assertVisible() ;

        String titlename = this.navigator.streamNowPlayingPage()
                      .songTitle()
                      .string() ;

        this.navigator.streamNowPlayingPage()
                      .arrowButton()
                      .tap() ;

        this.navigator.libraryTab()
                      .tap() ;

        this.navigator.libraryPage()
                      .favoriteCategory()
                      .tap() ;

        this.navigator.favoritePage()
                      .streamMusicButton()
                      .tap() ;

        this.navigator.favoritePage()
                      .streamMusicPanel()
                      .lineUp()
                      .card( 0 )
                      .title()
                      .assertEquals( titlename ) ;

        this.navigator.songNowPlayingBar()
                      .cover()
                      .tap() ;

        this.navigator.streamNowPlayingPage()
                      .favoriteButton()
                      .tap() ;

        this.navigator.streamNowPlayingPage()
                      .arrowButton()
                      .tap() ;

        if( this.navigator.favoritePage().streamMusicPanel().lineUp().card( 0 ).cover().isVisible() ){
            this.navigator.favoritePage()
                          .streamMusicPanel()
                          .lineUp()
                          .card( 0 )
                          .title()
                          .assertNotEquals( titlename ) ;

        } else {
            this.navigator.streamTab()
                          .tap() ;

            this.navigator.libraryTab()
                          .tap() ;

            this.navigator.libraryPage()
                          .favoriteCategory()
                          .tap() ;

            this.navigator.favoritePage()
                          .streamMusicButton()
                          .tap() ;

            this.navigator.emptyFavoritePage()
                          .title()
                          .assertVisible() ;
        }
    }

    @Test
    @TestRailId( { "C1922193" } )
    public void play_stream_song_in_favorite_playlists(){
        this.updateTestCaseInfo() ;

        this.navigator.streamPage()
                      .newSongsHitSongsModule()
                      .lineUp()
                      .card( 0 )
                      .cover()
                      .tap() ;

        this.navigator.newSongsHitSongsDetailPage()
                      .favoriteButton()
                      .tap() ;

        String titlename = this.navigator.newSongsHitSongsDetailPage()
                      .title()
                      .string() ;

        this.navigator.libraryTab()
                      .tap() ;

        this.navigator.libraryPage()
                      .favoriteCategory()
                      .tap() ;

        this.navigator.favoritePage()
                      .lineUp()
                      .card( 0 )
                      .title()
                      .assertEquals( titlename ) ;

        this.navigator.favoritePage()
                      .lineUp()
                      .card( 0 )
                      .playButton()
                      .tap() ;

        this.navigator.songNowPlayingBar()
                      .assertPlaying() ;

        this.navigator.favoritePage()
                      .lineUp()
                      .card( 0 )
                      .cover()
                      .tap() ;

        this.navigator.newSongsHitSongsDetailPage()
                      .favoriteButton()
                      .tap() ;
    }

    @Test
    @TestRailId( { "C3224847" } )
    public void best_Fifty_Order() {
        this.updateTestCaseInfo() ;

        this.navigator.streamPage()
                      .best50Module()
                      .lineUp()
                      .countSongs()
                      .assertEquals( 15 ) ;

        this.navigator.streamPage()
                      .best50Module()
                      .seeAll()
                      .tap() ;

        this.navigator.best50Page()
                      .showMoreButton()
                      .tap() ;

        this.navigator.best50Page()
                      .lineUp()
                      .countSongs()
                      .assertEquals( 50 ) ;
    }

    @Test
    @TestRailId( { "C2208781" } )
    public void myuta_song_in_playhistory_songs_page() {
        this.updateTestCaseInfo() ;

        this.navigator.streamPage()
                      .dailyMixModule()
                      .lineUp()
                      .card( 0 )
                      .playButton()
                      .tap() ;

        this.navigator.libraryTab()
                      .tap() ;

        this.navigator.libraryPage()
                      .playHistorySeeAllButton()
                      .tap() ;

        this.navigator.playHistoryPage()
                      .songsPanelButton()
                      .tap() ;

        this.navigator.playHistoryPage()
                      .SongsPanel()
                      .lineUp()
                      .card( 0 )
                      .myUtaButton()
                      .tap() ;

        this.navigator.saveMyUtaPopupMessage()
                      .saveButton()
                      .tap() ;

        if( this.navigator.saveMyUtaConfirmPopupMessage().messageTitle().isVisible() ){
            this.navigator.saveMyUtaConfirmPopupMessage()
                          .closeButton()
                          .tap() ;
        }

        this.navigator.playHistoryPage()
                      .SongsPanel()
                      .lineUp()
                      .card( 0 )
                      .playButton()
                      .assertVisible() ;

        this.navigator.playHistoryPage()
                      .SongsPanel()
                      .lineUp()
                      .card( 0 )
                      .playButton()
                      .tap() ;

        String songname = this.navigator.playHistoryPage()
                      .SongsPanel()
                      .lineUp()
                      .card( 0 )
                      .title()
                      .string() ;

        this.navigator.songNowPlayingBar()
                      .songName()
                      .assertEquals( songname ) ;
    }

    @Test
    @TestRailId({ "C2208814" })
    public void delete_artist_page_myuta_song(){
        this.updateTestCaseInfo() ;

        this.navigator.streamPage()
                      .popularArtistModule()
                      .lineUp()
                      .card( 0 )
                      .cover()
                      .tap() ;

        String songname = this.navigator.popularArtistDetailPage()
                      .lineUp()
                      .card( 0 )
                      .songName()
                      .string() ;

        this.navigator.popularArtistDetailPage()
                      .lineUp()
                      .card( 0 )
                      .myUtaButton()
                      .tap() ;

        this.navigator.saveMyUtaPopupMessage()
                      .saveButton()
                      .tap() ;

        if(this.navigator.saveMyUtaConfirmPopupMessage().closeButton().isVisible() ){
            this.navigator.saveMyUtaConfirmPopupMessage()
                          .closeButton()
                          .tap() ;
        }

        this.navigator.libraryTab()
                      .tap() ;

        this.navigator.libraryPage()
                      .artistsCategory()
                      .tap() ;

        this.navigator.artistsPage()
                      .sortButton()
                      .tap() ;

        this.navigator.artistSortPanel()
                      .recentlyAddedButton()
                      .tap() ;

        String artistname = this.navigator.artistsPage()
                      .lineUp()
                      .card( 0 )
                      .artistName()
                      .string() ;

        this.navigator.artistsPage()
                      .lineUp()
                      .card( 0 )
                      .cover()
                      .tap() ;

        this.navigator.albumsDetailPage()
                      .songsLineUp()
                      .song( 0 )
                      .songName()
                      .assertEquals( songname ) ;

        this.navigator.albumsDetailPage()
                      .songsLineUp()
                      .song( 0 )
                      .moreButton()
                      .tap() ;

        this.navigator.albumDetailMorePanel()
                      .deleteSongButton()
                      .tap() ;

        this.navigator.deleteSongConfirmMessage()
                      .deleteButton()
                      .tap() ;

        this.navigator.artistsPage()
                      .lineUp()
                      .card( 0 )
                      .artistName()
                      .assertNotEquals( artistname ) ;
    }

    @Test
    @TestRailId({ "C2208800" })
    public void delete_album_page_myuta_song(){
        this.updateTestCaseInfo() ;

        this.navigator.streamPage()
                      .topChartsModule()
                      .lineUp()
                      .card( 0 )
                      .cover()
                      .tap() ;

        String songname = this.navigator.popularArtistDetailPage()
                      .lineUp()
                      .card( 0 )
                      .songName()
                      .string() ;

        this.navigator.popularArtistDetailPage()
                      .lineUp()
                      .card( 0 )
                      .myUtaButton()
                      .tap() ;

        this.navigator.saveMyUtaPopupMessage()
                      .saveButton()
                      .tap() ;

        if(this.navigator.saveMyUtaConfirmPopupMessage().closeButton().isVisible() ){
            this.navigator.saveMyUtaConfirmPopupMessage()
                          .closeButton()
                          .tap() ;
        }

        this.navigator.libraryTab()
                      .tap() ;

        this.navigator.libraryPage()
                      .albumsCategory()
                      .tap() ;

        this.navigator.albumsPage()
                      .sortButton()
                      .tap() ;

        this.navigator.albumSortPanel()
                      .recentlyAddedButton()
                      .tap() ;

        String artistname = this.navigator.albumsPage()
                      .lineUp()
                      .card( 0 )
                      .artistName()
                      .string() ;

        this.navigator.albumsPage()
                      .lineUp()
                      .card( 0 )
                      .cover()
                      .tap() ;

        this.navigator.albumsDetailPage()
                      .songsLineUp()
                      .song( 0 )
                      .songName()
                      .assertEquals( songname ) ;

        this.navigator.albumsDetailPage()
                      .songsLineUp()
                      .song( 0 )
                      .moreButton()
                      .tap() ;

        this.navigator.albumDetailMorePanel()
                      .deleteSongButton()
                      .tap() ;

        this.navigator.deleteSongConfirmMessage()
                      .deleteButton()
                      .tap() ;

        this.navigator.albumsPage()
                      .lineUp()
                      .card( 0 )
                      .artistName()
                      .assertNotEquals( artistname ) ;
    }
}