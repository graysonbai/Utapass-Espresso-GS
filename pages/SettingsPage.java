package com.kddi.android.UtaPass.sqa_espresso.pages ;

import com.kddi.android.UtaPass.R ;
import com.kddi.android.UtaPass.sqa_espresso.common.ViewObject;

import static android.support.test.espresso.Espresso.onView ;
import static android.support.test.espresso.matcher.ViewMatchers.withId ;

public class SettingsPage extends ViewObject {

    public SettingsPage() {
        this.item = onView( withId( R.id.settings_scrollview ) ) ;
    }

    public void _ready() {
        if( ! this.isVisible( this.item ) ) {
            throw new RuntimeException( "Settings Page is not ready" ) ;
        }
    }

    public String id() {
        return this.getText( withId( R.id.settings_id_subtitle ) ) ;
    }
}
