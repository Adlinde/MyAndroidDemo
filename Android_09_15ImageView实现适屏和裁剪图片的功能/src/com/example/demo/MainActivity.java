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
	//声明两个静态整形变量，用于意图的返回标志
	private static final  int IMAGE_SELECT=1;//选择图片
	private static final  int IMAGE_CUT=2;//裁剪图片
	
	
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
				Uri uri=data.getData();//获得图片的路径
				int dw=getWindowManager().getDefaultDisplay().getWidth();//获得屏幕的宽度
				int dh=getWindowManager().getDefaultDisplay().getHeight()/2;//获得屏幕的高度
				
				try {
					//实现对图片的裁剪的类，是一个匿名的内部类
					BitmapFactory.Options factory=new BitmapFactory.Options();
					
					factory.inJustDecodeBounds=true;//如果设置为true，允许查询图片不是按照像素分配给内存
					
					Bitmap bmp=BitmapFactory.decodeStream(getContentResolver().openInputStream(uri),null,factory);
					
					//实现图片的宽度和高度对于手机的屏幕进行匹配
					int hRatio=(int)Math.ceil(factory.outHeight/(float)dh);
					int wRatio=(int)Math.ceil(factory.outWidth/(float)dw);
					//如果大于1表示图片的宽度大于手机屏幕的宽度
					
					//缩放到1/radio的尺寸和1/radio^2像素
					
					if(hRatio>1||wRatio>1){
						if(hRatio>wRatio){
							factory.inSampleSize=hRatio;
						}else{
							
							factory.inSampleSize=wRatio;
						}
						
					}
					//对
					factory.inJustDecodeBounds=false;
					
					//使用BitmapFactory对图片
					bmp=BitmapFactory.decodeStream(getContentResolver().openInputStream(uri),null,factory);
					
					imageView.setImageBitmap(bmp);
					
				} catch (Exception e) {
					// TODO: handle exception
				}
					
			}else if(requestCode==IMAGE_CUT){
				//”data“和返回标签一样
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
		//实现对图片的裁剪，必须设置图片的属性和大小
		intent.setType("image/*");//获取任意的图片类型
		intent.putExtra("crop","true" );//滑动选中图片区域；
		intent.putExtra("aspectX",1);//
		intent.putExtra("aspectY",1 );
		intent.putExtra("outputX",80 );
		intent.putExtra("outputY",80 );
		intent.putExtra("return-data",true );
		
		
		return intent;
	}

}
