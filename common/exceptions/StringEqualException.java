package com.kddi.android.UtaPass.sqa_espresso.common.exceptions ;

public class StringEqualException extends BasicException {

    public StringEqualException( String actual, String expecting ) {
        super( String.format( "actual = '%s', expecting = '%s'",
                              actual,
                              expecting) ) ;
    }
}
