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
import com.pioneerx1.discussionforum.models.Message;

import butterknife.Bind;
import butterknife.ButterKnife;

public class NewMessageActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String TAG = NewMessageActivity.class.getSimpleName();

    @Bind(R.id.submitMessageButton) Button mSubmitMessageButton;
    @Bind(R.id.messageAuthorInput) EditText mMessageAuthorInput;
    @Bind(R.id.messageContentInput) EditText mMessageContentInput;
    @Bind(R.id.messageTitleInput) EditText mMessageTitleInput;

    private DatabaseReference mMessageReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        mMessageReference = FirebaseDatabase
                .getInstance()
                .getReference()
                .child(Constants.FIREBASE_CHILD_MESSAGE);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_message);
        ButterKnife.bind(this);

        mSubmitMessageButton.setOnClickListener(this);
        Log.v(TAG, "--- NEW MESSAGE ACTIVITY REACHED!");
    }

    @Override
    public void onClick(View v) {
        if (v == mSubmitMessageButton) {
            createMessage();
            Intent intent = new Intent(NewMessageActivity.this, CategoryDetailActivity.class);
            startActivity(intent);
        }
    }

    public void createMessage() {
        String title = mMessageTitleInput.getText().toString();
        String content = mMessageContentInput.getText().toString();
        String author = mMessageAuthorInput.getText().toString();
        String categoryName = "Banjos";  // hard code for now

        if ( title.equals("") || content.equals("") || author.equals("") ) {
            Toast.makeText(NewMessageActivity.this, "You must complete ALL fields!", Toast.LENGTH_SHORT).show();
        } else {
            Message newMessage = new Message(title, content, author, categoryName);
            saveMessageToFirebase(newMessage);
        }
    }

    public void saveMessageToFirebase(Message newMessage) {
        mMessageReference.push().setValue(newMessage);
        Toast.makeText(NewMessageActivity.this, "New Message Posted!", Toast.LENGTH_SHORT).show();
    }

}
