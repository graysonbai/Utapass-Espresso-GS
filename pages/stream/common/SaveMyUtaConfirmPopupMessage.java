package com.kddi.android.UtaPass.sqa_espresso.pages.stream.common ;

import android.view.View;

import com.kddi.android.UtaPass.R;
import com.kddi.android.UtaPass.sqa_espresso.common.UtaPassUtil;
import com.kddi.android.UtaPass.sqa_espresso.common.ViewObject;

import org.hamcrest.Matcher;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withChild;
import static android.support.test.espresso.matcher.ViewMatchers.withClassName;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.endsWith;
import static org.hamcrest.core.AllOf.allOf;

public class SaveMyUtaConfirmPopupMessage extends ViewObject {

    private CloseButton closeButton ;

    public SaveMyUtaConfirmPopupMessage() {
        this.item = onView( this.matcher() ) ;

        this.closeButton = new CloseButton() ;
    }

    public void _ready() {
        if( !this.isVisible( this.item ) ) {
            throw new RuntimeException(
                    String.format( "NotDisplayed: '%s'",
                                   this.getClass().getSimpleName() ) ) ;
        }
    }

    protected Matcher<View> matcher() {
        return UtaPassUtil.withIndex(
                    allOf( withClassName( endsWith( "LinearLayout" ) ),
                           withChild( withId( R.id.myuta_saved_confirm ) ) ),
                    0
        ) ;
    }

    public String title() {
        return this.getText(
                UtaPassUtil.withIndex( withClassName( endsWith( "TextView" ) ), 0 ) ) ;
    }

    public String message() {
        return this.getText(
                UtaPassUtil.withIndex( withClassName( endsWith( "TextView" ) ), 1 ) ) ;
    }

    public boolean isVisible() {
        return this.isVisible( this.item ) ;
    }

    public CloseButton closeButton() {
        return this.closeButton ;
    }

    public void close() {
        this.closeButton().tap() ;
    }


    // ==============================
    // supporting class
    // ==============================
    public class CloseButton extends ViewObject {
        public CloseButton() {
            this.item = onView( this.matcher() ) ;
        }

        protected Matcher<View> matcher() {
            return withId( R.id.myuta_saved_confirm ) ;
        }

        public String text() {
            return this.getText( this.item ) ;
        }

        public void tap() {
            this.item.perform( click() ) ;
        }
    }
}
