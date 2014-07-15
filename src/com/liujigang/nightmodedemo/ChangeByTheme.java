package com.liujigang.nightmodedemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
/**
 * 通过主题
 * @author liujigang
 * @version 1.0
 * @since 2014-7-15
 */
public class ChangeByTheme extends Activity implements OnClickListener {
	private int i;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		if(System.currentTimeMillis()%2==0){
			System.out.println("白天模式");
			setTheme(R.style.LightMode);
		}else{
			System.out.println("夜间模式");
			setTheme(R.style.NightMode);
		}
		setContentView(R.layout.activity_theme);
		initTitle();
	}

	private void initTitle() {
		findViewById(R.id.btn_back).setOnClickListener(this);
		findViewById(R.id.btn_changle).setOnClickListener(this);
	}
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn_back:
			this.finish();
			break;
		case R.id.btn_changle:
			change(i++ % 2 == 0);
			break;

		default:
			break;
		}
	}

	private void change(boolean b) {
//		if (b) {
//			this.setTheme(R.style.LightMode);
//		}else{
//			this.setTheme(R.style.NightMode);
//		}
		this.finish();
		overridePendingTransition(0, 0);
		Intent intent=new Intent(getApplicationContext(), this.getClass());
//		intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
		this.startActivity(intent);
		setContentView(R.layout.activity_theme);
	}

	@Override
	protected void onStart() {
		super.onStart();
	}

	@Override
	protected void onRestart() {
		// TODO Auto-generated method stub
		super.onRestart();
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
	}

	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
	}
	
	
}
