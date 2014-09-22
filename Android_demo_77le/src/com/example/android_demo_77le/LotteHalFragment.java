package com.example.android_demo_77le;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import net.tsz.afinal.FinalHttp;
import net.tsz.afinal.http.AjaxCallBack;
import org.json.JSONArray;
import org.json.JSONObject;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class LotteHalFragment extends Fragment {

	private ListView lsView;
	private MyAdapter adapter;
	private String jsonString;
	private List<Map<String, String>> jsonlist;

	/** @���� ��onCreateView�м��ز��� */
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_lottle_hall, container, false);
		lsView = (ListView) view.findViewById(R.id.listView1);

		jsonlist = new ArrayList<Map<String, String>>();

		FinalHttp fh = new FinalHttp();
		fh.post("http://caipiao.77le.cn/m/period/shall.do", null, new AjaxCallBack<Object>() {
			@Override
			public void onSuccess(Object t) {
				jsonString = t.toString();
				try {
					JSONObject jsonObject = new JSONObject(jsonString);
					JSONArray jsonArray = jsonObject.getJSONArray("data");
					for (int i = 0; i < jsonArray.length(); i++) {
						JSONObject jsonObject2 = jsonArray.getJSONObject(i);
						Map<String, String> map = new HashMap<String, String>();
						Iterator<String> iterator = jsonObject2.keys(); //�Դ����json��key��Ϊmap��key
						while (iterator.hasNext()) {
							String key = iterator.next();
							String value = jsonObject2.get(key).toString();
							map.put(key, value);
						}
						jsonlist.add(map);
					}
					adapter.notifyDataSetChanged();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		adapter = new MyAdapter(getActivity());
		lsView.setAdapter(adapter);
		return view;
	}

	//����������
	public class MyAdapter extends BaseAdapter {

		public LayoutInflater layoutInflater;

		public MyAdapter(Context context) {
			layoutInflater = LayoutInflater.from(context);
		}

		@Override
		public int getCount() {
			return jsonlist.size();
		}

		@Override
		public Object getItem(int position) {
			return jsonlist.get(position);
		}

		@Override
		public long getItemId(int position) {
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			View view = null;
			if (convertView == null) {
				view = layoutInflater.inflate(R.layout.fragment_lottle_hall_item, null);
			} else {
				view = convertView;
			}
			TextView type = (TextView) view.findViewById(R.id.halltv1);
			TextView num = (TextView) view.findViewById(R.id.halltv2);
			TextView money = (TextView) view.findViewById(R.id.halltv3);
			TextView endtime = (TextView) view.findViewById(R.id.halltv4);
			ImageView logoimage = (ImageView) view.findViewById(R.id.hallimg);

			Map<String, String> map = jsonlist.get(position);
			int tp = Integer.parseInt(map.get("type"));
			String halltv1 = null;
			if (tp == 10) {
				halltv1 = "˫ɫ��";
				logoimage.setImageResource(R.drawable.logo_ssq);
			} else if (tp == 13) {
				halltv1 = "����͸";
				logoimage.setImageResource(R.drawable.logo_dlt);
			} else if (tp == 30) {
				halltv1 = "11ѡ5";
				logoimage.setImageResource(R.drawable.logo_jxsyxw);
			}

			type.setText(halltv1);
			num.setText("��" + map.get("no").toString() + "��");
			money.setText("����" + Integer.parseInt(map.get("accumu")) / 10000000 + "ǧ��");
			endtime.setText("��ֹʱ��" + map.get("endTime").toString());
			//����ͼƬ
			return view;
		}

	}

}
