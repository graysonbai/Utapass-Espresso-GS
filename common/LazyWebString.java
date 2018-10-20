package com.kddi.android.UtaPass.sqa_espresso.common ;

import android.support.test.uiautomator.UiObjectNotFoundException;

import com.kddi.android.UtaPass.sqa_espresso.common.exceptions.StringException;


public class LazyWebString extends ViewObject {

    protected LazyWebMatcher matcher ;

    public LazyWebString( LazyWebMatcher matcher ) {
        this.matcher = matcher ;
    }

    public void tap() {
        this.assertVisible() ;

        try {
            this.matcher.execute().click();

        } catch( UiObjectNotFoundException e ) {
            this.dprint( e.getMessage() ) ;
        }
    }

    public boolean isVisible() {
        return this.matcher.execute().exists() ;
    }

    public StringObject text() {
        try {
            StringObject strObj = new StringObject( this.matcher.execute().getText() ) ;
            strObj.label( this.label() ) ;
            return strObj ;

        } catch( UiObjectNotFoundException e ) {
            this.dprint( e.getMessage() ) ;

            return new StringObject( "" ) ;
        }
    }

    public void assertVisible() {
        if( ! this.isVisible() ) {
            throw new StringException( "Actual: InVisible, Expecting: Visible" ) ;
        }
    }

    public void assertInvisible() {
        if( this.isVisible() ) {
            throw new StringException( "Actual: Visible, Expecting: InVisible" ) ;
        }
    }


    public void assertEquals( StringObject expecting ) {
        this.text().assertEquals( expecting.string() ) ;
    }

    public void assertEquals( String expecting ) {
        this.text().assertEquals( expecting ) ;
    }

    public void assertEquals( int expecting ) {
        this.assertEquals( String.valueOf( expecting ) ) ;
    }


    public void assertNotEquals( StringObject expecting ) {
        this.text().assertNotEquals( expecting.string() ) ;
    }

    public void assertNotEquals( String expecting ) {
        this.text().assertNotEquals( expecting ) ;
    }

    public void assertNotEquals( int expecting ) {
        this.assertNotEquals( String.valueOf( expecting ) ) ;
    }
}




