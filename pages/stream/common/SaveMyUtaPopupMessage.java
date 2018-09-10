package com.kddi.android.UtaPass.sqa_espresso.pages.stream.common ;

import android.view.View;

import com.kddi.android.UtaPass.R;
import com.kddi.android.UtaPass.sqa_espresso.common.ViewObject;

import org.hamcrest.Matcher;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

public class SaveMyUtaPopupMessage extends ViewObject {

    private SaveButton saveButton ;
    private CancelButton cancelButton ;

    public SaveMyUtaPopupMessage() {
        this.item = onView( this.matcher() ) ;

        this.saveButton = new SaveButton() ;
        this.cancelButton = new CancelButton() ;
    }

    public void _ready() {
        if( !this.isVisible( this.item ) ) {
            throw new RuntimeException( "PopupMessage: 'Save song to MyUta' is not displayed" ) ;
        }
    }

    protected Matcher<View> matcher() {
        return withId( R.id.parentPanel ) ;
    }

    public String title() {
        return this.getText( withId( R.id.alertTitle ) ) ;
    }

    public String message() {
        return this.getText( withId( android.R.id.message ) ) ;
    }

    public boolean isVisible() {
        return this.isVisible( this.item ) ;
    }

    public SaveButton saveButton() {
        return this.saveButton ;
    }

    public void save() {
        this.saveButton().tap() ;
    }

    public CancelButton cancelButton() {
        return this.cancelButton ;
    }

    public void cancel() {
        this.cancelButton().tap() ;
    }


    // ==============================
    // supporting class
    // ==============================
    public class SaveButton extends ViewObject {
        public SaveButton() {
            this.item = onView( this.matcher() ) ;
        }

        protected Matcher<View> matcher() {
            return withId( android.R.id.button1 ) ;
        }

        public String text() {
            return this.getText( this.item ) ;
        }

        public void tap() {
            this.item.perform( click() ) ;
        }
    }

    public class CancelButton extends ViewObject {
        public CancelButton() {
            this.item = onView( this.matcher() ) ;
        }

        protected Matcher<View> matcher() {
            return withId( android.R.id.button2 ) ;
        }

        public String text() {
            return this.getText( this.item ) ;
        }

        public void tap() {
            this.item.perform( click() ) ;
        }
    }
}
