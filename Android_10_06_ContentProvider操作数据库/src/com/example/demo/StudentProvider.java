package com.example.demo;

import com.example.demo.db.DbHelper;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.util.Log;

public class StudentProvider extends ContentProvider {

	private final String TAG = "StudentProvider";

	private DbHelper helper = null;

	private static final UriMatcher URI_MATCHER = new UriMatcher(UriMatcher.NO_MATCH);

	private static final int STUDENT = 1;//操作单条

	private static final int STUDENTS = 2;//操作多条

	static {

		URI_MATCHER.addURI("com.example.demo.StudentProvider", "student", STUDENTS);
		URI_MATCHER.addURI("com.example.demo.StudentProvider", "student/#", STUDENT);
	}

	public StudentProvider() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean onCreate() {
		// TODO Auto-generated method stub
		helper = new DbHelper(getContext());
		return false;
	}

	@Override
	public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
		
		Cursor cursor=null;
		try {
			SQLiteDatabase database = helper.getWritableDatabase();
			int flag = URI_MATCHER.match(uri);
			switch (flag) {
			case STUDENT:

				long id = ContentUris.parseId(uri);
				String where_values = " id= " + id;
				if (selection != null && !selection.equals("")) {
					where_values += " and " + selection;
				}

				cursor = database.query("student", null, where_values, selectionArgs, null, null, null);

				break;
			case STUDENTS:
				cursor = database.query("student", null, selection, selectionArgs, null, null, null);
				break;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		
		return cursor;
	}

	@Override
	public String getType(Uri uri) {
		int flag = URI_MATCHER.match(uri);
		switch (flag) {
		case STUDENT:

			return "vnd.android.cursor.item/student";

		case STUDENTS:

			return "vnd.android.cursor.dir/students";
		}
		return null;
	}

	@Override
	public Uri insert(Uri uri, ContentValues values) {
		// TODO Auto-generated method stub
		Uri resultUri = null;
		int flag = URI_MATCHER.match(uri);
		switch (flag) {
		case STUDENTS:

			SQLiteDatabase database = helper.getWritableDatabase();
			long id = database.insert("student", null, values);
			resultUri = ContentUris.withAppendedId(uri, id);
			break;

		//		case STUDENT:
		//
		//			SQLiteDatabase database=helper.getWritableDatabase();
		//			long id=database.insert("student", null, values);
		//			resultUri=ContentUris.withAppendedId(uri, id);
		//			break;
		}
		Log.i(TAG, resultUri.toString());
		return resultUri;
	}

	@Override
	public int delete(Uri uri, String selection, String[] selectionArgs) {

		int count = -1;
		try {
			SQLiteDatabase database = helper.getWritableDatabase();
			int flag = URI_MATCHER.match(uri);
			switch (flag) {
			case STUDENT:

				long id = ContentUris.parseId(uri);
				String where_values = " id= " + id;
				if (selection != null && !selection.equals("")) {
					where_values += " and " + selection;
				}

				count = database.delete("student", where_values, selectionArgs);

				break;
			case STUDENTS:
				count = database.delete("student", selection, selectionArgs);
				break;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		return count;
	}

	@Override
	public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
		int count=-1;
		
		try {
			SQLiteDatabase database = helper.getWritableDatabase();
			long id = ContentUris.parseId(uri);
			int flag = URI_MATCHER.match(uri);
			switch (flag) {
			case STUDENT:
				String where_values = " id= " + id;
				if (selection != null && !selection.equals("")) {
					where_values += " and " + selection;
				}

				count = database.update("student", values, selection, selectionArgs);

				break;
			}	
		} catch (Exception e) {
			// TODO: handle exception
		}
		return count;
	}

}
