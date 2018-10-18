package com.kddi.android.UtaPass.sqa_espresso.common ;

import com.kddi.android.UtaPass.sqa_espresso.common.exceptions.ButtonInvisibleException;
import com.kddi.android.UtaPass.sqa_espresso.common.exceptions.ButtonVisibleException;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;


public class BasicButton extends ViewObject {

    protected String label ;
    protected LazyMatcher matcher ;

    public BasicButton( String label, LazyMatcher matcher ) {
        this.label = label ;
        this.matcher = matcher ;
    }

    public BasicButton( LazyMatcher matcher ) {
        this.matcher = matcher ;
    }

    public LazyMatcher matcher() {
        return this.matcher ;
    }

    public void tap() {
        this.ready() ;

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
            String msg = "NotReady: " + this.label() ;
            throw new RuntimeException( msg ) ;
        }
    }

    public String label() {
        return this.label ;
    }

    @Deprecated
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




