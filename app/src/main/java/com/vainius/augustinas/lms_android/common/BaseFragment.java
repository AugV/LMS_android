package com.vainius.augustinas.lms_android.common;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;


public abstract class BaseFragment extends Fragment {
    private AbstractFragmentCallback mCallback;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            mCallback = (AbstractFragmentCallback) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
                    + " must implement " + AbstractFragmentCallback.class.getCanonicalName());
        }
    }

    public void replaceFragment(Class<? extends Fragment> claz, boolean addToBackStack,
                                Bundle args) {
        mCallback.replaceFragment(claz, addToBackStack, args);
    }


    public interface AbstractFragmentCallback {
        void replaceFragment(Class<? extends Fragment> claz, boolean addToBackStack,
                             Bundle args);
    }
}
