package com.kddi.android.UtaPass.sqa_espresso.common.card_behavior;

import com.kddi.android.UtaPass.sqa_espresso.common.BasicButton;
import com.kddi.android.UtaPass.sqa_espresso.common.LazyMatcher;

public interface IMoreButton {
    void moreButton(String label, LazyMatcher matcher);
    BasicButton moreButton();
}
