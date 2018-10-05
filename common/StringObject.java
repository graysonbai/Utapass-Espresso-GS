package com.kddi.android.UtaPass.sqa_espresso.common ;

import com.kddi.android.UtaPass.sqa_espresso.common.exceptions.StringException;
import com.kddi.android.UtaPass.sqa_espresso.common.exceptions.StringEqualException;
import com.kddi.android.UtaPass.sqa_espresso.common.exceptions.StringInException;
import com.kddi.android.UtaPass.sqa_espresso.common.exceptions.StringInvisibleException;
import com.kddi.android.UtaPass.sqa_espresso.common.exceptions.StringNotEqualException;
import com.kddi.android.UtaPass.sqa_espresso.common.exceptions.StringNotInException;
import com.kddi.android.UtaPass.sqa_espresso.common.exceptions.StringVisibleException;

import java.util.Arrays;

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

    public void ready() {
        UtaPassUtil.retry( () -> this.isVisible() ) ;
    }


    // ========================================
    // Visible
    // ========================================
    public void assertVisible() {
        if( ! this.isVisible() ) {
            throw new StringInvisibleException( "Null" ) ;
        }
    }

    public void assertInvisible() {
        if( this.isVisible() ) {
            throw new StringVisibleException( this.string() ) ;
        }
    }

    // ========================================
    // Equals
    // ========================================
    public void assertEquals( String expecting ) {
        this.ready() ;

        String actual = this.string() ;
        if( ! actual.equals( expecting ) ) {
            throw new StringNotEqualException( actual, expecting ) ;
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
        this.ready() ;

        String actual = this.string() ;
        if( actual.equals( expecting ) ) {
            throw new StringEqualException( actual, expecting ) ;
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
        this.ready() ;

        String actual = this.string() ;
        if( Integer.parseInt( actual ) >= Integer.parseInt( expecting ) ) {
            throw new StringException( String.format(
                    "Actual: %s, Expecting: %s",
                    actual,
                    expecting ) ) ;
        }
    }

    public void assertLessThan( String expecting, int diff ) {
        this.ready() ;

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
    public void assertIn( String[] sets ) {
        this.ready() ;

        String actual = this.string() ;
        if( ! Arrays.asList( sets ).contains( actual ) ) {
            throw new StringNotInException( actual, sets ) ;
        }
    }


    // ========================================
    // NotIn
    // ========================================
    public void assesrtNotIn( String[] sets ) {
        this.ready() ;

        String actual = this.string() ;
        if( Arrays.asList( sets ).contains( actual ) ) {
            throw new StringInException( actual, sets ) ;
        }
    }
}




