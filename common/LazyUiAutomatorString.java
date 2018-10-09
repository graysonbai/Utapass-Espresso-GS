package com.kddi.android.UtaPass.sqa_espresso.common ;

import android.support.test.uiautomator.UiObjectNotFoundException;

import com.kddi.android.UtaPass.sqa_espresso.common.exceptions.StringInvisibleException;


public class LazyUiAutomatorString extends StringObject {

    protected LazyUiAutomatorMatcher matcher ;

    public LazyUiAutomatorString( LazyUiAutomatorMatcher matcher ) {
        this.matcher = matcher ;
    }

    public void tap() {
        this.ready() ;

        try {
            this.matcher.execute().click();

        } catch( UiObjectNotFoundException e ) {
            this.dprint( e.getMessage() ) ;
        }
    }

    public boolean isVisible() {
        return this.matcher.execute().exists() ;
    }

    public String string() {
        this.ready() ;

        try {
            return this.matcher.execute().getText() ;

        } catch( UiObjectNotFoundException e ) {
            this.dprint( e.getMessage() ) ;

            throw new StringInvisibleException( this.name() ) ;
        }
    }

    public StringObject text() {
        return new StringObject( this.string() ) ;
    }


    // ========================================
    // Equals & NotEquals
    // ========================================
    public boolean isEquals( LazyUiAutomatorString expecting ) {
        return this.isEquals( expecting.string() ) ;
    }

    public void assertEquals( LazyUiAutomatorString expecting ) {
        this.assertEquals( expecting.string() ) ;
    }

    public void assertNotEquals( LazyUiAutomatorString expecting ) {
        this.assertNotEquals( expecting.string() ) ;
    }

    // ========================================
    // LessThan
    // ========================================
    public boolean isLessThan( LazyUiAutomatorString expecting ) {
        return this.isLessThan( expecting.string() ) ;
    }

    public void assertLessThan( LazyUiAutomatorString expecting ) {
        this.assertLessThan( expecting.string() ) ;
    }

    public void assertLessThan( LazyString expecting, String diff ) {
        this.assertLessThan( expecting.string(), diff ) ;
    }

    public void assertLessThan( LazyString expecting, int diff ) {
        this.assertLessThan( expecting.string(), diff ) ;
    }

//    public void assertEquals( LazyUiAutomatorString expecting ) {
//        this.assertEquals( expecting.text() ) ;
//    }
//
//    public void assertNotEquals( LazyUiAutomatorString expecting ) {
//        this.assertNotEquals( expecting.text() ) ;
//    }
}




