package com.kddi.android.UtaPass.sqa_espresso.common ;

import com.kddi.android.UtaPass.sqa_espresso.common.exceptions.StringException;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;


public class LazyString extends ViewObject {

    protected LazyMatcher matcher ;

    public LazyString( LazyMatcher matcher ) {
        this.matcher = matcher ;
    }

    public void tap() {
        onView( this.matcher.execute() ).perform( click() ) ;
    }

    public boolean isVisible() {
        return this.isVisible( this.matcher.execute() ) ;
    }

    public StringObject text() {
        return new StringObject( this.getText( this.matcher.execute() ) ) ;
    }

    public void assertVisible() {
        if( ! this.isVisible() ) {
            throw new StringException( "Actual: InVisible, Expecting: Visible" ) ;
        }
    }

    public void assertInvisible() {
        if( this.isVisible() ) {
            throw new StringException( "Actual: Visible, Expecting: InVisible" ) ;
        }
    }


    public void assertEquals( StringObject expecting ) {
        this.text().assertEquals( expecting.string() ) ;
    }

    public void assertEquals( String expecting ) {
        this.text().assertEquals( expecting ) ;
    }

    public void assertEquals( int expecting ) {
        this.assertEquals( String.valueOf( expecting ) ) ;
    }


    public void assertNotEquals( StringObject expecting ) {
        this.text().assertNotEquals( expecting.string() ) ;
    }

    public void assertNotEquals( String expecting ) {
        this.text().assertNotEquals( expecting ) ;
    }

    public void assertNotEquals( int expecting ) {
        this.assertNotEquals( String.valueOf( expecting ) ) ;
    }
}




