package com.kddi.android.UtaPass.sqa_espresso.pages.stream.common ;

import android.view.View;

import com.kddi.android.UtaPass.sqa_espresso.common.ViewObject;

import org.hamcrest.Matcher;

import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.Matchers.allOf;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static android.support.test.espresso.matcher.ViewMatchers.isDescendantOfA;
import static android.support.test.espresso.action.ViewActions.click;


public class SeeAllButton extends ViewObject {

    public SeeAllButton( final Matcher<View> parent_matcher ) {
        this.item = onView( anyOf(
                allOf( withText( "See All" ),   isDescendantOfA( parent_matcher ) ),
                allOf( withText( "すべて見る" ), isDescendantOfA( parent_matcher ) ) ) ) ;
    }

    public void tap() {
        this.item.perform( click() ) ;
    }

    public boolean isVisible() {
        return this.isVisible( this.item ) ;
    }

    public String text() {
        return this.getText( this.item ) ;
    }
}




