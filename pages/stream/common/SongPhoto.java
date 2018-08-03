package com.kddi.android.UtaPass.sqa_espresso.pages.stream.common ;

import android.support.test.espresso.Espresso;
import android.support.test.espresso.ViewInteraction;
import android.view.View;

import com.kddi.android.UtaPass.sqa_espresso.common.ViewObject;

import org.hamcrest.Matcher;

import static android.support.test.espresso.Espresso.onView ;
import static android.support.test.espresso.action.ViewActions.click ;


public class SongPhoto extends ViewObject {

    private Matcher<View> matcherForPhoto ;

    public ViewInteraction item() {
        return onView( this.matcherForPhoto() ) ;
    }

    public void tap() {
        this.item().perform( click() ) ;
    }

    public boolean isVisible() {
        return this.isVisible( this.item() ) ;
    }

    public void matcherForPhoto( Matcher<View> matcher ) {
        this.matcherForPhoto = matcher ;
    }

    private Matcher<View> matcherForPhoto() {
        return this.matcherForPhoto ;
    }
}




