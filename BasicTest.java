package com.kddi.android.UtaPass.sqa_espresso ;

import android.support.test.rule.ActivityTestRule;

import com.kddi.android.UtaPass.main.MainActivity;
import com.kddi.android.UtaPass.sqa_espresso.common.Navigator;
import com.kddi.android.UtaPass.sqa_espresso.common.UserStatus;
import com.kddi.android.UtaPass.sqa_espresso.common.UtaPassUtil;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;

// to support GrantPermissionRule, need to upgrade 'androidSupportTestVersion' to '>= 1.0.2'
//import static android.Manifest.permission.*;
//import android.support.test.rule.GrantPermissionRule;


public class BasicTest {

    protected Navigator navigator = new Navigator() ;

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule =
            new ActivityTestRule<>( MainActivity.class ) ;

    @Before
    public void pre_condition() {
        this.ensureLogin() ;
        this.grantAllPermissions() ;
    }

    public void ensureLogin() {
        if( UserStatus.isLogin ) {
            return ;
        }

        this.navigator.streamPage()
                      .sideBarButton()
                      .tap() ;

        // loginButton invisible means it is logged in
        if( ! this.navigator.sideBarMenu()
                            .loginButton()
                            .isVisible() ) {

            UserStatus.isLogin = true ;
            UtaPassUtil.pressBack() ;
            return ;
        }

        this.navigator.sideBarMenu()
                      .loginButton()
                      .tap() ;

        this.sleep(5, "display AUID setting page" ) ;

        this.navigator.idSettingsPage()
                      .okButton()
                      .tap() ;

        UserStatus.isLogin = true ;
        this.navigator.streamPage() ;
    }

    public void grantAllPermissions() {
        if( UserStatus.isReadExternalStorageGranted ) {
            return ;
        }

        this.navigator.streamPage()
                      .libraryTab()
                      .tap() ;

        this.navigator.libraryPage()
                      .songsCategory()
                      .tap() ;

        this.sleep( 5, "Library > Songs, PermissionPopupMessage may display" ) ;

        if( this.navigator.permissionPopupMessage()
                          .isVisible() ) {

            this.navigator.permissionPopupMessage()
                          .allowButton()
                          .tap() ;
        }

        UserStatus.isReadExternalStorageGranted = true ;

        this.navigator.streamTab()
                      .tap() ;

        this.navigator.streamPage() ;
    }

    @After
    public void tear_down() {
        UtaPassUtil.stopNowPlayingBar() ;
        UtaPassUtil.closeApp() ;
    }

    public void sleep( int seconds, String info ) {
        UtaPassUtil.sleep( seconds, info ) ;
    }

    public void sleep( int seconds ) {
        UtaPassUtil.sleep( seconds ) ;
    }
}


