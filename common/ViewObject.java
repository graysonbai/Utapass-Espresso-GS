package com.kddi.android.UtaPass.sqa_espresso.common ;

import android.support.test.espresso.* ;
import android.view.View ;
import android.widget.TextView ;

import junit.framework.AssertionFailedError ;

import org.hamcrest.Matcher ;

import static android.support.test.espresso.Espresso.onView ;
import static android.support.test.espresso.assertion.ViewAssertions.matches ;
import static android.support.test.espresso.matcher.ViewMatchers.* ;

public class ViewObject {

    protected ViewInteraction item ;
    protected boolean retryWhenNotReady = true ;
    protected int retryMaxCount = 3 ;
    protected int retryInterval = 10 ;

    public <T extends ViewObject> T ready() {
        int count = 0 ;

        while( true ) {
            try {
                this._ready() ;
                return (T) this ;

            } catch( Exception e ) {
                this.dprint( e.getMessage() ) ;

                if( ! this.retryWhenNotReady ) {
                    throw e ;
                }

                if( count++ == this.retryMaxCount ) {
                    UtaPassUtil.takeScreenshot( "ComponentNotReady" ) ;
                    throw e;
                }

                this.sleep( this.retryInterval, String.format( "(%s/%s)", count, retryMaxCount ) ) ;
            }
        }
    }

    public void _ready() {
    }

    public void sleep( int seconds) {
        try {
            this.dprint( String.format( "Sleep %s second(s)", seconds ) ) ;
            Thread.sleep( seconds * 1000 ) ;

        } catch (InterruptedException ex) {
            this.dprint( ex.toString() ) ;
        }
    }

    public void sleep( int seconds, String msg ) {
        try {
            this.dprint( String.format( "Sleep %s second(s): %s", seconds, msg ) ) ;
            Thread.sleep( seconds * 1000 ) ;

        } catch (InterruptedException ex) {
            this.dprint( ex.toString() ) ;
        }
    }


    public void dprint( String msg ) {
        StackTraceElement caller = Thread.currentThread().getStackTrace()[ 4 ];
        android.util.Log.d("UtapassAutomation",
                           String.format( "%s (%s:%s)",
                                          msg,
                                          caller.getFileName(),
                                          caller.getLineNumber() ) ) ;
    }


    // Deprecated
    public boolean isVisibleByGetText( final Matcher<View> matcher ) {
        try {
            this.getText( matcher ) ;
            return true ;
        }
        catch( NoMatchingViewException e ) {
            return false ;
        }
    }

    public boolean isVisible( final Matcher<View> matcher ) {
        return this.isVisible( onView( matcher ) ) ;
    }

    public boolean isVisible( final ViewInteraction view ) {
        try {
            view.check( matches( isDisplayed() ) ) ;
            return true ;
        }
        catch( NoMatchingViewException e ) {
                return false ;
        }
        catch( AssertionFailedError e ) {
                return false ;
        }
    }

    public boolean isDisplayedCompletely( final Matcher<View> matcher ) {
        return this.isDisplayedCompletely( onView( matcher ) ) ;
    }

    public boolean isDisplayedCompletely( final ViewInteraction view ) {
        try {
            view.check( matches( isCompletelyDisplayed() ) ) ;
            return true ;
        }
        catch( NoMatchingViewException e ) {
            return false ;
        }
        catch( AssertionFailedError e ) {
            return false ;
        }
    }

    // copied from google
    protected String getText(final Matcher<View> matcher) {
        return this.getText( onView( matcher ) ) ;
    }

    protected String getText(final ViewInteraction viewInteraction) {
        final String[] stringHolder = { null };

        viewInteraction.perform(new ViewAction() {

            @Override
            public Matcher<View> getConstraints() {
                return isAssignableFrom(TextView.class);
            }

            @Override
            public String getDescription() {
                return "getting text from a TextView";
            }

            @Override
            public void perform(UiController uiController, View view) {
                TextView tv = (TextView)view; //Save, because of check in getConstraints()
                stringHolder[0] = tv.getText().toString();
            }
        });
        return stringHolder[0];
    }
}


