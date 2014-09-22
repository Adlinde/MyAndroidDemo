package com.example.android_loader_manager;

import com.example.android_loader_manager.db.DbHelper;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

public class StudentContentProvider extends ContentProvider {

	private DbHelper helper = null;

	private static final UriMatcher URI_MATCHER = new UriMatcher(UriMatcher.NO_MATCH);

	private static final int STUDENT = 1;

	private static final int STUDENTS = 2;

	static {
		URI_MATCHER.addURI("com.example.android_loader_manager.StudentContentProvider", "student", STUDENTS);
		URI_MATCHER.addURI("com.example.android_loader_manager.StudentContentProvider", "student/#", STUDENT);

	}

	public StudentContentProvider() {
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
		// TODO Auto-generated method stub

		Cursor cursor = null;

		int flag = URI_MATCHER.match(uri);

		SQLiteDatabase database = helper.getWritableDatabase();
		switch (flag) {
		case STUDENT:
			
			long id=ContentUris.parseId(uri);
			
			String where_value = "id=" + id;

			if (selection != null && !"".equals(selection)) {

				where_value += selection;
			}
			
			cursor=database.query("student", projection, where_value, selectionArgs, null, null, null);

			break;
		case STUDENTS:
			cursor=database.query("student", projection, selection, selectionArgs, null, null, null);
			break;
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
		int flag = URI_MATCHER.match(uri);
		Uri resultUri = null;
		SQLiteDatabase database = helper.getWritableDatabase();
		switch (flag) {
		case STUDENTS:
			long id = database.insert("student", null, values);
			resultUri = ContentUris.withAppendedId(uri, id);
			break;
		}
		System.out.println("-----" + resultUri.toString());

		return resultUri;
	}

	@Override
	public int delete(Uri uri, String selection, String[] selectionArgs) {

		int count = 0;//Ó°ÏìÐÐÊý

		int flag = URI_MATCHER.match(uri);

		SQLiteDatabase database = helper.getReadableDatabase();

		switch (flag) {
		case STUDENT:
			long id = ContentUris.parseId(uri);

			String where_value = "id=" + id;

			if (selection != null && !"".equals(selection)) {

				where_value += selection;
			}
			count = database.delete("student", where_value, selectionArgs);

			break;
		case STUDENTS:
			count = database.delete("student", selection, selectionArgs);
			break;

		}

		return count;
	}

	@Override
	public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
		int count = 0;
		int flag = URI_MATCHER.match(uri);

		SQLiteDatabase database = helper.getReadableDatabase();

		switch (flag) {
		case STUDENT:
			long id = ContentUris.parseId(uri);

			String where_value = "id=" + id;

			if (selection != null && !"".equals(selection)) {

				where_value += selection;
			}
			count = database.delete("student", where_value, selectionArgs);
			break;
		case STUDENTS:
			count = database.delete("student", selection, selectionArgs);
			break;
		}

		return count;
	}
}
