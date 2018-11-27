package com.kddi.android.UtaPass.sqa_espresso.common ;

import com.kddi.android.UtaPass.sqa_espresso.common.exceptions.InvisibleException;
import com.kddi.android.UtaPass.sqa_espresso.common.exceptions.VisibleException;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;


public class BasicImage extends ViewObject {
    protected LazyMatcher matcher ;

    public BasicImage( String label, LazyMatcher matcher ) {
        this.label( label ) ;
        this.matcher = matcher ;
    }

    public BasicImage( LazyMatcher matcher ) {
        this.label( "BasicImage: LabelNotAssigned" ) ;
        this.matcher = matcher ;
    }

    public void _ready() {
        this.assertVisible() ;
    }

    public void assertVisible() {
        if( ! this.isVisible() ) {
            throw new InvisibleException( this.label() ) ;
        }
    }

    public void assertInvisible() {
        if( this.isVisible() ) {
            throw new VisibleException( this.label() ) ;
        }
    }

    public boolean isVisible() {
        return this.isVisible( this.matcher.execute() ) ;
    }

    public void tap() {
        this.dprint_tap() ;
        onView( this.matcher.execute() ).perform( click() ) ;
    }
}




