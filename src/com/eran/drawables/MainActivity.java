package com.eran.drawables;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;

public class MainActivity extends Activity {
	private FrameLayout frBorder = null;
	private Button btn1 = null;
	private Button btn2 = null;
	private Button btn3 = null;
	private Button btn4 = null;
	private Button btn5 = null;
	private Button btn6 = null;
	private Button btn7 = null;
	private Button btn8 = null;
	private OnClickListener onclick = null;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		frBorder = (FrameLayout)findViewById(R.id.frBorder);
		onclick = new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				comeToMe(v);
				
			}
		};
		btn1 = (Button)findViewById(R.id.button1);
		btn2 = (Button)findViewById(R.id.button2);
		btn3 = (Button)findViewById(R.id.button3);
		btn4 = (Button)findViewById(R.id.button4);
		btn5 = (Button)findViewById(R.id.button5);
		btn6 = (Button)findViewById(R.id.button6);
		btn7 = (Button)findViewById(R.id.button7);
		btn8 = (Button)findViewById(R.id.button8);
		btn1.setOnClickListener(onclick);
		btn2.setOnClickListener(onclick);
		btn3.setOnClickListener(onclick);
		btn4.setOnClickListener(onclick);
		btn5.setOnClickListener(onclick);
		btn6.setOnClickListener(onclick);
		btn7.setOnClickListener(onclick);
		btn8.setOnClickListener(onclick);
	}

	@Override
	public void onWindowFocusChanged(boolean hasFocus) {
		// TODO Auto-generated method stub
		super.onWindowFocusChanged(hasFocus);
		
		int width = btn1.getWidth();
		int height = btn1.getHeight();
		frBorder.setLayoutParams(new LayoutParams(width, height));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void comeToMe(View view){
		RelativeLayout root = (RelativeLayout) findViewById( R.id.rootLayout );
		DisplayMetrics dm = new DisplayMetrics();
		this.getWindowManager().getDefaultDisplay().getMetrics( dm );
		int statusBarOffset = dm.heightPixels - root.getMeasuredHeight();

		int originalPos[] = new int[2];
		int destPos[] = new int[2];
	    view.getLocationOnScreen( destPos );
	    frBorder.getLocationOnScreen( originalPos );


	    frBorder.animate().x(destPos[0]);
	    frBorder.animate().y(destPos[1]- statusBarOffset);
	    frBorder.animate().setDuration(500);

	}
	
	public float convertToPx(int dp){
		Resources r= getResources();
	    float px = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics());
	    return px;
	}

}
