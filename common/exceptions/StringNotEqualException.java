package com.kddi.android.UtaPass.sqa_espresso.common.exceptions ;

public class StringNotEqualException extends BasicException {

    public StringNotEqualException( String actual, String expecting ) {
        super( String.format( "actual = '%s', expecting = '%s'",
                              actual,
                              expecting ) ) ;
    }
}
