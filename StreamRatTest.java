package com.kddi.android.UtaPass.sqa_espresso ;

import android.support.test.runner.AndroidJUnit4 ;
import com.kddi.android.UtaPass.sqa_espresso.common.* ;

import org.junit.Test ;
import org.junit.runner.RunWith ;


@RunWith(AndroidJUnit4.class)
public class StreamRatTest extends BasicTest {

    @Test
    public void play_spotlight() {
        this.navigator.streamPage()
                      .spotlightLineUp()
                      .card( 1 )
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
                      .radioLineUp()
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
                      .liveLineUp()
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
                      .artistNewReleaseLineUp()
                      .getCard( 0 )
                      .playButton()
                      .tap() ;

        this.navigator.nowPlayingBar()
                      .assertPlaying() ;
    }

    @Test
    public void play_daily_mix() {
        this.navigator.streamPage()
                      .dailyMixLineUp()
                      .getCard()
                      .playButton()
                      .tap() ;

        this.navigator.nowPlayingBar()
                      .assertPlaying() ;
    }

    @Test
    public void play_top_charts() {
        this.navigator.streamPage()
                      .topChartsLineUp()
                      .getCard( 3 )
                      .playButton()
                      .tap() ;

        this.navigator.nowPlayingBar()
                      .assertPlaying() ;
    }

    @Test
    public void play_best50() {
        this.navigator.streamPage()
                      .best50()
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
                      .popularArtistLineUp()
                      .getCard( 0 )
                      .playButton()
                      .tap() ;

        this.navigator.nowPlayingBar()
                      .assertPlaying() ;
    }

    @Test
    public void play_whats_new() {
        this.navigator.streamPage()
                      .whatsNewLineUp()
                      .getCard( 0 )
                      .playButton()
                      .tap() ;

        this.navigator.nowPlayingBar()
                      .assertPlaying() ;
    }

    @Test
    public void play_new_songs_hit_songs() {
        this.navigator.streamPage()
                      .newSongsHitSongsLineUp()
                      .getCard( 0 )
                      .playButton()
                      .tap() ;

        this.navigator.nowPlayingBar()
                      .assertPlaying() ;
    }

    @Test
    public void play_you_may_also_like() {
        this.navigator.streamPage()
                      .youMayAlsoLikeLineUp()
                      .getCard( 0 )
                      .playButton()
                      .tap() ;

        this.navigator.nowPlayingBar()
                      .assertPlaying() ;
    }
}
