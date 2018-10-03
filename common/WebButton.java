package com.kddi.android.UtaPass.sqa_espresso.common ;

import android.support.test.uiautomator.UiObjectNotFoundException;

import com.kddi.android.UtaPass.sqa_espresso.common.exceptions.InvalidStateException;


public class WebButton extends ViewObject {

    protected LazyWebMatcher matcher ;

    public WebButton( LazyWebMatcher matcher ) {
        this.matcher = matcher ;
    }

    public LazyWebMatcher matcher() {
        return this.matcher ;
    }

    public void tap() {
        this.assertVisible() ;

        try {
            this.matcher.execute().click() ;

        } catch( UiObjectNotFoundException e ) {
            this.dprint( e.getMessage() ) ;
        }
    }

    public boolean isVisible() {
        return this.matcher.execute().exists() ;
    }

    public String text() {
        try {
            return this.matcher.execute().getText();

        } catch( UiObjectNotFoundException e ) {
            this.dprint( e.getMessage() ) ;
            return "" ;
        }
    }

    public void _ready() {
        if( ! this.isVisible() ) {
            throw new RuntimeException( "NotReady: " + this.name() ) ;
        }
    }

    public String name() {
        return this.getClass().getSimpleName() ;
    }

    public void assertVisible() {
        if( ! this.isVisible() ) {
            throw new InvalidStateException( "Actual: InVisible, Expecting: Visible" ) ;
        }
    }

    public void assertInvisible() {
        if( this.isVisible() ) {
            throw new InvalidStateException( "Actual: Visible, Expecting: InVisible" ) ;
        }
    }
}




