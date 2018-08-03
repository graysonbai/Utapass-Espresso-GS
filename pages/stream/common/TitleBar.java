package com.kddi.android.UtaPass.sqa_espresso.pages.stream.common ;

import android.view.View;

import com.kddi.android.UtaPass.R;
import com.kddi.android.UtaPass.sqa_espresso.common.ViewObject;

import org.hamcrest.Matcher;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

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
        return withId( R.id.detail_editor_title ) ;
    }

    public String title() {
        return this.getText( this.matcher() ) ;
    }

    public boolean isVisible() {
        return this.isVisible( this.item ) ;
    }
}
