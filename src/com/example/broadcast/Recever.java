package com.example.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class Recever extends BroadcastReceiver{

	private static final String action = "android.provider.Telephony.SMS_RECEIVED";
	@Override
	public void onReceive(Context context, Intent intent) {
		if (intent.getAction().equals(action)) {
			Toast.makeText(context, context.getResources().getString(R.string.hello_world), Toast.LENGTH_SHORT).show();
		}else if(intent.getAction().equals(Intent.ACTION_BATTERY_CHANGED)){
			int level = intent.getIntExtra("level", 0);
			int scale = intent.getIntExtra("scale", 0);
			Toast.makeText(context, " £”‡µÁ¡ø£∫" + (level * 100 / scale) + "%", Toast.LENGTH_SHORT).show();
		}
	}
}
