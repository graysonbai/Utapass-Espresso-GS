package com.kddi.android.UtaPass.sqa_espresso ;

import com.kddi.android.UtaPass.sqa_espresso.common.UtaPassUtil;

public class BasicTest {

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

