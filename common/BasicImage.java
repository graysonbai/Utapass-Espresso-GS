package com.kddi.android.UtaPass.sqa_espresso.common ;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;


public class BasicImage extends ViewObject {

    protected LazyMatcher matcher ;

    public BasicImage( LazyMatcher matcher ) {
        this.matcher = matcher ;
    }

    public void tap() {
        onView( this.matcher.execute() ).perform( click() ) ;
    }

    public boolean isVisible() {
        return this.isVisible( this.matcher.execute() ) ;
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
}




