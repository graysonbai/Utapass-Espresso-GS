package com.kddi.android.UtaPass.sqa_espresso.common.exceptions ;

import com.kddi.android.UtaPass.sqa_espresso.common.UtaPassUtil;

public class StringNotInException extends BasicException {

    public StringNotInException( String label, String actual, String[] sets ) {
        super( label ) ;

        UtaPassUtil.dprint( String.format(
                "actual = '%s', Sets = '%s'",
                actual,
                String.join(",", sets ) ) ) ;
    }
}
