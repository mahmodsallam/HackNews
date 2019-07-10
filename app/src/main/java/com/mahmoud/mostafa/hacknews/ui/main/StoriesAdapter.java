package com.mahmoud.mostafa.hacknews.ui.main;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mahmoud.mostafa.hacknews.R;

import java.util.ArrayList;

public class StoriesAdapter extends RecyclerView.Adapter<StoriesAdapter.StoriesViewHolder> {
    ArrayList<String> storiesIds;
    Context context;
    MainInterface mainInterface;

    public StoriesAdapter(ArrayList<String> storiesIds, Context context , MainInterface mainInterface) {
        this.storiesIds = storiesIds;
        this.context = context;
        this.mainInterface = mainInterface ;
    }

    @NonNull
    @Override
    public StoriesViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.story_row, viewGroup, false);
        return new StoriesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StoriesViewHolder storiesViewHolder, int i) {
        final String id = storiesIds.get(i);
        storiesViewHolder.storyName.setText(id);
        storiesViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainInterface.openDetails(id);
            }
        });
    }

    @Override
    public int getItemCount() {
        return storiesIds.size();
    }

    class StoriesViewHolder extends RecyclerView.ViewHolder {
        TextView storyName;

        public StoriesViewHolder(@NonNull View itemView) {
            super(itemView);
            storyName = itemView.findViewById(R.id.tv_story);
        }
    }

}

