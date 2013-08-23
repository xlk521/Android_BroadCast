package com.example.broadcast;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;
/**
 * 
 * 响应自己机器中的变化 ===> 广播
 * 
 * 另外添加了一个关于menu键的响应，界面是main.xml文件。
 * 最后两个函数就是这个的显示以及响应函数
 * 
 * */
public class MainActivity extends Activity {

	private Button btn = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		btn = (Button)findViewById(R.id.button1);
		btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				registerReceiver(new Recever(), new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater m = new MenuInflater(this);
		m.inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		if (item.getGroupId() == R.id.setting) {
			if (item.isChecked()) {
				item.setChecked(false);
			}else{
				item.setChecked(true);
			}
		}
		if (item.getItemId() != R.id.item2) {
			Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
		}
		return true;
	}

}
