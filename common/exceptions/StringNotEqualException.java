package com.kddi.android.UtaPass.sqa_espresso.common.exceptions ;

import com.kddi.android.UtaPass.sqa_espresso.common.UtaPassUtil;

public class StringNotEqualException extends BasicException {

    public StringNotEqualException( String actual, String expecting ) {
        String msg = String.format( "actual = '%s', expecting = '%s'",
                                    actual,
                                    expecting ) ;

        UtaPassUtil.dprint( msg ) ;
        UtaPassUtil.takeScreenshot( "StringNotEqual" ) ;
    }
}
