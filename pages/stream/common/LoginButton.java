package com.kddi.android.UtaPass.sqa_espresso.pages.stream.common ;

import com.kddi.android.UtaPass.R;
import com.kddi.android.UtaPass.sqa_espresso.common.BasicButton;

import static android.support.test.espresso.matcher.ViewMatchers.withId;

public class LoginButton extends BasicButton {

    public LoginButton() {
        super( () -> withId( R.id.synapse_account_login_button ) ) ;
    }
}




