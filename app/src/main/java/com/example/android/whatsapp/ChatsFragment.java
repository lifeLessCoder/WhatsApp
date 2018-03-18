package com.example.android.whatsapp;


import android.graphics.Rect;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class ChatsFragment extends Fragment{

    public ChatsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_chats, container, false);
        RecyclerView recyclerView = rootView.findViewById(R.id.my_recycler_view);

        int[] imageResourceId = {
                R.drawable.elon_musk,
                R.drawable.goku,
                R.drawable.avengers,
                R.drawable.thor,
                R.drawable.justice_league,
                R.drawable.ant_man,
                R.drawable.thanos,
                R.drawable.spider_man,
                R.drawable.hulk,
                R.drawable.vegeta
        };

        String[] chatTitle = getActivity().getResources().getStringArray(R.array.chat_title_array);
        String[] chatTime = getActivity().getResources().getStringArray(R.array.chat_time_array);
        String[] chatMessage = getActivity().getResources().getStringArray(R.array.chat_message_array);

        recyclerView.setHasFixedSize(true);

        // use a linear layout manager
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        MyDividerItemDecoration dividerItemDecoration = new MyDividerItemDecoration(recyclerView.getContext(),
                layoutManager.getOrientation(), 80,
                (int)getActivity().getResources().getDimension(R.dimen.bottom_offset));
        recyclerView.addItemDecoration(dividerItemDecoration);

        // specify an adapter (see also next example)
        ChatListAdapter listAdapter = new ChatListAdapter(10,
                imageResourceId, chatTitle, chatTime, chatMessage, getActivity());
        recyclerView.setAdapter(listAdapter);

        return rootView;
    }

}
