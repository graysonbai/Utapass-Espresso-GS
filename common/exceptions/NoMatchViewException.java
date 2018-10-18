package com.kddi.android.UtaPass.sqa_espresso.common.exceptions ;

import com.kddi.android.UtaPass.sqa_espresso.common.UtaPassUtil;

public class NoMatchViewException extends RuntimeException {
    public NoMatchViewException( String label ) {
        super( label ) ;

        UtaPassUtil.takeScreenshot( "NoMatchView : " + label ) ;
    }
}




