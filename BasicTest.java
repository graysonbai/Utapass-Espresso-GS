package com.kddi.android.UtaPass.sqa_espresso ;

import android.support.test.rule.ActivityTestRule;

import com.kddi.android.UtaPass.main.MainActivity;
import com.kddi.android.UtaPass.sqa_espresso.common.Navigator;
import com.kddi.android.UtaPass.sqa_espresso.common.RunningStatus;
import com.kddi.android.UtaPass.sqa_espresso.common.UserStatus;
import com.kddi.android.UtaPass.sqa_espresso.common.UtaPassUtil;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;


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
        this.updateTestCaseName() ;

        if( UserStatus.isLogin ) {
            return ;
        }

        // 2017.Q3+ devices will pop out AuidSettingsPage once launching UtaPass
        if( this.navigator.idSettingsPage().isReady() ) {
            this.navigator.idSettingsPage()
                          .okButton()
                          .tap() ;

            this.sleep( 10, "LoginProcess may take time" ) ;
            UserStatus.isLogin = true ;

            this.navigator.streamPage() ;
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

    @After
    public void tear_down() {
        this.updateTestCaseName() ;
        UtaPassUtil.disableScreenShot() ;
        UtaPassUtil.stopNowPlayingBar() ;
        UtaPassUtil.enableScreenShot() ;
        this.navigator.streamPage().liveModule().lineUp().card( 0 ).playButton().tap() ;
        UtaPassUtil.closeApp() ;
        this.resetTestCaseName() ;
    }

    public void sleep( int seconds, String info ) {
        UtaPassUtil.sleep( seconds, info ) ;
    }

    public void sleep( int seconds ) {
        UtaPassUtil.sleep( seconds ) ;
    }


    protected void updateTestCaseName() {
        RunningStatus.caseName = Thread.currentThread()
                                       .getStackTrace()[ 3 ]
                                       .getMethodName() ;
    }

    protected void resetTestCaseName() {
        RunningStatus.caseName = "" ;
    }
}


