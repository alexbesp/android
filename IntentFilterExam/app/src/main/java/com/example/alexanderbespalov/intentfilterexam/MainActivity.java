package com.example.alexanderbespalov.intentfilterexam;

import android.Manifest;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void explicitCall(View view) {
        Intent intent = new Intent(this, CurrentDateActivity.class);
        startActivity(intent);
    }

    public void implicitCall(View view) {
        Intent intent = new Intent(".SiteActivity");
        startActivity(intent);
    }

    public void openContects(View view) {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("com.android.contacts", "com.android.contacts.DialtactsContactsEntryActivity"));
        startActivity(intent);
    }

    public void startDial(View view) {
/*        public void requestMultiplePermissions(){   //запрос разрешения
            ActivityCompat.requestPermissions(this,
                    new String[] {
                            Manifest.permission.CALL_PHONE,
                            Manifest.permission.READ_SMS
                    },
                    PERMISSION_REQUEST_CODE);
        } */
            ActivityCompat.requestPermissions(this,
                    new String[] {
                            Manifest.permission.CALL_PHONE,
                    },
                    1);

        startActivity(new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "112")));
    }
}

