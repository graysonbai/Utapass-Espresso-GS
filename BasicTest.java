package com.kddi.android.UtaPass.sqa_espresso ;


import androidx.test.rule.ActivityTestRule;

import com.kddi.android.UtaPass.main.MainActivity;
import com.kddi.android.UtaPass.sqa_espresso.common.Navigator;
import com.kddi.android.UtaPass.sqa_espresso.common.RunningStatus;
import com.kddi.android.UtaPass.sqa_espresso.common.TestRailId;
import com.kddi.android.UtaPass.sqa_espresso.common.UserStatus;
import com.kddi.android.UtaPass.sqa_espresso.common.UtaPassUtil;
import com.kddi.android.UtaPass.sqa_espresso.common.toolkit.QuotaControl;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;

import java.lang.reflect.Method;


public class BasicTest {

    protected Navigator navigator = new Navigator() ;

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>( MainActivity.class ) ;

    @Before
    public void pre_condition() {
        this.ensureLogin() ;
        this.resetQuota();
        this.ensureMyUtaPageIsEmpty();
        this.navigator.streamTab()
                      .tap() ;
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

    public void resetQuota(){
        this.navigator.streamPage()
                      .sideBarButton()
                      .tap() ;

        this.navigator.sideBarMenu()
                      .lineUp()
                      .card( 1 )
                      .title()
                      .tap() ;

        String auid = this.navigator.debugUtilPage()
                      .getMsno()
                      .string();

        resetQuota( auid );
        UtaPassUtil.pressBack();
    }

    public void resetQuota( String auid ) {
        QuotaControl quotaControl = new QuotaControl( auid );
        quotaControl.revokeAllQuota();
        quotaControl.get10Quota();
    }

    private void enterMyUtaPage(){
        this.navigator.libraryTab()
                      .tap();

        UtaPassUtil.swipeDown();

        UtaPassUtil.swipeDown();

        this.navigator.libraryPage()
                      .myUtaCategory()
                      .tap();
    }

    private void ensureMyUtaPageIsEmpty(){
        this.enterMyUtaPage();

        if ( this.navigator.myUtaPage().tooltip().isVisible() ){
            this.navigator.myUtaPage()
                    .tooltip()
                    .tap() ;
        }

        while ( !this.navigator.emptyMyUtaPage().title().isVisible() ) {
            this.navigator.myUtaPage()
                    .lineUp()
                    .card(0)
                    .moreActionsButton()
                    .tap() ;

            if( !this.navigator.songMoreActionMenu().deleteSongMenuItem().isVisible() ){
                this.navigator.myUtaPage()
                        .lineUp()
                        .card(0)
                        .moreActionsButton()
                        .tap() ;
            }

            this.navigator.songMoreActionMenu()
                    .deleteSongMenuItem()
                    .tap() ;

            this.navigator.deleteMyUtaConfirmPopupMessage()
                    .deleteButton()
                    .tap() ;
        }
    }

    private void ensureBackToStreamPage(){
        this.navigator.streamTab()
                      .tap() ;
        this.navigator.libraryTab()
                      .tap() ;
        this.navigator.streamTab()
                      .tap() ;
    }

    private void ensureCloseNowPlayingBar(){
        this.ensureBackToStreamPage() ;
        this.navigator.streamPage()
                      .liveModule()
                      .lineUp()
                      .card( 1 )
                      .playButton()
                      .tap() ;
    }

    @After
    public void tear_down() {
        this.updateTestCaseName() ;
        UtaPassUtil.disableScreenShot() ;
        this.ensureCloseNowPlayingBar() ;
        UtaPassUtil.enableScreenShot() ;
        UtaPassUtil.closeApp() ;
        this.resetTestCaseName() ;
    }

    public void sleep( int seconds, String info ) {
        UtaPassUtil.sleep( seconds, info ) ;
    }

    public void sleep( int seconds ) {
        UtaPassUtil.sleep( seconds ) ;
    }


    protected void updateTestCaseInfo() {

        // since we use stacktrace to retrieve className and methodName,
        // it will be complex if we move related logic to another method.
        // Thus, keep it here ...
        String clazzName = Thread.currentThread()
                                 .getStackTrace()[ 3 ]
                                 .getClassName() ;

        String methodName = Thread.currentThread()
                                  .getStackTrace()[ 3 ]
                                  .getMethodName() ;

        // record methodName so that we can see which method the debug message comes from
        RunningStatus.caseName = methodName ;

        // check if method is annotated
        Method method = this.handleExceptionWhenReflecting( clazzName, methodName ) ;
        if( ! method.isAnnotationPresent( TestRailId.class ) ) {
            return ;
        }

        for( String id: method.getAnnotation( TestRailId.class ).value() ) {
            UtaPassUtil.dprint( "TestRailId: " + id ) ;
        }
    }

    private void updateTestCaseName() {
        RunningStatus.caseName = Thread.currentThread()
                                       .getStackTrace()[ 3 ]
                                       .getMethodName() ;
    }

    protected void resetTestCaseName() {
        RunningStatus.caseName = "" ;
    }


    protected Method handleExceptionWhenReflecting( String clazzName, String methodName ) {
        try {
            return Class.forName( clazzName ).getDeclaredMethod( methodName ) ;
        }

        catch( ClassNotFoundException exp ) {
            return null ;
        }

        catch( NoSuchMethodException exp ) {
            return null ;
        }
    }
}


