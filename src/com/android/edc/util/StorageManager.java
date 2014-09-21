package com.android.edc.util;

import java.io.File;

public class StorageManager {

	public static boolean verifyAppHomePath(){
		boolean result = false;
		File mDirectory = new File(Const.getAppHomePath());
		try{
			if (!mDirectory.exists()) {
				result = mDirectory.mkdirs();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}
	
}
