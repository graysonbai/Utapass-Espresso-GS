package com.kddi.android.UtaPass.sqa_espresso.common.exceptions ;

import com.kddi.android.UtaPass.sqa_espresso.common.UtaPassUtil;

public class NotReadyException extends RuntimeException {
    public NotReadyException( String msg ) {
        super( msg ) ;

        UtaPassUtil.takeScreenshot( this.getClass().getSimpleName() ) ;
    }
}




