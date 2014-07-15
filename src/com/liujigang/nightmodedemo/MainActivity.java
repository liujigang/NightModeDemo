package com.liujigang.nightmodedemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	public void typeOne(View view) {
		startInten(ChangeByWidget.class);
	}

	public void typeTwo(View view) {
		startInten(ChangeByTheme.class);
	}

	public void typeThree(View view) {
		startInten(ChangeByMask.class);
	}

	private void startInten(Class<? extends Activity> clazz) {
		this.startActivity(new Intent(getApplicationContext(), clazz));
	}
}
