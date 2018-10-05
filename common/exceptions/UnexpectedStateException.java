package com.kddi.android.UtaPass.sqa_espresso.common.exceptions ;

import com.kddi.android.UtaPass.sqa_espresso.common.UtaPassUtil;

public class UnexpectedStateException extends RuntimeException {
    public UnexpectedStateException( String msg ) {
        super( msg ) ;

        UtaPassUtil.takeScreenshot( this.getClass().getSimpleName() ) ;
    }
}



