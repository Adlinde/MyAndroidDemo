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

		adapter = new MyAdapter(this);//����������

		dialog.setTitle("��ʾ");
		dialog.setMessage("�����������Ժ�");

		new MyTask().execute(CommonUrl.PRODUCT_URL);
	}

	/** djfaldfja
	 * @author ������ */
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
			//����
			adapter.notifyDataSetChanged();
			dialog.dismiss();
		}

		@Override
		protected List<Map<String, Object>> doInBackground(String... params) {
			// TODO Auto-generated method stub
			List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
			//���������ȡjson���ݲ��ҽ��н�����
			try {
				//				HttpClient httpClient=new DefaultHttpClient();
				//				HttpPost httpPost=new HttpPost(params[0]);
				//				
				//				HttpResponse httpResponse=httpClient.execute(httpPost);
				//				if(httpResponse.getStatusLine().getStatusCode()==200){
				//					
				//					String jsonString=EntityUtils.toString(httpResponse.getEntity(),
				//							"utf-8");
				String jsonString = "{\"product\":[{\"address\":\"�ӱ�\",\"price\":25,\"proimage\":\"001.png\",\"name\":\"ƻ��\",\"proid\":\"001\"}," + "{\"address\":\"�ӱ�2\",\"price\":252,\"proimage\":\"002.png\",\"name\":\"ƻ��2\",\"proid\":\"002\"}," + "{\"address\":\"�ӱ�3\",\"price\":253,\"proimage\":\"003.png\",\"name\":\"ƻ��3\",\"proid\":\"003\"}," + "{\"address\":\"�ӱ�4\",\"price\":254,\"proimage\":\"004.png\",\"name\":\"ƻ��4\",\"proid\":\"004\"}]}";
				JSONObject jsonObject = new JSONObject(jsonString);
				JSONArray jsonArray = jsonObject.getJSONArray("product");
				for (int i = 0; i < jsonArray.length(); i++) {
					JSONObject jsonObject2 = jsonArray.getJSONObject(i);
					Map<String, Object> map = new HashMap<String, Object>();
					Iterator<String> iterator = jsonObject2.keys(); //�Դ����json��key��Ϊmap��key
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
			//����ͼƬ

			final ImageView imageView = (ImageView) view.findViewById(R.id.imageView1);

			//ͼƬ������
			//			DownLoadImage downLoadImage=new DownLoadImage(CommonUrl.PRODUCT_IMG+
			//					list.get(position).get("images").toString());
			DownLoadImage downLoadImage = new DownLoadImage(CommonUrl.PRODUCT_IMG);
			downLoadImage.loadImage(new ImageCallBack() {

				//�ӿڵĻص����� �������ڲ��࣬
				@Override
				public void getDrawable(Drawable drawable) {
					imageView.setImageDrawable(drawable);
				}
			});

			return view;
		}

	}

}
