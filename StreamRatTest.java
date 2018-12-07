package com.kddi.android.UtaPass.sqa_espresso ;

import android.support.test.runner.AndroidJUnit4 ;

import org.junit.Test ;
import org.junit.runner.RunWith ;


@RunWith(AndroidJUnit4.class)
public class StreamRatTest extends BasicTest {

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

        this.navigator.songNowPlayingBar()
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

        this.navigator.songNowPlayingBar()
                      .songName()
                      .assertVisible() ;

        this.navigator.songNowPlayingBar()
                      .artistName()
                      .assertVisible() ;

        this.navigator.songNowPlayingBar()
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

        this.navigator.songNowPlayingBar()
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

        this.navigator.songNowPlayingBar()
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

        this.navigator.songNowPlayingBar()
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

        this.navigator.songNowPlayingBar()
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

        this.navigator.songNowPlayingBar()
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

        this.navigator.songNowPlayingBar()
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

        this.navigator.songNowPlayingBar()
                      .assertPlaying() ;

        this.navigator.songNowPlayingBar()
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

        this.navigator.songNowPlayingBar()
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

        this.navigator.songNowPlayingBar()
                      .assertPlaying() ;
    }
}
