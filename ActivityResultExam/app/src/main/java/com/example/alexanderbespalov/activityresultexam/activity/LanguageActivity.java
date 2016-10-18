package com.example.alexanderbespalov.activityresultexam.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import com.example.alexanderbespalov.activityresultexam.R;
import com.example.alexanderbespalov.activityresultexam.util.Language;

/**
 * Created by alexander.bespalov on 14.10.2016.
 */
public class LanguageActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.language_layout);
    }

    public void onLanguage(View view) {
        Intent intent;
        switch (view.getId()){
            case R.id.btnRu:
                intent = new Intent();
                intent.putExtra("language", Language.RUSSIAN.getLanguage());
                setResult(RESULT_OK, intent);
                finish();
                break;
            case R.id.btnDe:
                intent = new Intent();
                intent.putExtra("language", Language.DEUTCH.getLanguage());
                setResult(RESULT_OK, intent);
                finish();
                break;

            case R.id.btnEn:
                intent = new Intent();
                intent.putExtra("language", Language.ENGLISH.getLanguage());
                setResult(RESULT_OK, intent);
                finish();
                break;
        }
    }
}
