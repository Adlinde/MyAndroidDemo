package com.example.handler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.handler.DownLoadImage.ImageCallBack;

public class MainActivity extends Activity {

	private ListView listView;

	private ProgressDialog dialog;

	private MyAdapter adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		listView = (ListView) this.findViewById(R.id.listView1);
		dialog = new ProgressDialog(this);

		adapter = new MyAdapter(this);//构建适配器

		dialog.setTitle("提示");
		dialog.setMessage("正在下载请稍后");

		new MyTask().execute(CommonUrl.PRODUCT_URL);
	}

	/** djfaldfja
	 * @author 孙世东 */
	public class MyTask extends AsyncTask<String, Void, List<Map<String, Object>>> {

		@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub
			super.onPreExecute();
			dialog.show();
		}

		@Override
		protected void onPostExecute(List<Map<String, Object>> result) {
			// TODO Auto-generated method stub
			super.onPostExecute(result);
			adapter.setData(result);
			listView.setAdapter(adapter);
			//提醒
			adapter.notifyDataSetChanged();
			dialog.dismiss();
		}

		@Override
		protected List<Map<String, Object>> doInBackground(String... params) {
			// TODO Auto-generated method stub
			List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
			//连接网络获取json数据并且进行解析；
			try {
				//				HttpClient httpClient=new DefaultHttpClient();
				//				HttpPost httpPost=new HttpPost(params[0]);
				//				
				//				HttpResponse httpResponse=httpClient.execute(httpPost);
				//				if(httpResponse.getStatusLine().getStatusCode()==200){
				//					
				//					String jsonString=EntityUtils.toString(httpResponse.getEntity(),
				//							"utf-8");
				String jsonString = "{\"product\":[{\"address\":\"河北\",\"price\":25,\"proimage\":\"001.png\",\"name\":\"苹果\",\"proid\":\"001\"}," + "{\"address\":\"河北2\",\"price\":252,\"proimage\":\"002.png\",\"name\":\"苹果2\",\"proid\":\"002\"}," + "{\"address\":\"河北3\",\"price\":253,\"proimage\":\"003.png\",\"name\":\"苹果3\",\"proid\":\"003\"}," + "{\"address\":\"河北4\",\"price\":254,\"proimage\":\"004.png\",\"name\":\"苹果4\",\"proid\":\"004\"}]}";
				JSONObject jsonObject = new JSONObject(jsonString);
				JSONArray jsonArray = jsonObject.getJSONArray("product");
				for (int i = 0; i < jsonArray.length(); i++) {
					JSONObject jsonObject2 = jsonArray.getJSONObject(i);
					Map<String, Object> map = new HashMap<String, Object>();
					Iterator<String> iterator = jsonObject2.keys(); //对待输出json的key作为map的key
					while (iterator.hasNext()) {
						String key = iterator.next();
						Object value = jsonObject2.get(key);
						map.put(key, value);
					}
					list.add(map);
				}
				//}

			} catch (Exception e) {
				e.printStackTrace();
			}
			return list;
		}

	}

	
	public class MyAdapter extends BaseAdapter {

		public Context context;
		public LayoutInflater layoutInflater;
		private List<Map<String, Object>> list = null;

		public MyAdapter(Context context) {
			// TODO Auto-generated constructor stub
			this.context = context;
			layoutInflater = layoutInflater.from(context);
		}

		public void setData(List<Map<String, Object>> list) {
			this.list = list;
		}

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return list.size();
		}

		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return list.get(position);
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
			View view = null;
			if (convertView == null) {
				view = layoutInflater.inflate(R.layout.item, null);
			} else {
				view = convertView;
			}
			TextView name = (TextView) view.findViewById(R.id.textView1);
			TextView price = (TextView) view.findViewById(R.id.textView2);
			TextView address = (TextView) view.findViewById(R.id.textView3);

			name.setText(list.get(position).get("name").toString());
			price.setText(list.get(position).get("price").toString());
			address.setText(list.get(position).get("address").toString());
			//加载图片

			final ImageView imageView = (ImageView) view.findViewById(R.id.imageView1);

			//图片下载类
			//			DownLoadImage downLoadImage=new DownLoadImage(CommonUrl.PRODUCT_IMG+
			//					list.get(position).get("images").toString());
			DownLoadImage downLoadImage = new DownLoadImage(CommonUrl.PRODUCT_IMG);
			downLoadImage.loadImage(new ImageCallBack() {

				//接口的回调方法 。命名内部类，
				@Override
				public void getDrawable(Drawable drawable) {
					imageView.setImageDrawable(drawable);
				}
			});

			return view;
		}

	}

}
