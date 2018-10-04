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
    }

    public void ensureLogin() {
        if( UserStatus.isLogin ) {
            return ;
        }

        // 2017.Q3+ devices will pop out AuidSettingsPage once launching UtaPass
        this.sleep( 10, "wait for AuidSettingsPage that may display." ) ;
        if( this.navigator.idSettingsPage().isVisible() ) {
            this.navigator.idSettingsPage()
                          .okButton()
                          .tap() ;

            UserStatus.isLogin = true ;
            return ;
        }

        this.navigator.streamPage()
                      .sideBarButton()
                      .tap() ;

        // loginButton invisible means it is logged in already
        if( ! this.navigator.sideBarMenu()
                            .quotaInfo()
                            .loginButton()
                            .isVisible() ) {

            UserStatus.isLogin = true ;
            UtaPassUtil.pressBack() ;
            return ;
        }

        this.navigator.sideBarMenu()
                      .quotaInfo()
                      .loginButton()
                      .tap() ;

        this.sleep( 5, "for stability to display AUID setting page" ) ;

        this.navigator.idSettingsPage()
                      .okButton()
                      .tap() ;

        UserStatus.isLogin = true ;

        this.navigator.streamPage() ;
    }

    @After
    public void tear_down() {
        UtaPassUtil.stopNowPlayingBar() ;
        UtaPassUtil.closeApp() ;

//        UtaPassUtil.setScreenOrientationNatural( this.mActivityRule ) ;
    }

    public void sleep( int seconds, String info ) {
        UtaPassUtil.sleep( seconds, info ) ;
    }

    public void sleep( int seconds ) {
        UtaPassUtil.sleep( seconds ) ;
    }
}


