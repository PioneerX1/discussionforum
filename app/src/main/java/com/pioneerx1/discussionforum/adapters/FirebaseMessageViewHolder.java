package com.pioneerx1.discussionforum.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.pioneerx1.discussionforum.Constants;
import com.pioneerx1.discussionforum.R;
import com.pioneerx1.discussionforum.models.Message;
import com.pioneerx1.discussionforum.ui.CategoryDetailActivity;
import com.pioneerx1.discussionforum.ui.MessageDetailActivity;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import java.util.ArrayList;

public class FirebaseMessageViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private static final int MAX_WIDTH = 200;
    private static final int MAX_HEIGHT = 200;

    View mView;
    Context mContext;

    public FirebaseMessageViewHolder(View itemView) {
        super(itemView);
        mView = itemView;
        mContext = itemView.getContext();
        itemView.setOnClickListener(this);
    }

    public void bindMessage(Message message) {
        TextView messageTitleTextView = (TextView) mView.findViewById(R.id.messageTitleTextView);
        TextView messageAuthorTextView = (TextView) mView.findViewById(R.id.messageAuthorTextView);
        TextView messageContentTextView = (TextView) mView.findViewById(R.id.messageContentTextView);

        messageTitleTextView.setText(message.getTitle());
        messageAuthorTextView.setText("  by: " + message.getAuthor());
        messageContentTextView.setText(message.getContent());
    }

    @Override
    public void onClick(View view) {
        final ArrayList<Message> messages = new ArrayList<>();
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference(Constants.FIREBASE_CHILD_MESSAGE);
        ref.addListenerForSingleValueEvent(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                        messages.add(snapshot.getValue(Message.class));
                }

                int itemPosition = getLayoutPosition();

                // NEED CODE FOR NEXT INTENT HERE
                Intent intent = new Intent(mContext, MessageDetailActivity.class);
                intent.putExtra("position", itemPosition + "");
                intent.putExtra("messages", Parcels.wrap(messages));

                mContext.startActivity(intent);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) { }

        });

    }

}
