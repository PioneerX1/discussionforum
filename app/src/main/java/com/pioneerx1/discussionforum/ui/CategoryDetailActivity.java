package com.pioneerx1.discussionforum.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.pioneerx1.discussionforum.R;

public class CategoryDetailActivity extends AppCompatActivity {

    public static final String TAG = CategoryDetailActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_detail);
        Log.v(TAG, "-------DETAIL ACTIVITY REACHED!!!");
    }
}
