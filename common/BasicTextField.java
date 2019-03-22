package com.kddi.android.UtaPass.sqa_espresso.common ;

import com.kddi.android.UtaPass.sqa_espresso.common.exceptions.ButtonInvisibleException;
import com.kddi.android.UtaPass.sqa_espresso.common.exceptions.ButtonVisibleException;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.pressImeActionButton;
import static android.support.test.espresso.action.ViewActions.typeText;


public class BasicTextField extends ViewObject {
    protected LazyMatcher matcher ;

    public BasicTextField( String label, LazyMatcher matcher ) {
        this.label( label ) ;
        this.matcher = matcher ;
    }

    public BasicTextField( LazyMatcher matcher ) {
        this.label( "UnknownTextField" ) ;
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

    public void type( String text ) {
        this.ready() ;

        UtaPassUtil.dprint_type( this.label(), text ) ;
        onView( this.matcher.execute() ).perform( typeText( text ) ) ;
    }

    public void typeReturn( String text ) {
        this.ready() ;

        UtaPassUtil.dprint_type( this.label(), text ) ;
        onView( this.matcher.execute() ).perform( typeText( text ), pressImeActionButton() ) ;
        UtaPassUtil.sleep( 3 );
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




