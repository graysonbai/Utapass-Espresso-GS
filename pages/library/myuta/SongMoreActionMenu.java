package com.kddi.android.UtaPass.sqa_espresso.pages.library.myuta ;

import android.support.test.espresso.ViewInteraction;
import android.view.MenuItem;
import android.view.View;

import com.kddi.android.UtaPass.R;
import com.kddi.android.UtaPass.sqa_espresso.common.BasicButton;
import com.kddi.android.UtaPass.sqa_espresso.common.LineUpObject;
import com.kddi.android.UtaPass.sqa_espresso.common.UtaPassUtil;
import com.kddi.android.UtaPass.sqa_espresso.common.ViewObject;
import com.kddi.android.UtaPass.sqa_espresso.pages.stream.common.LoginButton;
import com.kddi.android.UtaPass.sqa_espresso.pages.stream.common.ReadMoreButton;

import org.hamcrest.Matcher;

import static android.support.test.espresso.matcher.ViewMatchers.isCompletelyDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.isDescendantOfA;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.anyOf;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

public class SongMoreActionMenu extends ViewObject {

    public SongMoreActionMenu() {
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
            super( () -> UtaPassUtil.withIndex( withId( R.id.context_menu_title ), 4 ) ) ;
        }
    }
}




