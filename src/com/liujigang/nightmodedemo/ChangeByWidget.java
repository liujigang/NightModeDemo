package com.liujigang.nightmodedemo;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * 对各个控件进行设置
 * 
 * @author liujigang
 * @version 1.0
 * @since 2014-7-15
 */
public class ChangeByWidget extends Activity implements OnClickListener {
	private TextView text;
	private LinearLayout wid;
	private int i;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_widget);
		initTitle();
		text = (TextView) findViewById(R.id.tv_text);
		wid = (LinearLayout) findViewById(R.id.ll_widget);
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

	private void change(boolean bl) {
		if (bl) {
			text.setTextColor(Color.GRAY);
			wid.setBackgroundColor(Color.BLACK);
		} else {
			text.setTextColor(Color.BLACK);
			wid.setBackgroundColor(Color.WHITE);
		}

	}
}
