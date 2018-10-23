package com.kddi.android.UtaPass.sqa_espresso.pages.stream.common ;

import android.view.View;

import com.kddi.android.UtaPass.R;
import com.kddi.android.UtaPass.sqa_espresso.common.BasicButton;
import com.kddi.android.UtaPass.sqa_espresso.common.LazyMatcher;
import com.kddi.android.UtaPass.sqa_espresso.common.LazyString;
import com.kddi.android.UtaPass.sqa_espresso.common.ViewObject;
import com.kddi.android.UtaPass.sqa_espresso.common.exceptions.InvisibleException;

import org.hamcrest.Matcher;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

public class SaveMyUtaPopupMessage extends ViewObject {
    private Matcher<View> matcher ;

    public SaveMyUtaPopupMessage() {
        this.matcher = withId( R.id.parentPanel ) ;

        this.label( "SaveMyUtaPopupMessage" ) ;
        this.retryWhenNotReady( false ) ;
    }

    public void _ready() {
        this.title().ready() ;
        this.message().ready() ;
        this.saveButton().ready() ;
        this.cancelButton().ready() ;
    }

    public LazyString title() {
        return new LazyString(
                this.label() + " > title",
                () -> withId( R.id.alertTitle ) ) ;
    }

    public LazyString message() {
        return new LazyString(
                this.label() + " > title",
                () -> withId( android.R.id.message ) ) ;
    }

    public void assertVisible() {
        if( ! isVisible() ) {
            throw new InvisibleException( this.label() ) ;
        }
    }

    public boolean isVisible() {
        return this.isVisible( this.matcher ) ;
    }

    public BasicButton saveButton() {
        return new BasicButton(
               this.label() + " > saveButton",
                () -> withId( android.R.id.button1 ) ) ;
    }

    public BasicButton cancelButton() {
        return new BasicButton(
                this.label() + " > cancelButton",
                () -> withId( android.R.id.button2 ) ) ;
    }
}
