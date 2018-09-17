package com.kddi.android.UtaPass.sqa_espresso.pages.stream.common ;

import com.kddi.android.UtaPass.R;
import com.kddi.android.UtaPass.sqa_espresso.common.ViewObject;

import static android.support.test.espresso.matcher.ViewMatchers.withId;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;


public class SideBarButton extends ViewObject {

    public SideBarButton() {
        this.item = onView( withId( R.id.main_drawer_icon ) ) ;
    }

    public void tap() {
        this.item.perform( click() ) ;
    }

    public boolean isVisible() {
        return this.isVisible( this.item ) ;
    }
}




