package com.kddi.android.UtaPass.sqa_espresso.common ;

import com.kddi.android.UtaPass.sqa_espresso.common.exceptions.StringException;
import com.kddi.android.UtaPass.sqa_espresso.common.exceptions.StringInvisibleException;
import com.kddi.android.UtaPass.sqa_espresso.common.exceptions.StringNotEqualException;
import com.kddi.android.UtaPass.sqa_espresso.common.exceptions.StringNotInException;
import com.kddi.android.UtaPass.sqa_espresso.common.exceptions.StringVisibleException;

import java.util.Arrays;

public class BasicString extends ViewObject {

    private String string = "" ;

    public BasicString() {}

    public BasicString( String str ) {
        this.string = str ;
    }

    public BasicString( int n ) {
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

    protected void _ready() {
        this.assertVisible() ;
    }

    @Deprecated
    public String name() {
        return this.getClass().getSimpleName() ;
    }

    // ========================================
    // Visible
    // ========================================
    public boolean isVisible() {
        return this.string() != null ;
    }

    public void assertVisible() {
        if( ! this.isVisible() ) {
            throw new StringInvisibleException( this.label() ) ;
        }
    }

    public void assertInvisible() {
        if( this.isVisible() ) {
            throw new StringVisibleException( this.string() ) ;
        }
    }

    // ========================================
    // Equals & NotEquals
    // ========================================
    public boolean isEquals( String expecting ) {
        return this.string().equals( expecting ) ;
    }

    public boolean isEquals( int expecting ) {
        return this.isEquals( String.valueOf( expecting ) ) ;
    }

    public void assertEquals( String expecting ) {
        if( ! this.isEquals( expecting ) ) {
            throw new StringNotEqualException( this.string(), expecting ) ;
        }
    }

    public void assertEquals( int expecting ) {
        this.assertEquals( String.valueOf( expecting ) ) ;
    }

    public void assertNotEquals( String expecting ) {
        if( this.isEquals( expecting ) ) {
            throw new StringNotEqualException( this.string(), expecting ) ;
        }
    }

    public void assertNotEquals( int expecting ) {
        this.assertNotEquals( String.valueOf( expecting ) ) ;
    }


    // ========================================
    // LessThan
    // ========================================
    public boolean isLessThan( int expecting ) {
        return Integer.parseInt( this.string() ) < expecting ;
    }

    public boolean isLessThan( String expecting ) {
        return this.isLessThan( Integer.parseInt( expecting ) ) ;
    }

    public boolean isLessThan( int expecting, int diff) {
        return Integer.parseInt( this.string() ) + diff == expecting ;
    }

    public boolean isLessThan( String expecting, int diff ) {
        return this.isLessThan( Integer.parseInt( expecting ), diff ) ;
    }

    public boolean isLessThan( int expecting, String diff ) {
        return this.isLessThan( expecting, Integer.parseInt( diff ) ) ;
    }

    public boolean isLessThan( String expecting, String diff ) {
        return this.isLessThan( Integer.parseInt( expecting ), diff ) ;
    }

    public void assertLessThan( int expecting ) {
        if( ! this.isLessThan( expecting ) ) {
            throw new StringException( String.format(
                    "Actual: %s, Expecting: %s",
                    this.string(),
                    expecting ) ) ;
        }
    }

    public void assertLessThan( String expecting ) {
        this.assertLessThan( Integer.parseInt( expecting ) ) ;
    }

    public void assertLessThan( int expecting, int diff ) {
        if( ! this.isLessThan( expecting, diff ) ) {
            throw new StringException( String.format(
                    "Actual: %s, Expecting: %s, diff: %s",
                    this.string(),
                    expecting,
                    diff ) ) ;
        }
    }

    public void assertLessThan( String expecting, int diff ) {
        this.assertLessThan( Integer.parseInt( expecting ), diff ) ;
    }

    public void assertLessThan( int expecting, String diff ) {
        this.assertLessThan( expecting, Integer.parseInt( diff ) ) ;
    }

    public void assertLessThan( String expecting, String diff ) {
        this.assertLessThan( expecting, Integer.parseInt( diff ) ) ;
    }


    // ========================================
    // In & NotIn
    // ========================================
    public boolean isIn( String[] sets ) {
        return Arrays.asList( sets ).contains( this.string() ) ;
    }

    public void assertIn( String[] sets ) {
        if( ! this.isIn( sets ) ) {
            throw new StringNotInException( this.label(), this.string(), sets ) ;
        }
    }

    public void assesrtNotIn( String[] sets ) {
        if( this.isIn( sets ) ) {
            throw new StringNotInException( this.label(), this.string(), sets ) ;
        }
    }
}




