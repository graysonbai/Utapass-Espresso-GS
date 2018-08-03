package com.kddi.android.UtaPass.sqa_espresso.pages.stream.common ;

import android.support.test.espresso.ViewInteraction;
import android.view.View;

import com.kddi.android.UtaPass.R ;
import com.kddi.android.UtaPass.sqa_espresso.common.ViewObject;

import org.hamcrest.Matcher;

import static android.support.test.espresso.Espresso.onView ;
import static android.support.test.espresso.matcher.ViewMatchers.withId ;
import static android.support.test.espresso.action.ViewActions.*;


public class MyUtaButton extends ViewObject {

    private ViewInteraction item ;
    private Matcher<View> matcherForButton ;
    private Matcher<View> matcherForText ;

    public ViewInteraction item() {
        if( this.item == null ) {
            this.item = onView( this.matcherForButton() ) ;
        }
        return this.item ;
    }

    public void tap() {
        this.item().perform( click() ) ;
    }

    public boolean isVisible() {
        return this.isVisible( this.item() ) ;
    }

    public String text() {
        return this.getText( this.matcherForText() ) ;
    }

    public void matcherForButton( Matcher<View> matcher ) {
        this.matcherForButton = matcher ;
    }

    private Matcher<View> matcherForButton() {
        return this.matcherForButton ;
    }

    public void matcherForText( Matcher<View> matcher ) {
        this.matcherForText = matcher ;
    }

    private Matcher<View> matcherForText() {
        return this.matcherForText ;
    }
}




