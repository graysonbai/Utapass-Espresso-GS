package com.kddi.android.UtaPass.sqa_espresso ;

import android.support.test.runner.AndroidJUnit4 ;

import org.junit.Test ;
import org.junit.runner.RunWith ;

@RunWith(AndroidJUnit4.class)
public class RatCriticalTest extends BasicTest {

    @Test
    public void play_() {
        this.updateTestCaseName() ;
    }

    @Test
    public void play_whats_new_songs(){
        this.updateTestCaseName() ;

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
        this.updateTestCaseName() ;

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
        this.updateTestCaseName() ;

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
        this.updateTestCaseName() ;

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
        this.updateTestCaseName() ;

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
        this.updateTestCaseName() ;

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
        this.updateTestCaseName() ;

        this.navigator.streamPage()
                      .dailyMixModule()
                      .lineUp()
                      .card( 0 )
                      .playButton()
                      .tap() ;
    }

    @Test
    public void verify＿settings_page_high_Quality_Button(){
        this.updateTestCaseName() ;

        this.navigator.streamPage()
                      .sideBarButton()
                      .tap() ;

        this.navigator.sideBarMenu()
                      .lineUp()
                      .card( 0 )
                      .title()
                      .tap() ;

        this.navigator.settingsPage()
                      .highQualityButton()
                      .tap() ;

        this.navigator.settingsPage()
                      .OkButton()
                      .tap() ;

        this.navigator.settingsPage()
                      .highQualityButton()
                      .tap() ;
    }

    @Test
    public void play_song_in_library_songs_page(){
        this.updateTestCaseName() ;

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
        this.updateTestCaseName()  ;

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
        this.updateTestCaseName()  ;

        this.navigator.libraryTab()
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
}