package com.androiddeveloper.fragments;


import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by azhar on 5/9/2017.
 */

public class FragmentCategory extends FragmentPagerAdapter {

    private Context mContext;
    public FragmentCategory(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;

    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public Fragment getItem(int position) {

       if(position == 0){
            return  new ActiveJobFrag();
        }else if(position == 1){
            return  new PreviousJobFrag();
        } else{
            return  new ActiveJobFrag();
        }
    }

    @Override
    public CharSequence getPageTitle(int position) {

       if(position == 0){
            return mContext.getString(R.string.app_name);
        } else {
            return mContext.getString(R.string.app_name);
        }
    }


}
