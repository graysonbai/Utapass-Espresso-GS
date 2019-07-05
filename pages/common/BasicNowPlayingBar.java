package com.kddi.android.UtaPass.sqa_espresso.pages.common ;

import android.view.View;

import com.kddi.android.UtaPass.R;
import com.kddi.android.UtaPass.sqa_espresso.common.BasicImage;
import com.kddi.android.UtaPass.sqa_espresso.common.UtaPassUtil;
import com.kddi.android.UtaPass.sqa_espresso.common.ViewObject;
import com.kddi.android.UtaPass.sqa_espresso.common.exceptions.InvisibleException;
import com.kddi.android.UtaPass.sqa_espresso.common.exceptions.VisibleException;

import org.hamcrest.Matcher;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.isCompletelyDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isDescendantOfA;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.allOf;


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
