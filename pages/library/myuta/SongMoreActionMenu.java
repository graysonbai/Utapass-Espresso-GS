package com.kddi.android.UtaPass.sqa_espresso.pages.library.myuta ;

import com.kddi.android.UtaPass.R;
import com.kddi.android.UtaPass.sqa_espresso.common.BasicButton;
import com.kddi.android.UtaPass.sqa_espresso.common.UtaPassUtil;
import com.kddi.android.UtaPass.sqa_espresso.common.ViewObject;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

public class SongMoreActionMenu extends ViewObject {

    public SongMoreActionMenu() {
       this.label( "SongMoreActionMenu" );
    }

    public void _ready() {
    }

    public BasicButton AlbumInfoMenuItem() {
        return new BasicButton( this.label() +  " > deleteSongMenuItem",
                () -> UtaPassUtil.withIndex( withId( R.id.context_menu_title ), 0 ) );
    }

    public BasicButton SongDetailMenuItem() {
        return new BasicButton( this.label() +  " > SongDetailMenuItem",
                () -> UtaPassUtil.withIndex( withId( R.id.context_menu_title ), 1 ) );
    }

    public BasicButton SongInfoMenuItem() {
        return new BasicButton( this.label() +  " > SongInfoMenuItem",
                () -> UtaPassUtil.withIndex( withId( R.id.context_menu_title ), 2 ) );
    }

    public BasicButton AddtoPlaylistMenuItem() {
        return new BasicButton( this.label() +  " > AddtoPlaylistMenuItem",
                () -> UtaPassUtil.withIndex( withId( R.id.context_menu_title ), 3 ) );
    }

    public BasicButton deleteSongMenuItem() {
        return new BasicButton( this.label() +  " > deleteSongMenuItem",
                () -> UtaPassUtil.withIndex( withId( R.id.context_menu_title ), 4 ) );
    }
}




