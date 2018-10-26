package com.kddi.android.UtaPass.sqa_espresso.common ;

import com.kddi.android.UtaPass.sqa_espresso.common.exceptions.ButtonInvisibleException;
import com.kddi.android.UtaPass.sqa_espresso.common.exceptions.ButtonVisibleException;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;


public class BasicButton extends ViewObject {
    protected LazyMatcher matcher ;

    public BasicButton( String label, LazyMatcher matcher ) {
        this.label( label ) ;
        this.matcher = matcher ;
    }

    public BasicButton( LazyMatcher matcher ) {
        this.label( "UnknownButton" ) ;
        this.matcher = matcher ;
    }

    public LazyMatcher matcher() {
        return this.matcher ;
    }

    public void tap() {
        this.ready() ;

        UtaPassUtil.dprint_tap( this.label() ) ;
        onView( this.matcher.execute() ).perform( click() ) ;
    }

    public boolean isVisible() {
        return this.isVisible( this.matcher.execute() ) ;
    }

    public LazyString text() {
        return new LazyString( this.label(), this.matcher ) ;
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




