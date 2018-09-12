package com.kddi.android.UtaPass.sqa_espresso.pages.stream.common ;

import com.kddi.android.UtaPass.R ;
import com.kddi.android.UtaPass.sqa_espresso.common.ViewObject;

import static android.support.test.espresso.Espresso.onView ;
import static android.support.test.espresso.matcher.ViewMatchers.withId ;
import static android.support.test.espresso.action.ViewActions.*;
import static android.support.test.espresso.matcher.ViewMatchers.withParent;
import static org.hamcrest.core.AllOf.allOf;


public class ShuffleAllButton extends ViewObject {

    public ShuffleAllButton() {
        this.item = onView( allOf( withId( R.id.view_shuffle_play_layout ),
                                   withParent( withId( R.id.detail_album_recycler_view ) ) ) ) ;
    }

    public void tap() {
        this.item.perform( click() ) ;
    }

    public boolean isVisible() {
        return this.isVisible( this.item ) ;
    }

    public String text() {
        return this.getText( this.item ) ;
    }
}




