package com.kddi.android.UtaPass.sqa_espresso ;

import android.support.test.espresso.NoMatchingViewException;
import android.support.test.runner.AndroidJUnit4 ;

import com.kddi.android.UtaPass.sqa_espresso.common.Navigator;

import org.junit.Before;
import org.junit.Test ;
import org.junit.runner.RunWith ;


// temp
import com.kddi.android.UtaPass.R ;
import com.kddi.android.UtaPass.sqa_espresso.common.UtaPassUtil;
import com.kddi.android.UtaPass.sqa_espresso.pages.stream._lineup.Best50LineUp;
import com.kddi.android.UtaPass.sqa_espresso.pages.stream.common.MyUtaButton;
import com.kddi.android.UtaPass.sqa_espresso.pages.stream.common.SongObject;
import com.kddi.android.UtaPass.sqa_espresso.pages.stream.common.StreamLineUp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static android.support.test.espresso.Espresso.onView ;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId ;
import static android.support.test.espresso.matcher.ViewMatchers.withText ;
import static android.support.test.espresso.matcher.ViewMatchers.withClassName;

import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.contrib.RecyclerViewActions.scrollToPosition ;
import static org.hamcrest.Matchers.* ;

@RunWith(AndroidJUnit4.class)
public class Best50Test extends BasicTest {

    private Navigator navigator = new Navigator() ;

    public void removeAllMyUtaSongs() {
        this.navigator.libraryTab()
                      .tap() ;

        this.navigator.libraryPage()
                      .myUtaCategory()
                      .tap() ;

        while( this.navigator.myUtaPage()
                             .playButton()
                             .isVisible() ) {

            this.navigator.myUtaPage()
                          .lineUp()
                          .song( 0 )
                          .moreActionButton()
                          .tap() ;

            this.navigator.songMoreActionMenu()
                          .deleteSongMenuItem()
                          .tap() ;

            this.navigator.deleteMyUtaConfirmPopupMessage()
                          .deleteButton()
                          .tap() ;

            this.sleep( 2 ) ;
       }

       this.navigator.streamTab()
                     .tap() ;
    }

    @Before
    public void pre_conditions() {
        // todo: reset myuta quotas
        // here...

//        this.removeAllMyUtaSongs() ;
    }

    public SongObject saveMyUtaSongsFromBest50LineUp() {
        if( this.navigator.streamPage()
                          .best50()
                          .lineUp()
                          .song( 0 )
                          .myUtaButton()
                          .isVisible() ) {

            this.navigator.streamPage()
                          .best50()
                          .lineUp()
                          .song(0)
                          .myUtaButton()
                          .tap() ;

            this.navigator.saveMyUtaPopupMessage()
                          .saveButton()
                          .tap() ;

            this.sleep(3) ;
            if( this.navigator.saveMyUtaConfirmPopupMessage()
                              .isVisible()) {

                this.navigator.saveMyUtaConfirmPopupMessage()
                              .closeButton()
                              .tap() ;
            }
        }

        return this.navigator.streamPage()
                             .best50()
                             .lineUp()
                             .song(0) ;
    }

    @Test
    public void title_on_stream() {
        String title = this.navigator.streamPage()
                                     .best50()
                                     .title() ;
        String[] expecting = {
                "週間 Myうた BEST50",
                "My Uta BEST 50"
        } ;

        this.assertTrue(
                () -> Arrays.asList( expecting ).contains( title ),
                "UnexpectingTitle: " + title ) ;
    }

    @Test
    public void subtitle_on_stream() {
        String subtitle = this.navigator.streamPage()
                                        .best50()
                                        .subtitle() ;
        String[] expecting = {
                "Myうた保存された人気曲をご紹介！（水曜日更新）",
                "Weekly update of the most popular songs saved as My Uta"
        } ;

        this.assertTrue(
                () -> Arrays.asList( expecting ).contains( subtitle ),
                "UnexpectingSubtitle: " + subtitle ) ;
    }

    @Test
    public void fifteen_songs_on_stream() {
        Set<String> set = new HashSet<String>() ;
        Best50LineUp lineup = this.navigator.streamPage().best50LineUp() ;

        for( int i = 0 ; i < 15 ; i++ ) {
            set.add(
                    String.format( "%s,%s",
                        lineup.song( i ).songName(),
                        lineup.song( i ).artistName() ) ) ;
        }

        this.assertTrue(
                () -> set.size() == 15,
                "UniqueSongs: " + set.size() ) ;
    }

    @Test
    public void fifty_songs_in_seeAll() {
        this.navigator.streamPage()
                      .best50()
                      .seeAll()
                      .tap() ;

        this.navigator.best50Page()
                      .showMoreButton()
                      .tap() ;

        StreamLineUp lineup = this.navigator.best50Page().songsLineUp() ;
        Set<String> set = new HashSet<String>() ;

        try {
            for (int i = 0; i < 50; i++) {
                SongObject song = lineup.song(i);
                this.retry(() -> song.isVisible());

                set.add(
                        String.format("%s,%s",
                                song.songName(),
                                song.artistName()));
            }

        } catch( NoMatchingViewException e ) {
            this.dprint( e.getMessage() ) ;
        }

        this.assertTrue(
                () -> set.size() == 50,
                "UniqueSongs: expecting = 50, actual = " + set.size() ) ;
    }

    public int remainingQuotasFromSideBarMenu() {
        this.navigator.streamTab()
                      .tap() ;

        this.navigator.streamPage()
                      .sideBarButton()
                      .tap() ;

        int result = Integer.parseInt(
                        this.navigator.sideBarMenu()
                                      .quotaInfo()
                                      .remainingQuotas() ) ;

        UtaPassUtil.pressBack() ;
        return result ;
    }

    public int remainingQuotasFromMyUtaPage() {
        this.navigator.libraryTab()
                      .tap() ;

        this.navigator.libraryPage()
                      .myUtaCategory()
                      .tap() ;

        this.navigator.myUtaPage()
                      .remainingQuotas() ;

        return Integer.parseInt( this.navigator.myUtaPage()
                                               .remainingQuotas() ) ;
    }

    @Test
    public void register_myuta_on_stream() {
        int quotas = this.remainingQuotasFromSideBarMenu() ;

        SongObject song = this.saveMyUtaSongsFromBest50LineUp() ;

        final int quotasFromSideBarMenu = this.remainingQuotasFromSideBarMenu() ;

        this.assertTrue( () -> quotas - quotasFromSideBarMenu == 1,
                         String.format( "(SideBarMenu) QuotaNotSynced: before = '%s', after = '%s'",
                                        quotas,
                                        quotasFromSideBarMenu ) ) ;

        final int quotasFromMyUtaPage = this.remainingQuotasFromMyUtaPage() ;
        this.assertTrue( () -> quotas - quotasFromMyUtaPage == 1,
                         String.format( "(MyUtaPage) QuotaNotSynced: before = '%s', after = '%s'",
                                        quotas,
                                        quotasFromMyUtaPage ) ) ;

        this.assertEqual( "1",
                          this.navigator.myUtaPage()
                                        .downloadedSongs() ) ;

        this.assertEqual( song.songName(),
                          this.navigator.myUtaPage()
                                        .lineUp()
                                        .song( 0 )
                                        .songName() ) ;

        this.assertEqual( song.artistName(),
                          this.navigator.myUtaPage()
                                        .lineUp()
                                        .song( 0 )
                                        .artistName() ) ;
    }
}
