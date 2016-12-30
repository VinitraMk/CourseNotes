package com.example.android.coursenotes;

import android.support.v4.app.Fragment;
import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by mikasa on 28/12/16.
 */

public class CategoryAdapter extends FragmentPagerAdapter {

    private Context mContext;
    public CategoryAdapter(Context context, FragmentManager fm){
        super(fm);
        mContext=context;
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new SyllabusFragment();
        }  else if (position == 1) {
            return new PreviousPapersFragment();
        } else {
            return new NotesFragment();
        }
    }

    @Override
    public int getCount() {
        return 3;
    }


    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return mContext.getString(R.string.syllabus_fragment);
        } else if (position == 1) {
            return mContext.getString(R.string.previous_papers_fragment);
        } else {
            return mContext.getString(R.string.notes_fragment);
        }
    }
}

