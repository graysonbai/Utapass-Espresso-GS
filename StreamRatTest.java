package com.kddi.android.UtaPass.sqa_espresso ;

import android.support.test.runner.AndroidJUnit4 ;
import com.kddi.android.UtaPass.sqa_espresso.common.* ;

import org.junit.After;
import org.junit.Test ;
import org.junit.runner.RunWith ;

// temp
import com.kddi.android.UtaPass.R ;
import static android.support.test.espresso.Espresso.onView ;
import static android.support.test.espresso.matcher.ViewMatchers.withId ;
import static android.support.test.espresso.matcher.ViewMatchers.withText ;

import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.contrib.RecyclerViewActions.scrollToPosition ;
import static org.hamcrest.Matchers.* ;


@RunWith(AndroidJUnit4.class)
public class StreamRatTest extends BasicTest {

    private Navigator navigator = new Navigator() ;

    @Test
    public void play_spotlight() {
        this.navigator.streamPage()
                      .spotlightLineUp()
                      .getCard( 1 )
                      .tap() ;

        this.navigator.spotlightPage()
//                      .songsLineUp()
//                      .song( 3 )
//                      .tap() ;
                      .playButton()
                      .tap() ;

        this.retry( () -> this.navigator.nowPlayingBar().isPlaying() ) ;
    }

    @Test
    public void play_live_event() {
        this.navigator.streamPage()
                      .liveLineUp()
                      .getCard( 0 )
                      .playButton()
                      .tap() ;

        this.assertEqual(
            this.navigator.liveConcertPage().getLiveTitleBar().getTitle(),
            "KICK OFF VIVA!!! 2017"
        ) ;
    }

    @Test
    public void play_artist_new_release() {
        this.navigator.streamPage()
                      .artistNewReleaseLineUp()
                      .getCard( 0 )
                      .playButton()
                      .tap() ;

        this.retry( () -> this.navigator.nowPlayingBar().isPlaying() ) ;
    }

    @Test
    public void play_daily_mix() {
        this.navigator.streamPage()
                      .dailyMixLineUp()
                      .getCard()
                      .playButton()
                      .tap() ;

        this.retry( () -> this.navigator.nowPlayingBar().isPlaying() ) ;
    }

    @Test
    public void play_top_charts() {
        this.navigator.streamPage()
                      .topChartsLineUp()
                      .getCard( 3 )
                      .playButton()
                      .tap() ;

        this.retry( () -> this.navigator.nowPlayingBar().isPlaying() ) ;
    }

    @Test
    public void play_popular_artist() {
        this.navigator.streamPage()
                      .popularArtistLineUp()
                      .getCard( 0 )
                      .playButton()
                      .tap() ;

        this.retry( () -> this.navigator.nowPlayingBar().isPlaying() ) ;
    }

    @Test
    public void play_whats_new() {
        this.navigator.streamPage()
                      .whatsNewLineUp()
                      .getCard( 0 )
                      .playButton()
                      .tap() ;

        this.retry( () -> this.navigator.nowPlayingBar().isPlaying() ) ;
    }

    @Test
    public void play_new_songs_hit_songs() {
        this.navigator.streamPage()
                      .newSongsHitSongsLineUp()
                      .getCard( 0 )
                      .playButton()
                      .tap() ;

        this.retry( () -> this.navigator.nowPlayingBar().isPlaying() ) ;
    }

    @Test
    public void play_you_may_also_like() {
        this.navigator.streamPage()
                      .youMayAlsoLikeLineUp()
                      .getCard( 0 )
                      .playButton()
                      .tap() ;

        this.retry( () -> this.navigator.nowPlayingBar().isPlaying() ) ;
    }

    @After
    public void tear_down() {
        UtaPassUtil.stopNowPlayingBar() ;
        UtaPassUtil.closeApp() ;
    }
}
