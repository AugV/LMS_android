package com.vainius.augustinas.lms_android.main;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.vainius.augustinas.lms_android.R;
import com.vainius.augustinas.lms_android.common.BaseFragment;
import com.vainius.augustinas.lms_android.login.LoginPageFragment;

public class MainActivity extends AppCompatActivity implements BaseFragment.AbstractFragmentCallback {

    RootViewMVCImpl mViewMVC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewMVC = new RootViewMVCImpl(this,null);
        setContentView(mViewMVC.getRootView());
        if(savedInstanceState == null){
            replaceFragment(LoginPageFragment.class, false,null);
        }
    }

    @Override
    public void replaceFragment(Class<? extends Fragment> claz, boolean addToBackStack, Bundle args) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();

        Fragment newFragment;

        try{
            newFragment=claz.newInstance();
            if(args!=null)newFragment.setArguments(args);
        }catch(InstantiationException e){
            e.printStackTrace();
            return;
        }catch (IllegalAccessException e){
            e.printStackTrace();
            return;
        }

        if(addToBackStack){
            fragmentTransaction.addToBackStack(null);
        }

        fragmentTransaction.replace(R.id.frame_contents, newFragment, claz.getClass().getSimpleName());
        fragmentTransaction.commit();
    }
}
