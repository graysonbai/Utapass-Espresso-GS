package com.kddi.android.UtaPass.sqa_espresso.common ;

import androidx.test.espresso.ViewInteraction;

@FunctionalInterface
public interface IMatcher {
    ViewInteraction execute() ;
}