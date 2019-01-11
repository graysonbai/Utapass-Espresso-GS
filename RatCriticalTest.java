package com.kddi.android.UtaPass.sqa_espresso ;

import android.support.test.runner.AndroidJUnit4 ;

import com.kddi.android.UtaPass.sqa_espresso.common.UtaPassUtil;

import org.junit.Test ;
import org.junit.runner.RunWith ;

@RunWith(AndroidJUnit4.class)
public class RatCriticalTest extends BasicTest {

    @Test
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
                      .tap();

        this.navigator.albumsDetailPage()
                      .songsLineUp()
                      .song( 0 )
                      .cover()
                      .tap() ;

        this.navigator.songNowPlayingBar()
                      .assertPlaying() ;
    }

    @Test
    public void play_unregister_song_in_playhistory_songs_panel() {

        this.updateTestCaseInfo() ;

        this.navigator.streamPage()
                      .popularArtistModule()
                      .lineUp()
                      .card( 0 )
                      .playButton()
                      .tap() ;

        this.navigator.songNowPlayingBar()
                      .assertPlaying() ;

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
                      .cover()
                      .tap() ;
    }

    @Test
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

//    @Test
//    public void demo(){
//        this.navigator.libraryTab().tap();
//        this.navigator.libraryPage().myPlaylistsCategory().tap();
//        this.navigator.myPlayListPage().createNowButton().tap();
//        this.navigator.createPlayListPage().addMusicButton().tap();
//        this.navigator.addMusicPage().songsType().tap();
//        this.navigator.myPlayListSongsPage().lineUp().card( 1 ).cover().tap();
//        this.navigator.myPlayListSongsPage().nextButton().tap();
//        this.navigator.createPlayListPage().doneButton().tap();
//
//        this.navigator.streamTab().tap();
//        this.navigator.libraryTab().tap();
//
//        this.navigator.libraryPage().albumsCategory().tap();
//        this.navigator.albumsPage().lineUp().card( 0 ).cover().tap();
//        String songname  = this.navigator.albumsDetailPage().songsLineUp().song( 0 ).songName().string();
//        UtaPassUtil.pressBack();
//        this.navigator.albumsPage().lineUp().card( 0 ).moreButton().tap();
//        this.navigator.albumsPage().addToPlaylistButton().tap();
//        this.navigator.addToPlaylistPage().lineUp().card( 0 ).cover().tap();
//        this.navigator.streamTab().tap();
//        this.navigator.libraryTab().tap();
//        this.navigator.libraryPage().myPlaylistsCategory().tap();
//        this.navigator.myPlayListPage().lineUp().card( 0 ).cover().tap();
//    }

    @Test
    public void demo1(){
        this.navigator.libraryTab().tap();
        this.navigator.libraryPage().myPlaylistsCategory().tap();
        this.navigator.myPlayListPage().lineUp().card( 0 ).cover().tap();
        this.navigator.myPlaylistDetailPage().lineUp().card( 1 ).songName().text();
    }
}