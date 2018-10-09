package com.kddi.android.UtaPass.sqa_espresso.common ;

import android.support.test.uiautomator.UiObjectNotFoundException;
import android.view.View;

import com.kddi.android.UtaPass.sqa_espresso.common.exceptions.ButtonInvisibleException;
import com.kddi.android.UtaPass.sqa_espresso.common.exceptions.ButtonVisibleException;

import org.hamcrest.Matcher;


public class UiAutomatorButton extends ViewObject {

    protected LazyUiAutomatorMatcher matcher ;

    public UiAutomatorButton( LazyUiAutomatorMatcher matcher ) {
        this.matcher = matcher ;
    }

    public LazyUiAutomatorMatcher matcher() {
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

    public StringObject text() {
        try {
            return new StringObject( this.matcher.execute().getText() ) ;

        } catch( UiObjectNotFoundException e ) {
            this.dprint( e.getMessage() ) ;

            return new StringObject( "" ) ;
        }
    }

    public void _ready() {
        this.assertVisible() ;
    }

    public String name() {
        return this.getClass().getSimpleName() ;
    }

    public void assertVisible() {
        if( ! this.isVisible() ) {
            throw new ButtonInvisibleException( this.name() ) ;
        }
    }

    public void assertInvisible() {
        if( this.isVisible() ) {
            throw new ButtonVisibleException( this.name() ) ;
        }
    }
}




