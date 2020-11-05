package com.example.mediconline;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;

import android.os.Bundle;
import android.view.View;

public class formulario_registro extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_registro);
    }
    //insertarpaciente
    public void insertarpaciente(View v) {

        addNotification();
    }
    private void addNotification() {
        NotificationCompat.Builder builder=
                new NotificationCompat.Builder(this,"chmediconline")
                        .setSmallIcon(R.drawable.aa)
                        .setContentTitle("Se ha registrado con éxito")
                        .setContentText("Revise su correo electrónico en los próximos 2 días")
                        .setAutoCancel(true)
                        .setPriority(NotificationCompat.PRIORITY_DEFAULT);
        NotificationManager manager=(NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            NotificationChannel ch = new NotificationChannel("chmediconline","Mediconline",
                    NotificationManager.IMPORTANCE_DEFAULT
            );
            if (manager != null) {
                manager.createNotificationChannel(ch);
                manager.notify(0, builder.build());
            }
        }
        else {
            manager.notify(0, builder.build());
        }
    }
}