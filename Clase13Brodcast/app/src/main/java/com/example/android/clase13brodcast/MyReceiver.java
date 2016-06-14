package com.example.android.clase13brodcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.util.Log;

public class MyReceiver extends BroadcastReceiver {
    public MyReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.

        Bundle info = intent.getExtras();
        if(info!=null){
            Object[] pduArray = (Object[]) info.get("pdus");
            SmsMessage[] messages = new SmsMessage[pduArray.length];
            for(int i=0;i<pduArray.length;i++)
            {
                messages[i]=SmsMessage.createFromPdu((byte[])pduArray[i]);
                Log.d("br", "Msg de:" + messages[i].getOriginatingAddress());
                Log.d("br","Texto:"+messages[i].getMessageBody());
            }
        }
    }

}
