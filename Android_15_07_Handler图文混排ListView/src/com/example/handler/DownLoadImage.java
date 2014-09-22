package com.example.handler;

import java.net.URL;
import android.graphics.drawable.Drawable;
import android.os.Handler;

public class DownLoadImage {

	private String image_path;

	public DownLoadImage(String image_path) {
		this.image_path = image_path;
	}

	public void loadImage(final ImageCallBack imageCallBack) {
		Handler handler = new Handler();
		//¿ªÆôÏß³Ì
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					final Drawable drawable = Drawable.createFromStream(new URL(image_path).openStream(), "");
					new Handler().post(new Runnable() {
						@Override
						public void run() {
							imageCallBack.getDrawable(drawable);
						}
					});
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}).start();
	}

	public interface ImageCallBack {

		public void getDrawable(Drawable drawable);
	}

}
