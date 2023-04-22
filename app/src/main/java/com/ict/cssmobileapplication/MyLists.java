package com.ict.cssmobileapplication;

import android.content.Context;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.InputStream;
import java.util.Scanner;

public class MyLists {
	public static String[] coc_1 = {
			"Disassemble/Assemble Desktop Computer",
			"Installing Computer Systems and Networks",
			"Prepare Installer (Creating Portable Bootable Device)",
			"Configure BIOS",
			"Install Windows Server 2008 R2",
			"Install Microsoft Office"
	};
	public static String[] coc_2 = {
			"Configuring Computer Systems and Networks",
			"Creating Network Cables",
			"Network Configuration",
			"Set router/Wi-Fi/wireless access point/repeater configuration",
			"Inspect and test configured computer network"
	};
	public static JSONObject json(Context ctx){
		try {
			String str = "";
			InputStream stream = ctx.getAssets().open("res.json");
			byte[] b = new byte[stream.available()];
			stream.read(b);
			stream.close();
			str = new String(b);
			JSONObject obj = new JSONObject(str);
			return obj;
		}catch(Exception e){
			Toast.makeText(ctx, e.getMessage(), Toast.LENGTH_LONG).show();
			return null;
		}
	}
	public static String[] jsonArrays(JSONObject json, String key){
		try {
			JSONArray arrays = json.getJSONArray(key);
			String[] lists = new String[arrays.length()];
			for(int i = 0; i < arrays.length(); i++){
				lists[i] = arrays.getString(i);
			}
			return lists;
		}catch(Exception e){
			return null;
		}
	}
}