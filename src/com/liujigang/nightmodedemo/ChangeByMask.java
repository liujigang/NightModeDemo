package com.liujigang.nightmodedemo;

import android.app.Activity;
import android.content.Context;
import android.graphics.PixelFormat;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout.LayoutParams;
/**
 * 通过遮罩层次
 * @author liujigang
 * @version 1.0
 * @since 2014-7-15
 */
public class ChangeByMask extends Activity implements OnClickListener {
	private View view;
	private WindowManager mWm;
	private int i;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_mask);
		initTitle();
		
		mWm = (WindowManager)getSystemService(Context.WINDOW_SERVICE);
		view = new View(getApplicationContext());
		view.setBackgroundColor(0xBB000000);
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
		if (b) {
			WindowManager.LayoutParams params = new WindowManager.LayoutParams(
					LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT,
					WindowManager.LayoutParams.TYPE_APPLICATION,
					WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE
							| WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
					PixelFormat.TRANSLUCENT);
			params.gravity = Gravity.BOTTOM;
//			params.y = 10;
			mWm.addView(view, params);
		}else{
			mWm.removeView(view);
		}
	}
}
