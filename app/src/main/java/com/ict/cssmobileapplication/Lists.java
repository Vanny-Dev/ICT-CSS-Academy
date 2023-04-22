package com.ict.cssmobileapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.appcompat.widget.AppCompatTextView;

import java.util.ArrayList;

public class Lists extends ArrayAdapter<String>{
	Context context;
	public Lists(Context ctx, ArrayList<String> lists){
		super(ctx, R.layout.list_view, lists);
		context = ctx;
	}
	public View getView(int pos, View v, ViewGroup vg){
		v = LayoutInflater.from(context).inflate(R.layout.list_view, vg, false);
		TextView tv = v.findViewById(R.id.lists_text);
		tv.setText(String.valueOf(getItem(pos)));
		return v;
	}
}
