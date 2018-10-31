package com.kddi.android.UtaPass.sqa_espresso.pages.settings ;

import android.support.test.uiautomator.UiSelector;

import com.kddi.android.UtaPass.sqa_espresso.common.LazyUiAutomatorString;
import com.kddi.android.UtaPass.sqa_espresso.common.StringObject;
import com.kddi.android.UtaPass.sqa_espresso.common.UiAutomatorButton;
import com.kddi.android.UtaPass.sqa_espresso.common.UtaPassUtil;
import com.kddi.android.UtaPass.sqa_espresso.common.ViewObject;


public class IdSettingsPage extends ViewObject {

    public static final String TITLE_IN_JAPANESE = "ID設定" ;
    public static final String MESSAGE_IN_JAPANESE = "次のau IDでログインします。" ;

    private UiAutomatorButton okButton ;
    private LazyUiAutomatorString title ;
    private LazyUiAutomatorString message ;
    private LazyUiAutomatorString id ;

    public IdSettingsPage() {
        this.label( "AuidSettingsPage" ) ;
    }

    public void _ready() {
        this.title().assertVisible() ;
        this.message().assertVisible() ;
        this.okButton().assertVisible() ;
    }

    public boolean isVisible() {
        return this.title().isVisible()
               && this.message().isVisible()
               && this.okButton().isVisible() ;
    }

    public UiAutomatorButton okButton() {
        return new UiAutomatorButton(this.label() + " > okButton",
                () -> UtaPassUtil.findObject(
                        new UiSelector().className( "android.widget.Button" ).text( "OK" ) ) ) ;
    }

    private LazyUiAutomatorString title() {
        return new LazyUiAutomatorString( this.label() + " > Title",
                () -> UtaPassUtil.findObject(
                        new UiSelector().className( "android.widget.TextView" ) ) ) ;

    }

    private LazyUiAutomatorString message() {
        return new LazyUiAutomatorString( this.label() + " > Message",
                () -> UtaPassUtil.findObject(
                        new UiSelector().className( "android.view.View" ).index( 3 ) ) ) ;
    }

    public StringObject id() {
        return new LazyUiAutomatorString( this.label() + " > ID",
                () -> UtaPassUtil.findObject(
                        new UiSelector().resourceId( "auidAlias" ) ) ) ;
    }
}
