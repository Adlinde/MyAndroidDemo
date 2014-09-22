package com.example.demo;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;

public class MainActivity extends Activity implements OnSeekBarChangeListener {

	private int minWidth;
	private ImageView imageView;
	private TextView textView1, textView2;

	private Matrix matrix = new Matrix();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		imageView = (ImageView) this.findViewById(R.id.imageview);
		SeekBar seekBar1 = (SeekBar) this.findViewById(R.id.seekbar);
		SeekBar seekBar2 = (SeekBar) this.findViewById(R.id.seekbar2);

		textView1 = (TextView) this.findViewById(R.id.textview1);
		textView2 = (TextView) this.findViewById(R.id.textview2);

		seekBar1.setOnSeekBarChangeListener(this);
		seekBar2.setOnSeekBarChangeListener(this);
		//
		DisplayMetrics dm = new DisplayMetrics();

		getWindowManager().getDefaultDisplay().getMetrics(dm);

		seekBar1.setMax(dm.widthPixels - minWidth);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
		if (seekBar.getId() == R.id.seekbar) {
			int newWidth = progress + minWidth;
			int newHeight = (int) (newWidth * 3 / 4);
			imageView.setLayoutParams(new LinearLayout.LayoutParams(newWidth, newHeight));

			textView1.setText("图像宽度：" + newWidth + "图像高度：" + newHeight);

		} else if (seekBar.getId() == R.id.seekbar2) {
			Bitmap bitmap = ((BitmapDrawable) (getResources()
					.getDrawable(R.drawable.pand))).getBitmap();
			
			matrix.setRotate(progress);//设置翻转的角度
			
			bitmap=Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(),
					bitmap.getHeight(),matrix,true);
			
			imageView.setImageBitmap(bitmap);
			
			textView2.setText(progress+"度");
			
		}

	}

	@Override
	public void onStartTrackingTouch(SeekBar seekBar) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStopTrackingTouch(SeekBar seekBar) {
		// TODO Auto-generated method stub

	}

}
