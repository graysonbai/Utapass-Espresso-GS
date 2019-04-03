package com.kddi.android.UtaPass.sqa_espresso.pages.library.myuta ;

import com.kddi.android.UtaPass.R;
import com.kddi.android.UtaPass.sqa_espresso.common.BasicButton;
import com.kddi.android.UtaPass.sqa_espresso.common.UtaPassUtil;
import com.kddi.android.UtaPass.sqa_espresso.common.ViewObject;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

public class SongMoreActionMenu extends ViewObject {

    public SongMoreActionMenu() {
        this.label( " SongMoreActionMenu " );
        this.item = onView( withId( R.id.design_bottom_sheet ) ) ;
    }

    public void _ready() {
        if( ! this.isVisible( this.item ) ) {
            String msg = "NotReady: Library > MyUta > Song > MoreAction > Menu" ;
            throw new RuntimeException( msg ) ;
        }
    }

    public DeleteSongMenuItem deleteSongMenuItem() {
        return new DeleteSongMenuItem() ;
    }

    public class DeleteSongMenuItem extends BasicButton {
        public DeleteSongMenuItem() {
            super( " > DeleteSongMenuItem " ,() -> UtaPassUtil.withIndex( withId( R.id.context_menu_title ), 4 ) ) ;
        }
    }
}




