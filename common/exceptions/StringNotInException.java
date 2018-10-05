package com.kddi.android.UtaPass.sqa_espresso.common.exceptions ;

import com.kddi.android.UtaPass.sqa_espresso.common.UtaPassUtil;

public class StringNotInException extends RuntimeException {

    public StringNotInException( String actual, String[] sets ) {
        super( String.format( "actual = '%s', Sets = '%s'",
                              actual,
                              String.join(",", sets )) ) ;

        UtaPassUtil.takeScreenshot( this.getClass().getSimpleName() ) ;
    }
}




