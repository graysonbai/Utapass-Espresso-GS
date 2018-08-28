package com.kddi.android.UtaPass.sqa_espresso ;

import android.support.test.rule.ActivityTestRule ;
import android.support.test.runner.AndroidJUnit4 ;

import com.kddi.android.UtaPass.main.MainActivity ;
import com.kddi.android.UtaPass.sqa_espresso.common.Navigator;
import com.kddi.android.UtaPass.sqa_espresso.common.UtaPassUtil;

import org.junit.After;
import org.junit.Rule ;
import org.junit.Test ;
import org.junit.runner.RunWith ;


@RunWith(AndroidJUnit4.class)
public class MyTest extends BasicTest {

    private Navigator navigator = new Navigator() ;

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(MainActivity.class);


    @Test
    public void play_song_in_songs() {
        this.navigator.streamPage()
                      .libraryTab()
                      .tap() ;

        this.navigator.libraryPage()
                      .songsCategory()
                      .tap() ;

        this.navigator.songsPage()
                      .songsLineUp()
                      .song( 0 )
                      .tap() ;

        this.retry( () -> this.navigator.nowPlayingBar().isPlaying() ) ;

        this.assertEqual(
                this.navigator.songsPage().songsLineUp().song( 0 ).songName(),
                this.navigator.nowPlayingBar().songName()
        ) ;

        this.assertEqual(
                this.navigator.songsPage().songsLineUp().song( 0 ).artistName(),
                this.navigator.nowPlayingBar().artistName()
        ) ;
    }

    @Test
    public void play_song_in_albums() {
        this.navigator.streamPage()
                      .libraryTab()
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
                      .song( 1 )
                      .tap() ;

        this.retry( () -> this.navigator.albumInfoPage().nowPlayingBar().isPlaying() ) ;
    }

    @Test
    public void play_song_in_artist() {
        this.navigator.streamPage()
                      .libraryTab()
                      .tap() ;

        this.navigator.libraryPage()
                      .artistsCategory()
                      .tap() ;

        this.navigator.artistsPage()
                      .artistsLineUp()
                      .artist( 9 )
                      .tap() ;

        this.sleep( 5 ) ;
    }

    @Test
    public void play_song_in_myuta() {
        // TestRails: 1934617

        this.navigator.streamPage()
                      .libraryTab()
                      .tap() ;

        this.navigator.libraryPage()
                      .myUtaCategory()
                      .tap() ;

        this.navigator.myUtaPage()
                      .playButton()
                      .tap() ;

        this.retry( () ->
                this.navigator.myUtaPage().nowPlayingBar().isPlaying()
        ) ;
    }

    @After
    public void tear_down() {
        UtaPassUtil.stopNowPlayingBar() ;
        UtaPassUtil.closeApp() ;
    }
}
