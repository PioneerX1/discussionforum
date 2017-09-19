package com.pioneerx1.discussionforum.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.pioneerx1.discussionforum.Constants;
import com.pioneerx1.discussionforum.R;
import com.pioneerx1.discussionforum.models.Category;

import butterknife.Bind;
import butterknife.ButterKnife;

public class NewCategoryActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String TAG = NewCategoryActivity.class.getSimpleName();

    @Bind(R.id.submitCategoryButton) Button mSubmitCategoryButton;
    @Bind(R.id.categoryNameInput) EditText mCategoryNameInput;
    @Bind(R.id.categoryDescriptionInput) EditText mCategoryDescriptionInput;
    @Bind(R.id.categoryImageUrlInput) EditText mCategoryImageUrlInput;

    private DatabaseReference mCategoryReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        mCategoryReference = FirebaseDatabase
                .getInstance()
                .getReference()
                .child(Constants.FIREBASE_CHILD_CATEGORY);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_category);
        ButterKnife.bind(this);

        mSubmitCategoryButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == mSubmitCategoryButton) {
            // create Category Object and save to Firebase
            createCategory();
            // move to Category List Activity
            Intent intent = new Intent(NewCategoryActivity.this, CategoryListActivity.class);
            startActivity(intent);
        }
    }

    // create Category object
    public void createCategory() {
        String name = mCategoryNameInput.getText().toString();
        String description = mCategoryDescriptionInput.getText().toString();
        String imageUrl = mCategoryImageUrlInput.getText().toString();

        // validate form
        if (name.equals("")|| description.equals("")) {
            Toast.makeText(NewCategoryActivity.this, "Make sure Name and Description fields are complete!", Toast.LENGTH_SHORT).show();
        } else {
            Category newCategory = new Category(name, description, imageUrl);
            Log.v(TAG, newCategory.getName() + " --- " + newCategory.getDescription() + " --- " + newCategory.getImageUrl());
            saveCategoryToFirebase(newCategory);
        }
    }

    // save Category to Firebase
    public void saveCategoryToFirebase(Category newCategory) {
        mCategoryReference.push().setValue(newCategory);
        //Log.v(TAG, "CATEGORY " + newCategory.getName() + " PUSHED TO FIREBASE");
        Toast.makeText(NewCategoryActivity.this, "New Category Saved!", Toast.LENGTH_SHORT).show();
    }
}
