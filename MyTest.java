package com.kddi.android.UtaPass.sqa_espresso ;

import android.app.KeyguardManager;
import android.content.Context;
import android.support.test.runner.AndroidJUnit4 ;

import com.kddi.android.UtaPass.sqa_espresso.common.Navigator;

import org.junit.Test ;
import org.junit.runner.RunWith ;

import static android.support.test.InstrumentationRegistry.getTargetContext;


// temp
import com.kddi.android.UtaPass.R ;

import java.util.ArrayList;

import static android.support.test.espresso.Espresso.onView ;
import static android.support.test.espresso.action.ViewActions.pressKey;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.isRoot;
import static android.support.test.espresso.matcher.ViewMatchers.withId ;
import static android.support.test.espresso.matcher.ViewMatchers.withText ;
import static android.support.test.espresso.matcher.ViewMatchers.withClassName;

import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.contrib.RecyclerViewActions.scrollToPosition ;
import static org.hamcrest.Matchers.* ;

@RunWith(AndroidJUnit4.class)
public class MyTest extends BasicTest {

    private Navigator navigator = new Navigator() ;

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

        this.navigator.nowPlayingBar()
                      .assertPlaying() ;

        this.navigator.songsPage()
                      .songsLineUp()
                      .song( 0 )
                      .songName()
                      .assertEquals( this.navigator.nowPlayingBar().songName() ) ;

        this.navigator.songsPage()
                      .songsLineUp()
                      .song( 0 )
                      .artistName()
                      .assertEquals( this.navigator.nowPlayingBar().artistName() ) ;
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

        this.navigator.nowPlayingBar()
                      .assertPlaying() ;
    }

    @Test
    public void play_song_in_artist() {
        this.navigator.streamPage()
                      .libraryTab()
                      .tap() ;

        this.navigator.libraryPage()
                      .artistsCategory()
                      .tap() ;

        int albums = Integer.parseInt( this.navigator.artistsPage()
                                                     .artistsLineUp()
                                                     .artist( 0 )
                                                     .albums() ) ;

        this.navigator.artistsPage()
                      .artistsLineUp()
                      .artist( 0 )
                      .tap() ;

        // ArtistAlbumsPage
        if( albums > 1 ) {
            this.navigator.artistAlbumsPage()
                          .artistAlbumsLineUp()
                          .album(0 )
                          .tap();
        }

        // AlbumInfoPage
        this.navigator.albumInfoPage()
                      .shuffleAllButton()
                      .tap() ;

        this.navigator.nowPlayingBar()
                      .assertPlaying() ;
    }

    @Test
    public void play_song_in_myuta() {
        // TestRails: 1934617

        // save any song to my uta
        this.navigator.streamPage()
                      .spotlightLineUp()
                      .card( 0 )
                      .tap() ;

        if( this.navigator.spotlightPage()
                          .songsLineUp()
                          .song( 0 )
                          .myUtaButton()
                          .isVisible() ) {

            this.navigator.spotlightPage()
                          .songsLineUp()
                          .song( 0 )
                          .myUtaButton()
                          .tap() ;

            this.navigator.saveMyUtaPopupMessage()
                          .saveButton()
                          .tap() ;

            this.sleep( 5 ) ;
            if( this.navigator.saveMyUtaConfirmPopupMessage().isVisible() ) {
                this.navigator.saveMyUtaConfirmPopupMessage()
                              .closeButton()
                              .tap();
            }
        }

        this.navigator.spotlightPage()
                      .libraryTab()
                      .tap() ;

        this.navigator.libraryPage()
                      .myUtaCategory()
                      .tap() ;

        this.navigator.myUtaPage()
                      .playButton()
                      .tap() ;

        this.navigator.nowPlayingBar()
                      .assertPlaying() ;
    }
}
