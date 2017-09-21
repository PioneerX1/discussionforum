package com.pioneerx1.discussionforum.ui;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import org.parceler.Parcels;
import butterknife.Bind;
import butterknife.ButterKnife;

import com.pioneerx1.discussionforum.R;
import com.pioneerx1.discussionforum.models.Category;

/**
 * A simple {@link Fragment} subclass.
 */
public class CategoryDetailFragment extends Fragment {

    public static final String TAG = CategoryDetailFragment.class.getSimpleName();

    @Bind(R.id.categoryDetailNameTextView) TextView mCategoryDetailNameTextView;

    private Category mCategory;


    public static CategoryDetailFragment newInstance(Category category) {
        // Required empty public constructor
        Log.v(TAG, "...... CATEGORY NAME FROM CATEGORY DETAIL FRAGMENT / NEW INSTANCE: " + category.getName());
        CategoryDetailFragment categoryDetailFragment = new CategoryDetailFragment();
        Bundle args = new Bundle();
        args.putParcelable("category", Parcels.wrap(category));
        categoryDetailFragment.setArguments(args);
        return categoryDetailFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mCategory = Parcels.unwrap(getArguments().getParcelable("category"));
        Log.v(TAG, "--- CATEGORY NAME FROM CATEGORY DETAIL FRAGMENT / ON CREATE: " + mCategory.getName());
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_category_detail, container, false);

        View view = inflater.inflate(R.layout.fragment_category_detail, container, false);
        ButterKnife.bind(this, view);

        // category image with Picasso would go here

        mCategoryDetailNameTextView.setText(mCategory.getName());

        return view;
    }

}
