package com.kddi.android.UtaPass.sqa_espresso.common.exceptions ;

import com.kddi.android.UtaPass.sqa_espresso.common.UtaPassUtil;

public class BasicException extends RuntimeException {
    public BasicException( String label ) {
        super( label ) ;

        UtaPassUtil.takeScreenshot( label.replace( " > ", "_" ) ) ;
    }
}




