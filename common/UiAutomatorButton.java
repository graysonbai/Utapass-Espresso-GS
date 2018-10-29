package com.kddi.android.UtaPass.sqa_espresso.common ;

import android.support.test.uiautomator.UiObjectNotFoundException;
import android.view.View;

import com.kddi.android.UtaPass.sqa_espresso.common.exceptions.ButtonInvisibleException;
import com.kddi.android.UtaPass.sqa_espresso.common.exceptions.ButtonVisibleException;

import org.hamcrest.Matcher;


public class UiAutomatorButton extends ViewObject {
    protected LazyUiAutomatorMatcher matcher ;

    public UiAutomatorButton( String label, LazyUiAutomatorMatcher matcher ) {
        this.label( label ) ;
        this.matcher = matcher ;
    }

    public UiAutomatorButton( LazyUiAutomatorMatcher matcher ) {
        this.label( "UnknownButton" ) ;
        this.matcher = matcher ;
    }

    public LazyUiAutomatorMatcher matcher() {
        return this.matcher ;
    }

    public void tap() {
        this.ready() ;

        try {
            UtaPassUtil.dprint_tap( this.label() ) ;
            this.matcher().execute().click() ;

        } catch( UiObjectNotFoundException e ) {
            throw new ButtonInvisibleException( this.label() ) ;
        }
    }

    public boolean isVisible() {
        return this.matcher().execute().exists() ;
    }

    public LazyUiAutomatorString text() {
        return new LazyUiAutomatorString( this.matcher() ) ;
    }

    public void _ready() {
        this.assertVisible() ;
    }

    public void assertVisible() {
        if( ! this.isVisible() ) {
            throw new ButtonInvisibleException( this.label() ) ;
        }
    }

    public void assertInvisible() {
        if( this.isVisible() ) {
            throw new ButtonVisibleException( this.label() ) ;
        }
    }
}




