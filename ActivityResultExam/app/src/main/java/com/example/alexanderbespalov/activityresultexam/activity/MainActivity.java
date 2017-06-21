package com.example.alexanderbespalov.activityresultexam.activity;

import android.app.AlertDialog;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.example.alexanderbespalov.activityresultexam.R;
import com.example.alexanderbespalov.activityresultexam.adapter.PhoneModelAdapter;
import com.example.alexanderbespalov.activityresultexam.pojo.PhoneModel;
import com.example.alexanderbespalov.activityresultexam.util.RequestCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alexander.bespalov on 14.10.2016.
 */
public class MainActivity extends ActionBarActivity {

    private TextView txtName;
    private TextView txtLanguage;
    private ListView listView;
    private NotificationManager nm;
    private final int NOTIFICATION_ID = 127;

    public final String TAG = "DEV";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);
     //   getActionBar().show();
        txtName = (TextView) findViewById(R.id.txtName);
        txtLanguage = (TextView) findViewById(R.id.txtLanguage);
        listView = (ListView) findViewById(R.id.listView);
        nm = (NotificationManager) getApplicationContext().getSystemService(Context.NOTIFICATION_SERVICE);

      //  List<PhoneModel> items = initData() ;
       // ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items);

        PhoneModelAdapter phoneModelAdapter = new PhoneModelAdapter(this, initData());

        listView.setAdapter(phoneModelAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_items, menu);
        return true;
    }


    public void onAbout(MenuItem item) {
        Toast.makeText(this, "Вы выбрали инфо", Toast.LENGTH_SHORT).show();

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case R.id.settings:
                Toast.makeText(this, "Вы выбрали настройки", Toast.LENGTH_SHORT).show();
                return true;
//            case R.id.about:
//                Toast.makeText(this, "Вы выбрали инфо", Toast.LENGTH_SHORT).show();
//                return true;
            case R.id.site:
                Toast.makeText(this, "Вы выбрали сайт", Toast.LENGTH_SHORT).show();
                return true;

        }

        return super.onOptionsItemSelected(item);
    }

    public void onShow (View v) {
        Intent intent;
        switch (v.getId()){
            case R.id.btnPresented:
                intent = new Intent(this, PresentedActivity.class);
                startActivityForResult(intent, RequestCode.REQUEST_CODE_PRESENTED);
                break;
            case R.id.btnLanguage:
                intent = new Intent(this, LanguageActivity.class);
                startActivityForResult(intent, RequestCode.REQUEST_CODE_LANGUAGE);
                break;

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case RequestCode.REQUEST_CODE_PRESENTED:
                    String name = data.getStringExtra("name");
                    txtName.setText("Рад знакомству, " + name);
                    break;
                case RequestCode.REQUEST_CODE_LANGUAGE:
                    String language = data.getStringExtra("language");
                    txtLanguage.setText(language);
                    break;
            }
        } else {
            Toast.makeText(this, "error", Toast.LENGTH_SHORT).show();
        }
    }

    public void showDialog(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

        builder.setTitle("Внимание!")
                .setMessage("Привет, юзер.\n" +
                        "Соглашайся!")
                .setCancelable(true)
                .setIcon(R.drawable.ic_launcher)
                .setNegativeButton("Нет", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(), "Какой непослушный :-(", Toast.LENGTH_SHORT).show();
                    }
                })
                .setPositiveButton("Да", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(), "Красавчик!", Toast.LENGTH_SHORT).show();
                    }
                })
                .setOnCancelListener(new DialogInterface.OnCancelListener() {
                    @Override
                    public void onCancel(DialogInterface dialog) {
                        Toast.makeText(getApplicationContext(), "Что за игнор?!", Toast.LENGTH_SHORT).show();
                    }
                })
                .setNeutralButton("Ну не знаю", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(), "Попробуй еще разок!", Toast.LENGTH_SHORT).show();

                    }
                });


        AlertDialog alert = builder.create();
        alert.show();



    }

    public void onInfoLog(View view) {
        Log.i(TAG, "Info level");

    }

    public void onWanrLog(View view) {
        Log.w(TAG, "Warn level");
    }

    public void onErrorLog(View view) {
        Log.e(TAG, "Error level");
    }

    public void onDebugLog(View view) {
        Log.d(TAG, "Debug level");
    }

    private List<PhoneModel> initData() {
        List<PhoneModel> list = new ArrayList<PhoneModel>();

        list.add(new PhoneModel(1, "Iphone", 70000));
        list.add(new PhoneModel(2, "LG", 33000));
        list.add(new PhoneModel(3, "Samsung", 40000));
        list.add(new PhoneModel(4, "HTC", 35000));

        return list;
    }

    private int counter = 0;
    public void showNotification(View view) {
        counter++;
        Notification.Builder builder = new Notification.Builder(getApplicationContext());

        Intent intent = new Intent(getApplicationContext(), FinishActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(), 0, intent, PendingIntent.FLAG_CANCEL_CURRENT);
        builder
                .setContentIntent(pendingIntent)
                .setSmallIcon(R.drawable.ic_launcher)
                .setLargeIcon(BitmapFactory.decodeResource(getApplicationContext().getResources(), R.drawable.sanchoicon))
                .setTicker("Новое уведомление")
                .setWhen(System.currentTimeMillis())
                .setAutoCancel(true)
                .setContentTitle("Уведомление")
                .setContentText("Нажмите, чтобы узнать секрет")
                .setProgress(100, 20, true);
           //     .setSound(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.boom_headshot));

        Notification notification = builder.build();
      //  notification.defaults = Notification.DEFAULT_VIBRATE | Notification.DEFAULT_LIGHTS;
       if (counter == 0) {
           notification.sound = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.headshot); }
        else {
           notification.sound = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.boom_headshot);
       }

        long[] vibrate = new long[]{100, 100, 100, 200, 100, 100};
        notification.vibrate = vibrate;
        notification.flags = notification.flags | Notification.FLAG_INSISTENT | Notification.FLAG_ONGOING_EVENT;
        nm.notify(NOTIFICATION_ID, notification);


    }

    public void cancelNotification(View view) {
        nm.cancel(NOTIFICATION_ID);
    }
}
