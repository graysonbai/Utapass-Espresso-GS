package com.kddi.android.UtaPass.sqa_espresso.common ;

import android.support.test.espresso.* ;
import android.view.View ;
import android.widget.TextView ;

import com.kddi.android.UtaPass.sqa_espresso.common.exceptions.NoMatchViewException;

import junit.framework.AssertionFailedError ;

import org.hamcrest.Matcher ;

import static android.support.test.espresso.Espresso.onView ;
import static android.support.test.espresso.assertion.ViewAssertions.matches ;
import static android.support.test.espresso.matcher.ViewMatchers.* ;

public class ViewObject {

    protected ViewInteraction item ;
    private boolean retryWhenNotReady = true ;

    public <T extends ViewObject> T ready() {
        UtaPassUtil.retry( () -> { this._ready(); return true ; },
                           this.retryWhenNotReady() ) ;

        return (T) this ;
    }

    public boolean isReady() {
        try {
            this.ready() ;
            return true ;

        } catch( RuntimeException e ) {
            return false ;
        }
    }

    protected boolean retryWhenNotReady() {
        return this.retryWhenNotReady ;
    }

    protected void retryWhenNotReady( boolean bool ) {
        this.retryWhenNotReady = bool ;
    }

    protected void _ready() {
    }

    protected void dprint( String msg ) {
        UtaPassUtil.dprint( msg ) ;
    }

    protected void handleNoMatchViewException( String label, ICommand command ) {
        try {
            command.execute() ;
        }

        catch( NoMatchingViewException e ) {
            this.dprint( e.getMessage() ) ;
            throw new NoMatchViewException( label ) ;
        }
    }

    protected boolean isVisible( final Matcher<View> matcher ) {
        return this.isVisible( onView( matcher ) ) ;
    }

    protected boolean isVisible( final ViewInteraction view ) {
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

    protected boolean isDisplayedCompletely( final Matcher<View> matcher ) {
        return this.isDisplayedCompletely( onView( matcher ) ) ;
    }

    protected boolean isDisplayedCompletely( final ViewInteraction view ) {
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


    @Deprecated
    protected boolean isVisibleByGetText( final Matcher<View> matcher ) {
        try {
            this.getText( matcher ) ;
            return true ;
        }
        catch( NoMatchingViewException e ) {
            return false ;
        }
    }
}
