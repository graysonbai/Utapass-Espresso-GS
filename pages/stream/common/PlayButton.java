package com.kddi.android.UtaPass.sqa_espresso.pages.stream.common ;

import com.kddi.android.UtaPass.R ;
import com.kddi.android.UtaPass.sqa_espresso.common.ViewObject;

import static android.support.test.espresso.Espresso.onView ;
import static android.support.test.espresso.matcher.ViewMatchers.withId ;
import static android.support.test.espresso.action.ViewActions.*;


public class PlayButton extends ViewObject {

    public PlayButton() {
        this.item = onView( withId( R.id.view_shuffle_play_layout ) ) ;
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




