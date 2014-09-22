package com.example.activitychangegif;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ViewFlipper;

public class MainActivity extends Activity {
	private ViewFlipper vFlipper;
	
	private float startx;
	
	private Animation in_lefttoright;
	private Animation out_lefttoright;
	private Animation in_righttoleft;
	private Animation out_righttoleft;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		in_lefttoright=AnimationUtils.loadAnimation(this, R.anim.left_right);
		out_lefttoright=AnimationUtils.loadAnimation(this, R.anim.out_left_right);
		
		
		in_righttoleft=AnimationUtils.loadAnimation(this, R.anim.right_left);
		out_righttoleft=AnimationUtils.loadAnimation(this, R.anim.out_right_left);
		vFlipper=(ViewFlipper)this.findViewById(R.id.viewFlipper); 
		
		
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		if(event.getAction()==MotionEvent.ACTION_DOWN){
			startx=event.getX();
		}
		else if(event.getAction()==MotionEvent.ACTION_UP)
		{
			float endx=event.getX();
			if(endx>startx){
				vFlipper.setInAnimation(in_lefttoright);
				vFlipper.setOutAnimation(out_lefttoright);
				vFlipper.showNext();//显示下一页
			}
			else if(endx<startx){
				vFlipper.setInAnimation(in_righttoleft);
				vFlipper.setOutAnimation(out_righttoleft);
				vFlipper.showPrevious();//显示前一页
			}
			return true;
		}
		return super.onTouchEvent(event);
	}
	
	
//	public void openActivity(View v){
//		Intent intent=new Intent(MainActivity.this,OtherActivity.class);
//		startActivity(intent);
//		this.overridePendingTransition(R.anim.alpha, R.anim.outalpha);//进入动画---退出动画		
//	}
	
	

}
