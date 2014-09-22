package com.example.android_loader_manager;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.app.Dialog;
import android.app.LoaderManager;
import android.app.LoaderManager.LoaderCallbacks;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ContextMenu.ContextMenuInfo;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	private LoaderManager manager;

	private ListView listView;
	
	private MyAdapter adapter = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		manager = getLoaderManager();//加载LoaderManager完成异步加载数据的操作
		manager.initLoader(1000, null, callback);
		listView = (ListView) this.findViewById(R.id.listView1);
		adapter = new MyAdapter(MainActivity.this);
		registerForContextMenu(listView);

	}

	//菜单
	@Override
	public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo menuInfo) {
		// TODO Auto-generated method stub
		//添加菜单
		getMenuInflater().inflate(R.menu.main, menu);
		super.onCreateContextMenu(menu, v, menuInfo);
	}
	//菜单选中发生事件
	@Override
	public boolean onMenuItemSelected(int featureId, MenuItem item) {
		AdapterContextMenuInfo info=(AdapterContextMenuInfo) item.getMenuInfo();
		switch (item.getItemId()) {
		case R.id.add:
			//添加自定义对话框，完成用户的数据录入
			//Toast.makeText(MainActivity.this, "add", 1).show();
			final Dialog dialog=creatAddDialog(MainActivity.this);	 		
			Button button=(Button)dialog.findViewById(R.id.button1);
			button.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					EditText editText=(EditText)dialog.findViewById(R.id.editText1);
					// TODO Auto-generated method stub
					String name=editText.getText().toString().trim();
					ContentResolver contentResolver=getContentResolver();
					
					ContentValues values=new ContentValues();
					values.put("name", name);
					Uri uri=Uri.parse("content://com.example.android_loader_manager.StudentContentProvider/student");
					Uri result_uri=contentResolver.insert(uri, values);
					if(result_uri!=null){
						manager.restartLoader(1000, null, callback);
						dialog.dismiss();
					}
				}
			});
			dialog.show();
			break;
		//删除
		case R.id.del:
			int position=info.position;
			String name=adapter.getItem(position).toString();
			//int id=(int) adapter.getItemId(position);
			//Toast.makeText(MainActivity.this, "del", 1).show();
			ContentResolver contentResolver=getContentResolver();
			Uri uri=Uri.parse("content://com.example.android_loader_manager.StudentContentProvider/student");
			int count=contentResolver.delete(uri," name = ? ",new String[]{name});
			if(count>0){
				manager.restartLoader(1000, null, callback);
			}
			break;
		}
		return super.onMenuItemSelected(featureId, item);
	}
	
	//创建一个对话框
	private Dialog creatAddDialog(Context context){
		Dialog dialog=new Dialog(context);
		dialog.setContentView(R.layout.add);
		return dialog;
		
	}

	/** MyAdapter
	 * @author 孙世东 */
	public class MyAdapter extends BaseAdapter {

		private List<String> list = null;

		private Context context;

		public MyAdapter(Context context) {
			// TODO Auto-generated constructor stub
			this.context = context;
		}

		public void setList(List<String> list) {
			// TODO Auto-generated method stub
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
			//适配器的值
			TextView view = null;

			if (convertView == null) {

				view = new TextView(context);
			} else {
				view = (TextView) convertView;
			}
			view.setText(list.get(position).toString());
			return view;
		}

	}

	/**
	 * 
	 */
	private LoaderCallbacks<Cursor> callback = new LoaderCallbacks<Cursor>() {

		@Override
		public void onLoaderReset(Loader<Cursor> loader) {
			// TODO Auto-generated method stub

		}

		//完成对UI数据的提取，更新UI的操作
		@Override
		public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {
			// TODO Auto-generated method stub

			//吧数据提取出来，放到适配器中
			//listView.setAdapter(new MyAdapter(this));

			List<String> list = new ArrayList<String>();
			while (cursor.moveToNext()) {
				String name = cursor.getString(cursor.getColumnIndex("name"));
				list.add(name);
			}
			
			adapter.setList(list);
			listView.setAdapter(adapter);
			adapter.notifyDataSetChanged();
		}

		@Override
		public Loader<Cursor> onCreateLoader(int id, Bundle args) {
			// TODO Auto-generated method stub

			//			CursorLoader loader=new CursorLoader(MainActivity.this);

			Uri uri = Uri.parse("content://com.example.android_loader_manager.StudentContentProvider/student");

			//			loader.setUri(uri);
			//			loader.setProjection(projection);
			//			loader.setSelection(selection);
			//			loader.setSelectionArgs(selectionArgs);
			//			loader.setSortOrder(sortOrder);

			CursorLoader loader = new CursorLoader(MainActivity.this, uri, null, null, null, null);

			return loader;
		}
	};

	/** 菜单 */
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
}
