package com.kddi.android.UtaPass.sqa_espresso.common.exceptions ;

import com.kddi.android.UtaPass.sqa_espresso.common.UtaPassUtil;

public class StringException extends RuntimeException {
    public StringException( String msg ) {
        super( msg ) ;

        UtaPassUtil.takeScreenshot( this.getClass().getSimpleName() ) ;
    }
}




