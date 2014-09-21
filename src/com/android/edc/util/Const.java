package com.android.edc.util;

import android.os.Environment;

public class Const {
	
	private static final String DIR_ROOT_PATH = Environment.getExternalStorageDirectory().getPath();
	
	private static final String DIR_APP_HOME = "edc";
	
	public static String getAppHomePath(){
		return new StringBuilder().append(DIR_ROOT_PATH).append("/").append(DIR_APP_HOME).append("/").toString();
	}
}
