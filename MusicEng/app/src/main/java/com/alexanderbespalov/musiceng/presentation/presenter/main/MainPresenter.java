package com.alexanderbespalov.musiceng.presentation.presenter.main;

import android.os.AsyncTask;
import android.util.Log;

import com.alexanderbespalov.musiceng.presentation.view.main.MainView;
import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

@InjectViewState
public class MainPresenter extends MvpPresenter<MainView> {
    Document doc = null;
    private Elements originals;
    private Elements translates;

    private class loadAsync extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... voids) {
            try {
                doc = Jsoup.connect("http://www.amalgama-lab.com/songs/e/eminem/superman.html").timeout(3000).get();
            } catch (IOException e) {
                Log.d("Parser", "loadLyrics: " + e.getMessage() + e.getCause());
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            getViewState().onDataChanged();
        }
    }

    public void loadLyrics() {
        new loadAsync().execute();
    }

    public Document getDoc() {
        return doc;
    }
}
