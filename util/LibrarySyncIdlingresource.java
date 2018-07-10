package com.kddi.android.UtaPass.sqatest.util;

import android.support.test.espresso.IdlingResource;

import com.kddi.android.UtaPass.domain.usecase.ui.library.GetLibraryUIDataUseCase;

import java.util.List;

/**
 * Created by vanessatsai on 2017/5/8.
 */

public class LibrarySyncIdlingresource implements IdlingResource {


    private volatile ResourceCallback resourceCallback;
    public GetLibraryUIDataUseCase.OnSuccessListener onSuccessListener;

    public LibrarySyncIdlingresource() {

        onSuccessListener = new GetLibraryUIDataUseCase.OnSuccessListener() {
            @Override
            public void onSuccess(Object... data) {
                if (!((List) data[0]).isEmpty() && resourceCallback != null) {
                    resourceCallback.onTransitionToIdle();
                }
            }
        };

    }

    @Override
    public String getName() {
        return LibrarySyncIdlingresource.class.getName();
    }

    @Override
    public boolean isIdleNow() {
        return false;
    }


    @Override
    public void registerIdleTransitionCallback(ResourceCallback callback) {
        resourceCallback = callback;
    }

}
