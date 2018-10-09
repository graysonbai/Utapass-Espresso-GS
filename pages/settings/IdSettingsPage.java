package com.kddi.android.UtaPass.sqa_espresso.pages.settings ;

import android.support.test.uiautomator.UiSelector;

import com.kddi.android.UtaPass.sqa_espresso.common.LazyUiAutomatorString;
import com.kddi.android.UtaPass.sqa_espresso.common.StringObject;
import com.kddi.android.UtaPass.sqa_espresso.common.UiAutomatorButton;
import com.kddi.android.UtaPass.sqa_espresso.common.UtaPassUtil;
import com.kddi.android.UtaPass.sqa_espresso.common.ViewObject;
import com.kddi.android.UtaPass.sqa_espresso.common.exceptions.NotReadyException;


public class IdSettingsPage extends ViewObject {

    public static final String TITLE_IN_JAPANESE = "ID設定" ;
    public static final String MESSAGE_IN_JAPANESE = "次のau IDでログインします。" ;

    private UiAutomatorButton okButton ;
    private LazyUiAutomatorString title ;
    private LazyUiAutomatorString message ;
    private LazyUiAutomatorString id ;

    public IdSettingsPage() {
        this.retryWhenNotReady( false ) ;
    }

    public void _ready() {
        this.assertVisible() ;
    }

    public void assertVisible() {
        if( ! this.isVisible() ) {
            throw new NotReadyException( this.getClass().getSimpleName() ) ;
        }
    }

    public boolean isVisible() {
        return this.title().isVisible()
               && this.message().isVisible()
               && this.okButton().isVisible() ;
    }

    public UiAutomatorButton okButton() {
        if( this.okButton == null ) {
            this.okButton = new UiAutomatorButton( () -> UtaPassUtil.findObject(
                    new UiSelector().className( "android.widget.Button" )
                                    .text( "OK" ) ) ) {

                public String name() {
                    return "AuidSettingsPage > Ok Button" ;
                }
            } ;
        }
        return this.okButton ;
    }

    private LazyUiAutomatorString title() {
        if( this.title == null ) {
            this.title = new LazyUiAutomatorString( () -> UtaPassUtil.findObject(
                    new UiSelector().className( "android.widget.TextView" ) ) ) {

                public String name() {
                    return "AuidSettingsPage > Title" ;
                }
            } ;
        }

        return this.title ;
    }

    private LazyUiAutomatorString message() {
        if( this.message == null ) {
            this.message = new LazyUiAutomatorString( () -> UtaPassUtil.findObject(
                    new UiSelector().className( "android.view.View" ).index( 3 ) ) ) {

                public String name() {
                    return "AuidSettingsPage > Message" ;
                }
            } ;
        }

        return this.message ;
    }

    public StringObject id() {
        if( this.id == null ) {
            this.id = new LazyUiAutomatorString( () -> UtaPassUtil.findObject(
                    new UiSelector().resourceId( "auidAlias" ) ) ) {

                public String name() {
                    return "AuidSettingsPage > ID" ;
                }
            } ;
        }

        return this.id ;
    }
}
