package com.kddi.android.UtaPass.sqa_espresso ;

import android.support.test.rule.ActivityTestRule ;
import android.support.test.runner.AndroidJUnit4 ;
import com.kddi.android.UtaPass.main.MainActivity ;
import com.kddi.android.UtaPass.sqa_espresso.common.* ;
import com.kddi.android.UtaPass.sqa_espresso.pages.common.NowPlayingBar;
import com.kddi.android.UtaPass.sqa_espresso.pages.library.songs.SongObject ;

import org.junit.Rule ;
import org.junit.Test ;
import org.junit.runner.RunWith ;

// for temp
import static android.support.test.espresso.action.ViewActions.click ;


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

        SongObject song = this.navigator.songsPage()
                                        .songsLineUp()
                                        .getSong( 0 ) ;

        // tap song to play it
        song.tap() ;

        NowPlayingBar nowPlayingBar = this.navigator.libraryPage().nowPlayingBar() ;

        // check nowPlayingBar is in playing status
        this.retry( () -> nowPlayingBar.isPlaying() ) ;

        this.assertTrue(
            () -> song.getSongName().equals(nowPlayingBar.getSongName()),
            String.format(
                "SongNameInNowPlayingBar is not correct: SongName = '%s', SongNameInNowPlayingBar = '%s' ",
                song.getSongName(),
                nowPlayingBar.getSongName()
            )
        ) ;

        this.assertTrue(
            () -> song.getArtistName().equals( nowPlayingBar.getArtistName() ),
            String.format(
                "ArtistNameInNowPlayingBar is not correct: ArtistName = '%s', ArtistNameInNowPlayingBar = '%s'",
                song.getArtistName(),
                nowPlayingBar.getArtistName()
            )
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
                      .getAlbum( 0 )
                      .tap() ;

        this.navigator.albumInfoPage()
                      .songsLineUp()
                      .getSong( 1 )
                      .tap() ;

        this.retry( () ->
                this.navigator.myUtaPage().nowPlayingBar().isPlaying()
        ) ;
    }

    @Test
    public void play_song_in_artist() {

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

    @Test
    public void libraryPage_tap_songs() {
        this.navigator.streamPage()
                      .libraryTab()
                      .tap() ;

        // tap "Songs"
        this.navigator.libraryPage()
                      .songsCategory()
                      .tap() ;
        this.sleep( 5 ) ;
        UtaPassUtil.pressBack() ;

        // tap "Albums"
        this.navigator.libraryPage()
                      .albumsCategory()
                      .tap() ;
        this.sleep( 5 ) ;
        UtaPassUtil.pressBack() ;

        // tap "Artists"
        this.navigator.libraryPage()
                      .artistsCategory()
                      .tap() ;
        this.sleep( 5 ) ;
        UtaPassUtil.pressBack() ;

        // tap "Videos"
        this.navigator.libraryPage()
                      .videosCategory()
                      .tap() ;
        this.sleep( 5 ) ;
        UtaPassUtil.pressBack() ;

        // tap "Favorite"
        this.navigator.libraryPage()
                      .favoriteCategory()
                      .tap() ;
        this.sleep( 5 ) ;
        UtaPassUtil.pressBack() ;

        // tap "My Playlists"
        this.navigator.libraryPage()
                      .myPlaylistsCategory()
                      .tap() ;
        this.sleep( 5 ) ;
        UtaPassUtil.pressBack() ;

        // tap "My Uta"
        this.navigator.libraryPage()
                      .myUtaCategory()
                      .tap() ;
        this.sleep( 5 ) ;
        UtaPassUtil.pressBack() ;

        // tap "Purchased Music"
        this.navigator.libraryPage()
                      .purchasedMusicCategory()
                      .tap() ;
        this.sleep( 5 ) ;
        UtaPassUtil.pressBack() ;

    }
}
