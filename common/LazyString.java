package com.kddi.android.UtaPass.sqa_espresso.common ;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;


public class LazyString extends StringObject {

    protected LazyMatcher matcher ;

    public LazyString( LazyMatcher matcher ) {
        this.matcher = matcher ;
    }

    public void tap() {
        onView( this.matcher.execute() ).perform( click() ) ;
    }

    public boolean isVisible() {
        return this.isVisible( this.matcher.execute() ) ;
    }

    public String toString() {
        return this.getText( this.matcher.execute() ) ;
    }

    public String string() {
        this.ready() ;
        return this.getText( this.matcher.execute() ) ;
    }

    public StringObject text() {
        return new StringObject( this.string() ) ;
    }


    // ========================================
    // Equals & NotEquals
    // ========================================
    public boolean isEquals( LazyString expecting ) {
        return this.isEquals( expecting.string() ) ;
    }

    public void assertEquals( LazyString expecting ) {
        this.assertEquals( expecting.string() ) ;
    }

    public void assertNotEquals( LazyString expecting ) {
        this.assertNotEquals( expecting.string() ) ;
    }

    // ========================================
    // LessThan
    // ========================================
    public boolean isLessThan( LazyString expecting ) {
        return this.isLessThan( expecting.string() ) ;
    }

    public void assertLessThan( LazyString expecting ) {
        this.assertLessThan( expecting.string() ) ;
    }

    public void assertLessThan( LazyString expecting, String diff ) {
        this.assertLessThan( expecting.string(), diff ) ;
    }

    public void assertLessThan( LazyString expecting, int diff ) {
        this.assertLessThan( expecting.string(), diff ) ;
    }
}
