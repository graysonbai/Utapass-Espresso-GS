package com.kddi.android.UtaPass.sqa_espresso.common ;

import android.support.test.espresso.ViewInteraction;
import android.view.View;

import org.hamcrest.Matcher;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;


public class BasicButton extends ViewObject {

    public BasicButton( final ViewInteraction view ) {
        this.item = view ;
    }

    public BasicButton( final Matcher<View> matcher ) {
        this.item = onView( matcher ) ;
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




