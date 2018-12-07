package com.kddi.android.UtaPass.sqa_espresso.pages.common ;

import com.kddi.android.UtaPass.R ;
import com.kddi.android.UtaPass.sqa_espresso.common.BasicImage;
import com.kddi.android.UtaPass.sqa_espresso.common.UtaPassUtil;
import com.kddi.android.UtaPass.sqa_espresso.common.ViewObject;
import com.kddi.android.UtaPass.sqa_espresso.common.exceptions.InvisibleException;
import com.kddi.android.UtaPass.sqa_espresso.common.exceptions.VisibleException;

import android.view.View ;

import org.hamcrest.Matcher;

import static android.support.test.espresso.matcher.ViewMatchers.isCompletelyDisplayed;

import static android.support.test.espresso.Espresso.onView ;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.isDescendantOfA;
import static android.support.test.espresso.matcher.ViewMatchers.withId ;
import static org.hamcrest.Matchers.* ;


public class BasicNowPlayingBar extends ViewObject {

    public BasicNowPlayingBar() {
        this.label( "NowPlayingBar" ) ;
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
        return this.isVisible( this.matcher() ) ;
    }

    public Matcher<View> matcher() {
        return UtaPassUtil.withIndex(
                allOf( withId( R.id.view_indicator_layout ),
                        isCompletelyDisplayed() ), 0 );
    }

    public BasicImage cover() {
        return new BasicImage( String.format( "%s > Cover", this.label() ),
                () -> allOf( withId( R.id.indicator_album_cover ),
                        isDescendantOfA( this.matcher() ) ) ) ;
    }

    public void tap() {
        this.dprint_tap() ;
        this.handleException(
                () -> onView( this.matcher() ).perform( click() ) ) ;
    }
}
