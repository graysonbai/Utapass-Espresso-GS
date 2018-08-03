package com.kddi.android.UtaPass.sqa_espresso.pages.stream.common ;

import com.kddi.android.UtaPass.R ;
import com.kddi.android.UtaPass.sqa_espresso.common.ViewObject;

import static android.support.test.espresso.Espresso.onView ;
import static android.support.test.espresso.matcher.ViewMatchers.withId ;
import static android.support.test.espresso.action.ViewActions.*;


public class ShowMoreButton extends ViewObject {

    private StreamLineUp streamLineUp ;

    public ShowMoreButton( StreamLineUp streamLineUp ) {
        this.streamLineUp = streamLineUp ;
        this.item = onView( withId( R.id.item_detail_show_more ) ) ;
    }

    public void tap() {
        this.item.perform( click() ) ;
        this.streamLineUp.resetMaxIndexOfWindow() ;
    }

    public boolean isVisible() {
        return this.isVisible( this.item ) ;
    }
}




