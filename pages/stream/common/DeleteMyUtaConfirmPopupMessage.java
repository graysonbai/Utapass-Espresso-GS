package com.kddi.android.UtaPass.sqa_espresso.pages.stream.common ;

import com.kddi.android.UtaPass.R;
import com.kddi.android.UtaPass.sqa_espresso.common.BasicButton;
import com.kddi.android.UtaPass.sqa_espresso.common.ViewObject;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

public class DeleteMyUtaConfirmPopupMessage extends ViewObject {

    private CancelButton cancelButton ;
    private DeleteButton deleteButton ;

    public DeleteMyUtaConfirmPopupMessage() {
        this.item = onView( withId( R.id.parentPanel ) ) ;
    }

    public void _ready() {
        if( !this.isVisible( this.item ) ) {
            String component = "Library > MyUta > Song > MoreAction > Delete > ConfirmPopupMessage" ;
            throw new RuntimeException( "NotReady: " + component ) ;
        }
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

    public CancelButton cancelButton() {
        if( this.cancelButton == null ) {
            this.cancelButton = new CancelButton() ;
        }
        return this.cancelButton ;
    }

    public DeleteButton deleteButton() {
        if( this.deleteButton == null ) {
            this.deleteButton = new DeleteButton() ;
        }
        return this.deleteButton ;
    }

    public class CancelButton extends BasicButton {

        public CancelButton() {
            super( "cancelButton", () -> withId( android.R.id.button2 ) ) ;
        }
    }

    public class DeleteButton extends BasicButton {
        public DeleteButton() {
            super( "DeleteButton", () -> withId( android.R.id.button1 ) ) ;
        }
    }
}
