package com.example.practiconro1;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;

public class MensajeRecibido extends BroadcastReceiver {
    private static Boolean flagLlamada = true;



    public void onReceive(Context context, Intent intent) {
        //   Toast.makeText(context, "Usted ha recibido un mensaje", Toast.LENGTH_LONG).show();
        String phoneNo = "911";

        if (intent.getExtras().getBoolean("connected") && flagLlamada) {
            String dial = "tel:" + phoneNo;
            flagLlamada = false;
            Intent i = new Intent(android.content.Intent.ACTION_CALL, Uri.parse(dial));
            context.startActivity(i);
       }else{
            flagLlamada = true;
        }
    }
}
