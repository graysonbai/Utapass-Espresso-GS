package com.kddi.android.UtaPass.sqa_espresso.pages.settings ;

import com.kddi.android.UtaPass.R;
import com.kddi.android.UtaPass.sqa_espresso.common.LazyString;
import com.kddi.android.UtaPass.sqa_espresso.common.StringObject;
import com.kddi.android.UtaPass.sqa_espresso.common.UtaPassUtil;
import com.kddi.android.UtaPass.sqa_espresso.common.ViewObject;
import com.kddi.android.UtaPass.sqa_espresso.common.WebButton;

import static android.support.test.espresso.matcher.ViewMatchers.isDescendantOfA;
import static android.support.test.espresso.matcher.ViewMatchers.withClassName;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.CoreMatchers.endsWith;
import static org.hamcrest.core.AllOf.allOf;


public class IdSettingsPage extends ViewObject {

    private LazyString titleBar ;
    private WebButton okButton ;

    public void _ready() {
        this.titleBar().assertVisible() ;
        this.titleBar().assertEquals( "ID設定" ) ;
        this.okButton().assertVisible() ;
    }

    public WebButton okButton() {
        if( this.okButton == null ) {
            this.okButton = new WebButton( () ->
                    UtaPassUtil.findObjectInWebView( "android.widget.Button", 0 ) ) {

                public String name() {
                    return "AuidSettingPage > OkButton" ;
                }
            } ;
        }
        return this.okButton ;
    }

    public StringObject titleBar() {
        if( this.titleBar == null ) {
            this.titleBar = new LazyString( () -> UtaPassUtil.withIndex(
                    allOf( withClassName( endsWith( "TextView" ) ),
                           isDescendantOfA( withId( R.id.action_bar ) ) ),
                    0 ) ) {

                public String name() {
                    return "AuidSettingPage > Title" ;
                }
            } ;
        }

        return this.titleBar.text() ;
    }
    public boolean isVisible() {
        return this.okButton().isVisible() && this.titleBar().isVisible() ;
    }
}
