package com.example.demo;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.SeekBar.OnSeekBarChangeListener;

public class MainActivity extends Activity implements OnSeekBarChangeListener {

	private TextView textView1,textView2;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		textView1=(TextView)this.findViewById(R.id.textview1);
		textView2=(TextView)this.findViewById(R.id.textview2);
		SeekBar seekBar1=(SeekBar)this.findViewById(R.id.seekbar1);
		SeekBar seekBar2=(SeekBar)this.findViewById(R.id.seekbar2);
		
		seekBar1.setOnSeekBarChangeListener(this);
		seekBar2.setOnSeekBarChangeListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	//�϶��� ����  progress�̶�  �̶���
	@Override
	public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
		if(seekBar.getId()==R.id.seekbar1){
			textView1.setText("seekBar1�ĵ�ǰλ��"+progress);
		}else{
			textView2.setText("seekBar2�ĵ�ǰλ��"+progress);
		}
		
	}

	//�����￪ʼ�϶�
	@Override
	public void onStartTrackingTouch(SeekBar seekBar) {
		
		if(seekBar.getId()==R.id.seekbar1){
			textView1.setText("seekBar1�ĵ�ǰλ��");
		}else{
			textView2.setText("seekBar2�ĵ�ǰλ��");
		}
	}

	//����������϶�
	@Override
	public void onStopTrackingTouch(SeekBar seekBar) {
		if(seekBar.getId()==R.id.seekbar1){
			textView1.setText("seekBar1�ĵ�ǰλ��");
		}else{
			textView2.setText("seekBar2�ĵ�ǰλ��");
		}
		
	}

}
