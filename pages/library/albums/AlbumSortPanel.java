package com.kddi.android.UtaPass.sqa_espresso.pages.library.albums;

import com.kddi.android.UtaPass.R;
import com.kddi.android.UtaPass.sqa_espresso.common.BasicButton;
import com.kddi.android.UtaPass.sqa_espresso.common.UtaPassUtil;
import com.kddi.android.UtaPass.sqa_espresso.common.ViewObject;

import static android.support.test.espresso.matcher.ViewMatchers.withId;

public class AlbumSortPanel extends ViewObject {
    public AlbumSortPanel(){
        this.label( "Artist Sort Panel" );
    }

    public BasicButton recentlyAddedButton(){
        return new BasicButton( this.label() + " > sortPanel",
                () -> UtaPassUtil.withIndex( withId( R.id.menu_item_text), 1 ) );
    }

    public BasicButton recentlyPlayedButton(){
        return new BasicButton( this.label() + " > sortPanel",
                () -> UtaPassUtil.withIndex( withId( R.id.menu_item_text), 2 ) );
    }
}