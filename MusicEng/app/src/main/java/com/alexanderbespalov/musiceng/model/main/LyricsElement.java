package com.alexanderbespalov.musiceng.model.main;

import io.realm.RealmObject;

/**
 * Created by alexander.bespalov on 14.07.2017.
 */

public class LyricsElement extends RealmObject {

    private String original;
    private String translate;
    private int sampleStart;
    private int sampleEnd;

    public String getOriginal() {
        return original;
    }

    public void setOriginal(String original) {
        this.original = original;
    }

    public String getTranslate() {
        return translate;
    }

    public void setTranslate(String translate) {
        this.translate = translate;
    }

    public int getSampleStart() {
        return sampleStart;
    }

    public void setSampleStart(int sampleStart) {
        this.sampleStart = sampleStart;
    }

    public int getSampleEnd() {
        return sampleEnd;
    }

    public void setSampleEnd(int sampleEnd) {
        this.sampleEnd = sampleEnd;
    }
}
