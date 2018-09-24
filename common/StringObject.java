package com.kddi.android.UtaPass.sqa_espresso.common ;

import com.kddi.android.UtaPass.sqa_espresso.common.exceptions.StringException;

import java.util.Arrays;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;


public class StringObject {

    private String string ;

    public StringObject( String str ) {
        this.string = str ;
    }

    public StringObject( int n ) {
        this.string = String.valueOf( n ) ;
    }

    public String string() {
        return this.string ;
    }

    public void string( String str ) {
        this.string = str ;
    }

    public void string( int n ) {
        this.string = String.valueOf( n ) ;
    }

    public boolean isVisible() {
        return this.string() != null ;
    }


    // ========================================
    // Visible
    // ========================================
    public void assertVisible() {
        if( ! this.isVisible() ) {
            throw new StringException( "StringInvisible" ) ;
        }
    }

    public void assertInvisible() {
        if( this.isVisible() ) {
            throw new StringException( "StringVisible" ) ;
        }
    }

    // ========================================
    // Equals
    // ========================================
    public void assertEquals( String expecting ) {
        String actual = this.string() ;

        if( ! actual.equals( expecting ) ) {
            throw new StringException( String.format(
                    "Actual: %s, Expecting: %s",
                    actual,
                    expecting ) ) ;
        }
    }

    public void assertEquals( StringObject strObj ) {
        this.assertEquals( strObj.string() ) ;
    }

    public void assertEquals( int expecting ) {
        this.assertEquals( String.valueOf( expecting ) ) ;
    }


    // ========================================
    // NotEquals
    // ========================================
    public void assertNotEquals( String expecting ) {
        String actual = this.string() ;

        if( actual.equals( expecting ) ) {
            throw new StringException( String.format(
                    "Actual: %s, Expecting: %s",
                    actual,
                    expecting ) ) ;
        }
    }

    public void assertNotEquals( StringObject strObj ) {
        this.assertNotEquals( strObj.string() ) ;
    }

    public void assertNotEquals( int expecting ) {
        this.assertNotEquals( String.valueOf( expecting ) ) ;
    }


    // ========================================
    // LessThan
    // ========================================
    public void assertLessThan( String expecting ) {
        String actual = this.string() ;

        if( Integer.parseInt( actual ) - Integer.parseInt( expecting ) > 0 ) {
            throw new StringException( String.format(
                    "Actual: %s, Expecting: %s",
                    actual,
                    expecting ) ) ;
        }
    }

    public void assertLessThan( String expecting, int diff ) {
        String actual = this.string() ;

        if( Integer.parseInt( expecting ) - Integer.parseInt( actual ) != diff ) {
            throw new StringException( String.format(
                    "Actual: %s, Expecting: %s",
                    actual,
                    expecting ) ) ;
        }
    }

    public void assertLessThan( String expecting, String diff ) {
        this.assertLessThan( expecting, Integer.parseInt( diff ) ) ;
    }

    public void assertLessThan( StringObject expecting ) {
        this.assertLessThan( expecting.string() ) ;
    }

    public void assertLessThan( StringObject expecting, String diff ) {
        this.assertLessThan( expecting.string(), diff ) ;
    }

    public void assertLessThan( StringObject expecting, int diff ) {
        this.assertLessThan( expecting.string(), diff ) ;
    }


    // ========================================
    // In
    // ========================================
    public void assertIn( String[] expectings ) {
        String actual = this.string() ;

        if( ! Arrays.asList( expectings ).contains( actual ) ) {
            throw new StringException( String.format(
                    "Actual: %s, Expecting: %s",
                    actual,
                    String.join(",", expectings ) ) ) ;
        }
    }


    // ========================================
    // NotIn
    // ========================================
    public void assesrtNotIn( String[] expectings ) {
        String actual = this.string() ;

        if( Arrays.asList( expectings ).contains( actual ) ) {
            throw new StringException( String.format(
                    "Actual: %s, Expecting: %s",
                    actual,
                    String.join(",", expectings ) ) ) ;
        }
    }
}




