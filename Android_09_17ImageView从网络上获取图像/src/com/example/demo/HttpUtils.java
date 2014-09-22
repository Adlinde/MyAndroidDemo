package com.example.demo;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpUtils {

	private final static String URL_PATH = "http://c.hiphotos.baidu.com/image/pic/item/dbb44aed2e738bd4713eca94a38b87d6277ff97c.jpg";//��������ͼƬ��·��

	public HttpUtils() {
		// TODO Auto-generated constructor stub
	}

	/** ������ս��ȡͼƬ��Ϣ����������ʽ����
	 * @return
	 * @throws IOException */
	public static InputStream getimageViewInputStream() throws IOException {
		InputStream inputStream = null;

		URL url = new URL(URL_PATH);

		if (url != null) {

			HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
			httpURLConnection.setConnectTimeout(3000);//�������ӳ�ʱ��ʱ��
			httpURLConnection.setRequestMethod("GET");
			httpURLConnection.setDoInput(true);
			int response_code = httpURLConnection.getResponseCode();

			if (response_code == 200) {
				inputStream = httpURLConnection.getInputStream();

			}

		}

		return inputStream;
	}

	/** ������ս��ȡͼƬ��Ϣ�����ֽ�������ʽ����
	 * @return
	 * @throws IOException */
//	public static byte[] getImageViewArray() {
//		byte[] data = null;
//
//		InputStream inputStream = null;
//
//		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
//
//		try {
//			URL url = new URL(URL_PATH);
//
//			if (url != null) {
//
//				HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
//				httpURLConnection.setConnectTimeout(3000);//�������ӳ�ʱ��ʱ��
//				httpURLConnection.setRequestMethod("GET");//���󷽷�
//				httpURLConnection.setDoInput(true);//��������
//				int response_code = httpURLConnection.getResponseCode();
//
//				int len = 0;
//				byte[] b_data = new byte[1024];
//
//				if (response_code == 200) {
//					inputStream = httpURLConnection.getInputStream();
//					while ((len = inputStream.read(b_data)) != 1) {
//						outputStream.write(b_data, 0, len);
//
//					}
//					data = outputStream.toByteArray();
//				}
//
//			}
//
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		} finally {
//
//			if (inputStream != null) {
//				try {
//					inputStream.close();
//				} catch (IOException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//
//		}
//
//		return data;
//	}

}
