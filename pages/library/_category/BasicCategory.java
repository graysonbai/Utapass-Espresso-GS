package com.kddi.android.UtaPass.sqa_espresso.pages.library._category ;

import android.view.View ;

import com.kddi.android.UtaPass.sqa_espresso.common.ViewObject;

import org.hamcrest.Matcher;

import static android.support.test.espresso.Espresso.onView ;
import static android.support.test.espresso.action.ViewActions.click ;

public abstract class BasicCategory extends ViewObject {

    public void _ready() {
        if( !this.isVisible( this.getMatcherForItem() ) ) {
            throw new RuntimeException( String.format(
                    "'%s' is not visible",
                    this.getClass().getSimpleName() ) ) ;
        }
    }

    public void tap() {
        this.dprint( String.format( "Tap '%s'", this.getClass().getSimpleName() ) ) ;
        onView( this.getMatcherForItem() ).perform( click() ) ;
    }

    protected abstract Matcher<View> getMatcherForItem() ;
}
