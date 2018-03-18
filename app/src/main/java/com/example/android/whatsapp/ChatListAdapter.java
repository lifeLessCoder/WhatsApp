package com.example.android.whatsapp;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;


public class ChatListAdapter extends RecyclerView.Adapter<ChatListAdapter.ChatViewHolder> {
    private int mNumberOfItems;
    private int[] mImageResourceId;
    private String[] mChatTitle;
    private String[] mTime;
    private String[] mMessage;
    private Context mContext;

    public ChatListAdapter(int numberOfItems, int[] imageResourceId, String[] chatTitle, String[] time,
                           String[] message, Context context) {
        mNumberOfItems = numberOfItems;
        mImageResourceId = imageResourceId;
        mChatTitle = chatTitle;
        mTime = time;
        mMessage = message;
        mContext = context;
    }

    @Override
    public ChatListAdapter.ChatViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);
        return new ChatViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ChatListAdapter.ChatViewHolder holder, int position) {
        holder.bind(mImageResourceId[position], mChatTitle[position], mTime[position],
                mMessage[position]);
    }

    @Override
    public int getItemCount() {
        return mNumberOfItems;
    }

    class ChatViewHolder extends RecyclerView.ViewHolder {

        CircleImageView circleImageView;
        TextView chatTitleTextView;
        TextView timeTextView;
        TextView messageTextView;
        TextView unreadMessagesTextView;

        public ChatViewHolder(View itemView) {
            super(itemView);

            circleImageView = itemView.findViewById(R.id.chat_image);
            chatTitleTextView = itemView.findViewById(R.id.tv_chat_name);
            timeTextView = itemView.findViewById(R.id.tv_chat_time);
            messageTextView = itemView.findViewById(R.id.tv_chat_message);
            unreadMessagesTextView = itemView.findViewById(R.id.tv_unread_messages);
        }


        void bind(int imageResourceId, String chatTitle, String time, String message) {
            circleImageView.setImageResource(imageResourceId);
            chatTitleTextView.setText(chatTitle);
            timeTextView.setText(time);
            messageTextView.setText(message);
            if(getAdapterPosition() < 3){
                unreadMessagesTextView.setVisibility(View.VISIBLE);
                unreadMessagesTextView.setText(String.valueOf(getAdapterPosition()));
                timeTextView.setTextColor(ContextCompat.getColor(mContext, R.color.colorAccent));
            }
        }
    }
}
