package com.kddi.android.UtaPass.sqa_espresso.common ;

import com.kddi.android.UtaPass.sqa_espresso.common.exceptions.InvalidStateException;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;


public class BasicButton extends ViewObject {

    protected LazyMatcher matcher ;

    public BasicButton( LazyMatcher matcher ) {
        this.matcher = matcher ;
    }

    public LazyMatcher matcher() {
        return this.matcher ;
    }

    public void tap() {
        this.assertVisible() ;

        onView( this.matcher.execute() ).perform( click() ) ;
    }

    public boolean isVisible() {
        return this.isVisible( this.matcher.execute() ) ;
    }

    public LazyString text() {
        return new LazyString( this.matcher ) ;
    }

    public void _ready() {
        if( ! this.isVisible() ) {
            String msg = "NotReady: " + this.name() ;
            throw new RuntimeException( msg ) ;
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




