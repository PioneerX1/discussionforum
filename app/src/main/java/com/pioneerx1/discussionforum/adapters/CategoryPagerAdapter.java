package com.pioneerx1.discussionforum.adapters;

/**
 * Created by Guest on 9/21/17.
 */

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.pioneerx1.discussionforum.models.Category;
import com.pioneerx1.discussionforum.ui.CategoryDetailFragment;

import java.util.ArrayList;

public class CategoryPagerAdapter extends FragmentPagerAdapter {

    private ArrayList<Category> mCategories;

    public CategoryPagerAdapter(FragmentManager fm, ArrayList<Category> categories) {
        super(fm);
        mCategories = categories;
    }

    @Override
    public Fragment getItem(int position) {
        return CategoryDetailFragment.newInstance(mCategories.get(position));
    }

    @Override
    public int getCount() {
        return mCategories.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mCategories.get(position).getName();
    }

}
