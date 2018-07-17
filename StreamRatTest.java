package com.kddi.android.UtaPass.sqa_espresso ;

import android.support.test.rule.ActivityTestRule ;
import android.support.test.runner.AndroidJUnit4 ;
import com.kddi.android.UtaPass.main.MainActivity ;
import com.kddi.android.UtaPass.sqa_espresso.common.* ;

import org.junit.After;
import org.junit.Rule ;
import org.junit.Test ;
import org.junit.runner.RunWith ;


@RunWith(AndroidJUnit4.class)
public class StreamRatTest extends BasicTest {

    private Navigator navigator = new Navigator() ;

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void play_spotlight() {
        this.navigator.streamPage()
                      .spotlightLineUp()
                      .getCard( 0 )
                      .background()
                      .tap() ;

        // TODO: check certain page is displayed
        // TODO: play any song
        // TODO: check nowPlayingBar is in playing status
    }

    @Test
    public void play_live_event() {
        this.navigator.streamPage()
                      .liveLineUp()
                      .getCard( 0 )
                      .playButton()
                      .tap() ;

        String liveTitle = this.navigator.liveConcertPage()
                                         .getLiveTitleBar()
                                         .getTitle() ;

        String expecting = "KICK OFF VIVA!!! 2017" ;
        this.assertTrue(
                () -> liveTitle.compareTo( expecting ) == 0,
                String.format( "WrongLiveEventTitle: actual='%s', expecting='%s'",
                               liveTitle,
                               expecting ) ) ;
    }

    @Test
    public void play_artist_new_release() {
        this.navigator.streamPage()
                      .artistNewReleaseLineUp()
                      .getCard( 0 )
                      .playButton()
                      .tap() ;

        this.retry( () -> this.navigator.streamPage().nowPlayingBar().isPlaying() ) ;
    }

    @Test
    public void play_daily_mix() {
        this.navigator.streamPage()
                      .dailyMixLineUp()
                      .getCard()
                      .playButton()
                      .tap() ;

        this.retry( () -> this.navigator.streamPage().nowPlayingBar().isPlaying() ) ;
    }

    @Test
    public void play_top_charts() {
        this.navigator.streamPage()
                      .topChartsLineUp()
                      .getCard( 3 )
                      .playButton()
                      .tap() ;

        this.retry( () -> this.navigator.streamPage().nowPlayingBar().isPlaying() ) ;
    }

    @Test
    public void play_popular_artist() {
        this.navigator.streamPage()
                      .popularArtistLineUp()
                      .getCard( 0 )
                      .playButton()
                      .tap() ;

        // TODO: navigate to next page successfully
    }

    @Test
    public void play_whats_new() {
        this.navigator.streamPage()
                      .whatsNewLineUp()
                      .getCard( 0 )
                      .playButton()
                      .tap() ;

        this.retry( () -> this.navigator.streamPage().nowPlayingBar().isPlaying() ) ;
    }

    @Test
    public void play_new_songs_hit_songs() {
        this.navigator.streamPage()
                      .newSongsHitSongsLineUp()
                      .getCard( 0 )
                      .playButton()
                      .tap() ;

        this.retry( () -> this.navigator.streamPage().nowPlayingBar().isPlaying() ) ;
    }

    @Test
    public void play_you_may_also_like() {
        this.navigator.streamPage()
                      .youMayAlsoLikeLineUp()
                      .getCard( 0 )
                      .playButton()
                      .tap() ;

        this.retry( () -> this.navigator.streamPage().nowPlayingBar().isPlaying() ) ;
    }

    @After
    public void tear_down() {
        UtaPassUtil.stopNowPlayingBar() ;
        UtaPassUtil.closeApp() ;
    }
}
