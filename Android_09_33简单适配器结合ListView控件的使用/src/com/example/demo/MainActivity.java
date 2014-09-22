package com.example.demo;

import java.util.List;
import java.util.Map;

import org.apache.http.NameValuePair;
import org.apache.http.impl.client.DefaultHttpClient;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

public class MainActivity extends Activity {

	private ListView listView;
	
	private SimpleAdapter adapter;
	
	private List<Map<String, Object>> data=null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_main);
		
		listView=(ListView)this.findViewById(R.id.listview);
		
		//添加数据源
		data=MyDataSource.getMaps();
		
//		DefaultHttpClient 
		
//		adapter=new SimpleAdapter(MainActivity.this,
//				data, R.layout.activity_main,
//				new String[]{"pname","price","address"},
//				new int[]{R.id.pname,R.id.price,R.id.address});
		
		MyAdapter adapter2 = new MyAdapter(this);
		
		//listView.setAdapter(adapter);
		listView.setAdapter(adapter2);
		
		
		
	}
	
	
	//ViewHolder静态类
   public static class ViewHolder
    {
        public TextView pname;
        public TextView price;
        public TextView address;
    }
	
   
   
	private class MyAdapter extends BaseAdapter{

		private LayoutInflater mInflater = null;
		
		public MyAdapter(Context context) {
			this.mInflater=LayoutInflater.from(context);

		}
		
		
		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return data.size();
		}

		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			ViewHolder holder = null;
			
            //如果缓存convertView为空，则需要创建View
            if(convertView == null)
            {
                holder = new ViewHolder();
                //根据自定义的Item布局加载布局
                convertView = mInflater.inflate(R.layout.activity_main, null);
                holder.pname = (TextView)convertView.findViewById(R.id.pname);
                holder.price = (TextView)convertView.findViewById(R.id.price);
                holder.address = (TextView)convertView.findViewById(R.id.address);
                //将设置好的布局保存到缓存中，并将其设置在Tag里，以便后面方便取出Tag
                convertView.setTag(holder);
            }else
            {
                holder = (ViewHolder)convertView.getTag();
            }
            //holder.pname.setBackgroundResource((Integer)data.get(position).get("img"));
            holder.pname.setText(data.get(position).get("pname").toString());
            holder.price.setText(data.get(position).get("price").toString());
            holder.address.setText((String)data.get(position).get("address"));
            
            return convertView;
		}
		

		
	} 
	
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
