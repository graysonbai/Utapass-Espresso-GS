package com.kddi.android.UtaPass.sqa_espresso.common.exceptions ;

public class StringInException extends BasicException {

    public StringInException( String actual, String[] sets ) {
        super( String.format( "actual = '%s', Sets = '%s'",
                              actual,
                              String.join(",", sets )) ) ;
    }
}
