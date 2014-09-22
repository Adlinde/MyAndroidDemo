package com.example.demo;


import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import android.content.Context;
import android.os.Environment;

public class FileService {
	
	private Context context;
	
	public FileService(Context context) {
		
		// TODO Auto-generated constructor stub
		this.context=context;
	}
	
	public String getFileFromSdcard(String fileName){
		
		
		FileInputStream inputStream=null;
		//���������������޹أ�����Ҫ�ر�
		ByteArrayOutputStream outputStream=new ByteArrayOutputStream();
		
		File file=new File(Environment.getExternalStorageDirectory(),fileName);
		
		
		//�ж�sdcard�Ƿ����
		if(Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())){
			
			try {
				inputStream=new FileInputStream(file);
				int len=0;
				byte[] data=new byte[1024];
				
				while ((len =inputStream.read(data))!=-1) {
					outputStream.write(data,0,len);
				}
				
			} catch (Exception e) {
				// TODO: handle exception
			}
			finally{
				if(inputStream!=null){
					
					try {
						inputStream.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
		
		return new String(outputStream.toByteArray());
	}
	
	
	/**
	 * �洢sdcard
	 * @param fileName�ļ�����
	 * @param content�ļ�����
	 * @return
	 */
	public boolean savecontentToSdcard(String fileName,String content){
		boolean flag=false;
		
		FileOutputStream fileOutputStream=null;
		
		File file=new File(Environment.getExternalStorageDirectory(),fileName);
		//�ж�sdcard�Ƿ����
		if(Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())){
			
			try {
				fileOutputStream=new FileOutputStream(file);
				fileOutputStream.write(content.getBytes());
				
				flag=true;
			} catch (Exception e) {
				// TODO: handle exception
			}
			finally{
				if(fileOutputStream!=null){
					
					try {
						fileOutputStream.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
		
		return flag;
	}

}
