package com.kddi.android.UtaPass.sqa_espresso ;

import android.support.test.runner.AndroidJUnit4 ;

import org.junit.Test ;
import org.junit.runner.RunWith ;

import com.kddi.android.UtaPass.sqa_espresso.common.StringObject;
import com.kddi.android.UtaPass.sqa_espresso.common.UtaPassUtil;
import com.kddi.android.UtaPass.sqa_espresso.pages.stream._module.Best50Module;


@RunWith(AndroidJUnit4.class)
public class Best50Test extends BasicTest {

    @Test
    public void title_on_stream() {
        String[] expectings = {
                "週間 Myうた BEST50",
                "My Uta BEST 50" } ;

        this.navigator.streamPage()
                      .best50Module()
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
                      .best50Module()
                      .subtitle()
                      .text()
                      .assertIn( expectings ) ;
    }

    @Test
    public void fifteen_songs_on_stream() {
        this.navigator.streamPage()
                      .best50Module()
                      .lineUp()
                      .countSongs()
                      .assertEquals( 15 ) ;
    }

    @Test
    public void fifty_songs_in_seeAll() {
        this.navigator.streamPage()
                      .best50Module()
                      .seeAll()
                      .tap() ;

        this.navigator.best50Page()
                      .showMoreButton()
                      .tap() ;

        this.navigator.best50Page()
                      .lineUp()
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
                                                 .remainingQuotas()
                                                 .text() ;

        UtaPassUtil.pressBack() ;

        StringObject[] names = this.saveMyUtaSongsFromBest50Module() ;
        StringObject songName = names[ 0 ] ;
        StringObject artistName = names[ 1 ] ;

        this.navigator.streamPage()
                      .sideBarButton()
                      .tap() ;

        this.sleep( 5, "QuotaInfo updated" ) ;

        this.navigator.sideBarMenu()
                      .remainingQuotas()
                      .assertLessThan( quotas_orig, 1 ) ;

        UtaPassUtil.pressBack() ;

        this.navigator.libraryTab()
                      .tap() ;

        this.navigator.libraryPage()
                      .myUtaCategory()
                      .tap() ;

        this.navigator.myUtaPage()
                      .remainingQuotas()
                      .assertLessThan( quotas_orig, 1 ) ;

        this.navigator.myUtaPage()
                      .downloadedSongs()
                      .assertEquals( 1 ) ;

        this.navigator.myUtaPage()
                      .lineUp()
                      .card( 0 )
                      .songName()
                      .assertEquals( songName ) ;

        this.navigator.myUtaPage()
                      .lineUp()
                      .card( 0 )
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
                          .card( 0 )
                          .moreActionsButton()
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

    public StringObject[] saveMyUtaSongsFromBest50Module() {
        for( int i = 0; i < 15 ; i++ ) {

            Best50Module.InternalCard card = this.navigator.streamPage()
                                                           .best50Module()
                                                           .lineUp()
                                                           .card( i ) ;
            if( card.myUtaButton()
                    .isVisible() ) {

                card.myUtaButton()
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

                return new StringObject[] {
                        card.songName().text(),
                        card.artistName().text() } ;
            }
        }

        throw new RuntimeException( "AllSongsRegistered" ) ;
    }
}
