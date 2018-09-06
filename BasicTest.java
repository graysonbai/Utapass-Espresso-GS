package com.kddi.android.UtaPass.sqa_espresso ;

import android.support.test.rule.ActivityTestRule;

import com.kddi.android.UtaPass.main.MainActivity;
import com.kddi.android.UtaPass.sqa_espresso.common.UtaPassUtil;

import org.junit.Rule;

public class BasicTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(MainActivity.class);

    public BasicTest() {
        UtaPassUtil.setActivityRule( this.mActivityRule ) ;
    }

    public void dprint( String msg ) {
        UtaPassUtil.dprint( msg ) ;
    }

    public void sleep( int seconds, String info ) {
        UtaPassUtil.sleep( seconds, info ) ;
    }

    public void sleep( int seconds ) {
        UtaPassUtil.sleep( seconds ) ;
    }

    public void retry( RetryUnit unit ) {
        boolean retryWhenNotReady = true ;
        int retryMaxCount = 3 ;
        int retryInterval = 10 ;
        int count = 0 ;

        while( true ) {
            try {
                if( ! unit.execute() ) {
                    throw new RuntimeException( "NowPlayingBar should be in playing status" ) ;
                }

                return ;

            } catch( Exception e ) {
                android.util.Log.d("UtapassAutomation", e.getMessage() ) ;

                if( ! retryWhenNotReady ) {
                    throw e ;
                }

                if( count++ == retryMaxCount ) {
                    throw e;
                }

                this.sleep( retryInterval, String.format( "(%s/%s)", count, retryMaxCount ) ) ;
            }
        }
    }

    public interface RetryUnit {
        boolean execute() ;
    }

    public void assertEqual( String actual, String expecting ) {
        this.assertTrue(
                () -> expecting.equals( actual ),
                String.format( "StringNotEqual: actual='%s', expecting='%s'",
                        actual,
                        expecting )
                ) ;
    }

    public void assertTrue( AssertTrue block, String msgWhenFail ) {
        try {
            this.assertTrue( block ) ;
        }
        catch( RuntimeException e ) {
            this.dprint( msgWhenFail ) ;
            throw e ;
        }
    }

    public void assertTrue( AssertTrue block ) {
        if( ! block.check() ) {
            throw new RuntimeException( "" ) ;
        }
    }

    public interface AssertTrue {
        boolean check() ;
    }
}


