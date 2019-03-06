package com.kddi.android.UtaPass.sqa_espresso.pages.library.myplaylist;

import com.kddi.android.UtaPass.R;
import com.kddi.android.UtaPass.sqa_espresso.common.BasicButton;
import com.kddi.android.UtaPass.sqa_espresso.common.UtaPassUtil;
import com.kddi.android.UtaPass.sqa_espresso.common.ViewObject;

import static android.support.test.espresso.matcher.ViewMatchers.isDescendantOfA;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.core.AllOf.allOf;

public class MoreMenuPage extends ViewObject {
    public MoreMenuPage(){
        this.label( "More Menu Page" );
    }

    public BasicButton moreEditPlaylistButton(){
        return new BasicButton(this.label() + " > Edit Playlist Button",
                () -> UtaPassUtil.withIndex(
                        withId( R.id.context_menu_layout ), 0 ) );
    }

    public BasicButton moreDeletePlaylistButton(){
        return new BasicButton( this.label() + " > Delete Playlist Button",
                () -> UtaPassUtil.withIndex(
                        withId( R.id.context_menu_layout ), 1 ) );
    }

    public BasicButton cancelButton(){
        return new BasicButton(
                this.label() + " > Delete Button",
                () -> allOf(
                        withId( android.R.id.button2 ),
                        isDescendantOfA( withId( R.id.buttonPanel ) ) ) );
    }

    public BasicButton deleteButton(){
        return new BasicButton(
                this.label() + " > Delete Button",
                () -> allOf(
                        withId( android.R.id.button1 ),
                        isDescendantOfA( withId( R.id.buttonPanel ) ) ) );
    }
}
