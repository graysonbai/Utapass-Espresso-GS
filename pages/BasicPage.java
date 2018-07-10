package com.kddi.android.UtaPass.sqatest.pages ;

import android.support.test.espresso.Espresso;

import com.kddi.android.UtaPass.sqatest.common.* ;

public class BasicPage extends ViewObject{

    public StreamTab streamTab() {
        return new StreamTab().ready() ;
    }

    public LibraryTab libraryTab() {
        return new LibraryTab().ready() ;
    }

    public SearchTab searchTab() {
        return new SearchTab().ready() ;
    }

    public NowPlayingBar nowPlayingBar() {
        return new NowPlayingBar().ready() ;
    }

    public void menu() {
        // todo: return SideMenu
    }

    public void pressBack() {
        Espresso.pressBack() ;
    }
}
