package com.kddi.android.UtaPass.sqa_espresso.common ;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;


public class BasicButton extends ViewObject {

    private LazyMatcher matcher ;

    public BasicButton( LazyMatcher matcher ) {
        this.matcher = matcher ;
    }

    public void tap() {
        onView( this.matcher.execute() ).perform( click() ) ;
    }

    public boolean isVisible() {
        return this.isVisible( this.matcher.execute() ) ;
    }

    public String text() {
        return this.getText( this.matcher.execute() ) ;
    }
}




