package com.kddi.android.UtaPass.sqa_espresso.common.card_behavior ;

import com.kddi.android.UtaPass.sqa_espresso.common.LazyMatcher;
import com.kddi.android.UtaPass.sqa_espresso.common.LazyString;

public interface ISongName {
    void songName( String label, LazyMatcher matcher ) ;
    LazyString songName() ;
}




