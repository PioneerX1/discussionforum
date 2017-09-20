package com.pioneerx1.discussionforum.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.pioneerx1.discussionforum.Constants;
import com.pioneerx1.discussionforum.R;
import com.pioneerx1.discussionforum.adapters.CategoryListAdapter;
import com.pioneerx1.discussionforum.adapters.FirebaseCategoryViewHolder;
import com.pioneerx1.discussionforum.adapters.FirebaseMessageViewHolder;
import com.pioneerx1.discussionforum.models.Category;
import com.pioneerx1.discussionforum.models.Message;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class CategoryDetailActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String TAG = CategoryDetailActivity.class.getSimpleName();
    public static final String categoryName = "Banjos";  // hard-coded for now

    private DatabaseReference mMessageReference;
    private FirebaseRecyclerAdapter mFirebaseAdapter;

    @Bind(R.id.messageRecyclerView) RecyclerView mRecyclerView;
    @Bind(R.id.newMessageButton) Button mNewMessageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_detail);
        ButterKnife.bind(this);
        Log.v(TAG, "-------DETAIL ACTIVITY REACHED!!!");

        mNewMessageButton.setOnClickListener(this);
        mMessageReference = FirebaseDatabase.getInstance().getReference(Constants.FIREBASE_CHILD_MESSAGE);
        setUpFirebaseAdapter();
    }

    @Override
    public void onClick(View v) {
        if (v == mNewMessageButton) {
            Intent intent = new Intent(CategoryDetailActivity.this, NewMessageActivity.class);
            startActivity(intent);
        }
    }

    private void setUpFirebaseAdapter() {
        mFirebaseAdapter = new FirebaseRecyclerAdapter<Message, FirebaseMessageViewHolder>
                (Message.class, R.layout.message_list_item, FirebaseMessageViewHolder.class, mMessageReference) {

            @Override
            protected void populateViewHolder(FirebaseMessageViewHolder viewHolder, Message model, int position) {
                viewHolder.bindMessage(model);
            }
        };
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mFirebaseAdapter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mFirebaseAdapter.cleanup();
    }
}
