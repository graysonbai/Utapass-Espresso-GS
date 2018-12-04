package com.kddi.android.UtaPass.sqa_espresso.pages ;

import com.kddi.android.UtaPass.R ;
import com.kddi.android.UtaPass.sqa_espresso.common.BasicButton;
import com.kddi.android.UtaPass.sqa_espresso.common.ViewObject;

import static android.support.test.espresso.matcher.ViewMatchers.isDescendantOfA;
import static android.support.test.espresso.matcher.ViewMatchers.withId ;
import static org.hamcrest.core.AllOf.allOf;

public class SettingsPage extends ViewObject {

    public SettingsPage() {
        this.label( "SettingsPage" );
    }

    public void _ready() {
    }

    public String id() {
        return this.getText( withId( R.id.settings_id_subtitle ) ) ;
    }

    public BasicButton highQualityButton(){
        return new BasicButton(
                this.label() + " > highQualityCheckBox",
                () -> allOf(
                        withId(R.id.settings_high_quality_checkbox ),
                        isDescendantOfA( withId( R.id.settings_high_quality_layout ) ) ) );
    }

    public BasicButton OkButton(){
        return new BasicButton(
                this.label() + " > okButton",
                () -> withId( android.R.id.button1 ) );
    }
}
