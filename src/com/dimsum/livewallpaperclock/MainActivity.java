package com.dimsum.livewallpaperclock;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextClock;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		
		setContentView(R.layout.activity_main);
		
		TextClock mainClock = (TextClock) findViewById(R.id.main_clock);
		mainClock.setFormat12Hour("h:mm");
		
		TextClock dayOfWeek = (TextClock) findViewById(R.id.day_of_week);
		dayOfWeek.setFormat12Hour("EEEE");

		TextClock month = (TextClock) findViewById(R.id.month);
		month.setFormat12Hour("MMMM");
		
		TextClock year = (TextClock) findViewById(R.id.year);
		year.setFormat12Hour("yyyy");
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
}
