package com.kddi.android.UtaPass.sqa_espresso.pages.library.songs ;


import com.kddi.android.UtaPass.sqa_espresso.common.LazyUiAutomatorString;
import com.kddi.android.UtaPass.sqa_espresso.common.StringObject;
import com.kddi.android.UtaPass.sqa_espresso.common.UiAutomatorButton;
import com.kddi.android.UtaPass.sqa_espresso.common.UtaPassUtil;
import com.kddi.android.UtaPass.sqa_espresso.common.ViewObject;


public class PermissionPopupMessage extends ViewObject {

    public static final String MESSAGE_IN_ENGLISH = "Allow Uta Pass to access photos, media, and files on your device?" ;
    public static final String MESSAGE_IN_JAPANSE = "" ;

    private UiAutomatorButton denyButton ;
    private UiAutomatorButton allowButton ;
    private LazyUiAutomatorString message ;

    public UiAutomatorButton allowButton() {
        if( this.allowButton == null ) {
            this.allowButton = new UiAutomatorButton( () ->
                    UtaPassUtil.findObjectByResourceId(
                        "com.android.packageinstaller:id/permission_allow_button" ) ) {

                public String name() {
                    return "Library > Songs > Permission > Allow Button" ;
                }
            } ;
        }
        return this.allowButton ;
    }

    public UiAutomatorButton denyButton() {
        if( this.denyButton == null ) {
            this.denyButton = new UiAutomatorButton( () ->
                    UtaPassUtil.findObjectByResourceId(
                            "com.android.packageinstaller:id/permission_deny_button" ) ) {

                public String name() {
                    return "Library > Songs > Permission > Deny Button" ;
                }
            } ;
        }
        return this.denyButton ;
    }

    public StringObject message() {
        if( this.message == null ) {
            String resourceId = "com.android.packageinstaller:id/permission_message" ;
            this.message = new LazyUiAutomatorString( () ->
                    UtaPassUtil.findObjectByResourceId( resourceId ) ) {


                public String name() {
                    return "Library > Songs > Permission > Message" ;
                }
            } ;
        }

        return this.message.text() ;
    }

    public boolean isVisible() {
        return this.allowButton().isVisible() &&
               this.denyButton().isVisible() &&
               this.message().isVisible() ;
    }
}
