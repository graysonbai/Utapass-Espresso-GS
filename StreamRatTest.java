package com.kddi.android.UtaPass.sqatest ;

import android.support.test.rule.ActivityTestRule ;
import android.support.test.runner.AndroidJUnit4 ;
import com.kddi.android.UtaPass.main.MainActivity ;
import com.kddi.android.UtaPass.sqatest.common.* ;

import org.junit.Rule ;
import org.junit.Test ;
import org.junit.runner.RunWith ;


@RunWith(AndroidJUnit4.class)
public class StreamRatTest {

    private Navigator navigator = new Navigator() ;

    public void writeMsg( String msg ) {
        android.util.Log.d( "UtapassAutomation", msg ) ;
    }

    public void sleep( int seconds, String info ) {
        try {
            this.writeMsg( String.format( "Sleep %s second(s): %s", seconds, info ) ) ;
            Thread.sleep( seconds * 1000 ) ;

        } catch (InterruptedException ex) {
            android.util.Log.d("UtapassAutomation", ex.toString());
        }
    }

    public void sleep( int seconds ) {
        try {
            this.writeMsg( String.format( "Sleep %s second(s)...", seconds ) ) ;
            Thread.sleep( seconds * 1000 ) ;

        } catch (InterruptedException ex) {
            android.util.Log.d("UtapassAutomation", ex.toString());
        }
    }

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(MainActivity.class);

    private void assertNowPlayingBar_playing() {
        boolean retryWhenNotReady = true ;
        int retryMaxCount = 3 ;
        int retryInterval = 10 ;
        int count = 0 ;

        while( true ) {
            try {
                if( ! this.navigator.streamPage().nowPlayingBar().isPlaying() ) {
                    throw new RuntimeException( "NowPlayingBar should be in playing status" ) ;
                }

                return ;

            } catch( Exception e ) {
                android.util.Log.d("UtapassAutomation", e.getMessage() ) ;

                if( ! retryWhenNotReady ) {
                    throw e ;
                }

                if( count++ == retryMaxCount ) {
                    throw e;
                }

                this.sleep( retryInterval, String.format( "(%s/%s)", count, retryMaxCount ) ) ;
            }
        }
    }

    @Test
    public void play_spotlight() {
        this.navigator.streamPage()
                      .spotlightLineUp()
                      .getCard( 0 )
                      .tap() ;

        // TODO: NowPlayingPage is displayed

        // TODO: NowPlayingBar is not displayed and is not in playing status

    }

    @Test
    public void play_live_event() {
        this.navigator.streamPage()
                      .liveLineUp()
                      .getCard( 0 )
                      .play() ;

        String liveTitle = navigator.liveConcertPage()
                                    .getLiveTitleBar()
                                    .getTitle() ;

        assert 0 == liveTitle.compareTo( "KICK OFF VIVA!!! 2017" ) ;
    }

    @Test
    public void play_artist_new_release() {
        this.navigator.streamPage()
                      .artistNewReleaseLineUp()
                      .getCard( 0 )
                      .play() ;

        this.assertNowPlayingBar_playing() ;
    }

    @Test
    public void play_daily_mix() {
        this.navigator.streamPage()
                      .dailyMixLineUp()
                      .getCard()
                      .play() ;

        this.assertNowPlayingBar_playing() ;
    }

    @Test
    public void play_top_charts() {
        this.navigator.streamPage()
                      .topChartsLineUp()
                      .getCard( 3 )
                      .play() ;

        this.assertNowPlayingBar_playing() ;
    }

    @Test
    public void play_popular_artist() {
        this.navigator.streamPage()
                      .popularArtistLineUp()
                      .getCard( 0 )
                      .play() ;

        this.assertNowPlayingBar_playing() ;
    }

    @Test
    public void play_whats_new() {
        this.navigator.streamPage()
                      .whatsNewLineUp()
                      .getCard( 0 )
                      .play() ;

        this.assertNowPlayingBar_playing() ;
    }

    @Test
    public void play_new_songs_hit_songs() {
        this.navigator.streamPage()
                      .newSongsHitSongsLineUp()
                      .getCard( 0 )
                      .play() ;

        this.assertNowPlayingBar_playing() ;
    }

    @Test
    public void play_you_may_also_like() {
        this.navigator.streamPage()
                .youMayAlsoLikeLineUp()
                .getCard( 0 )
                .play() ;

        this.assertNowPlayingBar_playing() ;
    }
}
