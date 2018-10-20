package com.kddi.android.UtaPass.sqa_espresso.common.exceptions ;

public class StringNotInException extends BasicException {

    public StringNotInException( String actual, String[] sets ) {
        super( String.format( "actual = '%s', Sets = '%s'",
                              actual,
                              String.join(",", sets ) ) ) ;
    }
}
