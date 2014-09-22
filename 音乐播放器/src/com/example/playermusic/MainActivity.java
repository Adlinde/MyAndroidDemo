package com.example.playermusic;

import java.io.File;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import android.os.Bundle;
import android.os.Environment;
import android.app.Activity;
import android.content.Context;
import android.drm.DrmStore.Playback;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	private EditText editText;
	private String path;
	private MediaPlayer mediaPlayer;
	private boolean pause;
	private int position;

	//private Button button1, button2, button3, button4;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		editText = (EditText) this.findViewById(R.id.editText1);
		
		mediaPlayer = new MediaPlayer();
//		
//		TelephonyManager telephonyManager=(TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
//		
//		telephonyManager.listen(new PhoneStateListener(){
//			@Override
//			public void onCallStateChanged(int state, String incomingNumber) {
//				switch (state) {
//				case  TelephonyManager.CALL_STATE_RINGING:
//					if (mediaPlayer.isPlaying()) {
//						position=mediaPlayer.getCurrentPosition();
//						mediaPlayer.stop();
//					}
//					break;
//				case  TelephonyManager.CALL_STATE_IDLE:
//					if(position>0&&path!=null){
//						play();
//						mediaPlayer.seekTo(position);
//						position=0;
//					}
//					break;
//				}
//			}
//			
//		}, PhoneStateListener.LISTEN_CALL_STATE);
	}
	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
	}

	public void mediaplay(View v) {
		String filename = editText.getText().toString();

		switch (v.getId()) {
		case R.id.button1:
			File audio = new File(Environment.getExternalStorageDirectory(), filename);
			if (audio.exists()) {
				path = audio.getAbsolutePath();
				play();
			} else {
				Toast.makeText(MainActivity.this, "ssss", 1).show();
			}
			break;
		case R.id.button2:
			if (mediaPlayer.isPlaying()) {
				mediaPlayer.pause();//��ͣ
				pause = true;
				((Button) v).setText("����");
			} else {
				if (pause) {
					mediaPlayer.start();//��������
					pause = false;
					((Button) v).setText("��ͣ");
				}
				Toast.makeText(MainActivity.this, "", 1).show();
			}
			break;
		case R.id.button3:
			if (mediaPlayer.isPlaying()) {
				mediaPlayer.seekTo(0);//�ؿ�ʼλ�ò���
			}else{
				if(path!=null){
					play();
				}
			}
			break;
		case R.id.button4:
			if (mediaPlayer.isPlaying()) {
				mediaPlayer.stop();//ֹͣ
			}
			break;
		}
	}

	//���Ű�ť
	private void play() {
		try {
			mediaPlayer.reset();//�ɸ�������ָ����ʼ״̬
			mediaPlayer.setDataSource(path);
			mediaPlayer.prepare();//�������ݵĻ���
			mediaPlayer.setOnPreparedListener(new OnPreparedListener() {
				@Override
				public void onPrepared(MediaPlayer mp) {
					mediaPlayer.start();//��ʼ����
				}
			});
		} catch (Exception e) {
		}
	}

	@Override
	protected void onDestroy() {
		mediaPlayer.release();
		mediaPlayer = null;
		super.onDestroy();
	}
	
//	@Override
//	protected void onPause() {
//		if (mediaPlayer.isPlaying()) {
//			position=mediaPlayer.getCurrentPosition();
//			mediaPlayer.stop();
//		}
//		super.onPause();
//	}
//	
//	@Override
//	protected void onResume() {
//		if(position>0&&path!=null){
//			play();
//			mediaPlayer.seekTo(position);
//		}
//		super.onResume();
//	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
