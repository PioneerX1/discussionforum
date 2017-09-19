package com.pioneerx1.discussionforum.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.pioneerx1.discussionforum.R;
import com.pioneerx1.discussionforum.adapters.CategoryListAdapter;
import com.pioneerx1.discussionforum.models.Category;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class CategoryListActivity extends AppCompatActivity implements View.OnClickListener {

    @Bind(R.id.newCategoryButton) Button mNewCategoryButton;
    @Bind(R.id.categoryRecyclerView) RecyclerView mCategoryRecyclerView;

    private CategoryListAdapter mAdapter;
    public ArrayList<Category> mCategories = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_list);
        ButterKnife.bind(this);

        mNewCategoryButton.setOnClickListener(this);
        getCategories();
    }

    @Override
    public void onClick(View v) {
        if (v == mNewCategoryButton) {
            Intent intent = new Intent(CategoryListActivity.this, NewCategoryActivity.class);
            startActivity(intent);
        }
    }

    private void getCategories() {

        mAdapter = new CategoryListAdapter(getApplicationContext(), mCategories);
        mCategoryRecyclerView.setAdapter(mAdapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(CategoryListActivity.this);
        mCategoryRecyclerView.setLayoutManager(layoutManager);
        mCategoryRecyclerView.setHasFixedSize(true);
    }
}
