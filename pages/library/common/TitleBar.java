package com.kddi.android.UtaPass.sqa_espresso.pages.library.common ;

import android.support.test.espresso.ViewInteraction;
import android.support.test.espresso.action.ViewActions;
import android.view.View;

import com.kddi.android.UtaPass.R;
import com.kddi.android.UtaPass.sqa_espresso.common.UtaPassUtil;
import com.kddi.android.UtaPass.sqa_espresso.common.ViewObject;

import org.hamcrest.Matcher;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.matcher.ViewMatchers.isDescendantOfA;
import static android.support.test.espresso.matcher.ViewMatchers.withClassName;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.endsWith;

public class TitleBar extends ViewObject {

    public TitleBar() {
        this.item = onView( this.matcher() ) ;
    }

    public void _ready() {
        if( !this.isVisible( this.item ) ) {
            throw new RuntimeException( "TitleBar is not visible" ) ;
        }
    }

    protected Matcher<View> matcher() {
        return withId( R.id.browse_toolbar ) ;
    }

    public String title() {
        return this.getText(
                UtaPassUtil.withIndex(
                        allOf( withClassName( endsWith( "TextView" ) ),
                               isDescendantOfA( this.matcher() ) ),
                        0 ) ) ;
    }

    public boolean isVisible() {
        return this.isVisible( this.item ) ;
    }

    public void swipeUp() {
        this.item.perform( ViewActions.swipeUp() ) ;
    }
}
