package com.example.demo;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewDebug.IntToString;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends Activity implements OnClickListener {

	private Button selectImageBtn;
	
	private Button cutImageBtn;
	
	private ImageView imageView;
	//����������̬���α�����������ͼ�ķ��ر�־
	private static final  int IMAGE_SELECT=1;//ѡ��ͼƬ
	private static final  int IMAGE_CUT=2;//�ü�ͼƬ
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		selectImageBtn=(Button)this.findViewById(R.id.selectimagebtn);
		cutImageBtn=(Button)this.findViewById(R.id.cutimagebtn);
		imageView=(ImageView)this.findViewById(R.id.imageview);
		
		
		selectImageBtn.setOnClickListener(this);
		
		cutImageBtn.setOnClickListener(this);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		
		if(resultCode==RESULT_OK){
			
			if(requestCode==IMAGE_SELECT){
				Uri uri=data.getData();//���ͼƬ��·��
				int dw=getWindowManager().getDefaultDisplay().getWidth();//�����Ļ�Ŀ��
				int dh=getWindowManager().getDefaultDisplay().getHeight()/2;//�����Ļ�ĸ߶�
				
				try {
					//ʵ�ֶ�ͼƬ�Ĳü����࣬��һ���������ڲ���
					BitmapFactory.Options factory=new BitmapFactory.Options();
					
					factory.inJustDecodeBounds=true;//�������Ϊtrue�������ѯͼƬ���ǰ������ط�����ڴ�
					
					Bitmap bmp=BitmapFactory.decodeStream(getContentResolver().openInputStream(uri),null,factory);
					
					//ʵ��ͼƬ�Ŀ�Ⱥ͸߶ȶ����ֻ�����Ļ����ƥ��
					int hRatio=(int)Math.ceil(factory.outHeight/(float)dh);
					int wRatio=(int)Math.ceil(factory.outWidth/(float)dw);
					//�������1��ʾͼƬ�Ŀ�ȴ����ֻ���Ļ�Ŀ��
					
					//���ŵ�1/radio�ĳߴ��1/radio^2����
					
					if(hRatio>1||wRatio>1){
						if(hRatio>wRatio){
							factory.inSampleSize=hRatio;
						}else{
							
							factory.inSampleSize=wRatio;
						}
						
					}
					//��
					factory.inJustDecodeBounds=false;
					
					//ʹ��BitmapFactory��ͼƬ
					bmp=BitmapFactory.decodeStream(getContentResolver().openInputStream(uri),null,factory);
					
					imageView.setImageBitmap(bmp);
					
				} catch (Exception e) {
					// TODO: handle exception
				}
					
			}else if(requestCode==IMAGE_CUT){
				//��data���ͷ��ر�ǩһ��
				Bitmap bitmap=data.getParcelableExtra("data");
				
			}
		}
		
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.selectimagebtn:
			
			Intent intent=new Intent(Intent.ACTION_PICK,
					android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
			startActivityForResult(intent, IMAGE_SELECT);
			break;

        case R.id.cutimagebtn:
			
			Intent intent2=getImageClipIntent();
			startActivityForResult(intent2, IMAGE_CUT);
			break;
			
			
		default:
			break;
		}
		
	}

	private Intent getImageClipIntent() {
		Intent intent=new Intent(Intent.ACTION_GET_CONTENT,null);
		//ʵ�ֶ�ͼƬ�Ĳü�����������ͼƬ�����Ժʹ�С
		intent.setType("image/*");//��ȡ�����ͼƬ����
		intent.putExtra("crop","true" );//����ѡ��ͼƬ����
		intent.putExtra("aspectX",1);//
		intent.putExtra("aspectY",1 );
		intent.putExtra("outputX",80 );
		intent.putExtra("outputY",80 );
		intent.putExtra("return-data",true );
		
		
		return intent;
	}

}
