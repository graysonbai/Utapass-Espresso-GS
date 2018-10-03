package com.kddi.android.UtaPass.sqa_espresso.pages.settings ;

import android.support.test.uiautomator.UiSelector;

import com.kddi.android.UtaPass.R;
import com.kddi.android.UtaPass.sqa_espresso.common.LazyString;
import com.kddi.android.UtaPass.sqa_espresso.common.UtaPassUtil;
import com.kddi.android.UtaPass.sqa_espresso.common.ViewObject;
import com.kddi.android.UtaPass.sqa_espresso.common.WebButton;

import static android.support.test.espresso.matcher.ViewMatchers.withId ;

public class IdSettingsPage extends ViewObject {

    public void _ready() {
        this.okButton().assertVisible() ;
    }

    public LazyString id() {
        return new LazyString( () -> withId( R.id.settings_id_subtitle ) ) ;
    }

    public WebButton okButton() {
        return new WebButton( () -> UtaPassUtil.getUiDeviceInstance().findObject(
                new UiSelector().instance( 0 ).className( "android.widget.Button" ) ) ) {

            public String name() {
                return "AuidSettingPage > OkButton" ;
            }
        } ;
    }

    public boolean isVisible() {
        return this.okButton().isVisible() ;
    }
}
