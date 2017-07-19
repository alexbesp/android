package com.example.alexanderbespalov.mvpedu.ui.activity.ex6_endless_recycler;

import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.alexanderbespalov.mvpedu.R;

import java.util.List;


public class SampleAdapter extends RecyclerView.Adapter<SampleAdapter.ViewHolder> {
    private List<String> myList;

    public SampleAdapter(List<String> myList) {
        this.myList = myList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.endless_recycler_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.textView.setText(myList.get(position));
    }

    @Override
    public int getItemCount() {
        return myList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        AppCompatTextView textView;

        ViewHolder(View itemView) {
            super(itemView);
            textView = (AppCompatTextView) itemView.findViewById(R.id.text1);
        }
    }
}
