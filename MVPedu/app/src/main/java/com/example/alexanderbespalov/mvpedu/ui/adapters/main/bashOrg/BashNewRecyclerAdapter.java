package com.example.alexanderbespalov.mvpedu.ui.adapters.main.bashOrg;

import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.alexanderbespalov.mvpedu.R;
import com.example.alexanderbespalov.mvpedu.model.bashOrg.PostModel;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by alexander.bespalov on 05.07.2017.
 */

public class BashNewRecyclerAdapter extends RecyclerView.Adapter<BashNewRecyclerAdapter.ViewHolder> {

    private List<PostModel> posts;

    public BashNewRecyclerAdapter(List<PostModel> posts) {
        this.posts = posts;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_bash_org, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        PostModel post = posts.get(position);
        holder.tvPost.setText(Html.fromHtml(post.getElementPureHtml()));
        holder.tvSite.setText(Html.fromHtml(post.getSite()));

    }

    @Override
    public int getItemCount() {
        if (posts == null) {
            return 0;
        }
        return posts.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_bash_post) TextView tvPost;
        @BindView(R.id.tv_bash_site) TextView tvSite;
        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
