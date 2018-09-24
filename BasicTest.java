package com.kddi.android.UtaPass.sqa_espresso ;

import android.support.test.rule.ActivityTestRule;

import com.kddi.android.UtaPass.main.MainActivity;
import com.kddi.android.UtaPass.sqa_espresso.common.UtaPassUtil;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;

// to support GrantPermissionRule, need to upgrade 'androidSupportTestVersion' to '>= 1.0.2'
//import static android.Manifest.permission.*;
//import android.support.test.rule.GrantPermissionRule;


public class BasicTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule =
            new ActivityTestRule<>( MainActivity.class ) ;

//    @Rule
//    public GrantPermissionRule mRuntimePermissionRule =
//            GrantPermissionRule.grant( ACCESS_FINE_LOCATION, READ_EXTERNAL_STORAGE ) ;

    @Before
    public void pre_condition() {
//        UtaPassUtil.setScreenOrientationPortrait( this.mActivityRule ); ;
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


