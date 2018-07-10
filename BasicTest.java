package com.kddi.android.UtaPass.sqa_espresso ;

import com.kddi.android.UtaPass.sqa_espresso.RetryUnit ;

public class BasicTest {

    public void writeMsg( String msg ) {
        android.util.Log.d( "UtapassAutomation", msg ) ;
    }

    public void sleep( int seconds, String info ) {
        try {
            this.writeMsg( String.format( "Sleep %s second(s): %s", seconds, info ) ) ;
            Thread.sleep( seconds * 1000 ) ;

        } catch (InterruptedException ex) {
            android.util.Log.d("UtapassAutomation", ex.toString());
        }
    }

    public void sleep( int seconds ) {
        try {
            this.writeMsg( String.format( "Sleep %s second(s)...", seconds ) ) ;
            Thread.sleep( seconds * 1000 ) ;

        } catch (InterruptedException ex) {
            android.util.Log.d("UtapassAutomation", ex.toString());
        }
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
            this.writeMsg( msgWhenFail ) ;
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


