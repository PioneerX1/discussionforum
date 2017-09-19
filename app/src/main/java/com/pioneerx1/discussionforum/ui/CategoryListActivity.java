package com.pioneerx1.discussionforum.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.pioneerx1.discussionforum.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class CategoryListActivity extends AppCompatActivity implements View.OnClickListener {

    @Bind(R.id.newCategoryButton) Button mNewCategoryButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_list);
        ButterKnife.bind(this);

        mNewCategoryButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == mNewCategoryButton) {
            Intent intent = new Intent(CategoryListActivity.this, NewCategoryActivity.class);
            startActivity(intent);
        }
    }
}
