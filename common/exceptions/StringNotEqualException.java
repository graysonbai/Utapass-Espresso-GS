package com.kddi.android.UtaPass.sqa_espresso.common.exceptions ;

import com.kddi.android.UtaPass.sqa_espresso.common.UtaPassUtil;

public class StringNotEqualException extends RuntimeException {

    public StringNotEqualException( String actual, String expecting ) {
        super( String.format( "actual = '%s', expecting = '%s'",
                              actual,
                              expecting) ) ;

        UtaPassUtil.takeScreenshot( this.getClass().getSimpleName() ) ;
    }
}




