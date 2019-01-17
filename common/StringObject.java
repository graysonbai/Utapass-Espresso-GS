package com.kddi.android.UtaPass.sqa_espresso.common ;


public class StringObject extends BasicString {

    public StringObject() {}

    public StringObject( String str ) {
        super( str ) ;
    }

    public StringObject( String label , String str ) {
        super( str ) ;
        this.label( label ) ;
    }

    public StringObject( int n ) {
        super( String.valueOf( n ) ) ;
    }

    public boolean isVisible() {
        return this.string() != null ;
    }

    public String toString() {
        return this.string() ;
    }

    // ========================================
    // Equals & NotEquals
    // ========================================
    public boolean isEquals( StringObject strObj ) {
        return this.isEquals( strObj.string() ) ;
    }

    public void assertEquals( StringObject strObj ) {
        this.assertEquals( strObj.string() ) ;
    }

    public void assertNotEquals( StringObject strObj ) {
        this.assertNotEquals( strObj.string() ) ;
    }

    // ========================================
    // LessThan
    // ========================================
    public boolean isLessThan( StringObject expecting ) {
        return this.isLessThan( expecting.string() ) ;
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
}




