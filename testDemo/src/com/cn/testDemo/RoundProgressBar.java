package com.cn.testDemo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
/** 仿iphone带进度的进度条，线程安全的View，可直接在线程中更新进度
 * @author xiaanming */
public class RoundProgressBar extends View {
	/** 画笔对象的引用 */
	private Paint paint;
	/** 圆环的颜色 */
	private int roundColor;
	/** 圆环进度的颜色 */
	private int roundProgressColor;
	/** 圆环的宽度 */
	private float roundWidth;
	/** 最大进度 */
	private int max;
	/** 当前进度 */
	private int progress;

	public RoundProgressBar(Context context) {
		this(context, null);
	}

	public RoundProgressBar(Context context, AttributeSet attrs) {
		this(context, attrs, 0);
	}

	public RoundProgressBar(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		paint = new Paint();
		roundColor = Color.parseColor("#e3e3e3");
		roundProgressColor = Color.parseColor("#d84541");
		//roundWidth = toPx(6);
		roundWidth = 6;
		max = 100;
	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);

		/** 画最外层的大圆环 */
		int centre = getWidth() / 2; //获取圆心的x坐标
		//int radius = toPx(27); //圆环的半径
		int radius = 27; //圆环的半径
		paint.setColor(roundColor); //设置圆环的颜色
		paint.setStyle(Paint.Style.STROKE); //设置空心
		paint.setStrokeWidth(roundWidth); //设置圆环的宽度
		paint.setAntiAlias(true); //消除锯齿 
		canvas.drawCircle(centre, centre, radius, paint); //画出圆环
		/** 画圆弧 ，画圆环的进度 */
		//设置进度是实心还是空心
		paint.setStrokeWidth(roundWidth); //设置圆环的宽度
		paint.setColor(roundProgressColor); //设置进度的颜色
		RectF oval = new RectF(centre - radius, centre - radius, centre + radius, centre + radius); //用于定义的圆弧的形状和大小的界限
		paint.setStyle(Paint.Style.STROKE);
		canvas.drawArc(oval, 180, 360 * progress / max, false, paint); //根据进度画圆弧,3.圆弧扫过的角度，顺时针方向，单位为度
	}

	public synchronized int getMax() {
		return max;
	}

	/** 设置进度的最大值
	 * @param max */
	public synchronized void setMax(int max) {
		if (max < 0) {
			throw new IllegalArgumentException("max not less than 0");
		}
		this.max = max;
	}

	/** 获取进度.需要同步
	 * @return */
	public synchronized int getProgress() {
		return progress;
	}

	/** 设置进度，此为线程安全控件，由于考虑多线的问题，需要同步 刷新界面调用postInvalidate()能在非UI线程刷新
	 * @param progress */
	public synchronized void setProgress(double progress) {
		if (progress < 1) {
			progress = 1;
		}
		if (progress > max) {
			progress = max;
		}
		if (progress <= max) {
			this.progress = (int) progress;
			postInvalidate();
		}

	}

	public int getCricleColor() {
		return roundColor;
	}

	public void setCricleColor(int cricleColor) {
		this.roundColor = cricleColor;
	}

	public int getCricleProgressColor() {
		return roundProgressColor;
	}

	public void setCricleProgressColor(int cricleProgressColor) {
		this.roundProgressColor = cricleProgressColor;
	}

	public float getRoundWidth() {
		return roundWidth;
	}

	public void setRoundWidth(float roundWidth) {
		this.roundWidth = roundWidth;
	}
}
