package com.alexanderbespalov.musiceng.ui.adapter.main;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.alexanderbespalov.musiceng.R;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.alexanderbespalov.musiceng.ui.activity.main.MainActivity.mn;

/**
 * Created by alexander.bespalov on 13.07.2017.
 */

public class LyricsAdapter extends RecyclerView.Adapter<LyricsAdapter.ViewHolder> {

    private Document doc;
    private Elements originals;
    private Elements translates;


    public LyricsAdapter(Document doc) {
        this.doc = doc;
        if(doc != null) {
            Elements containers = doc.getElementsByClass("string_container");
            originals = containers.select("div.original");
            translates = containers.select("div.translate");
        }
    }

    @Override
    public LyricsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler_main, parent, false);
        return new ViewHolder(v);
        }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
         String original;
         String translate;

        if(doc != null) {
            Log.d("Parser", "loadLyrics: doc != null" );

            original = originals.get(position).text();
            translate = translates.get(position).text();

            holder.tvOriginal.setText(original);
            holder.tvTranslate.setText(translate);

//            if(translate.equals(original)) {
//                holder.tvTranslate.setVisibility(View.GONE);
//            }
            Log.v("Parsertext", "loadLyrics: original =" + original);
            Log.v("Parsertext", "loadLyrics: translate = " + translate);
        }
    }

    @Override
    public int getItemCount() {
        if (doc == null) {
            Log.d("Parser", "loadLyrics: getitemcount doc = null" );


            return 0;
        }
        Log.d("Parser", "loadLyrics: getitemcount return originals.size()" );
        return originals.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_original) TextView tvOriginal;
        @BindView(R.id.tv_translate) TextView tvTranslate;
        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
