package com.kddi.android.UtaPass.sqa_espresso ;

import android.support.test.runner.AndroidJUnit4 ;

import com.kddi.android.UtaPass.sqa_espresso.common.TestRailId;
import com.kddi.android.UtaPass.sqa_espresso.common.UtaPassUtil;

import org.junit.Test ;
import org.junit.runner.RunWith ;

@RunWith(AndroidJUnit4.class)
public class RatCriticalBasicTest extends BasicTest {

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
                .assertLessThan( likecount );

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
                .assertEquals( titlename );
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
                .tap();

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


        this.navigator.addToPlaylistPage().closeButton().tap();

        this.navigator.localNowPlayingPage().arrowButton().tap();
    }

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
    @TestRailId( { "C1922153" } )
    public void Play_search_results_in_playlists(){
        this.updateTestCaseInfo() ;

        this.navigator.searchTab()
                .tap() ;

        this.navigator.searchPage()
                .searchBar()
                .typeReturn( "Coldplay" );

        this.navigator.searchPage()
                .searchStreamPanel()
                .lineUp()
                .card( 2 )
                .songName()
                .tap() ;

        this.navigator.songInfoPage()
                .songInfoPlayButton()
                .tap() ;

        this.navigator.songInfoPage()
                .songInfoPauseButton()
                .assertVisible() ;
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
}
