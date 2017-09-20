package com.pioneerx1.discussionforum.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.pioneerx1.discussionforum.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class CategoryDetailActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String TAG = CategoryDetailActivity.class.getSimpleName();

    @Bind(R.id.newMessageButton) Button mNewMessageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_detail);
        ButterKnife.bind(this);
        Log.v(TAG, "-------DETAIL ACTIVITY REACHED!!!");

        mNewMessageButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == mNewMessageButton) {
            Intent intent = new Intent(CategoryDetailActivity.this, NewMessageActivity.class);
            startActivity(intent);
        }
    }
}
