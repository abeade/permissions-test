package com.example.permissions.permissionstest;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.PermissionChecker;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import static android.support.v4.content.PermissionChecker.PERMISSION_DENIED;
import static android.support.v4.content.PermissionChecker.PERMISSION_DENIED_APP_OP;
import static android.support.v4.content.PermissionChecker.PERMISSION_GRANTED;

public class MainActivity extends AppCompatActivity {

    private TextView tvStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvStatus = (TextView)findViewById(R.id.tv_status);
    }

    public void onPermissionClick(View v) {
        if (PermissionChecker.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 0);
        } else {
            updatePermissionStatus();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        // Each time the permission request result is received update the current permission status
        updatePermissionStatus();
    }

    private void updatePermissionStatus() {
        switch (PermissionChecker.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)) {
            case PERMISSION_DENIED:
                tvStatus.setText("PERMISSION DENIED");
                break;
            case PERMISSION_DENIED_APP_OP:
                // THIS IS STATUS IS NEVER RETURNED!!!
                tvStatus.setText("PERMISSION DENIED APP OP");
                break;
            case PERMISSION_GRANTED:
                tvStatus.setText("PERMISSION GRANTED");
                break;
        }
    }
}
