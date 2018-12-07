package com.kddi.android.UtaPass.sqa_espresso.pages.common ;

import android.support.test.espresso.Espresso;
import com.kddi.android.UtaPass.sqa_espresso.common.* ;
import com.kddi.android.UtaPass.view.playingindicator.NowplayingAnimatorBar;

public class BasicPage extends ViewObject{

    private StreamTab streamTab ;
    private LibraryTab libraryTab ;
    private SearchTab searchTab ;
    private SongNowPlayingBar songNowPlayingBar ;

    public StreamTab streamTab() {
        if( this.streamTab == null ) {
            this.streamTab = new StreamTab().ready() ;
        }
        return this.streamTab ;
    }

    public LibraryTab libraryTab() {
        if( this.libraryTab == null ) {
            this.libraryTab = new LibraryTab().ready() ;
        }
        return this.libraryTab ;
    }

    public SearchTab searchTab() {
        if( this.searchTab == null ) {
            this.searchTab = new SearchTab().ready() ;
        }
        return this.searchTab ;
    }

    public SongNowPlayingBar nowPlayingBar() {
        if( this.songNowPlayingBar == null ) {
            this.songNowPlayingBar = new SongNowPlayingBar().ready() ;
        }
        return this.songNowPlayingBar ;
    }

    public void menu() {
        // todo: return SideMenu
    }

    public void pressBack() {
        Espresso.pressBack() ;
    }
}
