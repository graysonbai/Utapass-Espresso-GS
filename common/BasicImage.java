package com.kddi.android.UtaPass.sqa_espresso.common ;

import com.kddi.android.UtaPass.sqa_espresso.common.exceptions.NotReadyException;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;


public class BasicImage extends ViewObject {
    protected String label ;
    protected LazyMatcher matcher ;

    public BasicImage( String label, LazyMatcher matcher ) {
        this.label = label ;
        this.matcher = matcher ;
    }

    public BasicImage( LazyMatcher matcher ) {
        this.matcher = matcher ;
    }

    public void _ready() {
        this.assertVisible() ;
    }

    public void assertVisible() {
        if( ! this.isVisible() ) {
            throw new NotReadyException( this.label() ) ;
        }
    }

    public boolean isVisible() {
        return this.isVisible( this.matcher.execute() ) ;
    }

    public String label() {
        return this.label ;
    }

    public void tap() {
        onView( this.matcher.execute() ).perform( click() ) ;
    }

    @Deprecated
    public String name() {
        return this.getClass().getSimpleName() ;
    }
}




