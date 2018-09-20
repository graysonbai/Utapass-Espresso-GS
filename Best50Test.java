package com.kddi.android.UtaPass.sqa_espresso ;

import android.support.test.runner.AndroidJUnit4 ;

import com.kddi.android.UtaPass.sqa_espresso.common.Navigator;

import org.junit.Before;
import org.junit.Test ;
import org.junit.runner.RunWith ;

import com.kddi.android.UtaPass.sqa_espresso.common.SongObject;
import com.kddi.android.UtaPass.sqa_espresso.common.StringObject;
import com.kddi.android.UtaPass.sqa_espresso.common.UtaPassUtil;
import com.kddi.android.UtaPass.sqa_espresso.pages.stream._lineup.Best50LineUp;


@RunWith(AndroidJUnit4.class)
public class Best50Test extends BasicTest {

    private Navigator navigator = new Navigator() ;

    @Before
    public void pre_conditions() {
        // todo: reset myuta quotas
        // here...
    }

    @Test
    public void title_on_stream() {
        String[] expectings = {
                "週間 Myうた BEST50",
                "My Uta BEST 50" } ;

        this.navigator.streamPage()
                      .best50()
                      .title()
                      .text()
                      .assertIn( expectings ) ;
    }

    @Test
    public void subtitle_on_stream() {
        String[] expectings = {
                "Myうた保存された人気曲をご紹介！（水曜日更新）",
                "Weekly update of the most popular songs saved as My Uta" } ;

        this.navigator.streamPage()
                      .best50()
                      .subtitle()
                      .text()
                      .assertIn( expectings ) ;
    }

    @Test
    public void fifteen_songs_on_stream() {
        this.navigator.streamPage()
                      .best50()
                      .lineUp()
                      .countSongs()
                      .assertEquals( 15 ) ;
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

        this.navigator.best50Page()
                      .songsLineUp()
                      .countSongs()
                      .assertEquals( 50 ) ;
    }

    @Test
    public void register_myuta_on_stream() {
        this.removeAllMyUtaSongs() ;

        this.navigator.streamTab()
                      .tap() ;

        this.navigator.streamPage()
                      .sideBarButton()
                      .tap() ;

        StringObject quotas_orig = this.navigator.sideBarMenu()
                                                 .quotaInfo()
                                                 .remainingQuotas()
                                                 .text() ;

        UtaPassUtil.pressBack() ;

        SongObject song = this.saveMyUtaSongsFromBest50LineUp() ;
        String songName = song.songName().text().string() ;
        String artistName = song.artistName().text().string() ;

        this.navigator.streamPage()
                      .sideBarButton()
                      .tap() ;

        this.navigator.sideBarMenu()
                      .quotaInfo()
                      .remainingQuotas()
                      .text()
                      .assertLessThan( quotas_orig, 1 ) ;

        UtaPassUtil.pressBack() ;

        this.navigator.libraryTab()
                      .tap() ;

        this.navigator.libraryPage()
                      .myUtaCategory()
                      .tap() ;

        this.navigator.myUtaPage()
                      .remainingQuotas()
                      .text()
                      .assertLessThan( quotas_orig, 1 ) ;

        this.navigator.myUtaPage()
                      .downloadedSongs()
                      .assertEquals( 1 ) ;

        this.navigator.myUtaPage()
                      .lineUp()
                      .song( 0 )
                      .songName()
                      .assertEquals( songName ) ;

        this.navigator.myUtaPage()
                      .lineUp()
                      .song( 0 )
                      .artistName()
                      .assertEquals( artistName ) ;
    }

    // ========================================
    // Supporting functions
    // ========================================
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

    public SongObject saveMyUtaSongsFromBest50LineUp() {
        Best50LineUp lineup = this.navigator.streamPage()
                                            .best50()
                                            .lineUp() ;
        for( int i = 0; i < 15 ; i++ ) {
            SongObject song = lineup.song( i ) ;

            if( song.myUtaButton()
                    .isVisible() ) {

                song.myUtaButton()
                    .tap() ;

                this.navigator.saveMyUtaPopupMessage()
                              .saveButton()
                              .tap() ;

                this.sleep(5) ;
                if( this.navigator.saveMyUtaConfirmPopupMessage()
                                  .isVisible() ) {

                    this.navigator.saveMyUtaConfirmPopupMessage()
                                  .closeButton()
                                  .tap() ;
                }

                return song ;
            }
        }

        throw new RuntimeException( "AllSongsRegistered" ) ;
    }
}
